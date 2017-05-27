<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/17
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>
<div class="layui-tab layui-tab-brief sub-page-tab" lay-filter="F_sub_tab">
    <ul class="layui-tab-title">
        <li class="layui-this" data-url="/a/sys/role/">角色管理</li>
        <li data-url="/a/sys/role/form/">添加角色</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="10%">
                        <col width="15%">
                        <col width="20%">
                        <col width="10%">
                        <col width="20%">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>角色名</th>
                        <th>拥有权限</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${rolelist}" var="item">
                        <tr>
                            <td>${item.rId}</td>
                            <td>${item.rName}</td>
                            <td>${item.rPower}</td>
                            <td>
                                <div class="layui-btn-group">

                                    <button data-url="/admin/role/editor/${item.rId}"
                                            class="do-action layui-btn editor-active layui-btn-small">编辑
                                    </button>
                                    <button data-url="/admin/role/del/${item.rId}" data-type="ajaxDelete"
                                            class="do-action del-active layui-btn layui-btn-small">删除
                                    </button>
                                </div>
                            </td>
                        </tr>

                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
        <div class="layui-tab-item">

            <form id="inputForm" class="layui-form" action="" method="post">
                <input id="id" name="id" type="hidden" value="0">
                <div class="layui-form-item">
                    <label class="layui-form-label">名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" value="" lay-verify="required" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">权限设置</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="power" value="视频"  title="视频" checked="">
                        <input type="checkbox" name="power" value="采集" title="采集" checked="">
                        <input type="checkbox" name="power" value="角色管理" title="角色管理" checked="">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" data-listurl="/a/sys/role/" lay-submit=""
                                lay-filter="F_do_ajax_submit">确认提交
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    Date.prototype.format = function (format) {
        var o = {
            "M+": this.getMonth() + 1, //month
            "d+": this.getDate(),    //day
            "h+": this.getHours(),   //hour
            "m+": this.getMinutes(), //minute
            "s+": this.getSeconds(), //second
            "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
            "S": this.getMilliseconds() //millisecond
        }
        if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
            (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1,
                RegExp.$1.length == 1 ? o[k] :
                    ("00" + o[k]).substr(("" + o[k]).length));
        return format;
    }
    layui.use(['element', 'form', 'layedit', 'laydate'], function () {
        var $ = layui.jquery
            , layer = layui.layer
            , element = layui.element()
            , form = layui.form()
            , userRoles = []
            , laydate = layui.laydate;
        ;


        $('.editor-active').on('click', function () {
            var othis = $(this), type = othis.data('type') ,url=othis.data("url");
            window.location.href=url;
        });


        form.on('submit(F_do_ajax_submit)', function (data) {
            var d = new Date();
            var time = d.format('yyyy-MM-dd hh:mm:ss');
            var chk_value =[];
            $('input[name="power"]:checked').each(function(){
                chk_value.push($(this).val());
            });
            $.post('/admin/role/save',
                {
                    rName: $('input[name="name"]').val(),
                    rPower: chk_value.toString(),
                    rAddtime: time,
                },
                function (res) {
                    if (res.code == 200) {

                        layer.msg("角色创建成功！！");
                    } else {
                        layer.msg("角色创建失败，该用户已经存在");
                    }

                }, "json");
            return false;
        });


        $(".del-active").on('click', function () {
            var othis = $(this), url = othis.data("url");
            $.get(url,
                function (res) {
                    if (res.code==200)
                    {
                        layer.msg("删除成功！！");
                        location.reload();
                    }
                    else {
                        layer.msg("删除失败！！")
                    }
                });

        });
    });
</script>


</body>
</html>
