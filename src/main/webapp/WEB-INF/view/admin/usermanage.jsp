<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/17
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>


<div class="layui-tab layui-tab-brief sub-page-tab" lay-filter="F_sub_tab">
    <ul class="layui-tab-title">
        <li class="layui-this" data-url="/a/sys/user/">管理员</li>
        <li data-url="/a/sys/user/form/">添加管理员</li>
    </ul>

    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <div class="layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="5%">
                        <col width="20%">
                        <col width="20%">
                        <col width="10%">
                        <col width="20%">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>登录名</th>
                        <th>角色</th>
                        <th>是否启用</th>
                        <th>上次登录时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>


                    <c:forEach items="${userlist}" var="item">
                        <tr>
                            <td>${item.uId}</td>
                            <td>${item.uName}</td>
                            <td>${item.rName}</td>
                            <td>
                                <c:if test="${item.uStatus==true}">

                                    <i class="layui-icon menu-isshow menu-isshow_y"></i>
                                </c:if>

                                <c:if test="${item.uStatus==false}">
                                    <i class="layui-icon" style="font-size: 20px; color: #1AA194;">&#x1006;</i>
                                </c:if>

                            </td>
                            <td>${item.uLogintime}</td>
                            <td>
                                <div class="layui-btn-group">
                                    <button data-url="/admin/user/editor/${item.uId}"
                                            lay-submit="" lay-filter="editoruser"
                                            class="do-action layui-btn editor-active  layui-btn-small">编辑
                                    </button>
                                    <button data-url="/admin/user/del/${item.uId}" data-type="ajaxDelete"
                                            lay-submit="" lay-filter="deluser"
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

        <div class=" layui-tab-item">

            <form id="inputForm" class="layui-form" action="" method="post">
                <input id="id" name="id" type="hidden" value="0">
                <input type="hidden" name="oldPassword" value="">
                <div class="layui-form-item">
                    <label class="layui-form-label">登录名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="loginName" value="" lay-verify="required" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" value="" lay-verify="required" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">角色</label>
                    <div class="layui-input-block">
                        <c:forEach items="${rolelist}" var="item" varStatus="flag">
                            <c:if test="${flag.index==0}">
                                <input type="radio" name="role" value="${item.rType}" title="${item.rName}" checked="">
                            </c:if>
                            <c:if test="${flag.index!=0}">
                                <input type="radio" name="role" value="${item.rType}" title="${item.rName}">
                            </c:if>

                        </c:forEach>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否启用-默认开</label>
                    <div class="layui-input-block">
                        <input type="checkbox" checked="" name="flagopen" lay-skin="switch" lay-filter=""
                               lay-text="ON|OFF">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" data-listurl="" lay-submit="" lay-filter="F_jquery_ajax_submit">确认提交
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

    layui.use(['element', 'form', 'layedit', 'laydate', 'layer'], function () {
        var $ = layui.jquery
            , layer = layui.layer
            , element = layui.element()
            , form = layui.form()
            , userRoles = []
            , laydate = layui.laydate
            , $ = layui.jquery;


        form.on('submit(F_jquery_ajax_submit)', function (data) {
            var d = new Date();
            var time = d.format('yyyy-MM-dd hh:mm:ss');
            $.post('/admin/user/save',
                {
                    uName: $('input[name="loginName"]').val(),
                    uPassword: $('input[name="password"]').val(),
                    uGroup: $('input[name="role"]:checked').val(),
                    uStatus: $('input[name="flagopen"]:checked').val(),
                    uRegtime: time,
                },
                function (res) {
                    if (res.code == 200) {

                        layer.msg("注册成功！！");
                    } else {
                        layer.msg("注册失败，该用户已经存在");
                    }

                }, "json");
            return false;
        });


        $('.editor-active').on('click', function () {
            var othis = $(this), type = othis.data('type') ,url=othis.data("url");
            window.location.href=url;

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
