package com.company.manerger.sys.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class ServletUtils {

	/**
	 * 获取当前请求对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		try {
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取当前请求对象
	 *
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		try {
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 判断是否是Ajax
	 *
	 * @return
	 */
	public static Boolean isAjax() {
		String requestType = getRequest().getHeader("X-Requested-With");
		if("XMLHttpRequest".equalsIgnoreCase(requestType)){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	/**
	 *  打印JSON
	 * @param response
	 * @param content
	 */
	public static void printJson(HttpServletResponse response, String content) {
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(content);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}