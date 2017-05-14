<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/12
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频数据</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>

<fieldset class="layui-elem-field">
    <legend>过滤条件</legend>


    <div class="layui-field-box">
        <%--<form class="layui-form layui-form-pane" action="/admin/data/query" method="post">--%>
        <form class="layui-form" action="">

            <div class="layui-form-item">
                <label class="layui-form-label">选择</label>
                <div class="layui-input-inline">
                    <select name="class" id="mclass">
                        <option value="">视频分类</option>
                        <c:forEach items="${m_class}" var="item" varStatus="mt">
                            <option value="${mt.index+1}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="area" id="marea">
                        <option value="">视频地区</option>
                        <c:forEach items="${m_area}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach>

                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="lang" id="mlang">
                        <option value="">视频语言</option>
                        <c:forEach items="${m_lang}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="palyfrom" id="mplayfrom">
                        <option value="">视频播放器</option>
                        <c:forEach items="${m_playfrom}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="level" id="mlevel">
                        <option value="">视频推荐</option>
                        <option value="1">推荐1</option>
                        <option value="2">推荐2</option>
                        <option value="3">推荐3</option>
                        <option value="4">推荐4</option>
                        <option value="5">推荐5</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="hide" id="mhide">
                        <option value="">视频显隐</option>
                        <option value="1">显示</option>
                        <option value="0">隐藏</option>
                    </select>
                </div>
                <div class="layui-form-item">

                    <div class="layui-inline">
                        <label class="layui-form-label">关键字</label>
                        <div class="layui-input-inline">
                            <input type="text" name="key" id="key" lay-verify="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


            </div>

            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
            </div>
        </form>

    </div>
</fieldset>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>视频数据</legend>
</fieldset>

<div class="layui-form">
    <form method="post" action="">
        <table class="layui-table">
            <colgroup>
                <col width="50">
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
                <th>视频id</th>
                <th>名称</th>
                <th>分类</th>
                <th>来源</th>
                <th>推荐</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <%--视频数据--%>
            <tbody id="videodatas">
            </tbody>
        </table>
        <div class="layui-btn-group">
            <button class="layui-btn" lay-submit="" lay-filter="btndel">删除</button>
            <button class="layui-btn"lay-submit="" lay-filter="btnLevel">推荐</button>
            <button class="layui-btn"lay-submit="" lay-filter="btnType">分类</button>
        </div>
    </form>
</div>
<%--最初分页--%>
<div id="sortpage"></div>
<%--条件动态分页--%>
<div id="dynamicsortpage"></div>

<script>
    layui.use(['laypage', 'form', 'element', 'laydate', 'layer'], function () {
        var form = layui.form()
            , layer = layui.layer,
            element = layui.element()
            , laydate = layui.laydate
            , laypage = layui.laypage
            , $ = layui.jquery;

        var pagesize;
        $("#dynamicsortpage").hide();
        $("#sortpage").show();
        //监听提交
        form.on('submit(demo1)', function (data) {
            $("#dynamicsortpage").show();
            $("#sortpage").hide();
            $("#videodatas").empty();
            $.ajaxSetup({
                async: false //取消异步
            });
            $.get('/admin/data/pageapi/1',
                {
                    mclass: $("#mclass").val(),
                    marea: $("#marea").val(),
                    mlang: $("#mlang").val(),
                    mplayfrom: $("#mplayfrom").val(),
                    mlevel: $("#mlevel").val(),
                    mhide: $("#mhide").val(),
                    key: $("#key").val(),
                },
                function (res) {
                    pagesize = res.pagesize;
                    $.each(res.videodata, function (idx, item) {
                        $("#videodatas").append('<tr><td><input type="checkbox" name="videoid" value="'+item.mId+'" id="videoid" lay-skin="primary" lay-filter="selectid"></td><td>' + item.mId + '</td><td><a target="_blank" href="/v_show/id_'+item.mPlayurl+'">' + item.mName + '</a></td><td>' + item.cSort + '</td><td>' + item.mPlayfrom + '</td><td>' + item.mLevel + '(默认不推荐下是0)</td><td>' + item.addtime + '</td><td><a href="/admin/data/update/' + item.mId + '">修改</a> | <a href="/admin/data/del/' + item.mId + ' onclick="return confirm(&quot;确定要删除吗?&quot;)">删除</a></td></tr>');
                    })
                    form.render('checkbox');
                });
                 laypage({
                cont: 'dynamicsortpage'
                , pages: pagesize //总页数
                , groups: 5 //连续显示分页数
                , jump: function (obj) {
                    $("#videodatas").empty();
                    $.get('/admin/data/pageapi/' + obj.curr,
                        {
                            mclass: $("#mclass").val(),
                            marea: $("#marea").val(),
                            mlang: $("#mlang").val(),
                            mplayfrom: $("#mplayfrom").val(),
                            mlevel: $("#mlevel").val(),
                            mhide: $("#mhide").val(),
                            key: $("#key").val(),
                        },
                        function (res) {
                            $.each(res.videodata, function (idx, item) {
                                $("#videodatas").append('<tr><td><input type="checkbox" name="videoid" id="videoid" value="'+item.mId+'" lay-skin="primary"lay-filter="selectid"></td><td>' + item.mId + '</td><td><a target="_blank" href="/v_show/id_'+item.mPlayurl+'">' + item.mName + '</a></td><td>' + item.cSort + '</td><td>' + item.mPlayfrom + '</td><td>' + item.mLevel + '(默认不推荐下是0)</td><td>' + item.addtime + '</td><td><a href="/admin/data/update/' + item.mId + '">修改</a> | <a href="/admin/data/del/' + item.mId + ' onclick="return confirm(&quot;确定要删除吗?&quot;)">删除</a></td></tr>');
                            })
                            form.render('checkbox');
                        });
                }
            });


            return false;
        });
        //videodata中批量删除显隐推荐分类设置

        form.on('checkbox(selectid)', function(data){


            console.log(data.elem.checked); //是否被选中，true或者false
            console.log(data.value); //复选框value值，也可以通过data.elem.value得到


        });
        form.on('submit(btndel)', function (data) {
            var chk_value =[];
            $('input[name="videoid"]:checked').each(function(){
                chk_value.push($(this).val());
            });
            layer.msg(JSON.stringify(chk_value));
            layer.alert('确定删除？', function(index){
                $.get('/admin/data/del',
                    {
                       midlist:chk_value
                    },
                    function (res) {
                    if(res.code==200)
                    {
                        layer.msg("删除成功！！");
                        window.location.reload(true);

                    }else {
                        layer.msg("删除失败！！");
                    }

                        form.render('checkbox');
                    });

                layer.close(index);
            });

            return false;
        });


        form.on('submit(btnLevel)', function (data) {
            layer.alert('<select id="val" name="val"><option value="">请选择推荐</option><option value="1">推荐1</option><option value="2">推荐2</option><option value="3">推荐3</option><option value="4">推荐4</option><option value="5">推荐5</option><option value="0">取消推荐</option></select>', function(index){


                layer.close(index);
            });
            return false;
        });
        form.on('submit(btnType)', function (data) {
            layer.open({
                type: 1
                ,content: $('#mclass')
                ,btn: '确定'
                ,btnAlign: 'c'
                ,shade: 0
                ,area: ['210px', '160px']
                ,yes: function(){


                    layer.closeAll();
                }
            });


            return false;
        });





        laypage({
            cont: 'sortpage'
            , pages: ${pagesize} //总页数
            , groups: 5 //连续显示分页数
            , jump: function (obj) {
                $("#videodatas").empty();
                $.get('/admin/data/pageapi/' + obj.curr,
                    {
                        mclass: $("#mclass").val(),
                        marea: $("#marea").val(),
                        mlang: $("#mlang").val(),
                        mplayfrom: $("#mplayfrom").val(),
                        mlevel: $("#mlevel").val(),
                        mhide: $("#mhide").val(),
                        key: $("#key").val(),
                    },
                    function (res) {
                        $.each(res.videodata, function (idx, item) {
                            $("#videodatas").append('<tr><td><input type="checkbox" name="videoid" id="videoid" value="'+item.mId+'" lay-skin="primary" lay-filter="selectid"></td><td>' + item.mId + '</td><td><a target="_blank" href="/v_show/id_'+item.mPlayurl+'">' + item.mName + '</a></td><td>' + item.cSort + '</td><td>' + item.mPlayfrom + '</td><td>' + item.mLevel + '(默认不推荐下是0)</td><td>' + item.addtime + '</td><td><a href="/admin/data/update/' + item.mId + '">修改</a> | <a href="/admin/data/del/' + item.mId + ' onclick="return confirm(&quot;确定要删除吗?&quot;)">删除</a></td></tr>');
                        })
                        form.render('checkbox');
                    });
            }
        });


        //全选
        form.on('checkbox(allChoose)', function (data) {
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function (index, item) {
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });


    });
</script>

</body>
</html>
