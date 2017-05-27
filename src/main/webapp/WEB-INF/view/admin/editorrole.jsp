<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/19
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑角色</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>
<blockquote class="layui-elem-quote">编辑角色</blockquote>
<form id="inputForm" class="layui-form" action="" method="post">
    <input id="id" name="id" type="hidden" value="0">
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" value="${rolecontent.rName}" lay-verify="required" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">权限设置</label>
        <div class="layui-input-block">
            <c:if test="${pw.contains('视频')}">
                <input type="checkbox" name="power" value="视频" title="视频" checked="">
            </c:if>
            <c:if test="${!pw.contains('视频')}">
                <input type="checkbox" name="power" value="视频" title="视频">
            </c:if>

            <c:if test="${pw.contains('采集')}">
                <input type="checkbox" name="power" value="采集" title="采集" checked="">
            </c:if>
            <c:if test="${!pw.contains('采集')}">
                <input type="checkbox" name="power" value="采集" title="采集">
            </c:if>

            <c:if test="${pw.contains('角色管理')}">
                <input type="checkbox" name="power" value="角色管理" title="角色管理" checked="">
            </c:if>
            <c:if test="${!pw.contains('角色管理')}">
                <input type="checkbox" name="power" value="角色管理" title="角色管理">
            </c:if>
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



<script>

    layui.use(['element', 'form', 'layedit', 'laydate', 'layer'], function () {
        var $ = layui.jquery
            , layer = layui.layer
            , element = layui.element()
            , form = layui.form()
            , userRoles = []
            , laydate = layui.laydate
            , $ = layui.jquery;

        form.on('submit(F_do_ajax_submit)', function (data) {
            var chk_value =[];
            $('input[name="power"]:checked').each(function(){
                chk_value.push($(this).val());
            });

            $.post('/admin/role/editor/save',
                {
                    rId:${rolecontent.rId},
                    rName: $('input[name="name"]').val(),
                    rPower: chk_value.toString(),
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
