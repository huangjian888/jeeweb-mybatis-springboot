package cn.jeeweb.core.query.data;

import com.alibaba.fastjson.serializer.SerializeFilter;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: PropertyPreFilterable.java
 * @package cn.jeeweb.core.query.data
 * @description: JSON格式化输出
 * @author: auth_team
 * @date: 2017年5月1日 下午9:43:09
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public interface PropertyPreFilterable {
	
	public SerializeFilter constructFilter(Class<?> clazz);
	
	public void addQueryProperty(String... properties);
	
	public void addIncludeFilter(Class<?> clazz, String... properties);

	public void addExcludeFilter(Class<?> clazz, String... properties);
}
