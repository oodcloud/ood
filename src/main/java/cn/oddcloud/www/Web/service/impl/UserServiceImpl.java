package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.OodUserMapper;
import cn.generator.pojo.OodUser;
import cn.generator.pojo.OodUserWithBLOBs;
import cn.generator.pojo.UserWithRole;
import cn.oddcloud.www.Web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vog1g on 2017/5/10.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private OodUserMapper oodUserMapper;

    @Override
    public int UserNameIsExsit(String name) {
        return oodUserMapper.selectUserNameIsExsit(name);
    }

    @Override
    public int UserCheckAllMessage(String name, String passworld) {
        return oodUserMapper.selectUserCheckAllMessage(name,passworld);
    }

    @Override
    public List<UserWithRole> FindUserAdmin() {
        return oodUserMapper.FindUserAdmin();
    }

    @Override
    public int Save(OodUserWithBLOBs oodUser) {
        return oodUserMapper.insertSelective(oodUser);
    }

    @Override
    public OodUserWithBLOBs SelectUserById(int id) {
        return oodUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int DelUser(int id) {
        return oodUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int UpdataUser(OodUserWithBLOBs oodUserWithBLOBs) {
        return oodUserMapper.updateByPrimaryKeySelective(oodUserWithBLOBs);
    }

    @Override
    public Set<String> findRoles(String username) {
        return oodUserMapper.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        String power=oodUserMapper.findPermissions(username);
        String[] poweritem=power.split("\\,");
        Set<String> stringSet=new HashSet<>();
        for (int i = 0; i < poweritem.length; i++) {
            stringSet.add(poweritem[i]) ;
        }

        return stringSet;
    }

    @Override
    public OodUser findUserByUsername(String username) {
        return oodUserMapper.findUserByUsername(username);
    }
}
