package cn.oddcloud.www.Web.controller.admin;

import cn.oddcloud.www.Utils.VideoDataLoadType;
import cn.oddcloud.www.Web.service.MovieService;
import cn.oddcloud.www.Web.service.RoleService;
import cn.oddcloud.www.Web.service.UserService;
import cn.oddcloud.www.Web.service.VideoDataPageService;
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
    private UserService userService;
    @Resource
    private VideoDataPageService videoDataPageService;
    @Resource
    private RoleService roleService;

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
     * 最初打开视频数据时的视频数据
     *
     */
    @RequestMapping("/videodata")
    public String videodata(Model model)
    {

        model.addAttribute("m_class",videoDataPageService.getVideoClasses());
        model.addAttribute("m_area",videoDataPageService.getVideoAreas());
        model.addAttribute("m_lang",videoDataPageService.getVideoLangs());
        model.addAttribute("m_playfrom",videoDataPageService.getVideoPlayfroms());
        model.addAttribute("pagesize",videoDataPageService.getDynamicQueryMovieMoreInVideoDataPageSize(null,null,null,null,null,null,null));// 页面总数

        return "/admin/adminvideodata";
    }


    /**
     * 管理员菜单相关
     *
     */

    @RequestMapping("/usermanage")
    public String usermanage(Model model){
      model.addAttribute("rolelist",roleService.FindAll());
      model.addAttribute("userlist",userService.FindUserAdmin());
        return "/admin/usermanage";
    }
    /**
     *
     * 角色管理
     */
    @RequestMapping("/rolemanage")
    public String rolemanage(Model model){

        model.addAttribute("rolelist",roleService.FindAll());
        return "/admin/rolemanage";
    }



    /**
     * 添加管理员
     * @return
     */
    @RequestMapping("/addadminuser")
    public String addadminuser(){




        return "/admin/addadmin";
    }

//    /**
//     * 修改密码
//     * @return
//     */
//    @RequestMapping("/changepassworld")
//    public String changepassworld(){
//
//
//        return "/admin/changepassword";
//    }
//
//
//    /**
//     * 删除管理员
//     * @return
//     */
//    @RequestMapping("/deleteadmin")
//    public String deleteadmin(){
//
//
//        return "/admin/deleteadmin";
//    }
//
//    /**
//     * 设置权限
//     * @return
//     */
//    @RequestMapping("/settingauth")
//    public String settingauth(){
//
//
//        return "/admin/settingauth";
//    }

    /**
     * 在线采集
     * @return
     */
    @RequestMapping("/collectunion")
    public String collectunion(){


        return "/admin/collectunion";
    }

    /**
     * 定时采集
     * @return
     */
    @RequestMapping("/collecttimer")
    public String collecttimer(){


        return "/admin/collecttimer";
    }

}
