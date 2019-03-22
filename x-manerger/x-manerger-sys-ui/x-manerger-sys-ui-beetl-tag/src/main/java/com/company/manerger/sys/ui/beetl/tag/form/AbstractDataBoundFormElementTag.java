package com.company.manerger.sys.ui.beetl.tag.form;

import java.beans.PropertyEditor;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import com.company.manerger.sys.ui.beetl.tag.support.CustomBindStatus;
import org.springframework.beans.PropertyAccessor;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import com.company.manerger.sys.ui.beetl.tag.support.BindStatus;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import com.company.manerger.sys.ui.beetl.tag.EditorAwareTag;

public abstract class AbstractDataBoundFormElementTag extends AbstractFormTag implements EditorAwareTag {


	protected static final String NESTED_PATH_VARIABLE_NAME = "nestedPath";


	private String path;


	private String id;


	private BindStatus bindStatus;

	private Boolean nested = Boolean.TRUE; // 是否嵌套使用Form自定的模型，模式为真, // nested为false,需要设置对应字段为空字符串否则报错；
	private String valueWay = "";// 1,bean // 2,通过参数获取。3.获取getAttribute中的值
	private String defaultValue = "";// 当所有值都无效的时候，是由默认值

	public void setPath(String path) {
		this.path = path;
	}

	protected final String getPath() throws BeetlTagException {
		String resolvedPath = (String) evaluate("path", this.path);
		return (resolvedPath != null ? resolvedPath : "");
	}

	/**
	 * Set the value of the '{@code id}' attribute.
	 * <p>May be a runtime expression; defaults to the value of {@link #getName()}.
	 * Note that the default value may not be valid for certain tags.
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public Boolean getNested() {
		return nested;
	}

	public void setNested(Boolean nested) {
		this.nested = nested;
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

	protected void writeDefaultAttributes(TagWriter tagWriter) throws BeetlTagException {
		writeOptionalAttribute(tagWriter, "id", resolveId());
		writeOptionalAttribute(tagWriter, "name", getName());
	}

	@Nullable
	protected String resolveId() throws BeetlTagException {
		Object id = evaluate("id", getId());
		if (id != null) {
			String idString = id.toString();
			return (StringUtils.hasText(idString) ? idString : null);
		}
		return autogenerateId();
	}

	@Nullable
	protected String autogenerateId() throws BeetlTagException {
		String name = getName();
		return (name != null ? StringUtils.deleteAny(name, "[]") : null);
	}

	@Nullable
	protected String getName() throws BeetlTagException {
		return getPropertyPath();
	}

	protected BindStatus getBindStatus() throws BeetlTagException {
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
			this.bindStatus = CustomBindStatus.create(pathToUse, getRequestContext(), isHtmlEscape(), nested,
					valueWay, defaultValue);
			// this.bindStatus = new BindStatus(getRequestContext(), pathToUse, false);
		}
		return this.bindStatus;
	}

	protected String getNestedPath() {
		return (String) this.ctx.globalVar.get(NESTED_PATH_VARIABLE_NAME);
	}

	protected String getPropertyPath() throws BeetlTagException {
		String expression = getBindStatus().getExpression();
		return (expression != null ? expression : "");
	}

	@Nullable
	protected final Object getBoundValue() throws BeetlTagException {
		return getBindStatus().getValue();
	}

	@Nullable
	protected PropertyEditor getPropertyEditor() throws BeetlTagException {
		return getBindStatus().getEditor();
	}

	@Override
	@Nullable
	public final PropertyEditor getEditor() throws BeetlTagException {
		return getPropertyEditor();
	}

	protected String convertToDisplayString(Object value) throws BeetlTagException {
		PropertyEditor editor = (value != null ? getBindStatus().findEditor(value.getClass()) : null);
		return getDisplayString(value, editor);
	}

	protected final String processFieldValue(String name, String value, String type) {
		RequestDataValueProcessor processor = getRequestContext().getRequestDataValueProcessor();
		ServletRequest request = ServletUtils.getRequest();
		if (processor != null && (request instanceof HttpServletRequest)) {
			value = processor.processFormFieldValue((HttpServletRequest) request, name, value, type);
		}
		return value;
	}

	/**
	 * Disposes of the {@link BindStatus} instance.
	 */
	@Override
	public void doFinally() {
		this.bindStatus = null;
	}

}
