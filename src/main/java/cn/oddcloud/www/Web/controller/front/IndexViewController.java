package cn.oddcloud.www.Web.controller.front;

import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Web.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vog1g on 2017/5/5.
 */
@Controller
public class IndexViewController {
    @Resource
    private MovieService movieService;
    //SortExplain.properties文件下
    //    搞笑牛人=1
    //    网络短剧=2
    //    搞笑游戏=3
    //    搞笑动画=4
    //    相声小品=5
    //    综艺=6
    //    配音=7
    //    直播=8
    //    集锦=9

    @RequestMapping("/")
    public String index(Model model){

        //搞笑牛人
        List<MovieWithBLOBs> JokesPeople_data= movieService.selectMoiveOrderByClass("1");
        model.addAttribute("jokespeople",JokesPeople_data);

        //网络短剧
        List<MovieWithBLOBs> OnlineDrama_data= movieService.selectMoiveOrderByClass("2");
        model.addAttribute("onlinedrama",OnlineDrama_data);

        //搞笑游戏
        List<MovieWithBLOBs> JokesGame_data= movieService.selectMoiveOrderByClass("3");
        model.addAttribute("jokesgame",JokesGame_data);

        //搞笑动画
        List<MovieWithBLOBs> JokesCartoon_data= movieService.selectMoiveOrderByClass("4");
        model.addAttribute("jokescartoon",JokesCartoon_data);

        //相声小品
        List<MovieWithBLOBs> Comedy_data= movieService.selectMoiveOrderByClass("5");
        model.addAttribute("comedy",Comedy_data);

        //综艺
        List<MovieWithBLOBs> VarietyShows_data= movieService.selectMoiveOrderByClass("6");
        model.addAttribute("varietyshows",VarietyShows_data);

        //配音
        List<MovieWithBLOBs> Dubbed_data= movieService.selectMoiveOrderByClass("7");
        model.addAttribute("dubbed",Dubbed_data);


        //直播
        List<MovieWithBLOBs> Live_data= movieService.selectMoiveOrderByClass("8");
        model.addAttribute("live",Live_data);

        //集锦
        List<MovieWithBLOBs> JiJin_data= movieService.selectMoiveOrderByClass("9");
        model.addAttribute("jijin",JiJin_data);

        return "vod_index";
    }


    @RequestMapping("/error")
    public String error404(){

        return "404";
    }
    @RequestMapping("/spider")
    public String spidering(){
        return "spidering";
    }

}
