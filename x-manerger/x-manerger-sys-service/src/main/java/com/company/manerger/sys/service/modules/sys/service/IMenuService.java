package com.company.manerger.sys.service.modules.sys.service;

import java.util.List;

import com.company.manerger.sys.common.mybatis.service.ITreeCommonService;
import com.company.manerger.sys.service.modules.sys.entity.Menu;

/**
 */
public interface IMenuService extends ITreeCommonService<Menu, String> {

	/**
	 * 通过用户ID查找菜单
	 * 
	 * @return
	 */
	List<Menu> findMenuByUserId(String userId);

	/**
	 * 通过角色查找菜单
	 * 
	 * @return
	 */
	List<Menu> findMenuByRoleId(String roleId);

	/**
	 * 通过用户ID查找菜单
	 *
	 * @return
	 */
	List<String> findPermissionByUserId(String userId);

	/**
	 * 通过用户ID查找菜单
	 *
	 * @return
	 */
	List<String> findPermissionByRoleId(String roleId);
}
