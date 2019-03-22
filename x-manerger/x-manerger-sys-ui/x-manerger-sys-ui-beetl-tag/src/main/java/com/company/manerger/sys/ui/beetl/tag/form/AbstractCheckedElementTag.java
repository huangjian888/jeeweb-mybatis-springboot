package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;

public abstract class AbstractCheckedElementTag extends AbstractHtmlInputElementTag {

	/**
	 * Render the '{@code input(checkbox)}' with the supplied value, marking the
	 * '{@code input}' element as 'checked' if the supplied value matches the
	 * bound value.
	 */
	protected void renderFromValue(Object value, TagWriter tagWriter) throws BeetlTagException {
		renderFromValue(value, value, tagWriter);
	}

	/**
	 * Render the '{@code input(checkbox)}' with the supplied value, marking the
	 * '{@code input}' element as 'checked' if the supplied value matches the
	 * bound value.
	 */
	protected void renderFromValue(Object item, Object value, TagWriter tagWriter) throws BeetlTagException {
		String displayValue = convertToDisplayString(value);
		tagWriter.writeAttribute("value", processFieldValue(getName(), displayValue, getInputType()));
		if (isOptionSelected(value) || (value != item && isOptionSelected(item))) {
			tagWriter.writeAttribute("checked", "checked");
		}
	}

	/**
	 * Determines whether the supplied value matched the selected value
	 * through delegating to {@link com.company.manerger.sys.ui.beetl.tag.form.SelectedValueComparator#isSelected}.
	 */
	private boolean isOptionSelected(Object value) throws BeetlTagException {
		return com.company.manerger.sys.ui.beetl.tag.form.SelectedValueComparator.isSelected(getBindStatus(), value);
	}

	/**
	 * Render the '{@code input(checkbox)}' with the supplied value, marking
	 * the '{@code input}' element as 'checked' if the supplied Boolean is
	 * {@code true}.
	 */
	protected void renderFromBoolean(Boolean boundValue, TagWriter tagWriter) throws BeetlTagException {
		tagWriter.writeAttribute("value", processFieldValue(getName(), "true", getInputType()));
		if (boundValue) {
			tagWriter.writeAttribute("checked", "checked");
		}
	}

	/**
	 * Return a unique ID for the bound name within the current Context.
	 */
	@Override
	protected String autogenerateId() throws BeetlTagException {
		return TagIdGenerator.nextId(super.autogenerateId(), this.ctx);
	}


	/**
	 * Writes the '{@code input}' element to the supplied
	 * {@link TagWriter},
	 * marking it as 'checked' if appropriate.
	 */
	@Override
	protected abstract int writeTagContent(TagWriter tagWriter) throws BeetlTagException;

	/**
	 * Flags "type" as an illegal dynamic attribute.
	 */
	@Override
	protected boolean isValidDynamicAttribute(String localName, Object value) {
		return !"type".equals(localName);
	}

	/**
	 * Return the type of the HTML input element to generate:
	 * "checkbox" or "radio".
	 */
	protected abstract String getInputType();

}
