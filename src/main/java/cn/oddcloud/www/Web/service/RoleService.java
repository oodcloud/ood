package cn.oddcloud.www.Web.service;

/**
 * Created by vog1g on 2017/5/17.
 */

import cn.generator.pojo.OodRole;

import java.util.List;

/**
 *
 * 功能使用：
 *
 * 添加角色 ‘名称 英文名称 是否启用 角色描述’
 * 编辑角色
 * 权限分配  那些东西可以查看
 * 删除角色
 * 查询角色
 *
 *
 */


public interface RoleService {
    int addrole();//添加角色
    List<OodRole> FindAll();//查询所有角色
}
