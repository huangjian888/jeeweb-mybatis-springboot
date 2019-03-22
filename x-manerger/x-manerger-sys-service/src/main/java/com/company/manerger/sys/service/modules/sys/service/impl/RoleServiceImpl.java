package com.company.manerger.sys.service.modules.sys.service.impl;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.Role;
import com.company.manerger.sys.service.modules.sys.mapper.RoleMapper;
import com.company.manerger.sys.service.modules.sys.service.IRoleService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleService")
//@DS("master")
public class RoleServiceImpl extends CommonServiceImpl<RoleMapper, Role> implements IRoleService {

	@Override
	public List<Role> findListByUserId(String userid) {
		return baseMapper.findRoleByUserId(userid);
	}

}
