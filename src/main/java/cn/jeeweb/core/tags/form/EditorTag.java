package cn.jeeweb.core.tags.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.servlet.tags.form.TagWriter;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.tags.SysFunctions;

@SuppressWarnings("serial")
public class EditorTag extends TextareaTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private String editorType = "simditor"; // 编辑器
	private String editorSetting = "{}"; // JS格式
	private String editorHeight = "100%";
	private String editorWidth = "100%";
	private String editorSettingCallback = ""; // 配置方法,为js方法，返回配置
	private String editorAfterSetting = ""; // 配置完成后回调

	public String getEditorType() {
		return editorType;
	}

	public void setEditorType(String editorType) {
		this.editorType = editorType;
	}

	public String getEditorHeight() {
		return editorHeight;
	}

	public void setEditorHeight(String editorHeight) {
		this.editorHeight = editorHeight;
	}

	public String getEditorWidth() {
		return editorWidth;
	}

	public void setEditorWidth(String editorWidth) {
		this.editorWidth = editorWidth;
	}

	public String getEditorSetting() {
		return editorSetting;
	}

	public void setEditorSetting(String editorSetting) {
		this.editorSetting = editorSetting;
	}

	public String getEditorSettingCallback() {
		return editorSettingCallback;
	}

	public void setEditorSettingCallback(String editorSettingCallback) {
		this.editorSettingCallback = editorSettingCallback;
	}

	public String getEditorAfterSetting() {
		return editorAfterSetting;
	}

	public void setEditorAfterSetting(String editorAfterSetting) {
		this.editorAfterSetting = editorAfterSetting;
	}

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		tagWriter.startTag("textarea");
		writeDefaultAttributes(tagWriter);
		if (editorType.equals("markdown")) {
			writeOptionalAttribute(tagWriter, "data-provide", "markdown");
		}
		if (editorType.equals("ueditor")){
			//这里需要判断style是否为空
			String style=getCssStyle();
			if (StringUtils.isEmpty(style)) {
				style = "width:" + editorWidth + ";height:" + getEditorHeight();
			}else{
				style+=";width:" + editorWidth + ";height:" + getEditorHeight();
			}
			writeOptionalAttribute(tagWriter, "style",style);
		}
		writeOptionalAttribute(tagWriter, ROWS_ATTRIBUTE, getRows());
		writeOptionalAttribute(tagWriter, COLS_ATTRIBUTE, getCols());
		writeOptionalAttribute(tagWriter, ONSELECT_ATTRIBUTE, getOnselect());
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		value = StringEscapeUtils.unescapeHtml4(value);
		tagWriter.appendValue(processFieldValue(getName(), value, "textarea"));
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
		rootMap.put("height", editorHeight);
		rootMap.put("width", editorWidth);
		rootMap.put("editorSettingCallback", editorSettingCallback);
		rootMap.put("editorAfterSetting", editorAfterSetting);
		rootMap.put("path", this.getPath());
		// JS扩展
		if (StringUtils.isEmpty(editorSetting)) {
			editorSetting = "{}";
		}
		rootMap.put("editorSetting", editorSetting);
		editorType = editorType.toLowerCase();
		String fragment = htmlComponentManager.getFragmentComponent(editorType + "-editor", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			try {
				super.pageContext.getOut().write(fragment);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
