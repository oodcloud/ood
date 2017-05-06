package cn.oddcloud.www.Spider.enums;

/**
 * Created by vog1g on 2017/5/3.
 */
public enum  SpiderWebSiteURL {
    YILEDAO("http://www.yiledao.com/");

    private SpiderWebSiteURL(String url){
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    private String url;
}
