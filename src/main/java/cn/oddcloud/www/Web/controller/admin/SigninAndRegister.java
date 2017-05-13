package cn.oddcloud.www.Web.controller.admin;

import cn.oddcloud.www.Web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vog1g on 2017/5/10.
 */
@Controller
@RequestMapping("/admin")
public class SigninAndRegister {

    @Resource
    private UserService userService;

    @RequestMapping("/signin")
    public String signin(){
        return "/admin/signin";
    }

    @ResponseBody
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public Map<String,String> checkValue(@RequestParam(value = "loginusername",required = false)String loginusername, @RequestParam(value = "loginpassword",required = false)String loginpassword, HttpServletRequest httpServletRequest){
        int result = userService.UserNameIsExsit(loginusername); //查询name 和passworld
        //TODO 首先查name
        System.out.println("用户名："+loginusername+"密码："+loginpassword);
        HashMap<String,String> hashMap=new HashMap<>();


        if (result!=1)//查不到name
        {
            hashMap.put("code","100");

            hashMap.put("message","该用户不存在！");

        }else {//查到信息name
            //TODO 查name  和passworld
            int messageresult=userService.UserCheckAllMessage(loginusername, loginpassword);
            if (messageresult!=1)
            {
                hashMap.put("code","100");
                hashMap.put("message","密码错误！");
            }else {
                HttpSession httpSession=httpServletRequest.getSession();
                httpSession.setAttribute("username",loginusername);
                hashMap.put("code","200");
                hashMap.put("message","登录成功");
            }

        }
        return hashMap;
    }





}
