package cn.jeeweb.core.tags.html;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.tags.SysFunctions;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: ComponentTag.java
 * @package cn.jeeweb.core.tags.html
 * @description: 组建获取标签
 * @author: auth_team
 * @date: 2017年5月13日 上午9:05:06
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractHtmlTag extends BodyTagSupport {
	// private static final String[] HTML_COMPONENTS = { "bootstrap",
	// "bootstrap-fileinput" };
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private static final String[] SUPPORT_TYPES = { "CSS", "JS" };
	private String name = ""; // 组件名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 获取支持的html
	 */
	public String[] getHtmlComponents() {
		return null;
	}

	/**
	 * 
	 * @title: getSupportTypes
	 * @description: 获取支持的类型
	 * @return
	 * @return: String[]
	 */
	public abstract String[] getSupportTypes();

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	public int doEndTag() throws JspTagException {
		try {
			// 初始化数据
			JspWriter out = this.pageContext.getOut();
			String content = "";
			String[] components = name.split(",");
			for (String component : components) {
				if (isComponent(component)) {
					String[] types = getSupportTypes();
					if (types == null) {
						types = SUPPORT_TYPES;
					}
					for (String type : types) {
						String componentContent = getComponentHtml(component.toLowerCase(), type);
						if (!StringUtils.isEmpty(componentContent)) {
							content += componentContent + "\r\n";
						}
					}
				}
			}
			content = parseContent(content);
			out.print(content);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getComponentHtml(String component, String type) {
		// String ftl = "/tags/html/" + type.toLowerCase() + "/" +
		// component.toLowerCase() + ".flt";
		try {
			// String content =
			// FreeMarkerUtils.initByDefaultTemplate().processToString(ftl,
			// rootMap);
			String content = "";
			if (type.equals("CSS")) {
				content = htmlComponentManager.getCssComponent(component);
			} else if (type.equals("JS")) {
				content = htmlComponentManager.getJsComponent(component);
			} else if (type.equals("FRAGMENT")) {
				content = htmlComponentManager.getFragmentComponent(component);
			}
			return content;
		} catch (Exception e) {
			return null;
		}
	}

	private String parseContent(String content) throws TemplateException, IOException {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		String ctx = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
		String adminPath = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
		String staticPath = pageContext.getServletContext().getContextPath() + "/static";
		rootMap.put("ctx", ctx);
		rootMap.put("adminPath", adminPath);
		rootMap.put("staticPath", staticPath);
		String tempname = StringUtils.hashKeyForDisk(content);
		Configuration configuration = new Configuration();
		configuration.setNumberFormat("#");
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		stringLoader.putTemplate(tempname, content);
		@SuppressWarnings("deprecation")
		Template template = new Template(tempname, new StringReader(content));
		StringWriter stringWriter = new StringWriter();
		template.process(rootMap, stringWriter);
		configuration.setTemplateLoader(stringLoader);
		content = stringWriter.toString();
		return content;
	}

	/**
	 * 
	 * @title: isComponent
	 * @description:是否为组件
	 * @param name
	 * @return
	 * @return: boolean
	 */
	private boolean isComponent(String name) {
		/*
		 * if (StringUtils.isEmpty(name)) { return false; } for (String
		 * component : HTML_COMPONENTS) { if (component.equals(name.trim())) {
		 * return true; } } // 扩展中的 String[] htmlComponents =
		 * getHtmlComponents(); if (htmlComponents != null) { for (String
		 * component : HTML_COMPONENTS) { if (component.equals(name.trim())) {
		 * return true; } } }
		 */

		return true;
	}

}
