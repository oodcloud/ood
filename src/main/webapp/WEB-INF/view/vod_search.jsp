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
    <title>${worldkey}搜索结果</title>
    <jsp:include page="home_include.jsp"/>
</head>
<body>
<jsp:include page="home_head.jsp"/>
<div class="search-box">
    <form method="post" action="/search">
        <input class="kw" type="text" name="worldkey" maxlength="32" value="${worldkey}" placeholder="找搞笑视频" autocomplete="off">
        <button class="submit" type="submit"></button>
    </form>
</div>
<div class="search-content">
    <jsp:include page="vod_list.jsp"/>
</div>
<div class="search-foot">
    <jsp:include page="home_foot.jsp"/>
</div>

</body>
</html>
