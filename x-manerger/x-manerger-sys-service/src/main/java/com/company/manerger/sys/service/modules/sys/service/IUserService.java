package com.company.manerger.sys.service.modules.sys.service;

import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.company.manerger.sys.service.modules.sys.entity.User;

/**
 * @description: 用户
 *
 */
public interface IUserService extends ICommonService<User> {
	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(String userid, String newPassword);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * 根据Email查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByEmail(String email);

	/**
	 * 根据Email查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByPhone(String phone);

	/**
	 * 获取不同数据源数据
	 * 测试用例
	 * @return
	 */
	public String queryDynamicDataSource();
}
