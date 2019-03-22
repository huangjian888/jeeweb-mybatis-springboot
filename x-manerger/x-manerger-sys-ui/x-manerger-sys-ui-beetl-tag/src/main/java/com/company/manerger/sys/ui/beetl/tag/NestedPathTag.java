package com.company.manerger.sys.ui.beetl.tag;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.lang.Nullable;

public class NestedPathTag extends TagSupport {

	/**
	 * Name of the exposed variable within the scope of this tag: "nestedPath".
	 */
	public static final String NESTED_PATH_VARIABLE_NAME = "nestedPath";


	@Nullable
	private String path;

	/** Caching a previous nested path, so that it may be reset. */
	@Nullable
	private String previousNestedPath;


	/**
	 * Set the path that this tag should apply.
	 * <p>E.g. "customer" to allow bind paths like "address.street"
	 * rather than "customer.address.street".
	 * @see BindTag#setPath
	 */
	public void setPath(@Nullable String path) {
		if (path == null) {
			path = "";
		}
		if (path.length() > 0 && !path.endsWith(PropertyAccessor.NESTED_PROPERTY_SEPARATOR)) {
			path += PropertyAccessor.NESTED_PROPERTY_SEPARATOR;
		}
		this.path = path;
	}

	/**
	 * Return the path that this tag applies to.
	 */
	@Nullable
	public String getPath() {
		return this.path;
	}


	@Override
	public int doStartTag() throws BeetlTagException {
		// Save previous nestedPath value, build and expose current nestedPath value.
		// Use request scope to expose nestedPath to included pages too.
		this.previousNestedPath =
				(String) this.ctx.globalVar.get(NESTED_PATH_VARIABLE_NAME);
		String nestedPath =
				(this.previousNestedPath != null ? this.previousNestedPath + getPath() : getPath());
		this.ctx.globalVar.put(NESTED_PATH_VARIABLE_NAME, nestedPath);

		return EVAL_BODY_INCLUDE;
	}

	/**
	 * Reset any previous nestedPath value.
	 */
	@Override
	public int doEndTag() {
		if (this.previousNestedPath != null) {
			// Expose previous nestedPath value.
			this.ctx.globalVar.put(NESTED_PATH_VARIABLE_NAME, this.previousNestedPath);
		}
		else {
			// Remove exposed nestedPath value.
			this.ctx.globalVar.remove(NESTED_PATH_VARIABLE_NAME);
		}

		return EVAL_PAGE;
	}

	@Override
	public void doFinally() {
		this.previousNestedPath = null;
	}

}
