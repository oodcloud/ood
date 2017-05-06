package cn.oddcloud.www.Web.service.impl;
import cn.generator.mapper.SysUserMapper;
import cn.generator.pojo.SysUser;
import cn.oddcloud.www.Web.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private SysUserMapper sysUserMapper;


	@Override
	public SysUser getById(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
}
