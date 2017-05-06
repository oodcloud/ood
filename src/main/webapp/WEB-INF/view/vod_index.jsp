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
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <jsp:include page="home_include.jsp"/>
</head>
<body class="body-container">

<%--菜单--%>
<div class="neihan-nav">
    <nav class="layui-header">
        <div class="neihan-container">
            <!-- 登陆 -->
            <div class="neihan-user">
                <a href="">注册</a>
                |
                <a href="">登录</a>
            </div>
            <!-- 调用站点首页 -->
            <a class="neihan-logo" href="/"> <img src="../images/logo.png"/></a>
            <!-- 导航菜单 -->
            <ul class="layui-nav ">

                <li class="layui-nav-item layui-this"><a href="javascript:;">首页</a></li>
                <li class="layui-nav-item "><a href="">搞笑视频</a></li>
                <li class="layui-nav-item "><a href="">搞笑图片</a></li>
            </ul>
        </div>
    </nav>
</div>
<%--banner图--%>
<div id="banner">
    <div  id="bannerbody">
        <h2>内涵三十秒</h2>
        <p>内涵是一种抽象的但绝对存在的感觉，是某个人对一个人或某件事的一种认知感觉</p>
        <p>在这你能三十秒不笑吗？</p>
        <div class="search-form">
            <div class="input-group text-sm">
                <form method="get" action="#">
                    <input type="text" name="s" class="search-input" placeholder="搜索一下">
                    <button class="search-btn" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%--分类搞笑视频--%>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title positionalign">
        <li class="layui-this" lay-id="111"><a href="">搞笑视频</a></li>
        <li>网络短剧</li>
        <li>搞笑动画</li>
        <li>相声小品</li>
        <li>综艺</li>
        <li>配音</li>
        <li>直播</li>
        <li>集锦</li>
    </ul>
    <div class="layui-tab-content" style="height: 700px;">
        <div class="layui-tab-item layui-show">

            <%--数据流加载BY V--%>
            <div class="flowcard-container">
                <ul class="flow-default" style="height: 300px; " id="LAY_demo2">
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>

                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="card">
                            <a href="graph.php?orkey=80GGSL" class="card-image" target="_blank">
                                <img class="js-img"
                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"
                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》">
                                <span class="card-tag-0"></span>
                            </a>
                            <div class="card-bd">
                                <h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a>
                                </h3>
                                <p class="nowrap">具有国际吸引力的特效大片</p>
                            </div>
                            <ul class="card-ft">
                                <li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li>
                                <li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
        <div class="layui-tab-item">内容4</div>
        <div class="layui-tab-item">内容5</div>
    </div>
</div>


<script>
    layui.use(['element', 'flow'], function () {
        var $ = layui.jquery
            , element = layui.element(); //Tab的切换功能，切换事件监听等，需要依赖element模块
//        流加载
        var flow = layui.flow;
        flow.load({
            elem: '#LAY_demo2' //流加载容器
            , scrollElem: '#LAY_demo2' //滚动条所在元素，一般不用填，此处只是演示需要。
            , isAuto: false
            , isLazyimg: true
            , done: function (page, next) { //加载下一页
                //模拟插入
                setTimeout(function () {
                    var lis = [];
                    for (var i = 0; i < 8; i++) {
                        lis.push('<li><div class="card"><a href="graph.php?orkey=80GGSL" class="card-image" target="_blank"><img class="js-img"                                     src="http://avatar.graphmovie.com/boo/movies/13065/13065_20170505164634_b.png"                                     title="图解电影 | 免费送电影票丨撸片室の《超凡战队》" alt="图解电影 | 免费送电影票丨撸片室の《超凡战队》"><span class="card-tag-0"></span></a><div class="card-bd"><h3 class="card-tit nowrap"><a href="graph.php?orkey=80GGSL" target="_blank">免费送电影票丨撸片室の《超凡战队》</a></h3><p class="nowrap">具有国际吸引力的特效大片</p></div><ul class="card-ft"><li class="card-ft-span"><i class="layui-icon" style="font-size: 25px; color: #009688">&#xe600;</i> 1.3万</li><li class="card-ft-span tac"><i class="layui-icon" style="font-size: 45px; color: #F7B824">&#xe641;</i></li></ul></div></li>')
                    }
                    next(lis.join(''), page < 8); //假设总页数为 6
                }, 500);
            }
        });

        //触发事件
        var active = {
            tabChange: function () {
                //切换到指定Tab项
//                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };
    });
</script>


</body>
</html>
