<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/5
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}-内涵三十秒</title>
    <jsp:include page="home_include.jsp"/>
</head>
<body class="play-body">
<%--菜单--%>
<div class="neihan-nav">
    <nav class="layui-header">
        <div class="neihan-container">

            <!-- 调用站点首页 -->
            <a class="neihan-logo" href="/"> <img src="${webRoot}/images/logo.png"/></a>
            <!-- 导航菜单 -->
            <div class="play-nav">
            <span class="layui-breadcrumb">
                <a href="/">首页</a>
                 <a href="/demo/">${owntypename}</a>
                <a><cite>${title}</cite></a>
            </span>
            </div>
        </div>
    </nav>
</div>
<div class="video-postion">
    <video width="1120" height="630" controls="" autoplay="true" poster="${recommend.mPic}">
        <source src="${playurl}" type="video/mp4">
    </video>
</div>
<div class="subplay">
    <div class="video-other">
       <%--评论区--%>
        <div class="play-mainCol">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>看官评论区</legend>
            </fieldset>

            <form class="layui-form" action="">
                <div class="layui-form-item layui-form-text">

                    <div class="layui-input-block">
                        <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="Discuss"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="submit-discuss">提交</button>
                    </div>
                </div>
            </form>


        </div>

        <%--相关推荐--%>
        <div class="play-sideCol">
            <div class="v_like">
                <div class="tit"><strong>随机推荐</strong>
                </div>
                <div class="list">
                    <ul>
                        <c:forEach items="${othervideos}" var="recommend">

                            <li>
                                <a class="v_pic" href="/v_show/id_${recommend.mPlayurl}"><img
                                        class="scrollLoading"
                                        onerror="this.onerror=null;this.src='/images/timg.gif';"

                                        src="${recommend.mPic}" style="display: block;"></a>
                                <a class="v_title" href="/v_show/id_${recommend.mPlayurl}">${recommend.mName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </div>

</div>


<jsp:include page="home_foot.jsp"/>
<script>
    layui.use(['element','form','layedit','laydate'], function () {
        var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
        var form = layui.form()
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });

        //创建一个编辑器
        var editIndex = layedit.build('Discuss', {
            tool: [ 'strong' ,'italic' ,'left', 'center', 'right', '|', 'face']
        });

        //自定义验证规则
        form.verify({
           content: function(value){
                if(value.length < 5){
                    return '内容至少得5个字符啊';
                }
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(submit-discuss)', function(data){
//            layer.alert(data.field, {
//                title: '最终的提交信息'
//            })
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

    });
</script>

</body>
</html>
