package com.company.manerger.sys.ui.beetl.tag.form;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import com.company.manerger.sys.ui.beetl.tag.dict.DictUtils;
import com.company.manerger.sys.ui.beetl.tag.exception.BeetlTagException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public abstract class AbstractMultiCheckedElementTag extends AbstractCheckedElementTag {

	/**
	 * The HTML '{@code span}' tag.
	 */
	private static final String SPAN_TAG = "span";


	/**
	 * The {@link Collection}, {@link Map} or array of objects
	 * used to generate the '{@code input type="checkbox/radio"}' tags.
	 */
	private Object items;

	/**
	 * The name of the property mapped to the '{@code value}' attribute
	 * of the '{@code input type="checkbox/radio"}' tag.
	 */
	private String itemValue;

	/**
	 * The value to be displayed as part of the '{@code input type="checkbox/radio"}' tag.
	 */
	private String itemLabel;

	/**
	 * The HTML element used to enclose the '{@code input type="checkbox/radio"}' tag.
	 */
	private String element = SPAN_TAG;

	/**
	 * Delimiter to use between each '{@code input type="checkbox/radio"}' tags.
	 */
	private String delimiter;

	private String dict = "";// 绑定数据字典类型，数据字典优先

	public String getDict() {
		return dict;
	}

	public void setDict(String dict) {
		this.dict = dict;
	}

	/**
	 * Set the {@link Collection}, {@link Map} or array of objects
	 * used to generate the '{@code input type="checkbox/radio"}' tags.
	 * <p>Typically a runtime expression.
	 * @param items said items
	 */
	public void setItems(Object items) {
		Assert.notNull(items, "'items' must not be null");
		this.items = items;
	}

	/**
	 * Get the {@link Collection}, {@link Map} or array of objects
	 * used to generate the '{@code input type="checkbox/radio"}' tags.
	 */
	protected Object getItems() {
		if (!StringUtils.isEmpty(dict)) {
			return DictUtils.getDictList(dict);
		}
		return this.items;
	}

	/**
	 * Set the name of the property mapped to the '{@code value}' attribute
	 * of the '{@code input type="checkbox/radio"}' tag.
	 * <p>May be a runtime expression.
	 */
	public void setItemValue(String itemValue) {
		Assert.hasText(itemValue, "'itemValue' must not be empty");
		this.itemValue = itemValue;
	}

	/**
	 * Get the name of the property mapped to the '{@code value}' attribute
	 * of the '{@code input type="checkbox/radio"}' tag.
	 */
	protected String getItemValue() {
		if (!StringUtils.isEmpty(dict)) {
			return "value";
		}
		return this.itemValue;
	}

	/**
	 * Set the value to be displayed as part of the
	 * '{@code input type="checkbox/radio"}' tag.
	 * <p>May be a runtime expression.
	 */
	public void setItemLabel(String itemLabel) {
		Assert.hasText(itemLabel, "'itemLabel' must not be empty");
		this.itemLabel = itemLabel;
	}

	/**
	 * Get the value to be displayed as part of the
	 * '{@code input type="checkbox/radio"}' tag.
	 */
	protected String getItemLabel() {
		if (!StringUtils.isEmpty(dict)) {
			return "label";
		}
		return this.itemLabel;
	}

	/**
	 * Set the delimiter to be used between each
	 * '{@code input type="checkbox/radio"}' tag.
	 * <p>By default, there is <em>no</em> delimiter.
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Return the delimiter to be used between each
	 * '{@code input type="radio"}' tag.
	 */
	public String getDelimiter() {
		return this.delimiter;
	}

	/**
	 * Set the HTML element used to enclose the
	 * '{@code input type="checkbox/radio"}' tag.
	 * <p>Defaults to an HTML '{@code <span/>}' tag.
	 */
	public void setElement(String element) {
		Assert.hasText(element, "'element' cannot be null or blank");
		this.element = element;
	}

	/**
	 * Get the HTML element used to enclose
	 * '{@code input type="checkbox/radio"}' tag.
	 */
	public String getElement() {
		return this.element;
	}


	/**
	 * Appends a counter to a specified id as well,
	 * since we're dealing with multiple HTML elements.
	 */
	@Override
	protected String resolveId() throws BeetlTagException {
		Object id = evaluate("id", getId());
		if (id != null) {
			String idString = id.toString();
			return (StringUtils.hasText(idString) ? com.company.manerger.sys.ui.beetl.tag.form.TagIdGenerator.nextId(idString, this.ctx) : null);
		}
		return autogenerateId();
	}

	/**
	 * Renders the '{@code input type="radio"}' element with the configured
	 * {@link #setItems(Object)} values. Marks the element as checked if the
	 * value matches the bound value.
	 */
	@Override
	@SuppressWarnings("rawtypes")
	protected int writeTagContent(TagWriter tagWriter) throws BeetlTagException {
		Object items = getItems();
		Object itemsObject = (items instanceof String ? evaluate("items", items) : items);

		String itemValue = getItemValue();
		String itemLabel = getItemLabel();
		String valueProperty =
				(itemValue != null ? ObjectUtils.getDisplayString(evaluate("itemValue", itemValue)) : null);
		String labelProperty =
				(itemLabel != null ? ObjectUtils.getDisplayString(evaluate("itemLabel", itemLabel)) : null);

		Class<?> boundType = getBindStatus().getValueType();
		if (itemsObject == null && boundType != null && boundType.isEnum()) {
			itemsObject = boundType.getEnumConstants();
		}

		if (itemsObject == null) {
			throw new IllegalArgumentException("Attribute 'items' is required and must be a Collection, an Array or a Map");
		}

		if (itemsObject.getClass().isArray()) {
			Object[] itemsArray = (Object[]) itemsObject;
			for (int i = 0; i < itemsArray.length; i++) {
				Object item = itemsArray[i];
				writeObjectEntry(tagWriter, valueProperty, labelProperty, item, i);
			}
		}
		else if (itemsObject instanceof Collection) {
			final Collection<?> optionCollection = (Collection<?>) itemsObject;
			int itemIndex = 0;
			for (Iterator<?> it = optionCollection.iterator(); it.hasNext(); itemIndex++) {
				Object item = it.next();
				writeObjectEntry(tagWriter, valueProperty, labelProperty, item, itemIndex);
			}
		}
		else if (itemsObject instanceof Map) {
			final Map<?, ?> optionMap = (Map<?, ?>) itemsObject;
			int itemIndex = 0;
			for (Iterator it = optionMap.entrySet().iterator(); it.hasNext(); itemIndex++) {
				Map.Entry entry = (Map.Entry) it.next();
				writeMapEntry(tagWriter, valueProperty, labelProperty, entry, itemIndex);
			}
		}
		else {
			throw new IllegalArgumentException("Attribute 'items' must be an array, a Collection or a Map");
		}

		return SKIP_BODY;
	}

	private void writeObjectEntry(TagWriter tagWriter, String valueProperty,
                                  String labelProperty, Object item, int itemIndex) throws BeetlTagException {

		BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(item);
		Object renderValue;
		if (valueProperty != null) {
			renderValue = wrapper.getPropertyValue(valueProperty);
		}
		else if (item instanceof Enum) {
			renderValue = ((Enum<?>) item).name();
		}
		else {
			renderValue = item;
		}
		Object renderLabel = (labelProperty != null ? wrapper.getPropertyValue(labelProperty) : item);
		writeElementTag(tagWriter, item, renderValue, renderLabel, itemIndex);
	}

	private void writeMapEntry(TagWriter tagWriter, String valueProperty,
                               String labelProperty, Map.Entry<?, ?> entry, int itemIndex) throws BeetlTagException {

		Object mapKey = entry.getKey();
		Object mapValue = entry.getValue();
		BeanWrapper mapKeyWrapper = PropertyAccessorFactory.forBeanPropertyAccess(mapKey);
		BeanWrapper mapValueWrapper = PropertyAccessorFactory.forBeanPropertyAccess(mapValue);
		Object renderValue = (valueProperty != null ?
				mapKeyWrapper.getPropertyValue(valueProperty) : mapKey.toString());
		Object renderLabel = (labelProperty != null ?
				mapValueWrapper.getPropertyValue(labelProperty) : mapValue.toString());
		writeElementTag(tagWriter, mapKey, renderValue, renderLabel, itemIndex);
	}

	private void writeElementTag(TagWriter tagWriter, Object item, Object value, Object label, int itemIndex)
			throws BeetlTagException {

		tagWriter.startTag(getElement());
		if (itemIndex > 0) {
			Object resolvedDelimiter = evaluate("delimiter", getDelimiter());
			if (resolvedDelimiter != null) {
				tagWriter.appendValue(resolvedDelimiter.toString());
			}
		}
		tagWriter.startTag("input");
		String id = resolveId();
		writeOptionalAttribute(tagWriter, "id", id);
		writeOptionalAttribute(tagWriter, "name", getName());
		writeOptionalAttributes(tagWriter);
		tagWriter.writeAttribute("type", getInputType());
		renderFromValue(item, value, tagWriter);
		tagWriter.endTag();
		tagWriter.startTag("label");
		tagWriter.writeAttribute("for", id);
		tagWriter.appendValue(convertToDisplayString(label));
		tagWriter.endTag();
		tagWriter.endTag();
	}

}
