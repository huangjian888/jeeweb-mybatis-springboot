package cn.jeeweb.core.tags.form.support;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.BindStatus;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.HtmlUtils;
import cn.jeeweb.core.utils.ObjectUtils;
import java.util.Map;
import javax.servlet.jsp.PageContext;

public class CustomBindStatus extends BindStatus {

	private Object value;
	private Boolean htmlEscape;
	private String expression;
	private Boolean nested;

	public CustomBindStatus(PageContext pageContext, RequestContext requestContext, String path, boolean htmlEscape,
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
				this.value = getParameterValue(pageContext, path);
				if (isNullOrEmpty(this.value)) {
					this.value = pageContext.getRequest().getAttribute(path);
				}
			}
		} else {
			if (valueWay.equals("2")) {
				this.value = getParameterValue(pageContext, path);
			} else if (valueWay.equals("3")) {
				this.value = pageContext.getRequest().getAttribute(path);
			}
		}
		if (isNullOrEmpty(this.value)) {
			this.value = defaultValue;
		}
		if (htmlEscape && this.value instanceof String) {
			this.value = HtmlUtils.htmlEscape((String) this.value);
		}

	}

	public static BindStatus create(PageContext pageContext, String pathToUse, RequestContext requestContext,
			Boolean htmlEscape, Boolean nested, String valueWay, String defaultValue) {
		// 预处理防止报错
		if (!nested) {
			Map<String, Object> model = requestContext.getModel();
			if (model != null) {
				if (model.containsKey(pathToUse)) {
					requestContext.getModel().put(pathToUse, "");
				}
			}
			if (pageContext.getRequest().getAttribute(pathToUse) == null) {
				pageContext.getRequest().setAttribute(pathToUse, CustomModel.EMPTY);
			}
		}

		return new CustomBindStatus(pageContext, requestContext, pathToUse, htmlEscape, nested, valueWay, defaultValue);
	}

	/**
	 * 获得设置属性中的值
	 * 
	 * @param pageContext
	 * @param name
	 * @return
	 */
	public Object getAttribute(PageContext pageContext, String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		Object value = pageContext.getRequest().getAttribute(name);
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

	public static Object getParameterValue(PageContext pageContext, String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		Object value = null;
		String[] parameters = pageContext.getRequest().getParameterValues(name);
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
