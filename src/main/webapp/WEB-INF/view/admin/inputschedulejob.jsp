<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/26
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑任务页面</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body>


<br><br><br>
<form action="/admin/schedulejob/saveschedulejob" method="post">
    <input type="hidden" name="scheduleJobId" value="${ScheduleJob.scheduleJobId}">
    <table>
        <tr>
                <div class="layui-form-item">
                    <label class="layui-form-label">任务名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="jobName"  value="${ScheduleJob.jobName}" placeholder="" autocomplete="off" class="layui-input">
                    </div>
                </div>

        </tr>
        <tr>

                <div class="layui-input-inline">
                    <label class="layui-form-label">任务分组</label>
                    <select name="jobGroup" style="width: 250px;height: 38px">
                        <option value="">请选择所属任务组</option>
                        <c:forEach var="item" items="${Task}" >
                            <c:if test="${item==ScheduleJob.jobGroup}">
                                <option value="${item}" selected="">${item}</option>
                            </c:if>
                            <c:if test="${item!=ScheduleJob.jobGroup}">
                                <option value="${item}" >${item}</option>
                            </c:if>

                        </c:forEach>


                    </select>
                </div>


        </tr>
        <tr>

            <div class="layui-form-item">
                <label class="layui-form-label">时间表达式</label>
                <div class="layui-input-block">
                    <input type="text" name="cronExpression"  value="${ScheduleJob.cronExpression}" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>

        </tr>
        <tr>
            <div class="layui-form-item">
                <label class="layui-form-label">任务描述</label>
                <div class="layui-input-block">
                    <input type="text" name="description"  value="${ScheduleJob.description}" placeholder="" autocomplete="off" class="layui-input">
                </div>
            </div>


        </tr>
    </table>
    <button class="layui-btn" type="submit">确认</button>
</form>
<br>
<fieldset class="layui-elem-field">
    <legend>时间表达式说明</legend>
    <div class="layui-field-box">
        <p>
            表达式意义<br>
            "0 0 12 * * ?" 每天中午12点触发<br>

            "0 15 10 ? * *" 每天上午10:15触发<br>

            "0 15 10 * * ?" 每天上午10:15触发<br>

            "0 15 10 * * ? *" 每天上午10:15触发<br>

            "0 15 10 * * ? 2005" 2005年的每天上午10:15触发<br>

            "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发<br>

            "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发<br>

            "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发<br>

            "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发<br>

            "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发<br>

            "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发<br>

            "0 15 10 15 * ?" 每月15日上午10:15触发<br>

            "0 15 10 L * ?" 每月最后一日的上午10:15触发<br>

            "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发<br>

            "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发<br>

            "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发<br>

            每天早上6点<br>

            0 6 * * *<br>

            每两个小时<br>

            0 */2 * * *<br>

            晚上11点到早上8点之间每两个小时，早上八点<br>

            0 23-7/2，8 * * *<br>

            每个月的4号和每个礼拜的礼拜一到礼拜三的早上11点<br>

            0 11 4 * 1-3<br>

            1月1日早上4点<br>

            0 4 1 1 *<br>
        </p>
    </div>
</fieldset>

<script>
    layui.use(['form'], function () {
        var $ = layui.jquery, form = layui.form();

        $(function() {

            form.render('select');
        });

    });
</script>
</body>
</html>
