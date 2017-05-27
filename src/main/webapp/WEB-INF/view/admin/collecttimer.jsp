<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/15
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>定时采集</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>


<fieldset class="layui-elem-field">
    <legend>执行的任务</legend>
    <div class="layui-field-box">
        <a href="/admin/schedulejob/inputschedulejob" class="layui-btn">添加任务</a>
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>任务名称</th>
                <th>任务分组</th>
                <th>任务状态</th>
                <th>时间表达式</th>
                <th>任务描述</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${schedulejobList}" var="item">
                <tr>
                    <td>${item.jobName}</td>
                    <td>${item.jobGroup}</td>
                    <td>${item.status}</td>
                    <td>${item.cronExpression}</td>
                    <td>${item.description}</td>
                    <td>
                        <button class="layui-btn layui-btn-radius layui-btn-normal">
                            <a href="/admin/schedulejob/inputschedulejob?scheduleJobId=${item.scheduleJobId}">直接修改方式</a>
                        </button>
                        <%--<button class="layui-btn layui-btn-radius layui-btn-normal">--%>
                            <%--<a href="/admin/schedulejob/inputschedulejob?scheduleJobId=${item.scheduleJobId}&keywords=delUpdate">删除创建方式</a>--%>
                        <%--</button>--%>
                        <button class="layui-btn layui-btn-radius layui-btn-normal">
                            <a href="/admin/schedulejob/deleteschedulejob?scheduleJobId=${item.scheduleJobId}">删除</a>
                        </button>
                        <button class="layui-btn layui-btn-radius layui-btn-normal">
                            <a href="/admin/schedulejob/pauseschedulejob?scheduleJobId=${item.scheduleJobId}">暂停</a>
                        </button>

                        <button class="layui-btn layui-btn-radius layui-btn-normal">
                            <a href="/admin/schedulejob/resumeschedulejob?scheduleJobId=${item.scheduleJobId}">恢复</a>
                        </button>
                        <button class="layui-btn layui-btn-radius layui-btn-normal">
                            <a href="/admin/schedulejob/runonceschedulejob?scheduleJobId=${item.scheduleJobId}">立即运行一次</a>
                        </button>
                    </td>
                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>
</fieldset>


<fieldset class="layui-elem-field">
    <legend>运行中任务</legend>
    <div class="layui-field-box">
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>任务名称</th>
                <th>任务分组</th>
                <th>任务状态</th>
                <th>时间表达式</th>
                <th>任务描述</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${executingjobList}" var="item">

                <tr>
                    <td>${item.jobName}</td>
                    <td>${item.jobGroup}</td>
                    <td>${item.status}</td>
                    <td>${item.cronExpression}</td>

                    <td>${item.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</fieldset>
<script>
    layui.use('form', function () {
        var $ = layui.jquery, form = layui.form();


    });
</script>
</body>
</html>
