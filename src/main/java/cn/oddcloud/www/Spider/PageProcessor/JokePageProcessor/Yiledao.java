package cn.oddcloud.www.Spider.PageProcessor.JokePageProcessor;

import cn.oddcloud.www.Spider.PageProcessor.Interface.AbstractPageProcessor;
import com.alibaba.fastjson.JSON;
import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vog1g on 2017/4/30.
 */
public class Yiledao extends AbstractPageProcessor {

    public Yiledao(){
        setWebCharset("gb2312");
    }


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
        page.addTargetRequests(page.getHtml().links().regex(getTARGETURL()).all());
    }
}
