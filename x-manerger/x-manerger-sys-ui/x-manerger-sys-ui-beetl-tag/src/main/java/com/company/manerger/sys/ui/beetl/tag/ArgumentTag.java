package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.lang.Nullable;

public class ArgumentTag extends TagSupport {

	@Nullable
	private Object value;

	private boolean valueSet;


	/**
	 * Set the value of the argument (optional).
	 * If not set, the tag's body content will get evaluated.
	 * @param value the parameter value
	 */
	public void setValue(Object value) {
		this.value = value;
		this.valueSet = true;
	}


	@Override
	public int doEndTag() throws BeetlTagException {
		Object argument = null;
		if (this.valueSet) {
			argument = this.value;
		}
		else if (getBodyContent() != null) {
			// Get the value from the tag body
			argument = getBodyContent().getBody().trim();
		}

		// Find a param-aware ancestor
		/*ArgumentAware argumentAwareTag = (ArgumentAware) findAncestorWithClass(this, ArgumentAware.class);
		if (argumentAwareTag == null) {
			throw new BeetlTagException("The argument tag must be a descendant of a tag that supports arguments");
		}
		argumentAwareTag.addArgument(argument);*/

		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		this.value = null;
		this.valueSet = false;
	}

}
