package com.company.manerger.sys.ui.beetl.tag;

import java.beans.PropertyEditor;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import com.company.manerger.sys.ui.beetl.tag.support.BindStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;

public class BindTag extends HtmlEscapingAwareTag implements EditorAwareTag {

	public static final String STATUS_VARIABLE_NAME = "status";


	private String path = "";

	private boolean ignoreNestedPath = false;

	@Nullable
	private BindStatus status;

	@Nullable
	private Object previousPageStatus;

	@Nullable
	private Object previousRequestStatus;


	/**
	 * Set the path that this tag should apply. Can be a bean (e.g. "person")
	 * to get global errors, or a bean property (e.g. "person.name") to get
	 * field errors (also supporting nested fields and "person.na*" mappings).
	 * "person.*" will return all errors for the specified bean, both global
	 * and field errors.
	 * @see Errors#getGlobalErrors
	 * @see Errors#getFieldErrors
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Return the path that this tag applies to.
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * Set whether to ignore a nested path, if any.
	 * Default is to not ignore.
	 */
	public void setIgnoreNestedPath(boolean ignoreNestedPath) {
		this.ignoreNestedPath = ignoreNestedPath;
	}

	/**
	 * Return whether to ignore a nested path, if any.
	 */
	public boolean isIgnoreNestedPath() {
		return this.ignoreNestedPath;
	}


	@Override
	protected final int doStartTagInternal() throws BeetlTagException {
		String resolvedPath = getPath();
		if (!isIgnoreNestedPath()) {
			String nestedPath = (String) this.ctx.globalVar.get(
					NestedPathTag.NESTED_PATH_VARIABLE_NAME);
			// only prepend if not already an absolute path
			if (nestedPath != null && !resolvedPath.startsWith(nestedPath) &&
					!resolvedPath.equals(nestedPath.substring(0, nestedPath.length() - 1))) {
				resolvedPath = nestedPath + resolvedPath;
			}
		}

		try {
			this.status = new BindStatus(getRequestContext(), resolvedPath, isHtmlEscape());
		}
		catch (IllegalStateException ex) {
			throw new BeetlTagException(ex.getMessage());
		}

		// Save previous status values, for re-exposure at the end of this tag.
		this.previousPageStatus = this.ctx.globalVar.get(STATUS_VARIABLE_NAME);
		this.previousRequestStatus = this.ctx.globalVar.get(STATUS_VARIABLE_NAME);

		// Expose this tag's status object as PageContext attribute,
		// making it available for JSP EL.
		this.ctx.globalVar.remove(STATUS_VARIABLE_NAME);
		this.ctx.globalVar.put(STATUS_VARIABLE_NAME, this.status);

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() {
		// Reset previous status values.
		if (this.previousPageStatus != null) {
			this.ctx.globalVar.put(STATUS_VARIABLE_NAME, this.previousPageStatus);
		}
		if (this.previousRequestStatus != null) {
			this.ctx.globalVar.put(STATUS_VARIABLE_NAME, this.previousRequestStatus);
		}
		else {
			this.ctx.globalVar.remove(STATUS_VARIABLE_NAME);
		}
		return EVAL_PAGE;
	}


	/**
	 * Return the current BindStatus.
	 */
	private BindStatus getStatus() {
		Assert.state(this.status != null, "No current BindStatus");
		return this.status;
	}

	/**
	 * Retrieve the property that this tag is currently bound to,
	 * or {@code null} if bound to an object rather than a specific property.
	 * Intended for cooperating nesting tags.
	 * @return the property that this tag is currently bound to,
	 * or {@code null} if none
	 */
	@Nullable
	public final String getProperty() {
		return getStatus().getExpression();
	}

	/**
	 * Retrieve the Errors instance that this tag is currently bound to.
	 * Intended for cooperating nesting tags.
	 * @return the current Errors instance, or {@code null} if none
	 */
	@Nullable
	public final Errors getErrors() {
		return getStatus().getErrors();
	}

	@Override
	@Nullable
	public final PropertyEditor getEditor() {
		return getStatus().getEditor();
	}


	@Override
	public void doFinally() {
		super.doFinally();
		this.status = null;
		this.previousPageStatus = null;
		this.previousRequestStatus = null;
	}

}
