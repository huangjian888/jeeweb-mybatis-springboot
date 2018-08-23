package cn.jeeweb.modules.sys.utils;

import cn.jeeweb.core.utils.*;
import cn.jeeweb.modules.sys.entity.Menu;
import cn.jeeweb.modules.sys.entity.Role;
import cn.jeeweb.modules.sys.entity.User;
import cn.jeeweb.modules.sys.security.shiro.realm.UserRealm.Principal;
import cn.jeeweb.modules.sys.service.IMenuService;
import cn.jeeweb.modules.sys.service.IRoleService;
import cn.jeeweb.modules.sys.service.IUserService;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * All rights Reserved, Designed By www.jeeweb.cn
 *
 * @title: UserUtils.java
 * @package cn.jeeweb.modules.sys.utils
 * @description: 用户工具类
 * @author: auth_team
 * @date: 2017年6月26日 下午6:00:39
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("unchecked")
public class UserUtils {

	private static IUserService userService = SpringContextHolder.getBean(IUserService.class);
	private static IRoleService roleService = SpringContextHolder.getBean(IRoleService.class);
	private static IMenuService menuService = SpringContextHolder.getBean(IMenuService.class);
	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_USER_NAME_ = "username_";
	public static final String MENU_CACHE_URL_ = "menu_url_";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_MENU_LIST_ALL = "menuListAll";

	/**
	 * 根据ID获取用户
	 *
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id) {
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user == null) {
			user = userService.selectById(id);
			if (user == null) {
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_USER_NAME_ + user.getUsername(), user);
		}
		return user;
	}

	/**
	 * 根据用户名获取用户
	 *
	 * @param username
	 * @return
	 */
	public static User getByUserName(String username) {
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_USER_NAME_ + username);
		if (user == null) {
			user = userService.findByUsername(username);
			if (user == null) {
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_USER_NAME_ + user.getUsername(), user);
		}
		return user;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache() {
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		UserUtils.clearCache(getUser());
	}

	/**
	 * 清除指定用户缓存
	 *
	 * @param user
	 */
	public static void clearCache(User user) {
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_USER_NAME_ + user.getUsername());
	}

	/**
	 * 获取当前用户
	 *
	 * @return 取不到返回 new User()
	 */
	public static User getUser() {
		Principal principal = getPrincipal();
		if (principal != null) {
			User user = get(principal.getId());
			if (user != null) {
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}

	/**
	 * 获取当前用户角色列表
	 *
	 * @return
	 */
	public static List<Role> getRoleList() {
		List<Role> roleList = (List<Role>) getCache(CACHE_ROLE_LIST);
		if (roleList == null) {
			User user = getUser();
			roleList = roleService.findListByUserId(user.getId());
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}

	public static Set<String> getRoleStringList() {
		Set<Role> roles = Sets.newConcurrentHashSet(getRoleList());
		return Sets.newHashSet(Collections2.transform(roles, new Function<Role, String>() {
			@Override
			public String apply(Role role) {
				return role.getCode();
			}
		}));
	}

	/**
	 * 获取当前用户授权菜单
	 *
	 * @return
	 */
	public static List<Menu> getMenuList() {
		List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST);
		if (menuList == null) {
			menuList = new ArrayList<Menu>();
			User user = getUser();
//			menuList = menuService.findMenuByUserId(user.getId());
			menuList = menuService.findMenuByUserId_Type(user.getId(),"1");
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	public static List<Menu> getMenuListAll() {
		List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST_ALL);
		if (menuList == null) {
			menuList = new ArrayList<Menu>();
			menuList = menuService.findMenuByUserId(getUser().getId());
			putCache(CACHE_MENU_LIST_ALL, menuList);
		}
		return menuList;
	}

	/**
	 * 获取当前菜单
	 *
	 * @return
	 */
	public static Menu getCurrentMenu() {
		String url = ServletUtils.getRequest().getServletPath();
		if (url.endsWith(".jsp")) {
			return null;
		}
		String adminUrlPrefix = JeewebPropertiesUtil.getConfig("admin.url.prefix");
		url = url.substring(adminUrlPrefix.length() + 1, url.length());
		url = StringUtils.trimFirstAndLastChar(url, '/');
		if (StringUtils.isEmpty(url)) {
			return null;
		}
		// 全匹配查找
		List<Menu> menuList = getMenuList();
		return getCurrentMenu(menuList, url);
	}

	private static Menu getCurrentMenu(List<Menu> menuList, String url) {
		for (Menu menu : menuList) {
			if (!StringUtils.isEmpty(menu.getUrl())
					&& url.equals(StringUtils.trimFirstAndLastChar(menu.getUrl(), '/'))) {
				return menu;
			}
		}
		/*if (StringUtils.isEmpty(url)) {
		return null;
		}
		url = url.substring(0, url.lastIndexOf("/"));
		return getCurrentMenu(menuList, url);*/
		return null;
	}

	/**
	 * 通过ID获得菜单信息
	 *
	 * @return
	 */
	public static Menu getMenuById(String menuid) {
		if (StringUtils.isEmpty(menuid)) {
			return null;
		}
		List<Menu> menuList = getMenuList();
		for (Menu menu : menuList) {
			if (menuid.equals(menu.getId())) {
				return menu;
			}
		}
		return null;
	}

	public static Set<String> getPermissionsList(String permissionsFlag) {
		List<Menu> list = new ArrayList<Menu>();
		if(permissionsFlag.equalsIgnoreCase("all")){
			list = getMenuListAll();
		}else{
			list = UserUtils.getMenuList();
		}
		Set<String> permissionsList = Sets.newConcurrentHashSet();
		for (Menu menu : list) {
			if (StringUtils.isNotBlank(menu.getPermission())) {
				// 添加基于Permission的权限信息
				for (String permission : StringUtils.split(menu.getPermission(), ",")) {
					if (StringUtils.isNotBlank(permission)) {
						permissionsList.add(permission);
					}
				}
			}
		}
		return permissionsList;
	}

	/**
	 * 获取当前用户授权菜单
	 *
	 * @return
	 */
	public static Menu getTopMenu() {
		Menu topMenu = getMenuList().get(0);
		return topMenu;
	}

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return principal;
			}
			// subject.logout();
		} catch (UnavailableSecurityManagerException e) {

		} catch (InvalidSessionException e) {

		}
		return null;
	}

	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
			// subject.logout();
		} catch (InvalidSessionException e) {

		}
		return null;
	}

	// ============== User Cache ==============
	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}

}
