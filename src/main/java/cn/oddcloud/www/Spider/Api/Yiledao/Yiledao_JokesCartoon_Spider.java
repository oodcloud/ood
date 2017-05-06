package cn.oddcloud.www.Spider.Api.Yiledao;

import cn.oddcloud.www.Spider.Api.BaseApiSpider;
import cn.oddcloud.www.Spider.PageProcessor.JokePageProcessor.Yiledao;
import cn.oddcloud.www.Spider.Pipeline.MovieBasePipline;
import cn.oddcloud.www.Spider.Utils.ConfigProperties;
import cn.oddcloud.www.Spider.enums.SpiderWebSiteURL;
import cn.oddcloud.www.Spider.enums.YiledaoInterfaceTargetURL;
import cn.oddcloud.www.Spider.enums.YiledaoMatchURL;
import cn.oddcloud.www.Web.service.MovieService;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.HashSetDuplicateRemover;

/**
 * Created by vog1g on 2017/5/3.
 */
public class Yiledao_JokesCartoon_Spider implements BaseApiSpider {
    private Spider spider;
    private static volatile Yiledao_JokesCartoon_Spider yiledaoSpider;
    private Yiledao_JokesCartoon_Spider(){
        Yiledao yiledao= (Yiledao) new Yiledao().setWebUrl(SpiderWebSiteURL.YILEDAO.getUrl()).
                setExtractorRule(YiledaoMatchURL.JOKESCARTOON_Regex.getUrl());
        spider= Spider.create(yiledao);
    }

    public Spider getSpider() {
        return spider;
    }
    @Override
    public void doAction(MovieService movieService) {

        spider.setScheduler(new QueueScheduler()
                .setDuplicateRemover(new HashSetDuplicateRemover())).
                addUrl(YiledaoInterfaceTargetURL.JOKESCARTOON.getUrl()).addPipeline(new MovieBasePipline.Builder(movieService).setmClass(ConfigProperties.type("搞笑动画",getClass())).newInstance()).
                thread(5).runAsync();
    }

    @Override
    public void stopAction() {
        spider.stop();
    }


    public static Yiledao_JokesCartoon_Spider newInstance() {
        if (yiledaoSpider==null)
        {
            synchronized (Yiledao_JokesCartoon_Spider.class)
            {
                yiledaoSpider= new Yiledao_JokesCartoon_Spider();
            }
        }
        return yiledaoSpider;
    }
}
