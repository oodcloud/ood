package cn.oddcloud.www.Web.controller.admin;

import cn.generator.pojo.MovieWithBLOBs;
import cn.generator.pojo.MovieWithMovieClass;
import cn.oddcloud.www.Web.service.MovieService;
import cn.oddcloud.www.Web.service.VideoDataPageService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.bind.v2.TODO;
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
 * <p>
 * Created by vog1g on 2017/5/13.
 */
@Controller
@RequestMapping("/admin/data")
public class MovieVideoDataShowController {

    @Resource
    private VideoDataPageService videoDataPageService;

    /**
     * 获取选择的内容选项
     * from提交及提交后返回的视频数据
     * 最初打开视频数据时的视频数据
     */

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String querydata(@RequestParam("class") String mclass, @RequestParam("area") String area, @RequestParam("lang") String lang, @RequestParam("palyfrom") String palyfrom, @RequestParam("level") String level, @RequestParam("hide") String hide, @RequestParam("key") String key, Model model) {

        List<MovieWithMovieClass> blackInitData = videoDataPageService.getDynamicQueryMovieInVideoData(mclass, area, lang, palyfrom, level, hide, key);


        model.addAttribute("m_class", videoDataPageService.getVideoClasses());
        model.addAttribute("m_area", videoDataPageService.getVideoAreas());
        model.addAttribute("m_lang", videoDataPageService.getVideoLangs());
        model.addAttribute("m_playfrom", videoDataPageService.getVideoPlayfroms());
        model.addAttribute("pagesize", videoDataPageService.getDynamicQueryMovieMoreInVideoDataPageSize(null, null, null, null, null, null, null));// 页面总数

        return "/admin/adminvideodata";

    }

    @ResponseBody
    @RequestMapping(value = "/pageapi/{pageindex}", method = RequestMethod.GET)
    public HashMap<String, Object> pageApi(@PathVariable int pageindex, @RequestParam("mclass") String mclass, @RequestParam("marea") String marea, @RequestParam("mlang") String mlang, @RequestParam("mplayfrom") String mplayfrom, @RequestParam("mlevel") String mlevel, @RequestParam("mhide") String mhide, @RequestParam("key") String key) {
        HashMap<String, Object> map = new HashMap<>();
        List<MovieWithMovieClass> videodata = videoDataPageService.getDynamicQueryMovieMoreInVideoData(mclass, marea, mlang, mplayfrom, mlevel, mhide, key, pageindex);
        int pagesize = videoDataPageService.getDynamicQueryMovieMoreInVideoDataPageSize(mclass, marea, mlang, mplayfrom, mlevel, mhide, key);
        map.put("videodata", videodata);
        map.put("pagesize", pagesize);
        return map;
    }

    /**
     * 批量删除视频数据
     *
     * @param midlist 要删除视频id数组
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del")
    public Map<String, Object> videoDataDel(@RequestParam("midlist[]") int[] midlist) {

        Map<String, Object> map = new HashedMap();
        int size = videoDataPageService.DeleteVideoDatas(midlist);
        if (midlist.length == size) {
            map.put("code", 200);
        } else {
            if (size >= 1) {
                map.put("code", 100);//部分插入成功
            } else if (size < 1) {
                map.put("code", 300);//插入失败
            }
        }
        return map;
    }

    /**
     * 批量更新推荐等级
     *
     * @param midlist 要更新视频id数组
     * @param level   视频推荐值
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatalevel")
    public Map<String, Object> videoDataLevelUpdata(@RequestParam("midlist[]") int[] midlist, @RequestParam("level") String level) {
        Map<String, Object> map = new HashedMap();
        int size = videoDataPageService.UpdataLevelVideoDatas(midlist, level);
        if (midlist.length == size) {
            map.put("code", 200);
        } else {
            if (size >= 1) {
                map.put("code", 100);//部分插入成功
            } else if (size < 1) {
                map.put("code", 300);//插入失败
            }
        }
        return map;
    }

    /**
     * 批量更新分类
     *
     * @param midlist 要更新视频id数组
     * @param mclass  分类值
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatasort")
    public Map<String, Object> videoDataSortUpdata(@RequestParam("midlist[]") int[] midlist, @RequestParam("mclass") String mclass) {

        Map<String, Object> map = new HashedMap();
        int size = videoDataPageService.UpdataSortVideoDatas(midlist, mclass);
        if (midlist.length == size) {
            map.put("code", 200);
        } else {
            if (size >= 1) {
                map.put("code", 100);//部分插入成功
            } else if (size < 1) {
                map.put("code", 300);//插入失败
            }
        }
        return map;

    }

    /**
     *
     * 单个删除
     *
     * @param mid 要删除视频id
     * @return 状态值
     */

    @ResponseBody
    @RequestMapping("/singledel")
    public Map<String, Object> videoDataSingleDelete(@RequestParam("mid") int mid) {
        Map<String, Object> map = new HashedMap();

        int size =  videoDataPageService.DeleteVideoData(mid);
        if (size >= 1) {
            map.put("code", 200);//部分插入成功
        } else if (size < 1) {
            map.put("code", 100);//插入失败
        }


        return map;
    }

    /**
     * 视频编辑
     *
     * @param mid 视频id
     * @param model
     * @return  跳转到视频编辑页面
     */

    @RequestMapping("/editor/{mid}")
    public String videoDataEditor(@PathVariable("mid")int mid, Model model) {
        model.addAttribute("data",videoDataPageService.selectMovieById(mid));
        model.addAttribute("m_class", videoDataPageService.getVideoClasses());
        model.addAttribute("m_playfrom", videoDataPageService.getVideoPlayfroms());
        return "/admin/editorvideo";
    }


    @ResponseBody
    @RequestMapping(value = "/editor/save",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public Map<String,Object> videoDataEditorSave( MovieWithBLOBs movieWithBLOBs){
         Map<String,Object> map=new HashedMap();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+JSON.toJSONString(movieWithBLOBs));


        int flag=videoDataPageService.UpdataVideoData(movieWithBLOBs);
        if (flag==1)
        {
            map.put("code",200);
        }else {
            map.put("code",100);
        }

        return map;
    }



}
