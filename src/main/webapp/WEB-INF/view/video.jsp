<%--
  Created by IntelliJ IDEA.
  User: vog1g
  Date: 2017/5/28
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
    <%--<title>video++测试页面</title>--%>

<%--</head>--%>
<%--<body>--%>
<%--<div id="parent" style="width:748px;height:421px;"></div>--%>
<%--&lt;%&ndash;<script type="text/javascript" src="//cytroncdn.videojj.com/latest/cytron.core.js"></script>&ndash;%&gt;--%>

<%--<script type="text/javascript" src="http://7xjfim.com2.z0.glb.qiniucdn.com/flash_Iva.js"></script>--%>

<%--<script>--%>

<%--//    var ivaInstance = new Iva(--%>
<%--//        'parent',//父容器id--%>
<%--//        {--%>
<%--//            appkey: 'rkPMJX3JW',//必填，请在控制台查看应用标识--%>
<%--//            video: 'http://k.youku.com/player/getFlvPath/sid/04959582067031217607d/st/flv/fileid/0300020302590B7F4527C0131478ABF062C117-6E2B-184F-7FCE-7C2EAAD33A2D?k=3c1a0d1de397288b241305a7&hd=0&myp=0&ts=69&ctype=12&ev=1&token=0519&oip=2086519867&ep=ciadH0CIXswA4yTfiz8bZivkdHBbXP4J9h%2BFg9JhALkhQejNnkjVwp%2B3Pf9DFfgddSp3Yp3xrdKU%0Aa0ETYfY2qxoQ3kasT%2FrniIOW5aogxuVxF201cbzVwFSeRjH4&ccode=0401&duration=68&expire=18000&psid=b3e98e3d6402c743bad4c6732db3fc88&ups_client_netip=124.93.196.59&ups_ts=1495958206&ups_userid=&utid=RqdTEQmk9RsCAXxdxAjbzVmN&vid=XMjc0NTU3NTI3Ng%3D%3D&vkey=A09d4b27770f6259ec0b16f35e819da63',//必填，播放地址（例如：http://v.youku.com/v_show/id_XMTY5NDg2MzY5Ng==.html）--%>
<%--//            title: '小视频',//选填，建议填写方便后台数据统计--%>
<%--//            cover: '',//选填，视频封面url--%>
<%--//            playerUrl: '', //选填，第三方播放器与Video++互动层的桥接文件，由Video++官方定制提供，默认为空--%>
<%--//            videoStartPrefixSeconds: 0,//选填，跳过片头，默认为0--%>
<%--//            videoEndPrefixSeconds: 0,//选填，跳过片尾，默认为0--%>
<%--//            /* 以下参数可以在“控制台->项目看板->应用管理->播放器设置” >进行全局设置，前端设置可以覆盖全局设置 */--%>
<%--//            skinSelect: 0,//选填，播放器皮肤，可选0、1、2，默认为0，--%>
<%--//            autoplay: false,//选填，是否自动播放，默认为false--%>
<%--//            rightHand: true,//选填，是否开启右键菜单，默认为false--%>
<%--//            autoFormat: false,//选填，是否自动选择最高清晰度，默认为false--%>
<%--//            bubble: true,//选填，是否开启云泡功能，默认为true--%>
<%--//            jumpStep: 10,//选填，左右方向键快退快进的时间--%>
<%--//            tagTrack: false,//选填，云链是否跟踪，默认为false--%>
<%--//            tagShow: false,//选填，云链是否显示，默认为false--%>
<%--//            tagDuration: 5,//选填，云链显示时间，默认为5秒--%>
<%--//            tagFontSize: 16,//选填，云链文字大小，默认为16像素--%>
<%--//            editorEnable: true, // 选填，当用户登录之后，是否允许加载编辑器，默认为true--%>
<%--//            vorEnable: true, // 选填，是否允许加载灵悟，默认为true--%>
<%--//            vorStartGuideEnable: true //选填， 是否启用灵悟新人引导，默认为true--%>
<%--//        }--%>
<%--//    );--%>

<%--var ivaInstance = new Iva('parent', {--%>
    <%--appkey: 'rkPMJX3JW',--%>
    <%--video: 'http://k.youku.com/player/getFlvPath/sid/04959582067031217607d/st/flv/fileid/0300020302590B7F4527C0131478ABF062C117-6E2B-184F-7FCE-7C2EAAD33A2D?k=3c1a0d1de397288b241305a7&hd=0&myp=0&ts=69&ctype=12&ev=1&token=0519&oip=2086519867&ep=ciadH0CIXswA4yTfiz8bZivkdHBbXP4J9h%2BFg9JhALkhQejNnkjVwp%2B3Pf9DFfgddSp3Yp3xrdKU%0Aa0ETYfY2qxoQ3kasT%2FrniIOW5aogxuVxF201cbzVwFSeRjH4&ccode=0401&duration=68&expire=18000&psid=b3e98e3d6402c743bad4c6732db3fc88&ups_client_netip=124.93.196.59&ups_ts=1495958206&ups_userid=&utid=RqdTEQmk9RsCAXxdxAjbzVmN&vid=XMjc0NTU3NTI3Ng%3D%3D&vkey=A09d4b27770f6259ec0b16f35e819da63',--%>
    <%--title: '视频标题'--%>
<%--})--%>

<%--</script>--%>

<%--</body>--%>

<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css"
      href="http://g.alicdn.com/de/prismplayer/1.7.6/skins/default/index-min.css">
<script src="http://g.alicdn.com/de/prismplayer/1.7.6/prism-min.js"></script>

<script>
    function InitPlayer(){
        var player = new prismplayer({
            id: "J_prismPlayer",    // 容器id
            source: encodeURIComponent(decodeURIComponent('http://pl-ali.youku.com/playlist/m3u8?vid=XMjc0NTU3NTI3Ng%3D%3D&type=mp4&ups_client_netip=124.93.196.54&ups_ts=1495960033&utid=RqdTEQmk9RsCAXxdxAjbzVmN&ccode=0401&psid=5bb2a64defb42b6cf1119a945c6ecf86&ckey=&duration=853&expire=18000&ups_key=9436807091d95ae9f24df76efd169997')),  // 视频url 支持互联网可直接访问的视频地址
            autoplay: true,       // 自动播放
            width: "100%",        // 播放器宽度
            height: "400px"      // 播放器高度
        });
    }
</script>
<head>
    <title>自适应播放器示例</title>
</head>
<body>
<div id='J_prismPlayer' class='prism-player'></div>
<script type="text/javascript">InitPlayer()</script></body>
</html>
