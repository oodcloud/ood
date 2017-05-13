package cn.oddcloud.www.Web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Properties;

/**
 * Created by vog1g on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
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


    @RequestMapping("/videodata")
    public String videodata()
    {
        return "/admin/adminvideodata";
    }




}
