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



    public static final String URL_LIST = "http://www.yiledao.com/gaoxiaoniuren/list_\\w+\\.html";

    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("gb2312");

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
//           DownloadUtils.DOWN.imgDownUrl( val[i],"./imgs",val[i].hashCode()+System.currentTimeMillis()+".jpg");
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
