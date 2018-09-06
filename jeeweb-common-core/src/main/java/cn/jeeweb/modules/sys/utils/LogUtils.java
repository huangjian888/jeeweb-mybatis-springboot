package cn.jeeweb.modules.sys.utils;

import cn.jeeweb.core.tags.SysFunctions;
import cn.jeeweb.core.utils.*;
import cn.jeeweb.modules.sys.entity.Log;
import cn.jeeweb.modules.sys.entity.Menu;
import cn.jeeweb.modules.sys.entity.User;
import cn.jeeweb.modules.sys.service.ILogService;
import cn.jeeweb.modules.sys.service.IMenuService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class LogUtils {

	public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";
	private static ILogService logService = SpringContextHolder.getBean(ILogService.class);
	private static IMenuService menuService = SpringContextHolder.getBean(IMenuService.class);

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title) {
		saveLog(request, null, null, title, null);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title, String content) {
		saveLog(request, null, null, title, content);
	}

	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title) {
		saveLog(request, handler, ex, title, null);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title, String content) {
		User user = UserUtils.getUser();
		if (user != null && user.getId() != null) {
			Log log = new Log();
			log.setTitle(title);
			log.setType(ex == null ? Log.TYPE_ACCESS : Log.TYPE_EXCEPTION);
			log.setRemoteAddr(IpUtils.getIpAddr(request));
			log.setUserAgent(request.getHeader("user-agent"));
			log.setRequestUri(request.getRequestURI());
			log.setParams(request.getParameterMap());
			log.setMethod(request.getMethod());
			log.setContent(content);
			// 异步保存日志
			new SaveLogThread(log, handler, ex).start();
		}
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread {

		private Log log;
		private Object handler;
		private Exception ex;

		public SaveLogThread(Log log, Object handler, Exception ex) {
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}

		@Override
		public void run() {
			// 获取日志标题
			if (StringUtils.isBlank(log.getTitle())) {
				String permission = "";
				if (handler instanceof HandlerMethod) {
					Method m = ((HandlerMethod) handler).getMethod();
					RequiresPermissions rp = m.getAnnotation(RequiresPermissions.class);
					permission = (rp != null ? StringUtils.join(rp.value(), ",") : "");
				}
				log.setTitle(getMenuNamePath(log.getRequestUri(), permission));
			}
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isEmpty(log.getTitle()) && StringUtils.isEmpty(log.getException())) {
				return;
			}
			// 保存日志信息
			logService.insert(log);
		}
	}

	/**
	 * 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
	 */
	public static String getMenuNamePath(String requestUri, String permission) {
		String url = StringUtils.substringAfter(requestUri, SysFunctions.getAdminUrlPrefix() + "/");
		@SuppressWarnings("unchecked")
		Map<String, String> menuMap = (Map<String, String>) CacheUtils.get(CACHE_MENU_NAME_PATH_MAP);
		if (menuMap == null) {
			menuMap = Maps.newHashMap();
			List<Menu> menuList = menuService.selectList(new EntityWrapper<Menu>());
			for (Menu menu : menuList) {
				// 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
				String namePath = "";
				if (menu.getParentIds() != null) {
					List<String> namePathList = Lists.newArrayList();
					for (String id : StringUtils.split(menu.getParentIds(), "/")) {
						/*
						 * if (Menu.getRootId().equals(id)){ continue; // 过滤跟节点
						 * }
						 */
						for (Menu m : menuList) {
							if (m.getId().equals(id)) {
								namePathList.add(m.getName());
								break;
							}
						}
					}
					namePathList.add(menu.getName());
					namePath = StringUtils.join(namePathList, "-");
				}
				// 设置菜单名称路径
				if (StringUtils.isNotBlank(menu.getUrl())) {
					menuMap.put(menu.getUrl(), namePath);
				} else if (StringUtils.isNotBlank(menu.getPermission())) {
					for (String p : StringUtils.split(menu.getPermission())) {
						menuMap.put(p, namePath);
					}
				}

			}
			CacheUtils.put(CACHE_MENU_NAME_PATH_MAP, menuMap);
		}
		String menuNamePath = menuMap.get(url);
		if (menuNamePath == null) {
			for (String p : StringUtils.split(permission)) {
				menuNamePath = menuMap.get(p);
				if (StringUtils.isNotBlank(menuNamePath)) {
					break;
				}
			}
			if (menuNamePath == null) {
				return "";
			}
		}
		return menuNamePath;
	}
}
