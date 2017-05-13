<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/5
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="layui-header">
    <div class="neihan-container">
        <!-- 登陆 -->
        <div class="neihan-user">
            <ul class="layui-nav">
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="layui-icon" style="font-size: 20px; color: #eeeeee;">&#xe60c;</i>  欢迎,王玉杰</a>
                <dl class="layui-nav-child">
                    <dd class="layui-this"> <a href=""><i class="layui-icon" style="font-size: 20px; color: #1E9FFF;">&#xe642;</i> 修改密码</a></dd>
                    <dd><a href="">退出登录</a></dd>
                </dl>
            </li>
            </ul>
        </div>
        <!-- 调用站点首页 -->
        <a class="neihan-logo" href="/"> <img src="${webRoot}/images/logo.png"/></a>
        <!-- 导航菜单 -->
        <ul class="layui-nav ">
            <li class="layui-nav-item layui-this"><a href="/">网站首页</a></li>
            <li class="layui-nav-item "><a href="/admin/index">后台首页</a></li>
        </ul>
    </div>
</nav>
