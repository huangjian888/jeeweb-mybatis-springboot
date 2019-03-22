package com.company.manerger.sys.service.modules.sys.mapper;

import java.util.List;

import com.company.manerger.sys.common.mybatis.mapper.BaseTreeMapper;
import com.company.manerger.sys.service.modules.sys.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseTreeMapper<Menu> {

	/**
	 * 
	 * @title: findMenuByUserId
	 * @description: 通过用户查找菜单
	 * @param userId
	 * @return
	 * @return: List<Menu>
	 */
	List<Menu> findMenuByUserId(String userId);
	
	/**
	 * 
	 * @title: findMenuByRoleId
	 * @description: 通过角色查找菜单
	 * @param roleId
	 * @return
	 * @return: List<Menu>
	 */
	List<Menu> findMenuByRoleId(String roleId);


	/**
	 *
	 * @title: findMenuByUserId
	 * @description: 通过用户查找菜单
	 * @param userId
	 * @return
	 * @return: List<Menu>
	 */
	List<String> findPermissionByUserId(String userId);

	/**
	 *
	 * @title: findMenuByRoleId
	 * @description: 通过角色查找菜单
	 * @param roleId
	 * @return
	 * @return: List<Menu>
	 */
	List<String> findPermissionByRoleId(String roleId);

}