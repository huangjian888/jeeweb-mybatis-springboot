package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.User;
import cn.jeeweb.modules.sys.entity.UserOrganization;
import cn.jeeweb.modules.sys.entity.UserRole;
import cn.jeeweb.modules.sys.mapper.UserMapper;
//import cn.jeeweb.modules.sys.service.IUserOrganizationService;
import cn.jeeweb.modules.sys.service.IUserOrganizationService;
import cn.jeeweb.modules.sys.service.IUserRoleService;
import cn.jeeweb.modules.sys.service.IUserService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<UserMapper, User> implements IUserService {
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
		}
		insertOrUpdate(user);
	}

	@Override
	public User findByUsername(String username) {
		System.out.println("findByUsername-------------------------");
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

//	@Override
//	public boolean deleteBatchIds(List<? extends Serializable> idList) {
//		for (Object id : idList) {
//			this.deleteById((Serializable) id);
//		}
//		return true;
//	}

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

}
