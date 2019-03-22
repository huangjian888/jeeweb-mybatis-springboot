package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;

public class HtmlEscapeTag extends RequestContextAwareTag {

	private boolean defaultHtmlEscape;


	/**
	 * Set the default value for HTML escaping,
	 * to be put into the current PageContext.
	 */
	public void setDefaultHtmlEscape(boolean defaultHtmlEscape) {
		this.defaultHtmlEscape = defaultHtmlEscape;
	}


	@Override
	protected int doStartTagInternal() throws BeetlTagException {
		getRequestContext().setDefaultHtmlEscape(this.defaultHtmlEscape);
		return EVAL_BODY_INCLUDE;
	}

}
