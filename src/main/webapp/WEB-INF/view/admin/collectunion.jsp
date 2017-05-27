<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/15
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采集管理</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>
<fieldset class="layui-elem-field site-demo-button">
    <legend>视频采集器</legend>
    <div>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item" pane="">
                <label class="layui-form-label">采集类型</label>
                <div class="layui-input-block">
                    <input type="radio" name="spideraction" value="/admin/api/spider/jokespeoplestart" title="搞笑牛人" checked="">
                    <input type="radio" name="spideraction" value="/admin/api/spider/onlinedramastart" title="网络短剧">
                    <input type="radio" name="spideraction" value="/admin/api/spider/jokesgamestart" title="搞笑游戏">
                    <input type="radio" name="spideraction" value="/admin/api/spider/jokescartoonstart" title="搞笑动画">
                    <input type="radio" name="spideraction" value="/admin/api/spider/comedystart" title="相声小品">
                    <input type="radio" name="spideraction" value="/admin/api/spider/varietyshowsstart" title="综艺">
                    <input type="radio" name="spideraction" value="/admin/api/spider/dubbedstart" title="配音">
                    <input type="radio" name="spideraction" value="/admin/api/spider/livestart" title="直播">
                    <input type="radio" name="spideraction" value="/admin/api/spider/jijinstart" title="集锦">
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="spiderdo">开始采集</button>
            </div>
        </form>
    </div>
</fieldset>

<iframe name="mainFrame"   height="80%" width="100%"  frameborder="0" src="" ></iframe>

<script>

    layui.use(['form','layer'], function(){
        var form = layui.form();
        var $ = layui.jquery;
        form.on('submit(spiderdo)', function(data){
            $('iframe').attr('src',data.field.spideraction);
            return false;
        });


    });
</script>


</body>
</html>
