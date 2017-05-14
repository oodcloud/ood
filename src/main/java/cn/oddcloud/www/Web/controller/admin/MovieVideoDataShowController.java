package cn.oddcloud.www.Web.controller.admin;

import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;
import cn.oddcloud.www.Web.service.MovieService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台视频中的视频数据页面对应相关
 *
 * Created by vog1g on 2017/5/13.
 */
@Controller
@RequestMapping("/admin/data")
public class MovieVideoDataShowController {

    @Resource
    private MovieService movieService;
    /**
     *
     *  获取选择的内容选项
     * from提交及提交后返回的视频数据
     * 最初打开视频数据时的视频数据
     *
     */

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String querydata(@RequestParam("class")String mclass, @RequestParam("area")String area, @RequestParam("lang")String lang, @RequestParam("palyfrom")String palyfrom, @RequestParam("level")String level, @RequestParam("hide")String hide,  @RequestParam("key")String key,Model model){

     List<MovieWithMovieClass> blackInitData=   movieService.getDynamicQueryMovieInVideoData(mclass,area,lang,palyfrom,level,hide,key);



        model.addAttribute("m_class",movieService.getVideoClasses());
        model.addAttribute("m_area",movieService.getVideoAreas());
        model.addAttribute("m_lang",movieService.getVideoLangs());
        model.addAttribute("m_playfrom",movieService.getVideoPlayfroms());
        model.addAttribute("pagesize",movieService.getDynamicQueryMovieMoreInVideoDataPageSize(null,null,null,null,null,null,null));// 页面总数

        return "/admin/adminvideodata";

    }

    @ResponseBody
    @RequestMapping(value = "/pageapi/{pageindex}",method = RequestMethod.GET)
    public HashMap<String,Object> pageApi(@PathVariable int pageindex,@RequestParam("mclass")String mclass, @RequestParam("marea")String marea, @RequestParam("mlang")String mlang, @RequestParam("mplayfrom")String mplayfrom, @RequestParam("mlevel")String mlevel, @RequestParam("mhide")String mhide,  @RequestParam("key")String key){
        HashMap<String,Object> map=new HashMap<>();
         List<MovieWithMovieClass>  videodata=movieService.getDynamicQueryMovieMoreInVideoData(mclass,marea,mlang,mplayfrom,mlevel,mhide,key,pageindex);
         int pagesize=movieService.getDynamicQueryMovieMoreInVideoDataPageSize(mclass,marea,mlang,mplayfrom,mlevel,mhide,key);
        map.put("videodata",videodata);
        map.put("pagesize",pagesize);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/del")
    public Map<String,Object> videoDataDel(@RequestParam("midlist[]")String[] midlist){


        System.out.println("返回的数据：》》》》》》》》》》》》》》》》》》"+JSON.toJSONString(midlist));
        Map<String,Object> map=new HashedMap();
        //TODO 删除操作
        map.put("code",200);


        return map;
    }

}
