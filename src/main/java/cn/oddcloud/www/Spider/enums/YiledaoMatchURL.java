package cn.oddcloud.www.Spider.enums;

/**
 * Created by vog1g on 2017/5/3.
 * 爬虫的匹配规则
 *
 */


public enum YiledaoMatchURL {
    JOKESPEOPLE_Regex("gaoxiaoniuren/list_1_\\w+\\.html"),//搞笑牛人
    ONLINEDRAMA_Regex("lianzai/list_\\w+\\.html"),//网络短剧
    JOKESGAME_Regex("youxi/list_179_\\w+\\.html"),//搞笑游戏
    JOKESCARTOON_Regex("dongman/list_109_\\w+\\.html"),//搞笑动画
    COMEDY_Regex("xiaopinxiangsheng/list_\\w+\\.html"),//相声小品
    VarietyShows_Regex("zongyi/list_197_\\w+\\.html"),//综艺
    DUBBED_Regex("peiyin/list_105_\\w+\\.html"),//配音
    LIVE_Regex("zhibo/list_363_\\w+\\.html"),//直播
    JIJIN_Regex("qingsong/list_73_\\w+\\.html")//集锦
    ;




    private YiledaoMatchURL(String ruleurl){
        this.url=ruleurl;
    }

    public String getUrl() {
        return url;
    }

    private String url;

}
