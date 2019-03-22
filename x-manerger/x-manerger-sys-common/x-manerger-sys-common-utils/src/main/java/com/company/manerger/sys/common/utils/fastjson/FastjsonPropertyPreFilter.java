package com.company.manerger.sys.common.utils.fastjson;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class  FastjsonPropertyPreFilter extends ComplexPropertyPreFilter{

	public FastjsonPropertyPreFilter(){

	}
	public FastjsonPropertyPreFilter(Class<?> clazz,String includesProperties) {
		addIncludeFilter(clazz,includesProperties);
	}

	public FastjsonPropertyPreFilter(Map<Class<?>, Set<String>> includes) {
		super(includes);
	}


	public Class<?> getSubClass(Class<?> clazz, String fieldname) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			Class<?> type = field.getType();
			if (fieldname.equals(name)) {
				return type;
			}
		}
		return null;
	}

	@Override
	public void addIncludeFilter(Class<?> clazz, String... properties) {
		for (String property:properties) {
			property =property.trim();
			if (!StringUtils.isEmpty(property)) {
				String[] propertieArr = property.split(",");
				for (String singleProperty : propertieArr) {
					singleProperty=singleProperty.trim();
					if (StringUtils.isEmpty(singleProperty)){
						continue;
					}
					if (!StringUtils.isEmpty(singleProperty)) {
						addSingleIncludeFilter(clazz,singleProperty);
					}
				}
			}
		}
	}

	private void addSingleIncludeFilter(Class<?> clazz,String property){
		if (!property.contains(".")) {
			 super.addIncludeFilter(clazz, property);
		} else {
			String[] subPropertes = property.split("\\.");
			for (String subProperty : subPropertes) {
				if (clazz == null) {
					continue;
				}
				super.addIncludeFilter(clazz, subProperty);
				Class<?> subClazz = getSubClass(clazz, subProperty);
				clazz = subClazz;
			}
		}
	}

	@Override
	public void addExcludeFilter(Class<?> clazz, String... properties) {
		for (String property:properties) {
			property =property.trim();
			if (!StringUtils.isEmpty(property)) {
				String[] propertieArr = property.split(",");
				for (String singleProperty : propertieArr) {
					singleProperty=singleProperty.trim();
					if (StringUtils.isEmpty(singleProperty)){
						continue;
					}
					if (!StringUtils.isEmpty(singleProperty)) {
						addSingleExcludeFilter(clazz,singleProperty);
					}
				}
			}
		}
	}

	private void addSingleExcludeFilter(Class<?> clazz,String property){
		if (!property.contains(".")) {
			super.addExcludeFilter(clazz, property);
		} else {
			String[] subPropertes = property.split("\\.");
			for (String subProperty : subPropertes) {
				if (clazz == null) {
					continue;
				}
				super.addExcludeFilter(clazz, subProperty);
				Class<?> subClazz = getSubClass(clazz, subProperty);
				clazz = subClazz;
			}
		}
	}

}
