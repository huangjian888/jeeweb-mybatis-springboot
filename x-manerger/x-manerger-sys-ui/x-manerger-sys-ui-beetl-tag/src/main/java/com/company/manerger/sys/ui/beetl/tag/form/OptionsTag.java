package com.company.manerger.sys.ui.beetl.tag.form;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.dict.DictUtils;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import com.company.manerger.sys.ui.beetl.tag.support.BindStatus;

@Component
@Scope("prototype")
@BeetlTagName("form.options")
public class OptionsTag extends AbstractHtmlElementTag {

	/**
	 * The {@link java.util.Collection}, {@link java.util.Map} or array of
	 * objects used to generate the inner '{@code option}' tags.
	 */
	private Object items;

	/**
	 * The name of the property mapped to the '{@code value}' attribute
	 * of the '{@code option}' tag.
	 */
	private String itemValue;

	/**
	 * The name of the property mapped to the inner text of the
	 * '{@code option}' tag.
	 */
	private String itemLabel;

	private String dict;

	private boolean disabled;


	/**
	 * Set the {@link java.util.Collection}, {@link java.util.Map} or array
	 * of objects used to generate the inner '{@code option}' tags.
	 * <p>Required when wishing to render '{@code option}' tags from an
	 * array, {@link java.util.Collection} or {@link java.util.Map}.
	 * <p>Typically a runtime expression.
	 */
	public void setItems(Object items) {
		this.items = items;
	}

	/**
	 * Get the {@link java.util.Collection}, {@link java.util.Map} or array
	 * of objects used to generate the inner '{@code option}' tags.
	 * <p>Typically a runtime expression.
	 */
	protected Object getItems() {
		if (!StringUtils.isEmpty(dict)) {
			return DictUtils.getDictList(dict);
		}
		return this.items;
	}
	/**
	 * Set the name of the property mapped to the '{@code value}'
	 * attribute of the '{@code option}' tag.
	 * <p>Required when wishing to render '{@code option}' tags from
	 * an array or {@link java.util.Collection}.
	 */
	public void setItemValue(String itemValue) {
		Assert.hasText(itemValue, "'itemValue' must not be empty");
		this.itemValue = itemValue;
	}

	/**
	 * Get the value of the '{@code itemValue}' attribute.
	 * <p>May be a runtime expression.
	 */
	protected String getItemValue() {
		if (!StringUtils.isEmpty(dict)) {
			return "value";
		}
		return this.itemValue;
	}

	/**
	 * Set the name of the property mapped to the label (inner text) of the
	 * '{@code option}' tag.
	 */
	public void setItemLabel(String itemLabel) {
		Assert.hasText(itemLabel, "'itemLabel' must not be empty");
		this.itemLabel = itemLabel;
	}

	/**
	 * Get the value of the '{@code itemLabel}' attribute.
	 * <p>May be a runtime expression.
	 */
	protected String getItemLabel() {
		if (!StringUtils.isEmpty(dict)) {
			return "label";
		}
		return this.itemLabel;
	}

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
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


	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		SelectTag selectTag = getSelectTag();
		Object items = getItems();
		Object itemsObject = null;
		if (items != null) {
			itemsObject = (items instanceof String ? evaluate("items", items) : items);
		}
		else {
			Class<?> selectTagBoundType = selectTag.getBindStatus().getValueType();
			if (selectTagBoundType != null && selectTagBoundType.isEnum()) {
				itemsObject = selectTagBoundType.getEnumConstants();
			}
		}
		if (itemsObject != null) {
			String selectName = selectTag.getName();
			String itemValue = getItemValue();
			String itemLabel = getItemLabel();
			String valueProperty =
					(itemValue != null ? ObjectUtils.getDisplayString(evaluate("itemValue", itemValue)) : null);
			String labelProperty =
					(itemLabel != null ? ObjectUtils.getDisplayString(evaluate("itemLabel", itemLabel)) : null);
			OptionsWriter optionWriter = new OptionsWriter(selectName, itemsObject, valueProperty, labelProperty);
			optionWriter.writeOptions(tagWriter);
		}
		return SKIP_BODY;
	}

	/**
	 * Appends a counter to a specified id,
	 * since we're dealing with multiple HTML elements.
	 */
	@Override
	protected String resolveId() throws BeetlTagException {
		Object id = evaluate("id", getId());
		if (id != null) {
			String idString = id.toString();
			return (StringUtils.hasText(idString) ? TagIdGenerator.nextId(idString, this.ctx) : null);
		}
		return null;
	}

	private SelectTag getSelectTag() {
		return (SelectTag)this.getParent();
	}

	@Override
	protected BindStatus getBindStatus() {
		return (BindStatus) this.ctx.globalVar.get(SelectTag.LIST_VALUE_PAGE_ATTRIBUTE);
	}


	/**
	 * Inner class that adapts OptionWriter for multiple options to be rendered.
	 */
	private class OptionsWriter extends OptionWriter {

		private final String selectName;

		public OptionsWriter(String selectName, Object optionSource, String valueProperty, String labelProperty) {
			super(optionSource, getBindStatus(), valueProperty, labelProperty, isHtmlEscape());
			this.selectName = selectName;
		}

		@Override
		protected boolean isOptionDisabled() throws BeetlTagException {
			return isDisabled();
		}

		@Override
		protected void writeCommonAttributes(TagWriter tagWriter) throws BeetlTagException {
			writeOptionalAttribute(tagWriter, "id", resolveId());
			writeOptionalAttributes(tagWriter);
		}

		@Override
		protected String processOptionValue(String value) {
			return processFieldValue(this.selectName, value, "option");
		}

	}

}
