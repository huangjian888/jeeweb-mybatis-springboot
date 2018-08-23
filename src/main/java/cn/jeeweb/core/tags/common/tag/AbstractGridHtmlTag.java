package cn.jeeweb.core.tags.common.tag;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;
import cn.jeeweb.core.utils.ObjectUtils;
import cn.jeeweb.core.utils.Reflections;

/**
 * 动态属性标签处理类 实现：DynamicAttributes接口 http://liqita.iteye.com/blog/1678363
 * http://blog.csdn.net/danny1991/article/details/50638981
 * http://z-jianwen.iteye.com/blog/1073301
 */
@SuppressWarnings("serial")
public abstract class AbstractGridHtmlTag extends BodyTagSupport implements DynamicAttributes {
	protected Map<String, Object> dynamicAttributes;
	protected Map<String, Object> staticAttributes;

	@Override
	public int doStartTag() throws JspException {
		if (dynamicAttributes != null) {
			dynamicAttributes.clear();
		}
		if (staticAttributes != null) {
			staticAttributes.clear();
		}
		Field[] field = getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			Field field2 = field[j];
			if (ObjectUtils.isBaseDataType(field2.getType())) {
				String name = field[j].getName(); // 获取属性的名字
				setStaticAttribute(name, Reflections.invokeGetter(this, name));
			}
		}
		return super.doStartTag();
	}

	// 设置动态属性
	@Override
	public void setDynamicAttribute(String url, String localName, Object value) throws JspException {
		if (this.dynamicAttributes == null) {
			this.dynamicAttributes = new HashMap<String, Object>();
		}
		dynamicAttributes.put(localName, value);
	}

	// 设置静态属性
	public void setStaticAttribute(String localName, Object value) throws JspException {
		if (this.staticAttributes == null) {
			this.staticAttributes = new HashMap<String, Object>();
		}
		if (!ObjectUtils.isNullOrEmpty(value)) {
			staticAttributes.put(localName, value);
		}
	}

	protected void putCheckValue(Map<String, Object> dataMap, String key, Object value) {
		if (!ObjectUtils.isNullOrEmpty(value)) {
			dataMap.put(key, value);
		}
	}

	public Map<String, Object> getDynamicAttributes() {
		return dynamicAttributes;
	}

	public Map<String, Object> getStaticAttributes() {
		return staticAttributes;
	}

}