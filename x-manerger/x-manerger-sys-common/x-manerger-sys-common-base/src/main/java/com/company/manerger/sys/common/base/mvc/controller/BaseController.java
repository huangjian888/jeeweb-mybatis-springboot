package com.company.manerger.sys.common.base.mvc.controller;

import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.common.utils.convert.DateConvertEditor;
import com.company.manerger.sys.common.utils.convert.StringConvertEditor;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 基础控制器
 *
 */
public class BaseController {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private String viewPrefix;

	protected BaseController() {
		setViewPrefix(defaultViewPrefix());
	}

	/**
	 * 返回JSON字符串
	 * 
	 * @param response
	 * @param object
	 * @return
	 * @return
	 */
	protected void printString(HttpServletResponse response, Object object) {
		printString(response, JSON.toJSONString(object));
	}

	/**
	 * 打印字符串到页面
	 * 
	 * @param response
	 * @param string
	 * @return
	 */
	protected void printString(HttpServletResponse response, String string) {
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
		} catch (IOException e) {

		}
	}

	/**
	 * 初始化数据绑定
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(ServletRequestDataBinder binder) {
		// 将所有传递进来的String进行HTML编码，防止XSS攻击
		// 这个会导致数据库数据
		binder.registerCustomEditor(String.class, new StringConvertEditor());
		// 日期格式
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

	/**
	 * 当前模块 视图的前缀 默认 1、获取当前类头上的@RequestMapping中的value作为前缀 2、如果没有就使用当前模型小写的简单类名
	 */
	public void setViewPrefix(String viewPrefix) {
		if (viewPrefix.startsWith("/")) {
			viewPrefix = viewPrefix.substring(1);
		}
		this.viewPrefix = viewPrefix;
	}

	public String getViewPrefix() {
		return viewPrefix;
	}

	/**
	 * 获取视图名称：即prefixViewName + "/" + suffixName
	 *
	 * @return
	 */
	public String display(String suffixName) {
		if (!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}
		return getViewPrefix().toLowerCase() + suffixName;
	}

	/**
	 * 获取视图名称：即prefixViewName + "/" + suffixName
	 *
	 * @return
	 */
	public ModelAndView displayModelAndView(String suffixName) {
		if (!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}
		return new ModelAndView(getViewPrefix().toLowerCase() + suffixName);
	}

	protected String defaultViewPrefix() {
		String currentViewPrefix = "";
		ViewPrefix viewPrefix = AnnotationUtils.findAnnotation(getClass(), ViewPrefix.class);
		if (viewPrefix!=null&&!StringUtils.isEmpty(viewPrefix.value())) {
			currentViewPrefix = viewPrefix.value();
		}
		if (StringUtils.isEmpty(currentViewPrefix)) {
			currentViewPrefix = this.getClass().getSimpleName().replace("Controller", "").toLowerCase();
		}
		return currentViewPrefix;
	}

}
