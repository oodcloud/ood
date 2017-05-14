package cn.oddcloud.www.Web.controller.admin;

import cn.oddcloud.www.Utils.VideoDataLoadType;
import cn.oddcloud.www.Web.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * 后台列表跳转相关jsp功能
 *
 * Created by vog1g on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private MovieService movieService;

    @RequestMapping("/index")
    public String adminIndex(Model model) {


        return "/admin/index";
    }
    @RequestMapping("/welcome")
    @ModelAttribute
    public String welcome(Model model){
        //获取系统信息
        System.getProperties().list(System.out);
        Properties properties = System.getProperties();
        String osname = properties.getProperty("os.name");
        String encoding = properties.getProperty("file.encoding");
        String javaruntimeVersion = properties.getProperty("java.runtime.version");
        String Usejar = properties.getProperty("tomcat.util.scan.StandardJarScanFilter.jarsToSkip");
        String timezone=properties.getProperty("user.timezone");
        model.addAttribute("osname",osname);
        model.addAttribute("encoding",encoding);
        model.addAttribute("javaruntimeVersion",javaruntimeVersion);
        model.addAttribute("Usejar",Usejar);
        model.addAttribute("timezone",timezone);
        return "/admin/welcome";
    }

    /**
     *包括信息：
     * 查询
     * 视频分类m_class
     * 视频地区m_area
     * 视频语言m_lang
     * 视频播放器m_playfrom
     * 视频推荐m_level
     * 视频显隐m_hide 1显0隐
     * 最初打开视频数据时的视频数据
     *
     */
    @RequestMapping("/videodata")
    public String videodata(Model model)
    {

        model.addAttribute("m_class",movieService.getVideoClasses());
        model.addAttribute("m_area",movieService.getVideoAreas());
        model.addAttribute("m_lang",movieService.getVideoLangs());
        model.addAttribute("m_playfrom",movieService.getVideoPlayfroms());
        model.addAttribute("pagesize",movieService.getDynamicQueryMovieMoreInVideoDataPageSize(null,null,null,null,null,null,null));// 页面总数

        return "/admin/adminvideodata";
    }




}
