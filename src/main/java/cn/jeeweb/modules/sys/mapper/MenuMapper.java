package cn.jeeweb.modules.sys.mapper;

import cn.jeeweb.core.common.mapper.BaseTreeMapper;
import cn.jeeweb.modules.sys.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


	List<Menu> findMenuByUserId_Type(@Param("userId") String userId, @Param("type") String type);

	/**
	 * 
	 * @title: findMenuByRoleId
	 * @description: 通过角色查找菜单
	 * @param userId
	 * @return
	 * @return: List<Menu>
	 */
	List<Menu> findMenuByRoleId(String roleId);
}