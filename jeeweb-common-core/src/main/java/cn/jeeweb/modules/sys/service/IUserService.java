package cn.jeeweb.modules.sys.service;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.sys.entity.User;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: IUserService.java
 * @package cn.jeeweb.modules.sys.service
 * @description: 用户
 * @author: auth_team
 * @date: 2017年7月11日 下午9:21:07
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
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

}
