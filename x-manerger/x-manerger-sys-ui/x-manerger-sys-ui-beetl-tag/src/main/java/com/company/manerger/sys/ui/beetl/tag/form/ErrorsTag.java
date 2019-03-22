package com.company.manerger.sys.ui.beetl.tag.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.company.manerger.sys.ui.beetl.tag.BodyTag;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Component
@Scope("prototype")
@BeetlTagName("form.errors")
public class ErrorsTag extends AbstractHtmlElementBodyTag implements BodyTag {

	public static final String MESSAGES_ATTRIBUTE = "messages";

	public static final String SPAN_TAG = "span";


	private String element = SPAN_TAG;

	private String delimiter = "<br/>";

	/**
	 * Stores any value that existed in the 'errors messages' before the tag was started.
	 */
	private Object oldMessages;

	private boolean errorMessagesWereExposed;


	/**
	 * Set the HTML element must be used to render the error messages.
	 * <p>Defaults to an HTML '{@code <span/>}' tag.
	 */
	public void setElement(String element) {
		Assert.hasText(element, "'element' cannot be null or blank");
		this.element = element;
	}

	/**
	 * Get the HTML element must be used to render the error messages.
	 */
	public String getElement() {
		return this.element;
	}

	/**
	 * Set the delimiter to be used between error messages.
	 * <p>Defaults to an HTML '{@code <br/>}' tag.
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Return the delimiter to be used between error messages.
	 */
	public String getDelimiter() {
		return this.delimiter;
	}


	/**
	 * Get the value for the HTML '{@code id}' attribute.
	 * <p>Appends '{@code .errors}' to the value returned by {@link #getPropertyPath()}
	 * or to the model attribute name if the {@code <form:errors/>} tag's
	 * '{@code path}' attribute has been omitted.
	 * @return the value for the HTML '{@code id}' attribute
	 * @see #getPropertyPath()
	 */
	@Override
	protected String autogenerateId() throws BeetlTagException {
		String path = getPropertyPath();
		if ("".equals(path) || "*".equals(path)) {
			path = (String) this.ctx.globalVar.get(FormTag.MODEL_ATTRIBUTE_VARIABLE_NAME);
		}
		return StringUtils.deleteAny(path, "[]") + ".errors";
	}

	/**
	 * Get the value for the HTML '{@code name}' attribute.
	 * <p>Simply returns {@code null} because the '{@code name}' attribute
	 * is not a validate attribute for the '{@code span}' element.
	 */
	@Override
	protected String getName() throws BeetlTagException {
		return null;
	}

	/**
	 * Should rendering of this tag proceed at all?
	 * <p>Only renders output when there are errors for the configured {@link #setPath path}.
	 * @return {@code true} only when there are errors for the configured {@link #setPath path}
	 */
	@Override
	protected boolean shouldRender() throws BeetlTagException {
		try {
			return getBindStatus().isError();
		}
		catch (IllegalStateException ex) {
			// Neither BindingResult nor target object available.
			return false;
		}
	}

	@Override
	protected void renderDefaultContent(TagWriter tagWriter) throws BeetlTagException {
		tagWriter.startTag(getElement());
		writeDefaultAttributes(tagWriter);
		String delimiter = ObjectUtils.getDisplayString(evaluate("delimiter", getDelimiter()));
		String[] errorMessages = getBindStatus().getErrorMessages();
		for (int i = 0; i < errorMessages.length; i++) {
			String errorMessage = errorMessages[i];
			if (i > 0) {
				tagWriter.appendValue(delimiter);
			}
			tagWriter.appendValue(getDisplayString(errorMessage));
		}
		tagWriter.endTag();
	}
	
	@Override
	protected void exposeAttributes() throws BeetlTagException {
		List<String> errorMessages = new ArrayList<>();
		errorMessages.addAll(Arrays.asList(getBindStatus().getErrorMessages()));
		this.oldMessages = this.ctx.globalVar.get(MESSAGES_ATTRIBUTE);
		this.ctx.globalVar.put(MESSAGES_ATTRIBUTE, errorMessages);
		this.errorMessagesWereExposed = true;
	}
	
	@Override
	protected void removeAttributes() {
		if (this.errorMessagesWereExposed) {
			if (this.oldMessages != null) {
				this.ctx.globalVar.put(MESSAGES_ATTRIBUTE, this.oldMessages);
				this.oldMessages = null;
			}
			else {
				this.ctx.globalVar.remove(MESSAGES_ATTRIBUTE);
			}
		}
	}

}
