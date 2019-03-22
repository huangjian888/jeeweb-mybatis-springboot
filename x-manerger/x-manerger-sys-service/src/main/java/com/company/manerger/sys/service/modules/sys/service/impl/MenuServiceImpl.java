package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.TreeCommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.Menu;
import com.company.manerger.sys.service.modules.sys.mapper.MenuMapper;
import com.company.manerger.sys.service.modules.sys.service.IMenuService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("menuService")
public class MenuServiceImpl extends TreeCommonServiceImpl<MenuMapper, Menu, String> implements IMenuService {

	@Override
	public List<Menu> findMenuByUserId(String userId) {
		return baseMapper.findMenuByUserId(userId);
	}

	@Override
	public List<Menu> findMenuByRoleId(String roleId) {
		return baseMapper.findMenuByRoleId(roleId);
	}

	@Override
	public List<String> findPermissionByUserId(String userId) {
		return baseMapper.findPermissionByUserId(userId);
	}

	@Override
	public List<String> findPermissionByRoleId(String roleId) {
		return baseMapper.findPermissionByRoleId(roleId);
	}
}
