package cn.oddcloud.www.Web.service.impl;

import cn.generator.mapper.OodUserMapper;
import cn.generator.pojo.OodUser;
import cn.oddcloud.www.Web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
