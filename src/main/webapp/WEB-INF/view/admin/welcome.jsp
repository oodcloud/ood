<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/11
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <jsp:include page="../home_include.jsp"/>

</head>
<body class="welcome-content">



<fieldset class="layui-elem-field">
    <legend>环境信息</legend>
    <div class="layui-field-box">
        <blockquote class="layui-elem-quote layui-quote-nm">
            <fieldset class="layui-elem-field">

                <legend>欢迎来到内涵三十秒后台管理欢迎界面</legend>
                <div class="layui-field-box">
                    内涵是一种抽象的但绝对存在的感觉，是某个人对一个人或某件事的一种认知感觉
                </div>
            </fieldset>
        </blockquote>
        <blockquote class="layui-elem-quote">
            <fieldset class="layui-elem-field">
                <legend>环境</legend>
                <div class="layui-field-box">
                    <%= application.getServerInfo() %>
                </div>
            </fieldset>
        </blockquote>

        <blockquote class="layui-elem-quote">
            <fieldset class="layui-elem-field">
                <legend>操作系统</legend>
                <div class="layui-field-box">
                   ${osname}
                </div>
            </fieldset>
        </blockquote>


        <blockquote class="layui-elem-quote">
            <fieldset class="layui-elem-field">
                <legend>编码格式</legend>
                <div class="layui-field-box">
                    ${encoding}
                </div>
            </fieldset>
        </blockquote>


        <blockquote class="layui-elem-quote">
            <fieldset class="layui-elem-field">
                <legend>java运行版本</legend>
                <div class="layui-field-box">
                    ${javaruntimeVersion}
                </div>
            </fieldset>
        </blockquote>


        <blockquote class="layui-elem-quote">
            <fieldset class="layui-elem-field">
                <legend>时区</legend>
                <div class="layui-field-box">
                    ${timezone}
                </div>
            </fieldset>
        </blockquote>

    </div>
</fieldset>




</body>
</html>
