package cn.jeeweb.core.tags.html;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("serial")
public class DisplayTag extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	protected String getContent() {
		BodyContent body = getBodyContent();
		String content = body.getString();
		content = StringEscapeUtils.escapeHtml4(content);
		return content;
	}

	public int doEndTag() throws JspTagException {
		try {
			JspWriter out = this.pageContext.getOut();
			out.print(getContent());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}