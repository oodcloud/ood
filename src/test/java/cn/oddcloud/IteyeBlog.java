package cn.oddcloud;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author code4crafter@gmail.com <br>
 * Date: 13-8-2 <br>
 * Time: 上午7:52 <br>
 */
@TargetUrl("http://*.iteye.com/blog/*")
public class IteyeBlog implements Blog{

    @ExtractBy("//title")
    private String title;

    @ExtractBy(value = "div#blog_content",type = ExtractBy.Type.Css)
    private String content;

    @Override
    public String toString() {
        return "IteyeBlog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    /**

     http://k.youku.com/player/getFlvPath/sid/049304304512812eea875/st/flv/fileid/030002010058FA02A632FE1D40A78B88A24F72-13D1-0F33-1397-B3C7A5896A38?
     k=db455eb6f4e7c057261fa446&hd=0&
     myp=0&
     ts=403&
     ctype=12&
     ev=1&
     token=0544&
     oip=992919196&
     ep=ciadGUmJVc4E4CLdgD8bMnmzfHAKXP4J9h%2BFg9JjALshQJ7OmTygwZ6yOIpDYv0ZAyUOYuP52tLj%0AHEcWYfFA3WkQ3zirOvrh%2Ffnk5d9Qt5dxYxE%2FdLzUvFSeRjT1&ccode=0401&
     duration=402&
     expire=18000&
     psid=1d03f38a7e565b494e741a9a958cfafe&
     ups_client_netip=59.46.190.156&ups_ts=1493043045&
     ups_userid=1067781286&
     utid=RqdTEQmk9RsCAXxdxAjbzVmN&
     vid=XMjcyMTM0ODM0NA%3D%3D&
     vkey=A879129c4afd17aabc620b7d2d9d23f0a&
     yxon=1&
     special=true


     http://k.youku.com/player/getFlvPath/sid/049309855805112b1f4df/st/flv/fileid/030002010058C757B1A55213F608DD757BB612-89AC-3371-B3C8-D144A55220ED?
     k=6eece93caffa624b2412fc58&
     hd=0&
     myp=0&  -----不变
     ts=195&
     ymovie=1&
     ctype=12&  -----不变
     ev=1&  -----不变
     token=0509&
     oip=992919200&
     ep=ciadGUmEXssF7SPaiT8bNS20cCNZXP4J9h%2BFg9JjALshQJu4nDmjxuy1S%2F1DFY8fcipyZOz0rKKV%0AbEEWYfhK2BsQ3E2vOPqS%2FYPr5dlSwJRxYxw0cM2iwFSeRjD4&
     ccode=0401&
     duration=194&
     expire=18000&  -----不变
     psid=6babcf32a59209ad86d1c3c6f1ca9845&
     ups_client_netip=59.46.190.160&  -----不变
     ups_ts=1493098558&ups_userid=1067781286&
     utid=RqdTEQmk9RsCAXxdxAjbzVmN&  -----不变
     vid=XMjYzNzYyMTM4MA%3D%3D&  -----不变
     vkey=A96d2a2213625df1a4523064933229729&
     yxon=1& -----不变
     special=true -----不变






     http://play.youku.com/play/get.json?spm=5176.8246799.blogcont.4.OtHIyw&vid=XMjYzNzYyMTM4MA==&ct=10

     http://www.cnblogs.com/zhaojunjie/p/4009192.html

     http://www.bubuko.com/infodetail-1213170.html

     XMjcyOTA5ODMwNA%3D%3D


     分析url


     Cookie

     __ysuid=1489893479916xoJ; juid=01bbkis2gl2ob; __tft=1491061475084; __vtft=1491061487015; UM_distinctid=15b868b92af550-050348a9239c3d-7c153f41-1fa400-15b868b92b0a41; P_pck_rm=QkIXVrlN2w%2B%2BpRzVjVHdgIqX1sGx2xxHaoGC%2B9q1fzU0eflF2RZET7lq%2FqgBLakLilM9lkpb89gMl0N0CjpoNw6ct0U1kxLPvzYwx83AHJVO0c9zB%2FxH92ct32AdA%2BEZ; P_gck=NA%7CseNFg52%2FhtB1BqtFe%2FDSDw%3D%3D%7CNA%7C1492610966561; user_name=%E8%85%BE%E8%AE%AF%E7%94%A8%E6%88%B77945824191; __yscnt=1; yseid=1493098538241BxpnAi; yseidcount=9; rpvid=1493098543891otCgig-1493098554012; seid=01behsgu811vaf; referhost=http%3A%2F%2Fblog.csdn.net; __ayft=1493098538218; __aysid=1493041596006WYi; __arpvid=1493101651357BUOfqp-1493101651367; __arycid=dj-2-3072; __ayscnt=1; __arcms=dj-2-3072; __aypstp=5; __ayspstp=28; ypvid=1493101651371SxLQRd; ysestep=4; yseidtimeout=1493108851372; ycid=0; ystep=30; seidtimeout=1493103451377; cna=RqdTEQmk9RsCAXxdxAjbzVmN; P_sck=5z4Wnf8GSYWny%2BSA7fcwY%2F7yQrh1%2BV42KBCwmxBHLi17PyyNL4bgQztpD2SDYSYdgJSn8GwIP%2BY6aVZWcx%2FrKU%2BW5CXTVDbFyWYqEQvEBgiKwEh8EKf6NhnJSVqbATd9; yktk=AgADAAD%2F%2F%2F%2F%2FAAkA%7C1493101655%7C15%7CaWQ6MTA2Nzc4MTI4Nixubjrohb7orq%2FnlKjmiLc3OTQ1ODI0MTkxLHZpcDpmYWxzZSx5dGlkOjEwNjc3ODEyODYsdGlkOjA%3D%7C9178bc32e0d634884d5a7d840960dd67%7Ce3d67e31042507e7a76dab595189a1cfea2ae6b0%7C1; __ayvstp=4; __aysvstp=33

    能播的 http://k.youku.com/player/getFlvPath/sid/04931016554321266e037/st/flv/fileid/030002010058C757B1A55213F608DD757BB612-89AC-3371-B3C8-D144A55220ED?k=94b9bd33a39fe5432412fc5b&hd=0&myp=0&ts=195&ymovie=1&ctype=12&ev=1&token=0514&oip=992919186&ep=ciadGUiNV8gF4Cfcij8bYSq3dHQIXP4J9h%2BFg9JjALshQJu4nDmjxuy1S%2F1DFY8fcipyZOz0rKKV%0AbEEWYfhK2BsQ3E2vOPqS%2FYPr5dlSwJRxYxw0cM2iwFSeRjH1&ccode=0401&duration=194&expire=18000&psid=e83b93f59ff4205947c3973161132d3e&ups_client_netip=59.46.190.146&ups_ts=1493101655&ups_userid=1067781286&utid=RqdTEQmk9RsCAXxdxAjbzVmN&vid=XMjYzNzYyMTM4MA%3D%3D&vkey=A00ceb45356b8ed09b1775c321266ead4&yxon=1&special=true
    json获取的
         http://k.youku.com/player/getFlvPath/sid/049310162338612e2731d_00/st/mp4/fileid/030020010058C757A3A55213F608DD757BB612-89AC-3371-B3C8-D144A55220ED?k=a1192225dbffb02d2412fc5b&hd=1&myp=0&ts=195&ymovie=1&sign=1ace6fe1417199ed6132a8215ab1c436

        http://k.youku.com/player/getFlvPath/sid/04931018353631203b074_00/st/flv/fileid/030002010058C757B1A55213F608DD757BB612-89AC-3371-B3C8-D144A55220ED?k=7594f101826b4be0261fa498&hd=0&myp=0&ts=195&ymovie=1&sign=39b0df040a39c4ddc68a2d22452b7a23&d501f9f027158339261fa498&sign=39b0df040a39c4ddc68a2d22452b7a23

     过程：
     http://www.mamicode.com/info-detail-1219451.html


     http://player.youku.com/embed/unifull/unifull_.js?vid=XMjUyMzE2NTk4OA==&target=mp4&client_id=1067781286
     vid target client_id


     视频播放器
     http://www.mamicode.com/info-detail-1344696.html
     例子
     http://www.mamicode.com/info-detail-1417650.html



     http://182.140.217.174/youku/69729F00AC03A820C537835160/050008030058FFC6E576A208BD8A98B4D8F283-3555-7157-53DA-6FF8ED683470.m5v?
     sid=049318111324912ee0e5d&
     ctype=12&
     ccode=01010101&
     duration=393&
     expire=18000&
     psid=37d02f844680b3d4a96af7af7d3d77bb&
     ups_client_netip=59.46.190.147&
     ups_ts=1493181113&
     ups_userid=&
     utid=Vuu0QIEEIBYDAGdJzLDddxO6&
     vid=XMjcyOTA5ODMwNA%3D%3D&
     vkey=Ab2808bca4b5f372e865542df01e24fc9

     http://182.140.217.174/youku/6771F740F773181B989A8C5A3C/050008030058FFC6E576A208BD8A98B4D8F283-3555-7157-53DA-6FF8ED683470.m5v?
     sid=049318111324912ee0e5d&
     ctype=12&
     ccode=01010101&
     duration=393&
     expire=18000&
     psid=37d02f844680b3d4a96af7af7d3d77bb&
     ups_client_netip=59.46.190.147&
     ups_ts=1493181113&
     ups_userid=&
     utid=Vuu0QIEEIBYDAGdJzLDddxO6&
     vid=XMjcyOTA5ODMwNA%3D%3D&
     vkey=Ab2808bca4b5f372e865542df01e24fc9


     http://k.youku.com/player/getFlvPath/sid/049318269498910989ddc_00/st/flv/fileid/030002030058FFC5E476A208BD8A98B4D8F283-3555-7157-53DA-6FF8ED683470?k=a3c42064eb9359072412fc9e&hd=0&myp=0&ts=394&ymovie=1&sign=e57024fcf6f58750430bafd06a46d126
     http://182.140.217.174/youku/69729F00B643A820C5377061A9/050008030058FFC6E576A208BD8A98B4D8F283-3555-7157-53DA-6FF8ED683470.m5v?sid=049318111324912ee0e5d&ctype=12&ccode=01010101&duration=393&expire=18000&psid=37d02f844680b3d4a96af7af7d3d77bb&ups_client_netip=59.46.190.147&ups_ts=1493181113&ups_userid=&utid=Vuu0QIEEIBYDAGdJzLDddxO6&vid=XMjcyOTA5ODMwNA%3D%3D&vkey=Ab2808bca4b5f372e865542df01e24fc9
     *
     */

    public static void main(String[] args) {
        OOSpider.create(Site.me(), IteyeBlog.class).addUrl("http://flashsword20.iteye.com/blog").run();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
