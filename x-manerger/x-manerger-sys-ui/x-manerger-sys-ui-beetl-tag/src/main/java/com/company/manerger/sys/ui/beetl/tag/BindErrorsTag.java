package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;

public class BindErrorsTag extends HtmlEscapingAwareTag {

	/**
	 * Page context attribute containing {@link Errors}.
	 */
	public static final String ERRORS_VARIABLE_NAME = "errors";


	private String name = "";

	@Nullable
	private Errors errors;


	/**
	 * Set the name of the bean that this tag should check.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the name of the bean that this tag checks.
	 */
	public String getName() {
		return this.name;
	}


	@Override
	protected final int doStartTagInternal() throws BeetlTagException {
		this.errors = getRequestContext().getErrors(this.name, isHtmlEscape());
		if (this.errors != null && this.errors.hasErrors()) {
			this.ctx.globalVar.put(ERRORS_VARIABLE_NAME, this.errors);
			return EVAL_BODY_INCLUDE;
		}
		else {
			return SKIP_BODY;
		}
	}

	@Override
	public int doEndTag() {
		this.ctx.globalVar.remove(ERRORS_VARIABLE_NAME);
		return EVAL_PAGE;
	}

	@Nullable
	public final Errors getErrors() {
		return this.errors;
	}


	@Override
	public void doFinally() {
		super.doFinally();
		this.errors = null;
	}

}
