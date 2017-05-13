package cn.oddcloud.www.Web.controller.admin.spider_admin;

import cn.oddcloud.www.Spider.Api.BaseApiSpider;
import cn.oddcloud.www.Spider.Api.Yiledao.*;
import cn.oddcloud.www.Web.service.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * @param response
     * @return
     */
    @RequestMapping("/comedystart")
    public String ComedyStart(HttpServletRequest request, HttpServletResponse response) {

         HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_Comedy_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_Comedy_Spider.newInstance().stopAction();
            Yiledao_Comedy_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/comedystop")
    public String ComedyStop() {
        Yiledao_Comedy_Spider.newInstance().stopAction();
        return "index";
    }

    /**
     *配音采集api
     * @param request
     * @param response
     * @return
     */

    @RequestMapping("/dubbedstart")
    public String DubbedStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_Dubbed_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_Dubbed_Spider.newInstance().stopAction();
            Yiledao_Dubbed_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/dubbedstop")
    public String DubbedStop() {
        Yiledao_Dubbed_Spider.newInstance().stopAction();
        return "spidering";
    }


    /**
     * 集锦采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/jijinstart")
    public String JiJinStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_JiJin_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JiJin_Spider.newInstance().stopAction();
            Yiledao_JiJin_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/jijinstop")
    public String JiJinStop() {
        Yiledao_JiJin_Spider.newInstance().stopAction();
        return "index";
    }


    /**
     * 搞笑动画采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/jokescartoonstart")
    public String JokesCartoonStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_JokesCartoon_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JokesCartoon_Spider.newInstance().stopAction();
            Yiledao_JokesCartoon_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/jokescartoonstop")
    public String JokesCartoonStop() {
        Yiledao_JokesCartoon_Spider.newInstance().stopAction();
        return "index";
    }

    /**
     * 搞笑游戏采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/jokesgamestart")
    public String JokesGameStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_JokesGame_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JokesGame_Spider.newInstance().stopAction();
            Yiledao_JokesGame_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/jokesgamestop")
    public String JokesGameStop() {
        Yiledao_JokesGame_Spider.newInstance().stopAction();
        return "index";
    }

    /**
     * 搞笑牛人采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/jokespeoplestart")
    public String JokesPeopleStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_JokesPeople_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_JokesPeople_Spider.newInstance().stopAction();
            Yiledao_JokesPeople_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/jokespeoplestop")
    public String JokesPeopleStop() {
        Yiledao_JokesPeople_Spider.newInstance().stopAction();
        return "index";
    }


    /**
     * 搞笑直播采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/livestart")
    public String LiveStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_Live_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_Live_Spider.newInstance().stopAction();
            Yiledao_Live_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/livestop")
    public String LiveStop() {
        Yiledao_Live_Spider.newInstance().stopAction();
        return "index";
    }


    /**
     * 网络短剧采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/onlinedramastart")
    public String OnlineDramaStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_OnlineDrama_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_OnlineDrama_Spider.newInstance().stopAction();
            Yiledao_OnlineDrama_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/onlinedramastop")
    public String OnlineDramaStop() {
        Yiledao_OnlineDrama_Spider.newInstance().stopAction();
        return "index";
    }



    /**
     * 综艺采集api
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/varietyshowsstart")
    public String VarietyShowsStart(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession();

        if (session == null) {
            session.setAttribute("isFirstRequest", true);

            Yiledao_VarietyShows_Spider.newInstance().doAction(movieService);
        }else {
            Yiledao_VarietyShows_Spider.newInstance().stopAction();
            Yiledao_VarietyShows_Spider.newInstance().doAction(movieService);
        }
        return "spidering";
    }
    @RequestMapping("/varietyshowsstop")
    public String VarietyShowsStop() {
        Yiledao_VarietyShows_Spider.newInstance().stopAction();
        return "index";
    }

}
