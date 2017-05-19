package cn.oddcloud.www.Web.controller.admin;

import cn.generator.pojo.OodUserWithBLOBs;
import cn.oddcloud.www.Web.service.RoleService;
import cn.oddcloud.www.Web.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.rmi.MarshalledObject;
import java.util.Map;

/**
 * Created by vog1g on 2017/5/19.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;


    @RequestMapping("/save")
    @ResponseBody
    public Map<String, String> Save(OodUserWithBLOBs oodUserWithBLOBs) {
        Map<String, String> map = new HashedMap();
        int flag = userService.Save(oodUserWithBLOBs);
        if (flag == 1) {
            map.put("code", "200");
        } else {
            map.put("code", "100");
        }
        return map;
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Map<String, String> Del(@PathVariable("id")int id) {
        Map<String, String> map = new HashedMap();
        int flag = userService.DelUser(id);
        if (flag == 1) {
            map.put("code", "200");
        } else {
            map.put("code", "100");
        }
        return map;
    }


    @RequestMapping("/editor/{id}")
    public String Editor(@PathVariable("id") int id, Model model) {

        OodUserWithBLOBs oodUserWithBLOBs = userService.SelectUserById(id);
        model.addAttribute("rolelist",roleService.FindAll());
        model.addAttribute("usercontent",oodUserWithBLOBs);

        return "/admin/editoruser";
    }
    @RequestMapping("/editor/save")
    @ResponseBody
    public Map<String, String> EditorSave(OodUserWithBLOBs oodUserWithBLOBs) {
        Map<String, String> map = new HashedMap();
        int flag = userService.UpdataUser(oodUserWithBLOBs);
        if (flag == 1) {
            map.put("code", "200");
        } else {
            map.put("code", "100");
        }
        return map;
    }


}
