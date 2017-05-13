package cn.oddcloud.www.Spider.PageProcessor.JokePageProcessor;

import com.alibaba.fastjson.JSON;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vog1g on 2017/4/28.
 */

public class YiledaoProcessor implements PageProcessor {

//    Cookie: juid=01bcl310s4n59;
//    ysestep=1;
//    yseidcount=4;
//    ystep=10;
//    playMode=3;
//    P_pck_rm=QkIXVrlN2w%2B%2BpRzVjVHdgIqX1sGx2xxHaoGC%2B9q1fzU0eflF2RZET7lq%2FqgBLakLilM9lkpb89gMl0N0CjpoNw6ct0U1kxLPvzYwx83AHJVO0c9zB%2FxH92ct32AdA%2BEZ;
//    yktk=AgADAAD%2F%2F%2F%2F%2FAAAA%7C1492610966%7C15%7CaWQ6MTA2Nzc4MTI4Nixubjrohb7orq%2FnlKjmiLc3OTQ1ODI0MTkxLHZpcDpmYWxzZSx5dGlkOjEwNjc3ODEyODYsdGlkOjA%3D%7C20dad7f5507d4f19590ad7223622a455%7C4a1d92ba5ee57390e2fa9d384148405c8605cfd6%7C1;
//    P_gck=NA%7CseNFg52%2FhtB1BqtFe%2FDSDw%3D%3D%7CNA%7C1492610966561;
//    u_id=1067781286;
//     HasLoaded=true;
//    _zpdtk=a5c612b92f448056a7159fd74d0eedba5d6fe5a9;
//    P_sck=5z4Wnf8GSYWny%2BSA7fcwY%2F7yQrh1%2BV42KBCwmxBHLi17PyyNL4bgQztpD2SDYSYdgJSn8GwIP%2BY6aVZWcx%2FrKTaFFvJ7TamD%2BorZf66KU0ZuEBZOyRAav4e6Sny9iT1r;
//    __ysuid=1489893479916xoJ;
//    cna=RqdTEQmk9RsCAXxdxAjbzVmN;
//    l=Aufnn7FoRMBKGKiFZMUqKAU89xG33rky;
//    isg=Au_v5inF6mhF_O5Ud9mCQG9EfgPkJrN52h-K6wF6OdwZUAhSDmSjB01GpPcU

    public static final String URL_LIST = "http://www.yiledao.com/gaoxiaoniuren/list_\\w+\\.html";

    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("utf-8");
  //土豆cookie
//    .addCookie("juid", "01bcl310s4n59")
//            .addCookie("ysestep", "1")
//            .addCookie("yseidcount", "4")
//            .addCookie("ystep", "10")
//            .addCookie("playMode", "3")
//            .addCookie("P_pck_rm", "QkIXVrlN2w%2B%2BpRzVjVHdgIqX1sGx2xxHaoGC%2B9q1fzU0eflF2RZET7lq%2FqgBLakLilM9lkpb89gMl0N0CjpoNw6ct0U1kxLPvzYwx83AHJVO0c9zB%2FxH92ct32AdA%2BEZ")
//            .addCookie("yktk", "AgADAAD%2F%2F%2F%2F%2FAAAA%7C1492610966%7C15%7CaWQ6MTA2Nzc4MTI4Nixubjrohb7orq%2FnlKjmiLc3OTQ1ODI0MTkxLHZpcDpmYWxzZSx5dGlkOjEwNjc3ODEyODYsdGlkOjA%3D%7C20dad7f5507d4f19590ad7223622a455%7C4a1d92ba5ee57390e2fa9d384148405c8605cfd6%7C1")
//            .addCookie("P_gck", "NA%7CseNFg52%2FhtB1BqtFe%2FDSDw%3D%3D%7CNA%7C1492610966561")
//            .addCookie("u_id", "1067781286")
//            .addCookie("HasLoaded", "true")
//            .addCookie("_zpdtk", "a5c612b92f448056a7159fd74d0eedba5d6fe5a9")
//            .addCookie("P_sck", "5z4Wnf8GSYWny%2BSA7fcwY%2F7yQrh1%2BV42KBCwmxBHLi17PyyNL4bgQztpD2SDYSYdgJSn8GwIP%2BY6aVZWcx%2FrKTaFFvJ7TamD%2BorZf66KU0ZuEBZOyRAav4e6Sny9iT1r")
//            .addCookie("__ysuid", "1489893479916xoJ")
//            .addCookie("cna","RqdTEQmk9RsCAXxdxAjbzVmN")
//            .addCookie("l","Aufnn7FoRMBKGKiFZMUqKAU89xG33rky")
//            .addCookie("isg","Au_v5inF6mhF_O5Ud9mCQG9EfgPkJrN52h-K6wF6OdwZUAhSDmSjB01GpPcU")

    @Override
    public void process(Page page) {
        List<String> images = page.getHtml().xpath("//div[@class='box-bd']/ul/li/a/img/@src").all();
        List<String> urllist = new ArrayList<>();
        String[] val = new String[40];
        val = images.toArray(val);
        for (int i = 0; i < val.length; i++) {
            String[] a = val[i].split("\\/");
            urllist.add(a[3].split("\\.")[0]);//在图片中那其优酷数据
            val[i] = "http://www.yiledao.com" + val[i];
        }
        images.clear();
        images = Arrays.asList(val);
        List<String> titles = page.getHtml().xpath("//div[@class='box-bd']/ul/li/a/img/@alt").all();
        page.putField("images", JSON.toJSONString(images));
        page.putField("title", JSON.toJSONString(titles));
        page.putField("url", JSON.toJSONString(urllist));

        page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());


    }


    @Override
    public Site getSite() {
        return site;
    }


}
