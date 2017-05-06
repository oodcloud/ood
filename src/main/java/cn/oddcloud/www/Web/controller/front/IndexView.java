package cn.oddcloud.www.Web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vog1g on 2017/5/5.
 */
@Controller
public class IndexView {

    @RequestMapping("/")
    public String index(){

        return "vod_index";
    }


    @RequestMapping("/error")
    public String error404(){

        return "404";
    }



}
