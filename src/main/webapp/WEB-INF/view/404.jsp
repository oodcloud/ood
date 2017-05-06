<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/5
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8" />
    <title>Musik | Web Application</title>
    <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
    <jsp:include page="home_include.jsp"/>
</head>
<body class="bg-light dk">
<section id="content">
    <div class="row m-n">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="text-center m-b-lg">
                <h1 class="h text-white animated fadeInDownBig">404</h1>
            </div>
            <div class="list-group auto m-b-sm m-b-lg">
                <a href="index.html" class="list-group-item">
                    <i class="fa fa-chevron-right icon-muted"></i>
                    <i class="fa fa-fw fa-home icon-muted"></i> Goto homepage
                </a>
                <a href="#" class="list-group-item">
                    <i class="fa fa-chevron-right icon-muted"></i>
                    <i class="fa fa-fw fa-question icon-muted"></i> Send us a tip
                </a>
                <a href="#" class="list-group-item">
                    <i class="fa fa-chevron-right icon-muted"></i>
                    <span class="badge bg-info lt">021-215-584</span>
                    <i class="fa fa-fw fa-phone icon-muted"></i> Call us
                </a>
            </div>
        </div>
    </div>
</section>
<!-- footer -->
<footer id="footer">
    <div class="text-center padder clearfix">
        <p>
            <small>Web app framework base on Bootstrap<br>&copy; 2014</small>
        </p>
    </div>
</footer>

</body>
</html>
