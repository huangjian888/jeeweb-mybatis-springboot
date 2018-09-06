package cn.jeeweb.modules.sys.mapper;


import cn.jeeweb.modules.sys.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
	/**
	 * 
	 * @title: findRoleByUserId   
	 * @description: 通过用户查找角色
	 * @param userId
	 * @return      
	 * @return: List<Role>
	 */
	List<Role> findRoleByUserId(String userId);
}
