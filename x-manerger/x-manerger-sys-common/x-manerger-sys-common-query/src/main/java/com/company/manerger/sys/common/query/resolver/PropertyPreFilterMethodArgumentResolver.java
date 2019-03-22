package com.company.manerger.sys.common.query.resolver;

import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.QueryPropertyPreFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PropertyPreFilterMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private static final String DEFAULT_FILTER = "queryFields";
	private String filterName = DEFAULT_FILTER;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return PropertyPreFilterable.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String propertyPreFilterName = getFilterName(parameter);
		String queryFields = webRequest.getParameter(propertyPreFilterName);
		return new QueryPropertyPreFilter(queryFields);
	}

	/**
	 * Resolves the prefix to use to bind properties from. Will prepend a
	 * possible {@link Qualifier} if available or return the configured prefix
	 * otherwise.
	 *
	 * @param parameter
	 * @return
	 */
	private String getFilterName(MethodParameter parameter) {

		Qualifier qualifier = parameter.getParameterAnnotation(Qualifier.class);

		if (qualifier != null) {
			return new StringBuilder(((Qualifier) qualifier).value()).append("_").append(filterName).toString();
		}

		return filterName;
	}

}
