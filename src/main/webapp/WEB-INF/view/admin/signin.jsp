<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/10
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内涵三十秒-登录</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body class="bg-info dker">

<div class="signin-position">

    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">登录</li>

        </ul>
        <div class="layui-tab-content" style="height: 100px;">
            <div class="layui-tab-item layui-show">

                <form class="layui-form layui-form-pane" action="" method="post">

                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="loginusername" lay-verify="required" placeholder="请输入"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="loginpassword" placeholder="请输入密码" autocomplete="off"
                                   class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">请务必填写用户名</div>
                    </div>


                    <div class="layui-form-item btn-position">
                        <button class="layui-btn" lay-submit="" lay-filter="login">立即登录</button>
                    </div>
                </form>


            </div>
        </div>
    </div>

</div>


<script>
    layui.use(['jquery', 'form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form()
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        var $ = layui.jquery;
        form.verify({
            pass: [/(.+){6,12}$/, '密码必须6到12位']

        });

        form.on('submit(login)', function (data) {

            $.post("/admin/check", {loginusername: data.field.loginusername, loginpassword: data.field.loginpassword},
                function (data) {
                    if (data.code=="200")
                    {

                        layer.load(3);
                        setTimeout(function(){
                            window.location.href = "/admin/index";
                        },2000)
                    }
                    else {
                        layer.alert(data.message, {
                            title: '登录信息',
                            icon: 5
                        })
                    }
                },
                "json");
            return false;
        });
    });
</script>


</body>
</html>
