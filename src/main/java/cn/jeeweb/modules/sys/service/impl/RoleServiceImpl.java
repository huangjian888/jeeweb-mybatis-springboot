package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sys.entity.Role;
import cn.jeeweb.modules.sys.mapper.RoleMapper;
import cn.jeeweb.modules.sys.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("roleService")
public class RoleServiceImpl extends CommonServiceImpl<RoleMapper, Role> implements IRoleService {

	@Override
	public List<Role> findListByUserId(String userid) {
		return baseMapper.findRoleByUserId(userid);
	}

}
