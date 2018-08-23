package cn.jeeweb.core.tags.form;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import org.springframework.web.servlet.support.BindStatus;
import org.springframework.web.servlet.tags.form.TagWriter;
import cn.jeeweb.core.tags.form.support.CustomBindStatus;
import cn.jeeweb.core.utils.DateUtils;
import cn.jeeweb.core.utils.StringUtils;
import org.springframework.beans.PropertyAccessor;

@SuppressWarnings("serial")
public class InputTag extends org.springframework.web.servlet.tags.form.InputTag {

	private BindStatus bindStatus = null;
	private String datefmt = "";
	private Boolean nested = true; // 是否嵌套使用Form自定的模型，模式为真,
	private String valueway = "";// 1,bean
									// 2,通过参数获取。3.获取getAttribute中的值
	private String defaultValue = "";// 当所有值都无效的时候，是由默认值

	@Override
	protected BindStatus getBindStatus() throws JspException {
		if (this.bindStatus == null) {
			// HTML escaping in tags is performed by the ValueFormatter class.
			String nestedPath = "";
			if (nested) {
				nestedPath = getNestedPath();
			}
			String pathToUse = (nestedPath != null ? nestedPath + getPath() : getPath());
			if (pathToUse.endsWith(PropertyAccessor.NESTED_PROPERTY_SEPARATOR)) {
				pathToUse = pathToUse.substring(0, pathToUse.length() - 1);
			}
			this.bindStatus = CustomBindStatus.create(pageContext, pathToUse, getRequestContext(), false, nested,
					valueway, defaultValue);
		}
		return this.bindStatus;
	}

	private boolean hasDynamicTypeAttribute() {
		return getDynamicAttributes() != null && getDynamicAttributes().containsKey("type");
	}

	@Override
	protected void writeValue(TagWriter tagWriter) throws JspException {
		if (StringUtils.isEmpty(datefmt)) {
			super.writeValue(tagWriter);
		} else {
			//时间格式化
			String value = getDisplayString(getBoundValue(), getPropertyEditor());
			String type = hasDynamicTypeAttribute() ? (String) getDynamicAttributes().get("type") : getType();
			value = processFieldValue(getName(), value, type);
			try {
				if (value.endsWith(".0")) {
					value = value.toString().substring(0, value.toString().indexOf("."));
				}
				Date date;
				if (value.indexOf("CST")>0) {
					SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
					date=sdf.parse(value);
				}else{
					date = DateUtils.parseDate(value);
				}
				value = DateUtils.formatDate(date,datefmt);
			} catch (Exception e) {

			}
			tagWriter.writeAttribute("value", value);
		}
	}

	public Boolean getNested() {
		return nested;
	}

	public void setNested(Boolean nested) {
		this.nested = nested;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getValueway() {
		return valueway;
	}

	public void setValueway(String valueway) {
		this.valueway = valueway;
	}

	public String getDatefmt() {
		return datefmt;
	}

	public void setDatefmt(String datefmt) {
		this.datefmt = datefmt;
	}

	@Override
	public void doFinally() {
		super.doFinally();
		this.bindStatus = null;
	}

}
