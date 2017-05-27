package cn.oddcloud.www.Web.controller.admin.spider_admin;

import cn.oddcloud.www.Aop.AsycnImgDataShowByAop;
import cn.oddcloud.www.Aop.MovieDataShowByAop;
import cn.oddcloud.www.Spider.Api.Yiledao.*;
import cn.oddcloud.www.Web.service.MovieService;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.scheduler.Scheduler;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by vog1g on 2017/4/29.
 */

@Controller
@RequestMapping("/admin/api/spider")
public class SpiderController {
    @Resource
    private MovieService movieService;
    /**
     * 相声小品采集api
     *
     * @param request
     * @return
     */

//    @Scheduled(cron = "0 0 1 * * ?")
    @RequestMapping("/comedystart")
    public String ComedyStart(HttpServletRequest request) {


         HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

           long pagecount= Yiledao_Comedy_Spider.newInstance().doAction(movieService);
            System.out.println("pagecount:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+pagecount);
        }else {
            Yiledao_Comedy_Spider.newInstance().stopAction();
            Yiledao_Comedy_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }

    @RequestMapping("/comedystop")
    public String ComedyStop() {
        Yiledao_Comedy_Spider.newInstance().stopAction();
        return "index";
    }

    /**
     *配音采集api
     * @param request

     * @return
     */
    @RequestMapping("/dubbedstart")
    public String DubbedStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_Dubbed_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_Dubbed_Spider.newInstance().stopAction();
            Yiledao_Dubbed_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/dubbedstop")
    public String DubbedStop() {
        Yiledao_Dubbed_Spider.newInstance().stopAction();
        return "/admin/transactionpage";
    }


    /**
     * 集锦采集api
     * @param request

     * @return
     */
//    @Scheduled(cron = "0 0 3 * * ?")
    @RequestMapping("/jijinstart")
    public String JiJinStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_JiJin_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JiJin_Spider.newInstance().stopAction();
            Yiledao_JiJin_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/jijinstop")
    public String JiJinStop() {
        Yiledao_JiJin_Spider.newInstance().stopAction();
        return "index";
    }


    /**
     * 搞笑动画采集api
     * @param request

     * @return
     */
//    @Scheduled(cron = "0 0 4 * * ?")
    @RequestMapping("/jokescartoonstart")
    public String JokesCartoonStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_JokesCartoon_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JokesCartoon_Spider.newInstance().stopAction();
            Yiledao_JokesCartoon_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/jokescartoonstop")
    public String JokesCartoonStop() {
        Yiledao_JokesCartoon_Spider.newInstance().stopAction();
        return "index";
    }

    /**
     * 搞笑游戏采集api
     * @param request
     * @return
     */
//    @Scheduled(cron = "0 0 2 * * ?")
    @RequestMapping("/jokesgamestart")
    public String JokesGameStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_JokesGame_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JokesGame_Spider.newInstance().stopAction();
            Yiledao_JokesGame_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/jokesgamestop")
    public String JokesGameStop() {
        Yiledao_JokesGame_Spider.newInstance().stopAction();
        return "index";
    }

    /**
     * 搞笑牛人采集api
     * @param request

     * @return
     */
//    @Scheduled(cron = "0 0 3 * * ?")
    @RequestMapping("/jokespeoplestart")
    public String JokesPeopleStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_JokesPeople_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JokesPeople_Spider.newInstance().stopAction();
            Yiledao_JokesPeople_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/jokespeoplestop")
    public String JokesPeopleStop() {
        Yiledao_JokesPeople_Spider.newInstance().stopAction();
        return "index";
    }


    /**
     * 搞笑直播采集api
     * @param request

     * @return
     */
//    @Scheduled(cron = "0 0 5 * * ?")
    @RequestMapping("/livestart")
    public String LiveStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_Live_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_Live_Spider.newInstance().stopAction();
            Yiledao_Live_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/livestop")
    public String LiveStop() {



        Yiledao_Live_Spider.newInstance().stopAction();
        return "index";
    }


    /**
     * 网络短剧采集api
     * @param request

     * @return
     */
//    @Scheduled(cron = "0 0 4 * * ?")
    @RequestMapping("/onlinedramastart")
    public String OnlineDramaStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_OnlineDrama_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_OnlineDrama_Spider.newInstance().stopAction();
            Yiledao_OnlineDrama_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/onlinedramastop")
    public String OnlineDramaStop() {
        Yiledao_OnlineDrama_Spider.newInstance().stopAction();
        return "index";
    }



    /**
     * 综艺采集api
     * @param request

     * @return
     */
//    @Scheduled(cron = "0 0 5 * * ?")
    @RequestMapping("/varietyshowsstart")
    public String VarietyShowsStart(HttpServletRequest request) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            MovieDataShowByAop.movielistBlockingQueue.clear();
            AsycnImgDataShowByAop.imgqueue.clear();

            Yiledao_VarietyShows_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_VarietyShows_Spider.newInstance().stopAction();
            Yiledao_VarietyShows_Spider.newInstance().doAction(movieService);
        }
        return "/admin/transactionpage";
    }
    @RequestMapping("/varietyshowsstop")
    public String VarietyShowsStop() {
        Yiledao_VarietyShows_Spider.newInstance().stopAction();
        return "index";
    }

}
