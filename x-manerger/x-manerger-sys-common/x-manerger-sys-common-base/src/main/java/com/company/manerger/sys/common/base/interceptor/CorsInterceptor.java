package com.company.manerger.sys.common.base.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
                                Exception exception) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
                           ModelAndView modelAndView) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		//request.setCharacterEncoding("UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		return true;
	}

}
