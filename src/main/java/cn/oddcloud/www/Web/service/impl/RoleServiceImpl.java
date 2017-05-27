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
    public List<OodRole> FindAll() {
        return oodRoleMapper.FindAll();
    }

    @Override
    public int Save(OodRole oodRole) {
        return oodRoleMapper.insert(oodRole);
    }

    @Override
    public OodRole SelectRoleById(int id) {
        return oodRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int DelRole(int id) {
        return oodRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int UpdataRole(OodRole oodRole) {
        return oodRoleMapper.updateByPrimaryKeySelective(oodRole);
    }
}
