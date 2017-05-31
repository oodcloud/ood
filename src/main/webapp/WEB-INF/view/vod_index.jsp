<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/5
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内涵三十秒</title>
    <jsp:include page="home_include.jsp"/>
</head>
<body class="body-container">

<%--菜单--%>
<%--<div class="neihan-nav">--%>
    <%--<jsp:include page="home_head.jsp"/>--%>
<%--</div>--%>
<%--banner图--%>
<div id="banner">
    <div  id="bannerbody">
        <h2>内涵三十秒</h2>
        <p>内涵是一种抽象的但绝对存在的感觉，是某个人对一个人或某件事的一种认知感觉</p>
        <p>在这你能三十秒不笑吗？</p>
        <div class="search-form">
            <div class="input-group text-sm">
                <form method="post" action="/search">
                    <input type="text" name="worldkey" class="search-input" placeholder="搜索一下">
                    <button class="search-btn" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="layui-tab layui-tab-brief" lay-filter="moviedata">
    <ul class="layui-tab-title positionalign">
        <li class="layui-this" lay-id="1">搞笑牛人</li>
        <li lay-id="2">网络短剧</li>
        <li lay-id="3">搞笑游戏</li>
        <li lay-id="4">搞笑动画</li>
        <li lay-id="5">相声小品</li>
        <li lay-id="6">搞笑综艺</li>
        <li lay-id="7">搞笑配音</li>
        <li lay-id="8">搞笑直播</li>
        <li lay-id="9">搞笑集锦</li>
    </ul>
    <div class="layui-tab-content" style="height: 700px;">
        <div class="layui-tab-item layui-show">

            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="搞笑牛人">
                    <c:forEach items="${jokespeople}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>

                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>

                </ul>
            </div>

        </div>
        <div class="layui-tab-item">

            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="网络短剧">
                    <c:forEach items="${onlinedrama}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </div>
        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="搞笑游戏">
                    <c:forEach items="${jokesgame}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="搞笑动画">
                    <c:forEach items="${jokescartoon}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="相声小品">
                    <c:forEach items="${comedy}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="综艺">
                    <c:forEach items="${varietyshows}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="配音">
                    <c:forEach items="${dubbed}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="直播">
                    <c:forEach items="${live}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="layui-tab-item">
            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="集锦">
                    <c:forEach items="${jijin}" var="item">
                        <li>
                            <div class="card">
                                <a href="/v_show/id_${item.mPlayurl}" class="card-image" target="_blank">
                                    <img class="js-img"
                                         src="${item.mPic}"
                                         title="${item.mName}">
                                    <span class="card-tag-0"></span>
                                </a>
                                <div class="card-bd">
                                    <h3 class="card-tit nowrap"><a href="/v_show/id_${item.mPlayurl}" target="_blank">${item.mName}</a>
                                    </h3>
                                    <c:if test="${not empty item.mSubname}">
                                        <p class="nowrap">${item.mSubname}</p>
                                    </c:if>
                                </div>
                                <ul class="card-ft">
                                    <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> ${item.mHits}</li>
                                    <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 25px; color: #F7B824">&#xe641;</i></li>
                                </ul>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </div>
</div>

<div class="blank">
</div>




<script>



    layui.use(['layer','element', 'flow'], function () {
        var $ = layui.jquery
            , element = layui.element();
        var flow = layui.flow;
        flow.load({
            elem: '#搞笑牛人'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/1/v/'+page, function(res){

                    layui.each(res.data, function(index, item){
                       var subname= item.mSubname;
                       if($.isEmptyObject(subname))
                       {
                           subname=" ";
                       }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

        flow.load({
            elem: '#网络短剧'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/2/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

        flow.load({
            elem: '#搞笑游戏'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/3/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

        flow.load({
            elem: '#搞笑动画'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/4/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

        flow.load({
            elem: '#相声小品' //指定列表容器
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/5/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });
        flow.load({
            elem: '#综艺'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/6/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

        flow.load({
            elem: '#配音'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/7/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });
        flow.load({
            elem: '#直播'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/8/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

        flow.load({
            elem: '#集锦'
            , isAuto: false
            , isLazyimg: true
            ,done: function(page, next){
                var lis = [];
                $.get('/api/list/9/v/'+page, function(res){
                    layui.each(res.data, function(index, item){
                        var subname= item.mSubname;
                        if($.isEmptyObject(subname))
                        {
                            subname=" ";
                        }
                        lis.push('<li><div class="card"><a href="/v_show/id_'+item.mPlayurl+'" class="card-image" target="_blank"><img class="js-img" src="'+item.mPic+'" title="'+item.mName+'"> <span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="/v_show/id_'+item.mPlayurl+'" target="_blank">'+item.mName+'</a></h3><p class="nowrap">'+subname+'</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size:25px;color:#009688">&#xe600;</i> '+item.mHits+'</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size:25px;color:#F7B824">&#xe641;</i></li></ul></div></li>')
                    });
                    next(lis.join(''), page < 8);
                });
            }
        });

    });
</script>



<jsp:include page="home_foot.jsp"/>

</body>
</html>
