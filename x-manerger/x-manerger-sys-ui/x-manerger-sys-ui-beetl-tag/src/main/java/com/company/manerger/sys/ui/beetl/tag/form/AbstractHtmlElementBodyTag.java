package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.BodyTag;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.beetl.core.BodyContent;
import org.springframework.util.StringUtils;

public abstract class AbstractHtmlElementBodyTag extends AbstractHtmlElementTag implements BodyTag {

	private BodyContent bodyContent;

	private TagWriter tagWriter;


	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		onWriteTagContent();
		this.tagWriter = tagWriter;
		if (shouldRender()) {
			exposeAttributes();
			return EVAL_BODY_BUFFERED;
		}
		else {
			return SKIP_BODY;
		}
	}


	@Override
	public int doEndTag() throws BeetlTagException {
		if (shouldRender()) {
			if (this.bodyContent != null && StringUtils.hasText(this.bodyContent.getBody())) {
				renderFromBodyContent(this.bodyContent, this.tagWriter);
			}
			else {
				renderDefaultContent(this.tagWriter);
			}
		}
		return EVAL_PAGE;
	}

	/**
	 * Render the tag contents based on the supplied {@link BodyContent}.
	 * <p>The default implementation simply {@link #flushBufferedBodyContent flushes}
	 * the {@link BodyContent} directly to the output. Subclasses may choose to
	 * override this to add additional content to the output.
	 */
	protected void renderFromBodyContent(BodyContent bodyContent, TagWriter tagWriter) throws BeetlTagException {
		flushBufferedBodyContent(this.bodyContent);
	}

	/**
	 * Clean up any attributes and stored resources.
	 */
	@Override
	public void doFinally() {
		super.doFinally();
		removeAttributes();
		this.tagWriter = null;
		this.bodyContent = null;
	}



	protected void onWriteTagContent() {
	}


	protected boolean shouldRender() throws BeetlTagException {
		return true;
	}


	protected void exposeAttributes() throws BeetlTagException {
	}

	protected void removeAttributes() {
	}


	protected void flushBufferedBodyContent(BodyContent bodyContent) throws BeetlTagException {
		// no op
	}

	protected abstract void renderDefaultContent(TagWriter tagWriter) throws BeetlTagException;


	//---------------------------------------------------------------------
	// BodyTag implementation
	//---------------------------------------------------------------------

	@Override
	public void doInitBody() throws BeetlTagException {
		// no op
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

}
