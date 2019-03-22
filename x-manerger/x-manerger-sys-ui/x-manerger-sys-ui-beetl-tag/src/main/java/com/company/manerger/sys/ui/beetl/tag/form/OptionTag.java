package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.BodyTag;
import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.beetl.core.BodyContent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.company.manerger.sys.ui.beetl.tag.support.BindStatus;

@Component
@Scope("prototype")
@BeetlTagName("form.option")
public class OptionTag extends AbstractHtmlElementBodyTag implements BodyTag {

	/**
	 * The name of the JSP variable used to expose the value for this tag.
	 */
	public static final String VALUE_VARIABLE_NAME = "value";

	/**
	 * The name of the JSP variable used to expose the display value for this tag.
	 */
	public static final String DISPLAY_VALUE_VARIABLE_NAME = "displayValue";

	/**
	 * The name of the '{@code selected}' attribute.
	 */
	private static final String SELECTED_ATTRIBUTE = "selected";

	/**
	 * The name of the '{@code value}' attribute.
	 */
	private static final String VALUE_ATTRIBUTE = VALUE_VARIABLE_NAME;

	/**
	 * The name of the '{@code disabled}' attribute.
	 */
	private static final String DISABLED_ATTRIBUTE = "disabled";


	/**
	 * The 'value' attribute of the rendered HTML {@code <option>} tag.
	 */
	private Object value;

	/**
	 * The text body of the rendered HTML {@code <option>} tag.
	 */
	private String label;

	private Object oldValue;

	private Object oldDisplayValue;

	private boolean disabled;


	/**
	 * Set the 'value' attribute of the rendered HTML {@code <option>} tag.
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Get the 'value' attribute of the rendered HTML {@code <option>} tag.
	 */
	protected Object getValue() {
		return this.value;
	}

	/**
	 * Set the value of the '{@code disabled}' attribute.
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * Get the value of the '{@code disabled}' attribute.
	 */
	protected boolean isDisabled() {
		return this.disabled;
	}

	/**
	 * Set the text body of the rendered HTML {@code <option>} tag.
	 * <p>May be a runtime expression.
	 */
	public void setLabel(String label) {
		Assert.notNull(label, "'label' must not be null");
		this.label = label;
	}

	/**
	 * Get the text body of the rendered HTML {@code <option>} tag.
	 */
	protected String getLabel() {
		return this.label;
	}


	@Override
	protected void renderDefaultContent(TagWriter tagWriter) throws BeetlTagException {
		Object value = this.ctx.globalVar.get(VALUE_VARIABLE_NAME);
		String label = getLabelValue(value);
		renderOption(value, label, tagWriter);
	}

	@Override
	protected void renderFromBodyContent(BodyContent bodyContent, TagWriter tagWriter) throws BeetlTagException {
		Object value = this.ctx.globalVar.get(VALUE_VARIABLE_NAME);
		String label = bodyContent.getBody();
		renderOption(value, label, tagWriter);
	}

	/**
	 * Make sure we are under a '{@code select}' tag before proceeding.
	 */
	@Override
	protected void onWriteTagContent() {
		assertUnderSelectTag();
	}

	@Override
	protected void exposeAttributes() throws BeetlTagException {
		Object value = resolveValue();
		this.oldValue = this.ctx.globalVar.get(VALUE_VARIABLE_NAME);
		this.ctx.globalVar.put(VALUE_VARIABLE_NAME, value);
		this.oldDisplayValue = this.ctx.globalVar.get(DISPLAY_VALUE_VARIABLE_NAME);
		this.ctx.globalVar.put(DISPLAY_VALUE_VARIABLE_NAME, getDisplayString(value, getBindStatus().getEditor()));
	}

	@Override
	protected BindStatus getBindStatus() {
		return (BindStatus) this.ctx.globalVar.get(SelectTag.LIST_VALUE_PAGE_ATTRIBUTE);
	}

	@Override
	protected void removeAttributes() {
		if (this.oldValue != null) {
			this.ctx.globalVar.put(VALUE_ATTRIBUTE, this.oldValue);
			this.oldValue = null;
		}
		else {
			this.ctx.globalVar.remove(VALUE_VARIABLE_NAME);
		}

		if (this.oldDisplayValue != null) {
			this.ctx.globalVar.put(DISPLAY_VALUE_VARIABLE_NAME, this.oldDisplayValue);
			this.oldDisplayValue = null;
		}
		else {
			this.ctx.globalVar.remove(DISPLAY_VALUE_VARIABLE_NAME);
		}
	}

	private void renderOption(Object value, String label, TagWriter tagWriter) throws BeetlTagException {
		tagWriter.startTag("option");
		writeOptionalAttribute(tagWriter, "id", resolveId());
		writeOptionalAttributes(tagWriter);
		String renderedValue = getDisplayString(value, getBindStatus().getEditor());
		renderedValue = processFieldValue(getSelectTag().getName(), renderedValue, "option");
		tagWriter.writeAttribute(VALUE_ATTRIBUTE, renderedValue);
		if (isSelected(value)) {
			tagWriter.writeAttribute(SELECTED_ATTRIBUTE, SELECTED_ATTRIBUTE);
		}
		if (isDisabled()) {
			tagWriter.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
		}
		tagWriter.appendValue(label);
		tagWriter.endTag();
	}

	@Override
	protected String autogenerateId() throws BeetlTagException {
		return null;
	}

	/**
	 * Returns the value of the label for this '{@code option}' element.
	 * If the {@link #setLabel label} property is set then the resolved value
	 * of that property is used, otherwise the value of the {@code resolvedValue}
	 * argument is used.
	 */
	private String getLabelValue(Object resolvedValue) throws BeetlTagException {
		String label = getLabel();
		Object labelObj = (label == null ? resolvedValue : evaluate("label", label));
		return getDisplayString(labelObj, getBindStatus().getEditor());
	}

	private void assertUnderSelectTag() {

		// TagUtils.assertHasAncestorOfType(this, SelectTag.class, "option", "select");
	}

	private SelectTag getSelectTag() {
		return (SelectTag)this.getParent();
	}

	private boolean isSelected(Object resolvedValue) {
		return SelectedValueComparator.isSelected(getBindStatus(), resolvedValue);
	}

	private Object resolveValue() throws BeetlTagException {
		return evaluate(VALUE_VARIABLE_NAME, getValue());
	}

}
