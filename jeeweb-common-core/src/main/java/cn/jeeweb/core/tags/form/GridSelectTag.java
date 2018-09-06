package cn.jeeweb.core.tags.form;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.jsp.JspException;
import org.springframework.web.servlet.tags.form.TagWriter;
import com.google.common.collect.Maps;
import cn.jeeweb.core.tags.form.support.FreemarkerFormTagHelper;
import cn.jeeweb.core.tags.html.manager.HtmlComponentManager;
import cn.jeeweb.core.utils.ArrayUtils;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.core.utils.StringUtils;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: GridSelectTag.java
 * @package cn.jeeweb.core.tags.form
 * @description: 表格选择
 * @author: auth_team
 * @date: 2017年6月17日 下午1:59:17
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class GridSelectTag extends HiddenInputTag {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	private String gridId = "";
	private String labelName = "";// 显示域的ID
	private String labelValue = "";// 显示域的值
	private String bindLabelField = "";// 对应绑定Grid的字段
	private String title = "";// 显示的标题
	private String icon = "fa-search";// 图标
	private String layerWidth = "700px";// 宽度
	private String layerHeight = "400px";// 高度
	private Boolean genField = Boolean.TRUE;// 是否生成,显示域及隐藏域标签
	private Boolean multiselect = Boolean.FALSE;// 是否多选
	private String gridUrl = "";// 访问链接
	private String callback = "";// 回调函数
	private String formField = "";// 表单中的字段
	private String gridField = "";// 对应Grid中的字段，需要一一对应

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

	public String getGridUrl() {
		return gridUrl;
	}

	public void setGridUrl(String gridUrl) {
		this.gridUrl = gridUrl;
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
		// formField
		List<String> formFields = ArrayUtils.split(formField, ",");
		List<String> gridFields = ArrayUtils.split(gridField, ",");
		Map<String, String> gridFieldMap = Maps.newHashMap();
		for (int i = 0; i < gridFields.size(); i++) {
			String gridField = gridFields.get(i);
			String formField = formFields.get(i);
			gridFieldMap.put(formField, gridField);
		}
		gridFieldMap.put(labelName, getBindLabelField());
		rootMap.put("gridFieldMap", gridFieldMap);
		String fragment = htmlComponentManager.getFragmentComponent("gridselect", rootMap);
		if (!StringUtils.isEmpty(fragment) && !fragment.equals("null")) {
			// 获得编辑器
			try {
				super.pageContext.getOut().write(fragment);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getBindLabelField() {
		if (StringUtils.isEmpty(bindLabelField)) {
			bindLabelField = labelName;
		}
		return bindLabelField;
	}

	public void setBindLabelField(String bindLabelField) {
		this.bindLabelField = bindLabelField;
	}

	public String getFormField() {
		return formField;
	}

	public void setFormField(String formField) {
		this.formField = formField;
	}

	public String getGridField() {
		return gridField;
	}

	public void setGridField(String gridField) {
		this.gridField = gridField;
	}

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

}
