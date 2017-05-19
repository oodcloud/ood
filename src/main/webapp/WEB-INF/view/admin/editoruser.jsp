<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/19
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户编辑</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>
<blockquote class="layui-elem-quote">管理员编辑</blockquote>
<form id="inputForm" class="layui-form" action="" method="post">
    <input id="id" name="id" type="hidden" value="${usercontent.uId}">
    <input type="hidden" name="oldPassword" value="${usercontent.uPassword}">
    <div class="layui-form-item">
        <label class="layui-form-label">登录名</label>
        <div class="layui-input-inline">
            <input type="text" name="loginName" value="${usercontent.uName}" lay-verify="required" class="layui-input"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" value="${usercontent.uPassword}" lay-verify="required" autocomplete="off" class="layui-input"></div>
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
        <label class="layui-form-label">是否启用</label>
        <div class="layui-input-block">
            <input type="hidden" id="J_hdn_loginFlag" name="loginFlag" value="1">
            <c:if test="${usercontent.uStatus==true}">
                <input type="checkbox" name="flagopen" checked lay-verify="required" lay-skin="switch" lay-filter="F_switch"
                       data-hdnid="#J_hdn_loginFlag" lay-text="ON|OFF">
            </c:if>
            <c:if test="${usercontent.uStatus!=true}">
                <input type="checkbox" name="flagopen" lay-verify="required" lay-skin="switch" lay-filter="F_switch"
                       data-hdnid="#J_hdn_loginFlag" lay-text="ON|OFF">
            </c:if>

            <div class="layui-unselect layui-form-switch layui-form-onswitch" lay-skin="_switch"><em>ON</em><i></i>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="F_jquery_ajax_submit">确认提交
            </button>
        </div>
    </div>
</form>

<script>

    layui.use(['element', 'form', 'layedit', 'laydate', 'layer'], function () {
        var $ = layui.jquery
            , layer = layui.layer
            , element = layui.element()
            , form = layui.form()
            , userRoles = []
            , laydate = layui.laydate
            , $ = layui.jquery;

        form.on('submit(F_jquery_ajax_submit)', function (data) {

            $.post('/admin/user/editor/save',
                {
                    uId:${usercontent.uId},
                    uName: $('input[name="loginName"]').val(),
                    uPassword: $('input[name="password"]').val(),
                    uGroup: $('input[name="role"]:checked').val(),
                    uFlag: $('input[name="flagopen"]:checked').val(),
                },
                function (res) {
                    if (res.code == 200) {

                        layer.msg("保存成功！！");

                    } else {
                        layer.msg("保存失败！！");
                    }

                }, "json");
            return false;
        });
    });

</script>

</body>
</html>
