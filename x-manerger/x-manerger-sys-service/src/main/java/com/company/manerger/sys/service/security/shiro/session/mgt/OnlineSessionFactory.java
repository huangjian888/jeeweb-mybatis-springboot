/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.company.manerger.sys.service.security.shiro.session.mgt;

import com.company.manerger.sys.common.utils.IpUtils;
import com.company.manerger.sys.service.modules.sys.entity.UserOnline;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;


import javax.servlet.http.HttpServletRequest;

/**
 *
 * @description:    创建自定义的session， 添加一些自定义的数据 如 用户登录到的系统ip 用户状态（在线 隐身 强制退出） 等 比如当前所在系统等
 *
 */
public class OnlineSessionFactory implements SessionFactory {

	@Override
	public Session createSession(SessionContext initData) {
		OnlineSession session = new OnlineSession();
		if (initData != null && initData instanceof WebSessionContext) {
			WebSessionContext sessionContext = (WebSessionContext) initData;
			HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
			if (request != null) {
				session.setHost(IpUtils.getIpAddr(request));
				session.setUserAgent(request.getHeader("User-Agent"));

				//session.setSystemHost(request.getLocalAddr() + ":" + request.getLocalPort());
			}
		}
		return session;
	}

	public Session createSession(UserOnline userOnline) {
		return userOnline.getSession();
	}
}
