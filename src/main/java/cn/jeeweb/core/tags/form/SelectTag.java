package cn.jeeweb.core.tags.form;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.PropertyAccessor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.BindStatus;
import cn.jeeweb.core.tags.form.support.CustomBindStatus;
import cn.jeeweb.modules.sys.utils.DictUtils;

import javax.servlet.jsp.JspException;

@SuppressWarnings("serial")
public class SelectTag extends org.springframework.web.servlet.tags.form.SelectTag {

	private BindStatus bindStatus = null;
	private Boolean nested = true; // 是否嵌套使用Form自定的模型，模式为真,
	// nested为false,需要设置对应字段为空字符串否则报错；
	private String dict = "";// 绑定数据字典类型，数据字典优先
	private String valueWay = "";// 1,bean
									// 2,通过参数获取。3.获取getAttribute中的值
	private String defaultValue = "";// 当所有值都无效的时候，是由默认值

//	private String name;// 列字段名称
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
					valueWay, defaultValue);
		}
		return this.bindStatus;
	}

	public Boolean getNested() {
		return nested;
	}

	public void setNested(Boolean nested) {
		this.nested = nested;
	}

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	@Override
	protected Object getItems() {
		if (!StringUtils.isEmpty(dict)) {
			return DictUtils.getDictList(dict);
		}
		return super.getItems();
	}

	@Override
	protected String getItemLabel() {
		if (!StringUtils.isEmpty(dict)) {
			return "label";
		}
		return super.getItemLabel();
	}

	@Override
	protected String getItemValue() {
		if (!StringUtils.isEmpty(dict)) {
			return "value";
		}
		return super.getItemValue();
	}

	@Override
	public void doFinally() {
		super.doFinally();
		this.bindStatus = null;
	}

	public String getValueWay() {
		return valueWay;
	}

	public void setValueWay(String valueWay) {
		this.valueWay = valueWay;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setBindStatus(BindStatus bindStatus) {
		this.bindStatus = bindStatus;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
}
