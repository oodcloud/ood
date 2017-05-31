package cn.oddcloud.www.Web.service;

/**
 * Created by vog1g on 2017/5/10.
 */

import cn.generator.pojo.OodUser;
import cn.generator.pojo.OodUserWithBLOBs;
import cn.generator.pojo.UserWithRole;

import java.util.List;
import java.util.Set;

/**
 *
 * 查询管理员
 * 删除管理员
 * 编辑管理员
 * 添加管理员
 */


public interface UserService {
    int UserNameIsExsit(String name);
    int UserCheckAllMessage(String name,String passworld);
    List<UserWithRole> FindUserAdmin();//查询普通管理员
    int Save(OodUserWithBLOBs oodUserWithBLOBs);
    OodUserWithBLOBs SelectUserById(int id);
    int DelUser(int id);
    int UpdataUser(OodUserWithBLOBs oodUserWithBLOBs);


    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    OodUser findUserByUsername(String username);
}
