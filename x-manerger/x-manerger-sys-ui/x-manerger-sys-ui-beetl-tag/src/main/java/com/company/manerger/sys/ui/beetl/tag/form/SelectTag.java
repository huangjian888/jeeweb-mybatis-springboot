package com.company.manerger.sys.ui.beetl.tag.form;

import java.util.Collection;
import java.util.Map;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import com.company.manerger.sys.ui.beetl.tag.dict.DictUtils;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import com.company.manerger.sys.ui.beetl.tag.support.BindStatus;

@Component
@Scope("prototype")
@BeetlTagName("form.select")
public class SelectTag extends AbstractHtmlInputElementTag {

	/**
	 * The {@link org.beetl.core.Context} attribute under
	 * which the bound value is exposed to inner {@link com.company.manerger.sys.ui.beetl.tag.form.OptionTag OptionTags}.
	 */
	public static final String LIST_VALUE_PAGE_ATTRIBUTE =
			"SelectTag.listValue";

	/**
	 * Marker object for items that have been specified but resolve to null.
	 * Allows to differentiate between 'set but null' and 'not set at all'.
	 */
	private static final Object EMPTY = new Object();


	/**
	 * The {@link Collection}, {@link Map} or array of objects used to generate the inner
	 * '{@code option}' tags.
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

	/**
	 * The value of the HTML '{@code size}' attribute rendered
	 * on the final '{@code select}' element.
	 */
	private String size;

	/**
	 * Indicates whether or not the '{@code select}' tag allows
	 * multiple-selections.
	 */
	private Object multiple;

	/**
	 * The {@link TagWriter} instance that the output is being written.
	 * <p>Only used in conjunction with nested {@link com.company.manerger.sys.ui.beetl.tag.form.OptionTag OptionTags}.
	 */
	private TagWriter tagWriter;


	/**
	 * Set the {@link Collection}, {@link Map} or array of objects used to
	 * generate the inner '{@code option}' tags.
	 * <p>Required when wishing to render '{@code option}' tags from
	 * an array, {@link Collection} or {@link Map}.
	 * <p>Typically a runtime expression.
	 * @param items the items that comprise the options of this selection
	 */
	public void setItems(Object items) {
		this.items = (items != null ? items : EMPTY);
	}

	/**
	 * Get the value of the '{@code items}' attribute.
	 * <p>May be a runtime expression.
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
	 * an array or {@link Collection}.
	 * <p>May be a runtime expression.
	 */
	public void setItemValue(String itemValue) {
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

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	/**
	 * Set the name of the property mapped to the label (inner text) of the
	 * '{@code option}' tag.
	 * <p>May be a runtime expression.
	 */
	public void setItemLabel(String itemLabel) {
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

	/**
	 * Set the value of the HTML '{@code size}' attribute rendered
	 * on the final '{@code select}' element.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Get the value of the '{@code size}' attribute.
	 */
	protected String getSize() {
		return this.size;
	}

	/**
	 * Set the value of the HTML '{@code multiple}' attribute rendered
	 * on the final '{@code select}' element.
	 */
	public void setMultiple(Object multiple) {
		this.multiple = multiple;
	}

	/**
	 * Get the value of the HTML '{@code multiple}' attribute rendered
	 * on the final '{@code select}' element.
	 */
	protected Object getMultiple() {
		return this.multiple;
	}


	/**
	 * Renders the HTML '{@code select}' tag to the supplied
	 * {@link TagWriter}.
	 * <p>Renders nested '{@code option}' tags if the
	 * {@link #setItems items} property is set, otherwise exposes the
	 * bound value for the nested {@link com.company.manerger.sys.ui.beetl.tag.form.OptionTag OptionTags}.
	 */
	@Override
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		tagWriter.startTag("select");
		writeDefaultAttributes(tagWriter);
		if (isMultiple()) {
			tagWriter.writeAttribute("multiple", "multiple");
		}
		tagWriter.writeOptionalAttributeValue("size", getDisplayString(evaluate("size", getSize())));

		Object items = getItems();
		if (items != null) {
			// Items specified, but might still be empty...
			if (items != EMPTY) {
				Object itemsObject = evaluate("items", items);
				if (itemsObject != null) {
					final String selectName = getName();
					String valueProperty = (getItemValue() != null ?
							ObjectUtils.getDisplayString(evaluate("itemValue", getItemValue())) : null);
					String labelProperty = (getItemLabel() != null ?
							ObjectUtils.getDisplayString(evaluate("itemLabel", getItemLabel())) : null);
					OptionWriter optionWriter =
							new OptionWriter(itemsObject, getBindStatus(), valueProperty, labelProperty, isHtmlEscape()) {
								@Override
								protected String processOptionValue(String resolvedValue) {
									return processFieldValue(selectName, resolvedValue, "option");
								}
							};
					optionWriter.writeOptions(tagWriter);
				}
			}
			tagWriter.endTag(true);
			writeHiddenTagIfNecessary(tagWriter);
			return 1;
		}
		else {
			tagWriter.forceBlock();
			this.tagWriter = tagWriter;
			this.ctx.globalVar.put(LIST_VALUE_PAGE_ATTRIBUTE, getBindStatus());
			return 1;
		}
	}

	private void writeHiddenTagIfNecessary(TagWriter tagWriter) throws BeetlTagException {
		if (isMultiple()) {
			tagWriter.startTag("input");
			tagWriter.writeAttribute("type", "hidden");
			String name = WebDataBinder.DEFAULT_FIELD_MARKER_PREFIX + getName();
			tagWriter.writeAttribute("name", name);
			tagWriter.writeAttribute("value", processFieldValue(name, "1", "hidden"));
			tagWriter.endTag();
		}
	}

	private boolean isMultiple() throws BeetlTagException {
		Object multiple = getMultiple();
		if (multiple != null) {
			String stringValue = multiple.toString();
			return ("multiple".equalsIgnoreCase(stringValue) || Boolean.parseBoolean(stringValue));
		}
		return forceMultiple();
	}

	private boolean forceMultiple() throws BeetlTagException {
		BindStatus bindStatus = getBindStatus();
		Class<?> valueType = bindStatus.getValueType();
		if (valueType != null && typeRequiresMultiple(valueType)) {
			return true;
		}
		else if (bindStatus.getEditor() != null) {
			Object editorValue = bindStatus.getEditor().getValue();
			if (editorValue != null && typeRequiresMultiple(editorValue.getClass())) {
				return true;
			}
		}
		return false;
	}

	private static boolean typeRequiresMultiple(Class<?> type) {
		return (type.isArray() || Collection.class.isAssignableFrom(type) || Map.class.isAssignableFrom(type));
	}

	@Override
	protected int doStartTag() throws BeetlTagException {
		this.ctx.globalVar.put(PARENT_VARIABLE_NAME,this);
		return super.doStartTag();
	}

	/**
	 * Closes any block tag that might have been opened when using
	 * nested {@link com.company.manerger.sys.ui.beetl.tag.form.OptionTag options}.
	 */
	@Override
	public int doEndTag() throws BeetlTagException {
		this.ctx.globalVar.remove(PARENT_VARIABLE_NAME);
		if (this.tagWriter != null) {
			this.tagWriter.endTag();
			writeHiddenTagIfNecessary(this.tagWriter);
		}
		return EVAL_PAGE;
	}

	/**
	 * Clears the {@link TagWriter} that might have been left over when using
	 * nested {@link OptionTag options}.
	 */
	@Override
	public void doFinally() {
		super.doFinally();
		this.tagWriter = null;
		this.ctx.globalVar.remove(LIST_VALUE_PAGE_ATTRIBUTE);
	}

}
