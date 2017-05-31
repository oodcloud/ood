package cn.oddcloud.www.Web.controller.admin;

import cn.generator.pojo.OodRole;
import cn.generator.pojo.OodUserWithBLOBs;
import cn.oddcloud.www.Web.service.RoleService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.javascript.navig.Array;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by vog1g on 2017/5/19.
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {
    @Resource
    private RoleService roleService;
    @RequestMapping("/save")
    @ResponseBody
    public Map<String, String> Save(OodRole oodRole) {
        Map<String, String> map = new HashedMap();
        int flag = roleService.Save(oodRole);
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
        int flag = roleService.DelRole(id);
        if (flag == 1) {
            map.put("code", "200");
        } else {
            map.put("code", "100");
        }
        return map;
    }


    @RequestMapping("/editor/{id}")
    public String Editor(@PathVariable("id") int id, Model model) {

        OodRole oodRole = roleService.SelectRoleById(id);
        String powers=oodRole.getrPower();
        String[] power=powers.split("\\,");
        List<String> pw= Arrays.asList(power);
        model.addAttribute("rolecontent",oodRole);
        model.addAttribute("pw",pw);
        return "/admin/editorrole";
    }
    @RequestMapping("/editor/save")
    @ResponseBody
    public Map<String, String> EditorSave(OodRole oodRole) {
        Map<String, String> map = new HashedMap();
        int flag = roleService.UpdataRole(oodRole);
        if (flag == 1) {
            map.put("code", "200");
        } else {
            map.put("code", "100");
        }
        return map;
    }


}
