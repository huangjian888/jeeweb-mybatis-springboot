package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@BeetlTagName("form.textarea")
public class TextareaTag extends AbstractHtmlInputElementTag {

	public static final String ROWS_ATTRIBUTE = "rows";

	public static final String COLS_ATTRIBUTE = "cols";

	public static final String ONSELECT_ATTRIBUTE = "onselect";

	public static final String READONLY_ATTRIBUTE = "readonly";


	private String rows;

	private String cols;

	private String onselect;


	/**
	 * Set the value of the '{@code rows}' attribute.
	 * May be a runtime expression.
	 */
	public void setRows(String rows) {
		this.rows = rows;
	}

	/**
	 * Get the value of the '{@code rows}' attribute.
	 */
	protected String getRows() {
		return this.rows;
	}

	/**
	 * Set the value of the '{@code cols}' attribute.
	 * May be a runtime expression.
	 */
	public void setCols(String cols) {
		this.cols = cols;
	}

	/**
	 * Get the value of the '{@code cols}' attribute.
	 */
	protected String getCols() {
		return this.cols;
	}

	/**
	 * Set the value of the '{@code onselect}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}

	/**
	 * Get the value of the '{@code onselect}' attribute.
	 */
	protected String getOnselect() {
		return this.onselect;
	}


	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		tagWriter.startTag("textarea");
		writeDefaultAttributes(tagWriter);
		writeOptionalAttribute(tagWriter, ROWS_ATTRIBUTE, getRows());
		writeOptionalAttribute(tagWriter, COLS_ATTRIBUTE, getCols());
		writeOptionalAttribute(tagWriter, ONSELECT_ATTRIBUTE, getOnselect());
		String value = getDisplayString(getBoundValue(), getPropertyEditor());
		tagWriter.appendValue("\r\n" + processFieldValue(getName(), value, "textarea"));
		tagWriter.endTag();
		return SKIP_BODY;
	}

}
