package com.company.manerger.sys.ui.beetl.tag.support;

import com.company.manerger.sys.common.utils.ObjectUtils;
import com.company.manerger.sys.common.utils.ServletUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

public class CustomBindStatus extends BindStatus {

	private Object value;
	private Boolean htmlEscape;
	private String expression;
	private Boolean nested;

	public CustomBindStatus(RequestContext requestContext, String path, boolean htmlEscape,
							Boolean nested, String valueWay, String defaultValue) {
		super(requestContext, path, htmlEscape);
		// 这是需要考虑问题
		this.htmlEscape = htmlEscape;
		this.nested = nested;
		if (this.nested) {
			this.expression = super.getExpression();
		} else {
			this.expression = path;
		}
		this.value = super.getValue();
		if (StringUtils.isEmpty(valueWay)) {
			if (isNullOrEmpty(super.getValue())) {
				// 处理
				this.value = getParameterValue( path);
				if (isNullOrEmpty(this.value)) {
					this.value = ServletUtils.getRequest().getAttribute(path);
				}
			}
		} else {
			if (valueWay.equals("2")) {
				this.value = getParameterValue(path);
			} else if (valueWay.equals("3")) {
				this.value = ServletUtils.getRequest().getAttribute(path);
			}
		}
		if (isNullOrEmpty(this.value)) {
			this.value = defaultValue;
		}
		if (htmlEscape && this.value instanceof String) {
			this.value = HtmlUtils.htmlEscape((String) this.value);
		}

	}

	public static BindStatus create(String pathToUse, RequestContext requestContext,
			Boolean htmlEscape, Boolean nested, String valueWay, String defaultValue) {
		// 预处理防止报错
		if (!nested) {
			/*Map<String, Object> model = requestContext.getModel();
			if (model != null) {
				if (model.containsKey(pathToUse)) {
					requestContext.getModel().put(pathToUse, "");
				}
			}*/
			if (ServletUtils.getRequest().getAttribute(pathToUse) == null) {
				ServletUtils.getRequest().setAttribute(pathToUse, CustomModel.EMPTY);
			}
		}
		return new CustomBindStatus(requestContext, pathToUse, htmlEscape, nested, valueWay, defaultValue);
	}

	/**
	 * 获得设置属性中的值
	 *
	 * @param name
	 * @return
	 */
	public Object getAttribute(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		Object value = ServletUtils.getRequest().getAttribute(name);
		return value;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public boolean isNullOrEmpty(Object obj) {
		if (ObjectUtils.isNullOrEmpty(obj) || obj == CustomModel.EMPTY) {
			return true;
		}
		return false;
	}

	public static Object getParameterValue(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		Object value = null;
		String[] parameters = ServletUtils.getRequest().getParameterValues(name);
		if (parameters != null && parameters.length == 1) {
			value = parameters[0];
		} else {
			value = parameters;
		}
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public Object getActualValue() {
		return value;
	}

	@Override
	public String getDisplayValue() {
		if (this.value instanceof String) {
			return (String) this.value;
		}
		if (this.value != null) {
			return (this.htmlEscape ? HtmlUtils.htmlEscape(this.value.toString()) : this.value.toString());
		}
		return "";
	}

	public String getExpression() {

		return expression;
	}

	private static class CustomModel {
		public static final CustomModel EMPTY = new CustomModel();
	}

}
