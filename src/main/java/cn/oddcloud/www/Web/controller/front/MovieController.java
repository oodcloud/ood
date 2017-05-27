package cn.oddcloud.www.Web.controller.front;

import cn.generator.pojo.Movie;
import cn.generator.pojo.MovieWithBLOBs;
import cn.oddcloud.www.Parse.YoukuParseEnitity;
import cn.oddcloud.www.Spider.Api.Yiledao.*;
import cn.oddcloud.www.Web.Entity.PlayContentEntity;
import cn.oddcloud.www.Web.service.MovieService;
import cn.oddcloud.www.Web.service.PlayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


/**
 * Created by vog1g on 2017/5/6.
 */

@Controller
public class MovieController {
    @Resource
    private MovieService movieService;
    @Resource
    private PlayService playService;
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
    @ResponseBody
    @RequestMapping(value = "/api/list/{type}/v/{page}", method = RequestMethod.GET)
    public Map<String, List<MovieWithBLOBs>> loadMoreData(@PathVariable String type, @PathVariable int page) {
        HashMap<String, List<MovieWithBLOBs>> hashMap = new HashMap<>();
        hashMap.put("data", movieService.selectMoiveOrderByClassMore(type, page));
        return hashMap;
    }


    @RequestMapping(value = "/v_show/id_{vid}", method = RequestMethod.GET)
    public String playVideo(@PathVariable String vid,Model model) {
        List<YoukuParseEnitity.SegsBean> urls= playService.getPlayRealUrl(vid);
        PlayContentEntity playContentEntity= playService.getOtherPlayMessage(vid);
        model.addAttribute("othervideos",playContentEntity.getMovieWithBLOBsList());
        model.addAttribute("title",playContentEntity.getVideoname());
        model.addAttribute("owntypename",playContentEntity.getVideotypename());
        model.addAttribute("playurl",urls);

        return "vod_play";
    }


}
