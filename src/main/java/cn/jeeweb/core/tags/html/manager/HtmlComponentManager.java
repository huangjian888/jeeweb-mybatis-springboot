package cn.jeeweb.core.tags.html.manager;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;
import cn.jeeweb.core.tags.html.builder.HtmlComponentBuilder;
import cn.jeeweb.core.tags.html.builder.NoneHtmlComponentBuilder;
import cn.jeeweb.core.utils.EhcacheUtil;
import cn.jeeweb.core.utils.StringUtils;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * HTML组建管理器
 * 
 * @author auth_team
 * @version 2017-02-09
 */
public class HtmlComponentManager {
	protected HtmlComponentBuilder dynamicStatementBuilder = null;
	protected final static String HTML_COMPONENT_CACHE_NAME = "htmlComponentCache";
	protected final static String HTML_COMPONENT_PRE_NAME_JS = "js_";
	protected final static String HTML_COMPONENT_PRE_NAME_CSS = "css_";
	protected final static String HTML_COMPONENT_PRE_NAME_FRAGMENT = "fragment_";
	protected final static EhcacheUtil ehcacheUtil = new EhcacheUtil(HTML_COMPONENT_CACHE_NAME);
	public final static String COMPONENT_TYPE_JS = "js";
	public final static String COMPONENT_TYPE_CSS = "css";
	public final static String COMPONENT_TYPE_FRAGMENT = "fragment";

	public void setDynamicStatementBuilder(HtmlComponentBuilder dynamicStatementBuilder) {
		this.dynamicStatementBuilder = dynamicStatementBuilder;
	}

	public void init() throws IOException {
		if (dynamicStatementBuilder == null) {
			dynamicStatementBuilder = new NoneHtmlComponentBuilder();
		}
		dynamicStatementBuilder.init();

		Map<String, String> cssComponents = dynamicStatementBuilder.getCssComponents();
		Map<String, String> jsComponents = dynamicStatementBuilder.getJsComponents();
		Map<String, String> fragmentComponents = dynamicStatementBuilder.getFragmentComponents();
		// 设置css
		setCache(cssComponents, HTML_COMPONENT_PRE_NAME_CSS);
		// 设置js
		setCache(jsComponents, HTML_COMPONENT_PRE_NAME_JS);
		// 设置代码片段
		setCache(fragmentComponents, HTML_COMPONENT_PRE_NAME_FRAGMENT);
	}

	private void setCache(Map<String, String> cssComponents, String htmlComponentPreName) {
		for (Entry<String, String> entry : cssComponents.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			ehcacheUtil.set(htmlComponentPreName + key, value);
		}
	}

	/**
	 * 
	 * @title: getComponent
	 * @description: 获得组建的html
	 * @param componentType
	 * @param name
	 * @return
	 * @return: String
	 */
	public String getComponent(String componentType, String name) {
		if (componentType.equals(COMPONENT_TYPE_JS)) {
			return ehcacheUtil.getString(HTML_COMPONENT_PRE_NAME_JS + name);
		} else if (componentType.equals(COMPONENT_TYPE_CSS)) {
			return ehcacheUtil.getString(HTML_COMPONENT_PRE_NAME_CSS + name);
		} else if (componentType.equals(COMPONENT_TYPE_FRAGMENT)) {
			return ehcacheUtil.getString(HTML_COMPONENT_PRE_NAME_FRAGMENT + name);
		}
		return "";
	}

	public String getComponent(String componentType, String name, Map<String, Object> dataMap) {
		try {
			String content = getComponent(componentType, name);
			String tempname = StringUtils.hashKeyForDisk(content);
			Configuration configuration = new Configuration();
			configuration.setNumberFormat("#");
			StringTemplateLoader stringLoader = new StringTemplateLoader();
			stringLoader.putTemplate(tempname, content);
			@SuppressWarnings("deprecation")
			Template template = new Template(tempname, new StringReader(content));
			StringWriter stringWriter = new StringWriter();
			template.process(dataMap, stringWriter);
			configuration.setTemplateLoader(stringLoader);
			content = stringWriter.toString();
			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getJsComponent(String name) {
		return getComponent(COMPONENT_TYPE_JS, name);
	}

	public String getJsComponent(String name, Map<String, Object> dataMap) {
		return getComponent(COMPONENT_TYPE_JS, name, dataMap);
	}

	public String getCssComponent(String name) {
		return getComponent(COMPONENT_TYPE_CSS, name);
	}

	public String getCssComponent(String name, Map<String, Object> dataMap) {
		return getComponent(COMPONENT_TYPE_CSS, name, dataMap);
	}

	public String getFragmentComponent(String name) {
		return getComponent(COMPONENT_TYPE_FRAGMENT, name);
	}

	public String getFragmentComponent(String name, Map<String, Object> dataMap) {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getComponent(COMPONENT_TYPE_FRAGMENT, name, dataMap);
	}

	/*
	 * 清除换成
	 */
	public static void clear() {
		ehcacheUtil.remove(HTML_COMPONENT_CACHE_NAME);
	}

}
