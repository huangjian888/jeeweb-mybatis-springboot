package com.company.manerger.sys.service.tags;

import javax.servlet.http.Cookie;

import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import org.springframework.core.env.Environment;

/**
 *
 * @description: 提供一些公用的函数
 *
 */
public class SysFunctions {

	/**
	 * 获得后台地址
	 * 
	 * @title: getAdminUrlPrefix
	 * @description: 获得后台地址
	 * @return
	 * @return: String
	 */
	public static String getAdminUrlPrefix() {
		Environment env= SpringContextHolder.getBean(Environment.class);
		String adminUrlPrefix = env.getProperty("company.admin.url.prefix");
		return adminUrlPrefix;
	}

	/**
	 * 加载风格
	 * 
	 * @title: getTheme
	 * @return
	 * @return: String
	 */
	public static String getTheme() {
		// 默认风格
		Environment env= SpringContextHolder.getBean(Environment.class);
		String theme = env.getProperty("company.admin.default.theme");
		if (StringUtils.isEmpty(theme)) {
			theme = "uadmin";
		}
		// cookies配置中的模版
		Cookie[] cookies = ServletUtils.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
				continue;
			}
			if (cookie.getName().equalsIgnoreCase("theme")) {
				theme = cookie.getValue();
			}
		}
		return theme;
	}
}
