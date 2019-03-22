package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.lang.Nullable;

public class ParamTag extends TagSupport {

	private String name = "";

	@Nullable
	private String value;

	private boolean valueSet;


	/**
	 * Set the name of the parameter (required).
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the value of the parameter (optional).
	 */
	public void setValue(String value) {
		this.value = value;
		this.valueSet = true;
	}


	@Override
	public int doEndTag() throws BeetlTagException {
		Param param = new Param();
		param.setName(this.name);
		if (this.valueSet) {
			param.setValue(this.value);
		}
		else if (getBodyContent() != null) {
			// Get the value from the tag body
			param.setValue(getBodyContent().getBody().trim());
		}

		// Find a param aware ancestor
		/*ParamAware paramAwareTag = (ParamAware) findAncestorWithClass(this, ParamAware.class);
		if (paramAwareTag == null) {
			throw new BeetlTagException("The param tag must be a descendant of a tag that supports parameters");
		}

		paramAwareTag.addParam(param);*/

		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		this.name = "";
		this.value = null;
		this.valueSet = false;
	}

}
