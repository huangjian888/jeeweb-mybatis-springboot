package com.company.manerger.sys.ui.beetl.tag;

import java.io.IOException;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.beetl.core.BodyContent;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.util.JavaScriptUtils;

@Component
@Scope("prototype")
@BeetlTagName("body.escape")
public class EscapeBodyTag extends HtmlEscapingAwareTag implements BodyTag {

	private boolean javaScriptEscape = false;

	@Nullable
	private BodyContent bodyContent;


	/**
	 * Set JavaScript escaping for this tag, as boolean value.
	 * Default is "false".
	 */
	public void setJavaScriptEscape(boolean javaScriptEscape) throws BeetlTagException {
		this.javaScriptEscape = javaScriptEscape;
	}


	@Override
	protected int doStartTagInternal() {
		// do nothing
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public void doInitBody() {
		// do nothing
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	@Override
	public int doAfterBody() throws BeetlTagException {
		try {
			String content = readBodyContent();
			// HTML and/or JavaScript escape, if demanded
			content = htmlEscape(content);
			content = (this.javaScriptEscape ? JavaScriptUtils.javaScriptEscape(content) : content);
			writeBodyContent(content);
		}
		catch (IOException ex) {
			throw new BeetlTagException("Could not write escaped body", ex);
		}
		return (SKIP_BODY);
	}

	/**
	 * Read the unescaped body content from the page.
	 * @return the original content
	 * @throws IOException if reading failed
	 */
	protected String readBodyContent() throws IOException {
		Assert.state(this.bodyContent != null, "No BodyContent set");
		return this.bodyContent.getBody();
	}

	/**
	 * Write the escaped body content to the page.
	 * <p>Can be overridden in subclasses, e.g. for testing purposes.
	 * @param content the content to write
	 * @throws IOException if writing failed
	 */
	protected void writeBodyContent(String content) throws IOException {
		Assert.state(this.bodyContent != null, "No BodyContent set");
		// this.bodyContent.getEnclosingWriter().print(content);
		this.ctx.byteWriter.writeString(content);
	}

}
