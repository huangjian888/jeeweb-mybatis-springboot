package cn.jeeweb.core.query.data;

import cn.jeeweb.core.utils.ComplexPropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

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
 * @param <T>
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *             http://www.cnblogs.com/sandyfog/articles/3679804.html
 *             http://www.cnblogs.com/dirgo/p/5178629.html Filter DEMO
 */
public class QueryPropertyPreFilter implements PropertyPreFilterable {
	private String queryPropertyStr;
	private Set<String> queryPropertys;
	private ComplexPropertyPreFilter complexPropertyPreFilter;

	public QueryPropertyPreFilter() {
		init("");
	}

	public QueryPropertyPreFilter(String queryPropertyStr) {
		init(queryPropertyStr);
	}

	public void init(String queryPropertyStr) {
		this.queryPropertyStr = queryPropertyStr;
		this.queryPropertys = new HashSet<String>();
		if (!StringUtils.isEmpty(this.queryPropertyStr)) {
			this.queryPropertyStr = this.queryPropertyStr.substring(0, this.queryPropertyStr.length() - 1);
			String[] queryPropertys = this.queryPropertyStr.split(",");
			for (String queryProperty : queryPropertys) {
				this.queryPropertys.add(queryProperty);
			}
		}
		if (complexPropertyPreFilter == null) {
			complexPropertyPreFilter = new ComplexPropertyPreFilter();
		}
	}

	@Override
	public SerializeFilter constructFilter(Class<?> clazz) {
		for (String queryProperty : queryPropertys) {
			if (!queryProperty.contains(".")) {
				complexPropertyPreFilter.addIncludeFilter(clazz, queryProperty);
			} else {
				constructSubClass(clazz, queryProperty);
			}
		}
		return complexPropertyPreFilter;
	}

	public void constructSubClass(Class<?> clazz, String queryProperty) {
		String[] querySubPropertys = queryProperty.split("\\.");
		for (String querySubProperty : querySubPropertys) {
			if (clazz == null) {
				continue;
			}
			complexPropertyPreFilter.addIncludeFilter(clazz, querySubProperty);
			Class<?> subClazz = getSubClass(clazz, querySubProperty);
			clazz = subClazz;
		}
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
	public void addQueryProperty(String... properties) {
		for (String item : properties) {
			if (item != null) {
				queryPropertys.add(item);
			}
		}
	}

	@Override
	public void addIncludeFilter(Class<?> clazz, String... properties) {
		complexPropertyPreFilter.addIncludeFilter(clazz, properties);
	}

	@Override
	public void addExcludeFilter(Class<?> clazz, String... properties) {
		complexPropertyPreFilter.addExcludeFilter(clazz, properties);
	}

}
