<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/22
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>过渡页面</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>

<button class="layui-btn"  onclick="reloadPage()" >正在加载采集页面,若无相应请点击此按钮</button>
<script>
    function reloadPage()
    {
        document.write("3s后刷新");
        setTimeout(function(){window.location.href="/admin/api/spider/data";},2000);
    }
    setTimeout(function(){window.location.href="/admin/api/spider/data";
    },2000);
</script>
</body>
</html>
