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
                        <th>添加时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${rolelist}" var="item">
                        <tr>
                            <td>${item.rId}</td>
                            <td>${item.rName}</td>
                            <td>${item.rAddtime}</td>
                            <td>
                                <div class="layui-btn-group">
                                    <button data-url="/a/sys/user/form?id=1012" data-type="tabAdd" class="do-action layui-btn site-demo-active layui-btn-small">分配权限</button>
                                    <button data-url="/a/sys/role/form?id=1" class="do-action layui-btn layui-btn-small">编辑</button>
                                    <button data-url="/a/sys/role/do_delete?id=1" data-type="ajaxDelete" class="do-action layui-btn layui-btn-small">删除</button>
                                </div>
                            </td>
                        </tr>

                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
        <div class="layui-tab-item">

            <form id="inputForm" class="layui-form" action="/a/sys/role/do_save" method="post">
                <input id="id" name="id" type="hidden" value="0">
                <div class="layui-form-item">
                    <label class="layui-form-label">名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" value="" lay-verify="required" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">英文名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="enname" value="" lay-verify="required" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">角色标识，系统唯一（例如：project_manager）</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否启用</label>
                    <div class="layui-input-block">
                        <input type="hidden" id="J_hdn_status" name="status" value="1">
                        <input type="checkbox" checked="" lay-verify="required" lay-skin="switch" lay-filter="F_switch" data-hdnid="#J_hdn_status" lay-text="ON|OFF"><div class="layui-unselect layui-form-switch layui-form-onswitch" lay-skin="_switch"><em>ON</em><i></i></div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">角色描述</label>
                    <div class="layui-input-inline">
                        <textarea placeholder="请输入角色描述" name="remark" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" data-listurl="/a/sys/role/" lay-submit="" lay-filter="F_do_ajax_submit">确认提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    layui.use(['element','form', 'layedit', 'laydate'], function(){
        var $ = layui.jquery
            ,layer = layui.layer
            ,element = layui.element()
            ,form = layui.form()
            ,userRoles = []
            ,laydate = layui.laydate;;

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('F_sub_tab', {
                    title: '权限分配' //用于演示
                    ,content: '<form class="layui-form" action=""><label class="layui-form-label">权限设置</label><div class="layui-input-block"><input type="checkbox" title="视频" checked=""><input type="checkbox" title="采集" checked=""><input type="checkbox" title="角色管理" checked=""></div><button class="layui-btn">保存</button> </form>'
                    ,id: 2212 //实际使用一般是规定好的id，这里以时间戳模拟下
                })
                element.tabChange('F_sub_tab', '2212');
                form.render('checkbox');
            }

        };

        element.on('tab(F_sub_tab)', function(data){

            if (data.index!=2)
            {
                element.tabDelete('F_sub_tab', '2212');
            }
        });

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>


</body>
</html>
