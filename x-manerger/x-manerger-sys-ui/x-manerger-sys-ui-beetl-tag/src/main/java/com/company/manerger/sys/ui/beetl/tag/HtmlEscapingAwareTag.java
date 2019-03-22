package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.common.utils.ServletUtils;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.lang.Nullable;
import org.springframework.web.util.HtmlUtils;

public abstract class HtmlEscapingAwareTag extends RequestContextAwareTag {

	@Nullable
	private Boolean htmlEscape;


	public void setHtmlEscape(boolean htmlEscape) throws BeetlTagException {
		this.htmlEscape = htmlEscape;
	}

	protected boolean isHtmlEscape() {
		if (this.htmlEscape != null) {
			return this.htmlEscape.booleanValue();
		}
		else {
			return isDefaultHtmlEscape();
		}
	}

	protected boolean isDefaultHtmlEscape() {
		return getRequestContext().isDefaultHtmlEscape();
	}

	protected boolean isResponseEncodedHtmlEscape() {
		return getRequestContext().isResponseEncodedHtmlEscape();
	}


	protected String htmlEscape(String content) {
		String out = content;
		if (isHtmlEscape()) {
			if (isResponseEncodedHtmlEscape()) {
				out = HtmlUtils.htmlEscape(content, ServletUtils.getResponse().getCharacterEncoding());
			}
			else {
				out = HtmlUtils.htmlEscape(content);
			}
		}
		return out;
	}

}
