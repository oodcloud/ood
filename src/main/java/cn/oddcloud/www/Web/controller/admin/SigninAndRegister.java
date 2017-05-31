package cn.oddcloud.www.Web.controller.admin;

import cn.oddcloud.www.Web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
        HashMap<String,String> hashMap=new HashMap<>();

        Subject subject = SecurityUtils.getSubject() ;

        UsernamePasswordToken token = new UsernamePasswordToken(loginusername,loginpassword) ;

        if (result!=1)//查不到name
        {
            hashMap.put("code","100");

            hashMap.put("message","该用户不存在！");

        }else {//查到信息name

            try {
                subject.login(token);
                Session session= subject.getSession();
                session.setTimeout(3000000);
                hashMap.put("code","200");
                hashMap.put("message","登录成功");

            }catch (Exception e){
                hashMap.put("code","100");
                hashMap.put("message","密码错误！");
            }

        }
        return hashMap;
    }


    @RequestMapping("/logout")
    public String logout(){

        SecurityUtils.getSubject().logout();
        return "/admin/signin";
    }


}
