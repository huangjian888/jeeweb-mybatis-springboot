package com.company.manerger.sys.common.query.data;

import com.alibaba.fastjson.serializer.SerializeFilter;

/**
 * 
 * @title: PropertyPreFilterable.java
 * @package com.company.manerger.sys.common.query.data
 * @description: JSON格式化输出
 */
public interface PropertyPreFilterable {
	
	public SerializeFilter constructFilter(Class<?> clazz);
	
	public void addQueryProperty(String... properties);
	
	public void addIncludeFilter(Class<?> clazz, String... properties);

	public void addExcludeFilter(Class<?> clazz, String... properties);
}
