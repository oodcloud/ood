package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.OodRoleMapper;
import cn.generator.pojo.OodRole;
import cn.oddcloud.www.Web.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vog1g on 2017/5/19.
 */
@Service
public class RoleServiceImpl  implements RoleService{
    @Resource
    private OodRoleMapper oodRoleMapper;
    @Override
    public int addrole() {
        return 0;
    }

    @Override
    public List<OodRole> FindAll() {
        return oodRoleMapper.FindAll();
    }
}
