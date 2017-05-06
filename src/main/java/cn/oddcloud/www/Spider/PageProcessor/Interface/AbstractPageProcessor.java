package cn.oddcloud.www.Spider.PageProcessor.Interface;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by vog1g on 2017/4/30.
 */
public abstract class AbstractPageProcessor implements PageProcessor, SpiderWebUrlInterface<String>, SpiderWebExtractorRuleInterface<String>, SpiderWebCharsetInterface<String>,SpiderWebEntendUrlRuleInterface<String>{
    private String charset;

    private String Urls;
    private String urlrole;
    private String extendurlrole;
    public String TARGETURL;
    public String EXTENDSURL;

    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(1000).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset(charset);


    @Override
    public AbstractPageProcessor setExtractorRule(String urlrole) {
        this.urlrole=urlrole;
        return this;
    }

    public String getTARGETURL() {
        TARGETURL=Urls+urlrole;
        return TARGETURL;
    }

    public String getEXTENDSURL() {
        EXTENDSURL=Urls+extendurlrole;
        return EXTENDSURL;
    }

    @Override
    public AbstractPageProcessor setWebUrl(String s) {
        Urls=s;
        return this;
    }

    @Override
    public AbstractPageProcessor setExtendUrlRule(String s) {
        extendurlrole=s;

        return this;
    }

    @Override
    public AbstractPageProcessor setWebCharset(String charset) {
        this.charset = charset;
        return this;
    }

    @Override
    public Site getSite() {
        return site;
    }


}
