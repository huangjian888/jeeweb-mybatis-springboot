package cn.jeeweb.core.tags.form;

import java.io.IOException;
import java.util.Map;
import javax.servlet.jsp.JspException;
import org.springframework.web.servlet.tags.form.TagWriter;
import cn.jeeweb.core.tags.form.support.FreemarkerFormTagHelper;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.core.utils.StringUtils;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: TreeSelect.java
 * @package cn.jeeweb.core.tags.form
 * @description: 树形选择
 * @author: auth_team
 * @date: 2017年4月10日 下午9:16:24
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class TreeSelectTag extends HiddenInputTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private String labelName = "";// 显示域的ID
	private String labelValue = "";// 显示域的值
	private String title = "";// 显示的标题
	private String icon = "fa-search";// 图标
	private String layerWidth = "300px";// 宽度
	private String layerHeight = "420px";// 高度
	private Boolean genField = Boolean.TRUE;// 是否生成,显示域及隐藏域标签
	private Boolean multiselect = Boolean.FALSE;// 是否多选
	private String chkboxType = "ps";// 上下级关系“p” 表示操作会影响父级节点； “s” 表示操作会影响子级节点。 
	private String dataUrl = "";// 访问链接
	private String callback = "";// 回调函数

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
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

	public Boolean getMultiselect() {
		return multiselect;
	}

	public void setMultiselect(Boolean multiselect) {
		this.multiselect = multiselect;
	}

	public String getLayerWidth() {
		return layerWidth;
	}

	public void setLayerWidth(String layerWidth) {
		this.layerWidth = layerWidth;
	}

	public String getLayerHeight() {
		return layerHeight;
	}

	public void setLayerHeight(String layerHeight) {
		this.layerHeight = layerHeight;
	}

	public String getChkboxType() {
		return chkboxType;
	}

	public void setChkboxType(String chkboxType) {
		this.chkboxType = chkboxType;
	}

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
		Map<String, Object> rootMap = FreemarkerFormTagHelper.getTagStatic(this, pageContext);
		rootMap.put("name", getPath());
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		rootMap.put("value", processFieldValue(getName(), value, "hidden"));
		String fragment = htmlComponentManager.getFragmentComponent("treeselect-treeselect", rootMap);
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
