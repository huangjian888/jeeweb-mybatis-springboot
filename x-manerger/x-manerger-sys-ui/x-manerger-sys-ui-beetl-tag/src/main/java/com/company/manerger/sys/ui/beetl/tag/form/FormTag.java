package com.company.manerger.sys.ui.beetl.tag.form;

import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.context.annotation.Scope;
import org.springframework.core.Conventions;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.UriUtils;

@Component
@Scope("prototype")
@BeetlTagName("form.form")
public class FormTag extends AbstractHtmlElementTag {

	/** The default HTTP method using which form values are sent to the server: "post". */
	private static final String DEFAULT_METHOD = "post";

	/** The default attribute name: &quot;command&quot;. */
	public static final String DEFAULT_COMMAND_NAME = "command";

	/** The name of the '{@code modelAttribute}' setting. */
	private static final String MODEL_ATTRIBUTE = "modelAttribute";

	/**
	 * The name of the {@link org.beetl.core.Context} attribute under which the
	 * form object name is exposed.
	 */
	public static final String MODEL_ATTRIBUTE_VARIABLE_NAME =
			Conventions.getQualifiedAttributeName(AbstractFormTag.class, MODEL_ATTRIBUTE);

	/** Default method parameter, i.e. {@code _method}. */
	private static final String DEFAULT_METHOD_PARAM = "_method";

	private static final String FORM_TAG = "form";

	private static final String INPUT_TAG = "input";

	private static final String ACTION_ATTRIBUTE = "action";

	private static final String METHOD_ATTRIBUTE = "method";

	private static final String TARGET_ATTRIBUTE = "target";

	private static final String ENCTYPE_ATTRIBUTE = "enctype";

	private static final String ACCEPT_CHARSET_ATTRIBUTE = "accept-charset";

	private static final String ONSUBMIT_ATTRIBUTE = "onsubmit";

	private static final String ONRESET_ATTRIBUTE = "onreset";

	private static final String AUTOCOMPLETE_ATTRIBUTE = "autocomplete";

	private static final String NAME_ATTRIBUTE = "name";

	private static final String VALUE_ATTRIBUTE = "value";

	private static final String TYPE_ATTRIBUTE = "type";


	private TagWriter tagWriter;

	private String modelAttribute = DEFAULT_COMMAND_NAME;

	private String name;

	private String action;

	private String servletRelativeAction;

	private String method = DEFAULT_METHOD;

	private String target;

	private String enctype;

	private String acceptCharset;

	private String onsubmit;

	private String onreset;

	private String autocomplete;

	private String methodParam = DEFAULT_METHOD_PARAM;

	/** Caching a previous nested path, so that it may be reset. */
	private String previousNestedPath;


	/**
	 * Set the name of the form attribute in the model.
	 * <p>May be a runtime expression.
	 */
	public void setModelAttribute(String modelAttribute) {
		this.modelAttribute = modelAttribute;
	}

	/**
	 * Get the name of the form attribute in the model.
	 */
	protected String getModelAttribute() {
		return this.modelAttribute;
	}

	/**
	 * Set the value of the '{@code name}' attribute.
	 * <p>May be a runtime expression.
	 * <p>Name is not a valid attribute for form on XHTML 1.0. However,
	 * it is sometimes needed for backward compatibility.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of the '{@code name}' attribute.
	 */
	@Override
	protected String getName() throws BeetlTagException {
		return this.name;
	}

	/**
	 * Set the value of the '{@code action}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setAction(String action) {
		this.action = (action != null ? action : "");
	}

	/**
	 * Get the value of the '{@code action}' attribute.
	 */
	protected String getAction() {
		return this.action;
	}

	/**
	 * Set the value of the '{@code action}' attribute through a value
	 * that is to be appended to the current servlet path.
	 * <p>May be a runtime expression.
	 * @since 3.2.3
	 */
	public void setServletRelativeAction(String servletRelativeAction) {
		this.servletRelativeAction = (servletRelativeAction != null ? servletRelativeAction : "");
	}

	/**
	 * Get the servlet-relative value of the '{@code action}' attribute.
	 * @since 3.2.3
	 */
	protected String getServletRelativeAction() {
		return this.servletRelativeAction;
	}

	/**
	 * Set the value of the '{@code method}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Get the value of the '{@code method}' attribute.
	 */
	protected String getMethod() {
		return this.method;
	}

	/**
	 * Set the value of the '{@code target}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * Get the value of the '{@code target}' attribute.
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * Set the value of the '{@code enctype}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

	/**
	 * Get the value of the '{@code enctype}' attribute.
	 */
	protected String getEnctype() {
		return this.enctype;
	}

	/**
	 * Set the value of the '{@code acceptCharset}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setAcceptCharset(String acceptCharset) {
		this.acceptCharset = acceptCharset;
	}

	/**
	 * Get the value of the '{@code acceptCharset}' attribute.
	 */
	protected String getAcceptCharset() {
		return this.acceptCharset;
	}

	/**
	 * Set the value of the '{@code onsubmit}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setOnsubmit(String onsubmit) {
		this.onsubmit = onsubmit;
	}

	/**
	 * Get the value of the '{@code onsubmit}' attribute.
	 */
	protected String getOnsubmit() {
		return this.onsubmit;
	}

	/**
	 * Set the value of the '{@code onreset}' attribute.
	 * <p>May be a runtime expression.
	 */
	public void setOnreset(String onreset) {
		this.onreset = onreset;
	}

	/**
	 * Get the value of the '{@code onreset}' attribute.
	 */
	protected String getOnreset() {
		return this.onreset;
	}

	/**
	 * Set the value of the '{@code autocomplete}' attribute.
	 * May be a runtime expression.
	 */
	public void setAutocomplete(String autocomplete) {
		this.autocomplete = autocomplete;
	}

	/**
	 * Get the value of the '{@code autocomplete}' attribute.
	 */
	protected String getAutocomplete() {
		return this.autocomplete;
	}

	/**
	 * Set the name of the request param for non-browser supported HTTP methods.
	 */
	public void setMethodParam(String methodParam) {
		this.methodParam = methodParam;
	}

	/**
	 * Get the name of the request param for non-browser supported HTTP methods.
	 * @since 4.2.3
	 */
	protected String getMethodParam() {
		return this.methodParam;
	}

	/**
	 * Determine if the HTTP method is supported by browsers (i.e. GET or POST).
	 */
	protected boolean isMethodBrowserSupported(String method) {
		return ("get".equalsIgnoreCase(method) || "post".equalsIgnoreCase(method));
	}


 
	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		this.tagWriter = tagWriter;

		tagWriter.startTag(FORM_TAG);
		writeDefaultAttributes(tagWriter);
		tagWriter.writeAttribute(ACTION_ATTRIBUTE, resolveAction());
		writeOptionalAttribute(tagWriter, METHOD_ATTRIBUTE, getHttpMethod());
		writeOptionalAttribute(tagWriter, TARGET_ATTRIBUTE, getTarget());
		writeOptionalAttribute(tagWriter, ENCTYPE_ATTRIBUTE, getEnctype());
		writeOptionalAttribute(tagWriter, ACCEPT_CHARSET_ATTRIBUTE, getAcceptCharset());
		writeOptionalAttribute(tagWriter, ONSUBMIT_ATTRIBUTE, getOnsubmit());
		writeOptionalAttribute(tagWriter, ONRESET_ATTRIBUTE, getOnreset());
		writeOptionalAttribute(tagWriter, AUTOCOMPLETE_ATTRIBUTE, getAutocomplete());

		tagWriter.forceBlock();

		if (!isMethodBrowserSupported(getMethod())) {
			assertHttpMethod(getMethod());
			String inputName = getMethodParam();
			String inputType = "hidden";
			tagWriter.startTag(INPUT_TAG);
			writeOptionalAttribute(tagWriter, TYPE_ATTRIBUTE, inputType);
			writeOptionalAttribute(tagWriter, NAME_ATTRIBUTE, inputName);
			writeOptionalAttribute(tagWriter, VALUE_ATTRIBUTE, processFieldValue(inputName, getMethod(), inputType));
			tagWriter.endTag();
		}

		// Expose the form object name for nested tags...
		String modelAttribute = resolveModelAttribute();
		this.ctx.globalVar.put(MODEL_ATTRIBUTE_VARIABLE_NAME, modelAttribute);

		// Save previous nestedPath value, build and expose current nestedPath value.
		// Use request scope to expose nestedPath to included pages too.
		this.previousNestedPath =
				(String) this.ctx.globalVar.get(NESTED_PATH_VARIABLE_NAME);
		this.ctx.globalVar.put(NESTED_PATH_VARIABLE_NAME,
				modelAttribute + PropertyAccessor.NESTED_PROPERTY_SEPARATOR);

		return EVAL_BODY_INCLUDE;
	}

	private String getHttpMethod() {
		return (isMethodBrowserSupported(getMethod()) ? getMethod() : DEFAULT_METHOD);
	}

	private void assertHttpMethod(String method) {
		for (HttpMethod httpMethod : HttpMethod.values()) {
			if (httpMethod.name().equalsIgnoreCase(method)) {
				return;
			}
		}
		throw new IllegalArgumentException("Invalid HTTP method: " + method);
	}

	/**
	 * Autogenerated IDs correspond to the form object name.
	 */
	@Override
	protected String autogenerateId() throws BeetlTagException {
		return resolveModelAttribute();
	}

	/**
	 * {@link #evaluate Resolves} and returns the name of the form object.
	 * @throws IllegalArgumentException if the form object resolves to {@code null}
	 */
	protected String resolveModelAttribute() throws BeetlTagException {
		Object resolvedModelAttribute = evaluate(MODEL_ATTRIBUTE, getModelAttribute());
		if (resolvedModelAttribute == null) {
			throw new IllegalArgumentException(MODEL_ATTRIBUTE + " must not be null");
		}
		return (String) resolvedModelAttribute;
	}

	/**
	 * Resolve the value of the '{@code action}' attribute.
	 * <p>If the user configured an '{@code action}' value then the result of
	 * evaluating this value is used. If the user configured an
	 * '{@code servletRelativeAction}' value then the value is prepended
	 * with the context and servlet paths, and the result is used. Otherwise, the
	 * {@link com.company.manerger.sys.ui.beetl.tag.support.RequestContext#getRequestUri()
	 * originating URI} is used.
	 * @return the value that is to be used for the '{@code action}' attribute
	 */
	protected String resolveAction() throws BeetlTagException {
		String action = getAction();
		String servletRelativeAction = getServletRelativeAction();
		if (StringUtils.hasText(action)) {
			action = getDisplayString(evaluate(ACTION_ATTRIBUTE, action));
			return processAction(action);
		}
		else if (StringUtils.hasText(servletRelativeAction)) {
			String pathToServlet = getRequestContext().getPathToServlet();
			if (servletRelativeAction.startsWith("/") &&
					!servletRelativeAction.startsWith(getRequestContext().getContextPath())) {
				servletRelativeAction = pathToServlet + servletRelativeAction;
			}
			servletRelativeAction = getDisplayString(evaluate(ACTION_ATTRIBUTE, servletRelativeAction));
			return processAction(servletRelativeAction);
		}
		else {
			String requestUri = getRequestContext().getRequestUri();
			String encoding = ServletUtils.getResponse().getCharacterEncoding();
			try {
				requestUri = UriUtils.encodePath(requestUri, encoding);
			}
			catch (UnsupportedCharsetException ex) {
				// shouldn't happen - if it does, proceed with requestUri as-is
			}
			ServletResponse response = ServletUtils.getResponse();
			if (response instanceof HttpServletResponse) {
				requestUri = ((HttpServletResponse) response).encodeURL(requestUri);
				String queryString = getRequestContext().getQueryString();
				if (StringUtils.hasText(queryString)) {
					requestUri += "?" + HtmlUtils.htmlEscape(queryString);
				}
			}
			if (StringUtils.hasText(requestUri)) {
				return processAction(requestUri);
			}
			else {
				throw new IllegalArgumentException("Attribute 'action' is required. " +
						"Attempted to resolve against current request URI but request URI was null.");
			}
		}
	}

	/**
	 * Process the action through a {@link RequestDataValueProcessor} instance
	 * if one is configured or otherwise returns the action unmodified.
	 */
	private String processAction(String action) {
		RequestDataValueProcessor processor = getRequestContext().getRequestDataValueProcessor();
		ServletRequest request = ServletUtils.getRequest();
		if (processor != null && request instanceof HttpServletRequest) {
			action = processor.processAction((HttpServletRequest) request, action, getHttpMethod());
		}
		return action;
	}

	/**
	 * Closes the '{@code form}' block tag and removes the form object name
	 * from the {@link org.beetl.core.Context}.
	 */
	@Override
	public int doEndTag() throws BeetlTagException {
		RequestDataValueProcessor processor = getRequestContext().getRequestDataValueProcessor();
		ServletRequest request = ServletUtils.getRequest();
		if (processor != null && request instanceof HttpServletRequest) {
			writeHiddenFields(processor.getExtraHiddenFields((HttpServletRequest) request));
		}
		this.tagWriter.endTag();
		return EVAL_PAGE;
	}

	/**
	 * Writes the given values as hidden fields.
	 */
	private void writeHiddenFields(Map<String, String> hiddenFields) throws BeetlTagException {
		if (!CollectionUtils.isEmpty(hiddenFields)) {
			this.tagWriter.appendValue("<div>\n");
			for (String name : hiddenFields.keySet()) {
				this.tagWriter.appendValue("<input type=\"hidden\" ");
				this.tagWriter.appendValue("name=\"" + name + "\" value=\"" + hiddenFields.get(name) + "\" ");
				this.tagWriter.appendValue("/>\n");
			}
			this.tagWriter.appendValue("</div>");
		}
	}

	/**
	 * Clears the stored {@link TagWriter}.
	 */
	@Override
	public void doFinally() {
		super.doFinally();

		this.ctx.globalVar.remove(MODEL_ATTRIBUTE_VARIABLE_NAME);
		if (this.previousNestedPath != null) {
			// Expose previous nestedPath value.
			this.ctx.globalVar.put(NESTED_PATH_VARIABLE_NAME, this.previousNestedPath);
		}
		else {
			// Remove exposed nestedPath value.
			this.ctx.globalVar.remove(NESTED_PATH_VARIABLE_NAME);
		}
		this.tagWriter = null;
		this.previousNestedPath = null;
	}


	/**
	 * Override resolve CSS class since error class is not supported.
	 */
	@Override
	protected String resolveCssClass() throws BeetlTagException {
		return ObjectUtils.getDisplayString(evaluate("cssClass", getCssClass()));
	}

	/**
	 * Unsupported for forms.
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setPath(String path) {
		throw new UnsupportedOperationException("The 'path' attribute is not supported for forms");
	}

	/**
	 * Unsupported for forms.
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setCssErrorClass(String cssErrorClass) {
		throw new UnsupportedOperationException("The 'cssErrorClass' attribute is not supported for forms");
	}

}
