package com.company.manerger.sys.ui.tag.form.support;

import com.company.manerger.sys.common.utils.ObjectUtils;
import com.company.manerger.sys.common.utils.Reflections;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.beetl.core.Context;
import org.springframework.core.env.Environment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerFormTagHelper {
	protected Map<String, Object> staticAttributes = new HashMap<String, Object>();

	public static FreemarkerFormTagHelper getFormHelper() {
		return new FreemarkerFormTagHelper();
	}

	public static Map<String, Object> getTagStatic(Object tag, Context pageContext) {
		return new FreemarkerFormTagHelper().initFreeMarkerMap(tag, pageContext);
	}

	public Map<String, Object> initFreeMarkerMap(Object tag, Context pageContext) {
		Map<String, Object> rootMap = new HashMap<>();
		String ctx = (String)pageContext.globalVar.get("ctxPath");
		Environment env = SpringContextHolder.getBean(Environment.class);
		String adminPath = ctx + "";
		String staticPath = ctx + "/static";
		if (env != null){
			staticPath = env.getProperty("company.staticPath");
			adminPath = env.getProperty("company.admin.url.prefix");
		}
		rootMap.put("ctx", ctx);
		rootMap.put("adminPath", adminPath);
		rootMap.put("staticPath", staticPath);
		initStaticAttribute(tag);
		rootMap.putAll(staticAttributes);
		return rootMap;
	}

	public void initStaticAttribute(Object tag) {
		Field[] field = tag.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			Field field2 = field[j];
			if (ObjectUtils.isBaseDataType(field2.getType())) {
				String name = field[j].getName(); // 获取属性的名字
				setStaticAttribute(name, Reflections.invokeGetter(tag, name));
			}
		}
	}

	// 设置静态属性
	public void setStaticAttribute(String localName, Object value) {
		if (this.staticAttributes == null) {
			this.staticAttributes = new HashMap<String, Object>();
		}
		if (!ObjectUtils.isNullOrEmpty(value)) {
			staticAttributes.put(localName, value);
		}
	}
}
