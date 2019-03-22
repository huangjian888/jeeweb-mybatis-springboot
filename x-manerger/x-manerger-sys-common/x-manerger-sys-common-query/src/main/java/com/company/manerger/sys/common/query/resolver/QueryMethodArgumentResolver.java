package com.company.manerger.sys.common.query.resolver;

import com.company.manerger.sys.common.query.annotation.QueryableDefaults;
import com.company.manerger.sys.common.query.data.Pageable;
import com.company.manerger.sys.common.query.data.QueryRequest;
import com.company.manerger.sys.common.query.data.Queryable;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;
import java.util.Map;

/**
 * 请求查询参数字符串及分页/排序参数绑定到Queryable
 *
 * <pre>
 *     查询参数格式如下：
 *     1.1、默认查询字符串
 *         query.realname
 *         query.age=12
 *     1.2、控制器处理方法写法
 *         public void test(Queryable queryable);
 *
 *     2.1、自定义查询字符串
 *         test.realname=zhang
 *         test.age=12
 *     2.2、控制器处理方法写法
 *        public void test(@Qualifier("test") Queryable queryable1, @Qualifier("test") Queryable queryable2);
 *
 *     3.1、禁用查询时分页及排序
 *          public void test(@Query(page = false, sort = false) Queryable queryable);
 */
public class QueryMethodArgumentResolver extends BaseMethodArgumentResolver {

	private static final PageableMethodArgumentResolver DEFAULT_PAGEABLE_RESOLVER = new PageableMethodArgumentResolver();
	private static final String DEFAULT_QUERY_PREFIX = "query";

	private String prefix = DEFAULT_QUERY_PREFIX;

	/**
	 * 设置查询参数前缀
	 *
	 * @param prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * 分页参数解析器
	 */
	private PageableMethodArgumentResolver pageableMethodArgumentResolver = DEFAULT_PAGEABLE_RESOLVER;

	public void setPageableMethodArgumentResolver(PageableMethodArgumentResolver pageableMethodArgumentResolver) {
		this.pageableMethodArgumentResolver = pageableMethodArgumentResolver;
	}

	public boolean supportsParameter(MethodParameter parameter) {
		return Queryable.class.isAssignableFrom(parameter.getParameterType());
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		String queryPrefix = getQueryPrefix(parameter);

		Map<String, String[]> queryeableMap = getPrefixParameterMap(queryPrefix, webRequest, true);

		boolean hasCustomQueryFilter = queryeableMap.size() > 0;

		QueryableDefaults queryDefaults = getQueryableDefaults(parameter);

		boolean needMergeDefault = queryDefaults != null && queryDefaults.merge();

		Queryable queryable = null;
		// 自定义覆盖默认
		if (needMergeDefault || !hasCustomQueryFilter) {
			queryable = getDefaultFromAnnotation(queryDefaults);
		}
		if (queryable == null) {
			queryable = new QueryRequest();
		}
		if (hasCustomQueryFilter) {
			for (String name : queryeableMap.keySet()) {
				String[] mapValues = filterQueryValues(queryeableMap.get(name));

				if (mapValues.length == 1) {
					if (name.endsWith("in") || name.endsWith("between")) {
						queryable.addCondition(name, StringUtils.split(mapValues[0], ","));
					} else {
						queryable.addCondition(name, mapValues[0]);
					}
				} else {
					queryable.addCondition(name, mapValues);
				}
			}
		}

		Pageable pageable = (Pageable) pageableMethodArgumentResolver.resolveArgument(parameter, mavContainer,
				webRequest, binderFactory);
		// 默认分页及排序
		if (queryDefaults == null) {
			queryable.setPageable(pageable);
		}
		// needPage=true 分页及排序
		if (queryDefaults != null && queryDefaults.needPage()) {
			queryable.setPageable(pageable);
		}
		// needPage=false needSort=true 不要分页，但排序
		if (queryDefaults != null && !queryDefaults.needPage() && queryDefaults.needSort()) {
			queryable.addSort(pageable.getSort());
		}
		if (pageable.getSort() != null) {
			queryable.addSort(pageable.getSort());
		}
		return queryable;
	}

	private String[] filterQueryValues(String[] values) {
		List<String> result = Lists.newArrayList(values);
		for (int i = 0; i < result.size(); i++) {
			if (StringUtils.isBlank(result.get(i))) {
				result.remove(i);
			}
		}
		return result.toArray(values);
	}

	private String getQueryPrefix(MethodParameter parameter) {
		Qualifier qualifier = parameter.getParameterAnnotation(Qualifier.class);

		if (qualifier != null) {
			return new StringBuilder(((Qualifier) qualifier).value()).append("_").append(prefix).toString();
		}

		return prefix;
	}

	private QueryableDefaults getQueryableDefaults(MethodParameter parameter) {
		// 首先从参数上找
		QueryableDefaults queryDefaults = parameter.getParameterAnnotation(QueryableDefaults.class);
		// 找不到从方法上找
		if (queryDefaults == null) {
			queryDefaults = parameter.getMethodAnnotation(QueryableDefaults.class);
		}
		return queryDefaults;
	}

	private Queryable getDefaultFromAnnotation(QueryableDefaults queryableDefaults) {

		Queryable queryable = defaultQueryable(queryableDefaults);
		if (queryable != null) {
			return queryable;
		}
		return QueryRequest.newQueryable();
	}

	private Queryable defaultQueryable(QueryableDefaults queryableDefaults) {

		if (queryableDefaults == null) {
			return null;
		}

		Queryable queryable = QueryRequest.newQueryable();
		for (String queryParam : queryableDefaults.value()) {
			String[] queryPair = queryParam.split("=");
			String paramName = queryPair[0];
			String paramValue = queryPair[1];
			if (paramName.endsWith("in") || paramName.endsWith("between")) {
				queryable.addCondition(paramName, StringUtils.split(paramValue, ","));
			} else {
				queryable.addCondition(paramName, paramValue);
			}
		}

		return queryable;
	}

}