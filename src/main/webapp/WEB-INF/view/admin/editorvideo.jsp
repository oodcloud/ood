<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/15
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频编辑页</title>
    <jsp:include page="../home_include.jsp"/>
</head>
<body >
<form class="layui-form" action="">
<fieldset class="layui-elem-field">
    <legend>视频</legend>
    <div class="layui-field-box">
        <div class="layui-form">
            <table class="layui-table">
                <colgroup>
                    <col width="50">
                    <col width="80%">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>视频数据</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>参数：</td>
                    <td>
                        <div class="layui-form-item">
                            <div class="layui-input-inline">
                                <select name="class" id="mclass">
                                    <option value>视频分类</option>
                                    <c:forEach items="${m_class}" var="item" varStatus="mt">
                                        <c:if test="${mt.index+1 == data.mClass}">
                                            <option selected="selected" value="${mt.index+1}">${item}</option>
                                        </c:if>
                                        <c:if test="${mt.index+1 != data.mClass}">
                                            <option value="${mt.index+1}">${item}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="area" id="marea">
                                    <option value>视频地区</option>
                                    <option value="大陆">大陆</option>
                                    <option value="香港">香港</option>
                                    <option value="台湾">台湾</option>
                                    <option value="美国">美国</option>
                                    <option value="韩国">韩国</option>
                                    <option value="日本">日本</option>
                                    <option value="泰国">泰国</option>
                                    <option value="新加坡">新加坡</option>
                                    <option value="马来西亚">马来西亚</option>
                                    <option value="印度">印度</option>
                                    <option value="英国">英国</option>
                                    <option value="法国">法国</option>
                                    <option value="加拿大">加拿大</option>
                                    <option value="西班牙">西班牙</option>

                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="lang" id="mlang">
                                    <option value>视频语言</option>
                                    <option value="国语">国语</option>
                                    <option value="英语">英语</option>
                                    <option value="粤语">粤语</option>
                                    <option value="闽南语">闽南语</option>
                                    <option value="韩语">韩语</option>
                                    <option value="日语">日语</option>
                                    <option value="法语">法语</option>
                                    <option value="德语">德语</option>
                                    <option value="其它">其它</option>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="level" id="mlevel">
                                    <option value>视频推荐</option>
                                    <option value="1">推荐1</option>
                                    <option value="2">推荐2</option>
                                    <option value="3">推荐3</option>
                                    <option value="4">推荐4</option>
                                    <option value="5">推荐5</option>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="hide" id="mhide">
                                    <option value>视频显隐</option>
                                    <option value="1">显示</option>
                                    <option value="0">隐藏</option>
                                </select>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>名字：</td>
                    <td>
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="text" name="title"  autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">副标题</label>
                            <div class="layui-input-inline">
                                <input type="text" name="subtitle"  autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>演员：</td>
                    <td>
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="text" name="staring"  autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">导演:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="daoyan"  autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">时长:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="time"  autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>图片：</td>
                    <td>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <input type="text" name="pic"  autocomplete="off"  class="layui-input">
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>播放地址：</td>
                    <td>
                        <label class="layui-form-label">视频播放器:</label>
                        <div class="layui-input-inline">
                            <select name="palyfrom" id="mplayfrom">
                                <option >视频播放器</option>
                                <c:forEach items="${m_playfrom}" var="item">
                                    <option value="${item}">${item}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">视频地址:</label>
                            <div class="layui-input-block">
                                <textarea name="playurl" placeholder="请输入视频地址" class="layui-textarea"></textarea>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>简介：</td>
                    <td>
                        <div class="layui-form-item layui-form-text">
                            <div class="layui-input-block">
                                <textarea class="layui-textarea layui-hide" placeholder="请输入视频简介" name="content" id="LAY_demo_editor"></textarea>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
      <div class="editorbtn">
          <button class="layui-btn " lay-submit="" lay-filter="btnsave">保存</button>
          <button class="layui-btn " lay-submit="" lay-filter="btnblack">返回</button>
      </div>

    </div>
</fieldset>
</form>
<script>

    layui.use(['laypage','layedit', 'form', 'element', 'laydate', 'layer'], function () {
        var form = layui.form()
            , layer = layui.layer,
            element = layui.element()
            , laydate = layui.laydate
            ,layedit = layui.layedit
            , laypage = layui.laypage
            , $ = layui.jquery;



        $("#marea option").each(function(){
            if($(this).val() == "${data.mArea}") {
                $(this).attr("selected",true)
            }
        });

        $("#mlang option").each(function(){
            if($(this).val() == "${data.mLang}") {
                $(this).attr("selected",true)
            }
        });
        $("#mlevel option").each(function(){
            if($(this).val() == "${data.mLevel}") {
                $(this).attr("selected",true)
            }
        });
        $("#mhide option").each(function(){
            if($(this).val() == "${data.mHide}") {
                $(this).attr("selected",true)
            }
        });
        $("#mplayfrom option").each(function(){
            if($(this).val() == "${data.mPlayfrom}") {
                $(this).attr("selected",true)
            }
        });
        $('input[name="title"]').val("${data.mName}");
        $('input[name="subtitle"]').val("${data.mSubname}");
        $('input[name="staring"]').val("${data.mStarring}");
        $('input[name="daoyan"]').val("${data.mDirected}");
        $('input[name="time"]').val("${data.mTime}");
        $('input[name="pic"]').val("${data.mPic}");
        $('textarea[name="playurl"]').val("${data.mPlayurl}");
        $('textarea[name="content"]').val("${data.mContent}");
        form.render('select');
        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        form.on('submit(btnsave)', function (data) {
                $.post('/admin/data/editor/save',
                    {
                        mId:${data.mId},
                        mClass: $("#mclass").val(),
                        mArea: $("#marea").val(),
                        mLang: $("#mlang").val(),
                        mPlayfrom: $("#mplayfrom").val(),
                        mLevel: $("#mlevel").val(),
                        mHide: $("#mhide").val(),
                        mName: $('input[name="title"]').val(),
                        mSubname: $('input[name="subtitle"]').val(),
                        mStarring: $('input[name="staring"]').val(),
                        mDirected: $('input[name="daoyan"]').val(),
                        mTime: $('input[name="time"]').val(),
                        mPic: $('input[name="pic"]').val(),
                        mPlayurl: $('input[name="playurl"]').val(),
                        mContent: $('input[name="content"]').val(),
                    },
                    function (res) {
                        if(res.code==200)
                        {

                            layer.msg("保存成功,两秒后跳转视频数据页面！！");
                            setTimeout(function () {

                                window.location.href="/admin/videodata";

                            }, 2000);


                        }else {
                                layer.msg("保存失败！！");
                        }

                    },"json");
            return false;
            });

        form.on('submit(btnblack)', function (data) {
            window.history.go(-1);
            return false;
        });
    });


</script>
</body>
</html>
