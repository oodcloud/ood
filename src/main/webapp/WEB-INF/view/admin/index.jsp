<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/11
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内涵三十秒-后台管理</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>
<div class="neihan-nav">
    <jsp:include page="admin_head.jsp"/>
</div>
<div class="layui-side layui-side-xsm layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree" lay-filter="Menu_index_tab">

            <li class="layui-nav-item">
                <a href="javascript:;">视频</a>
                <dl class="layui-nav-child">
                    <dd data-url="/admin/videodata"  data-id="1"  class=""><a  href="javascript:;">视频数据</a></dd>
                    <dd  data-url="/sync/index" data-id="2"><a  href="javascript:;">同步下载远程图片</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">用户</a>
                <dl class="layui-nav-child">
                    <dd data-url="/admin/videodata"  data-id="3" ><a  href="javascript:;">添加管理员</a></dd>
                    <dd data-url="/admin/videodata"  data-id="4" ><a  href="javascript:;">修改密码</a></dd>
                    <dd data-url="/admin/videodata"  data-id="5" ><a href="javascript:;">删除管理员</a></dd>
                    <dd data-url="/admin/videodata"  data-id="6" ><a href="javascript:;">设置权限</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">采集</a>
                <dl class="layui-nav-child">
                    <dd data-url="/admin//videodata"  data-id="7" ><a href="javascript:;">在线采集</a></dd>
                    <dd data-url="/admin//videodata"  data-id="8" ><a href="javascript:;">定时采集</a></dd>
                </dl>
            </li>

            <li class="layui-nav-item">
                <a href="javascript:;">数据监控</a>
                <dl class="layui-nav-child">
                    <dd data-url="/druid/index.html"  data-id="7" ><a href="javascript:;">Druid监控</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>

<div class="layui-body layui-body-xsm">
    <div class="layui-tab layui-tab-card main-index-tab" lay-filter="F_index_tab">
        <ul class="layui-tab-title" id="J_index_tab_title">
            <li class="layui-this">首页</li>
        </ul>
        <div class="layui-tab-content" >
            <div class="layui-tab-item layui-show">
                <iframe name="mainFrame" height="100%" width="100%" frameborder="0" src="/admin/welcome"></iframe>
            </div>
        </div>
    </div>
</div>


<script>


    layui.use(['layer','element'], function () {
        var $ = layui.jquery
        var element = layui.element();
        element.on('nav(Menu_index_tab)', function (elem) {
            $('iframe').attr('src',elem.data('url'));
        });
    });
</script>
</body>
</html>
