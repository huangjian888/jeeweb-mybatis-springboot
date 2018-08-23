package cn.jeeweb.core.tags.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import org.springframework.web.servlet.tags.form.TagWriter;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.tags.SysFunctions;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: TreeSelect.java
 * @package cn.jeeweb.core.tags.form
 * @description: 图标选择
 * @author: auth_team
 * @date: 2017年4月10日 下午9:16:24
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class IconSelectTag extends org.springframework.web.servlet.tags.form.HiddenInputTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private String width = "800px";// 宽度
	private String height = "420px";// 高度
	private Boolean genField = Boolean.TRUE;// 是否生成,显示域
	private String callback = "";// 回调函数

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		tagWriter.startTag("input");
		writeDefaultAttributes(tagWriter);
		tagWriter.writeAttribute("type", "hidden");
		if (isDisabled()) {
			tagWriter.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
		}
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		tagWriter.writeAttribute("value", processFieldValue(getName(), value, "hidden"));
		tagWriter.endTag();
		// 输出编辑器代码片段
		writeFragment();
		return SKIP_BODY;
	}

	private void writeFragment() throws JspException {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		String ctx = pageContext.getServletContext().getContextPath();
		String adminPath = pageContext.getServletContext().getContextPath() + SysFunctions.getAdminUrlPrefix();
		String staticPath = pageContext.getServletContext().getContextPath() + "/static";
		rootMap.put("ctx", ctx);
		rootMap.put("adminPath", adminPath);
		rootMap.put("staticPath", staticPath);
		rootMap.put("name", getPath());
		rootMap.put("genField", genField);
		rootMap.put("width", width);
		rootMap.put("height", height);
		rootMap.put("callback", callback);
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		rootMap.put("value", processFieldValue(getName(), value, "hidden"));

		String fragment = htmlComponentManager.getFragmentComponent("fa-icons", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			try {
				super.pageContext.getOut().write(fragment);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

 

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public Boolean getGenField() {
		return genField;
	}

	public void setGenField(Boolean genField) {
		this.genField = genField;
	}
	
	
}
