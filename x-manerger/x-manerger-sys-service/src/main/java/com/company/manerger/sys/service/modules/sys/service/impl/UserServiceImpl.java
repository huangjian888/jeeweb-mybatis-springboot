package com.company.manerger.sys.service.modules.sys.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.modules.sys.entity.Role;
import com.company.manerger.sys.service.modules.sys.entity.User;
import com.company.manerger.sys.service.modules.sys.entity.UserOrganization;
import com.company.manerger.sys.service.modules.sys.entity.UserRole;
import com.company.manerger.sys.service.modules.sys.mapper.UserMapper;
import com.company.manerger.sys.service.modules.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

//@Transactional
@Service
//@DS("master")
public class UserServiceImpl extends CommonServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	private IStoreUserService storeUserService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	PasswordService passwordService;
	@Autowired
	private IUserOrganizationService userOrganizationService;
	@Autowired
	private IUserRoleService userRoleService;

	@Override
	public void changePassword(String userid, String newPassword) {
		User user = selectById(userid);
		if (user != null) {
			user.setPassword(newPassword);
			passwordService.encryptPassword(user);
			user.setUpdateDate(new Date());
		}
		insertOrUpdate(user);
	}

	@Override
	public User findByUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return null;
		}
		return selectOne(new EntityWrapper<User>(User.class).eq("username", username));
	}

	@Override
	public User findByEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return null;
		}
		return selectOne(new EntityWrapper<User>(User.class).eq("email", email));
	}

	@Override
	public User findByPhone(String phone) {
		if (StringUtils.isEmpty(phone)) {
			return null;
		}
		return selectOne(new EntityWrapper<User>(User.class).eq("phone", phone));
	}

	@Override
	public boolean insert(User user) {
		passwordService.encryptPassword(user);
		return super.insert(user);
	}

	@Override
	public boolean deleteById(Serializable id) {
		// 删除角色关联
		userRoleService.delete(new EntityWrapper<UserRole>(UserRole.class).eq("userId", id));
		// 删除部门关联
		userOrganizationService.delete(new EntityWrapper<UserOrganization>(UserOrganization.class).eq("userId", id));
		return super.deleteById(id);
	}

	@Override
	public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
		for (Object id : idList) {
			this.deleteById((Serializable) id);
		}
		return true;
	}

	@Override
	public Page<User> selectPage(Page<User> page, Wrapper<User> wrapper) {
		wrapper.eq("1", "1");
		page.setRecords(baseMapper.selectUserList(page, wrapper));
		return page;
	}

	@Override
	public String queryDynamicDataSource() {
		String pwd = storeUserService.findByUsername("test").getPassword(); //从库
		List<Role> roleList = roleService.findListByUserId("40288ab85a362150015a3675ca950006"); //主库
		return "pwd";
	}

}
