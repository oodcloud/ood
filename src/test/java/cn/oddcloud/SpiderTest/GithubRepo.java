package cn.oddcloud.SpiderTest;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by vog1g on 2017/4/24.
 */
@TargetUrl("http://www.yiledao.com/\\w+/\\w+.html")
@HelpUrl("http://www.yiledao.com/gaoxiaoniuren/list_1_\\w+.html")
//http://www.yiledao.com/gaoxiaoniuren/list_1_2.html
public class GithubRepo {

    @ExtractBy(value = "//div[@class='sa-comic_show sa-comic_detail']/div/div/h1/text()", notNull = true)
    private String name;

    @ExtractByUrl("http://www.yiledao.com/\\w+/\\w+.html")
    private String author;

    @ExtractBy(value = "//div[@class='tab_css']/video/source/@src",notNull = false)
    private String readme;













    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("http://www.yiledao.com/qingsong/list_73_2.html").thread(1).run();
    }
}