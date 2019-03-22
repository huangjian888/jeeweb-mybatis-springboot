package com.company.manerger.sys.ui.tag.form;

import java.util.Map;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import com.company.manerger.sys.ui.beetl.tag.form.TagWriter;
import com.company.manerger.sys.ui.beetl.tag.form.TextareaTag;
import com.company.manerger.sys.ui.tag.form.support.FreemarkerFormTagHelper;
import com.company.manerger.sys.ui.tag.html.manager.HtmlComponentManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@BeetlTagName("form.editor")
public class EditorTag extends TextareaTag {
	private String editorType = "simditor"; // 编辑器
	private String editorSetting = "{}"; // JS格式
	private String editorHeight = "100%";
	private String editorWidth = "100%";
	private String editorSettingCallback = ""; // 配置方法,为js方法，返回配置
	private String editorAfterSetting = ""; // 配置完成后回调
	protected String modulePath = "";//文件业务目录
	private String theme=""; //样式

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

	public String getModulePath() {
		return modulePath;
	}

	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	protected int writeTagContent(TagWriter tagWriter)throws BeetlTagException {
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
		//value = StringEscapeUtils.unescapeHtml4(value);
		tagWriter.appendValue(processFieldValue(getName(), value, "textarea"));
		tagWriter.endTag();
		// 输出编辑器代码片段
		writeFragment(tagWriter);
		return SKIP_BODY;
	}

	private void writeFragment(TagWriter tagWriter) throws BeetlTagException {
//		Map<String, Object> rootMap = new HashMap<String, Object>();
//		String ctx = (String)this.ctx.globalVar.get("ctxPath");
//		String adminPath = ctx + "";
//		String staticPath = ctx + "/static";
//		rootMap.put("ctx", ctx);
//		rootMap.put("adminPath", adminPath);
//		rootMap.put("staticPath", staticPath);
		Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, this.ctx);
		rootMap.put("height", editorHeight);
		rootMap.put("width", editorWidth);
		rootMap.put("editorSettingCallback", editorSettingCallback);
		rootMap.put("editorAfterSetting", editorAfterSetting);
		rootMap.put("path", this.getPath());
		rootMap.put("modulePath", modulePath);
		rootMap.put("theme", theme);
		// JS扩展
		if (StringUtils.isEmpty(editorSetting)) {
			editorSetting = "{}";
		}
		rootMap.put("editorSetting", editorSetting);
		editorType = editorType.toLowerCase();
		HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
				.getBean(HtmlComponentManager.class);
		String fragment = htmlComponentManager.getFragmentComponent(editorType + "-editor", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			tagWriter.forceAppendValue(fragment);
		}
	}

}
