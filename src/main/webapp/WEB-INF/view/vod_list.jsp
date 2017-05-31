<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/5
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${content!=null}">
    <c:forEach items="${content}" var="item">
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


</c:if>
<c:if test="${content==null}">

    <div class="search-result-box">
        <div class="empty-list">

            <h3>很抱歉，没找到相关的视频</h3>
            <dl>
                <dt>建议您：</dt>
                <dd>1. 请检查输入的关键词是否有误</dd>
                <dd>2. 请缩短关键词</dd>
            </dl>
        </div>
    </div>

</c:if>