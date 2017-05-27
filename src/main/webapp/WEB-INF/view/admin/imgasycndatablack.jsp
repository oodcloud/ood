<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/22
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片同步</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>采集数据结果</legend>
</fieldset>

<table class="layui-table" lay-even="" lay-skin="nob">
    <colgroup>
        <col width="150">
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>源图片url</th>
        <th>同步后图片url</th>

        <th>同步状态</th>


    </tr>
    </thead>
    <tbody>
    <c:if test="${code==200}">
        <c:forEach items="${data}" var="item">
            <tr>
                <td>${item.originImgUrl}</td>
                <td>${item.asycnImgUrl}</td>
                <td>${item.status}</td>

            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>



<button class="layui-btn"  onclick="reloadPage()" >2s后重新加载页面,若无相应请点击此按钮</button>
<script>
    function reloadPage()
    {
        setTimeout(function(){window.location.reload();},2000);
    }
    var code=${code};

    if (code==100)
    {
    setTimeout(function(){

            window.location.reload();
    },2000);
    }
    if (code==200)
    {
        window.location.reload();
    }

    layui.use('form', function(){
        var $ = layui.jquery, form = layui.form();

        //全选
        form.on('checkbox(allChoose)', function(data){
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });

    });



    var _beforeUnload_time = 0, _gap_time = 0;
    var is_fireFox = navigator.userAgent.indexOf("Firefox")>-1;//是否是火狐浏览器
    window.onunload = function (){
        _gap_time = new Date().getTime() - _beforeUnload_time;
        if(_gap_time <= 5)
            $.get('/admin/api/spider/close',

                function (res) {

                });

    }
    window.onbeforeunload = function (){
        _beforeUnload_time = new Date().getTime();
        if(is_fireFox)//火狐关闭执行
            $.get('/admin/api/spider/close',

                function (res) {

                });
    };


</script>
</body>
</html>
