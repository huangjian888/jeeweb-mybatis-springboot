package com.company.manerger.sys.common.query.resolver;

import com.company.manerger.sys.common.query.annotation.RequestJsonParam;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.company.manerger.sys.common.utils.mapper.JsonMapper;
import com.company.manerger.sys.common.utils.mapper.MapWapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

import javax.servlet.ServletException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 解析请求参数json字符串
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RequestJsonParamMethodArgumentResolver extends AbstractNamedValueMethodArgumentResolver
		implements WebArgumentResolver {

	private JsonMapper mapper = new JsonMapper();

	public RequestJsonParamMethodArgumentResolver() {
		super(null);
	}

	public boolean supportsParameter(MethodParameter parameter) {

		if (parameter.hasParameterAnnotation(RequestJsonParam.class)) {
			return true;
		}
		return false;
	}

	@Override
	protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
		RequestJsonParam annotation = parameter.getParameterAnnotation(RequestJsonParam.class);
		return new RequestJsonParamNamedValueInfo(annotation);

	}

	@Override
	protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest webRequest) throws Exception {
		String[] paramValues = webRequest.getParameterValues(name);
		Class<?> paramType = parameter.getParameterType();
		if (paramValues == null) {
			return null;
		}

		try {
			if (paramValues.length == 1) {
				String text = StringEscapeUtils.unescapeHtml4(paramValues[0]);
				Type type = parameter.getGenericParameterType();

				if (MapWapper.class.isAssignableFrom(paramType)) {
					MapWapper<?, ?> jsonMap = (MapWapper<?, ?>) paramType.newInstance();

					MapType mapType = (MapType) getJavaType(HashMap.class);

					if (type instanceof ParameterizedType) {
						mapType = (MapType) mapType
								.withKeyType((JavaType)((ParameterizedType) type).getActualTypeArguments()[0]);
						mapType = (MapType) mapType
								.withContentType((JavaType) ((ParameterizedType) type).getActualTypeArguments()[1]);
					}
					jsonMap.setInnerMap(mapper.<Map> readValue(text, mapType));
					return jsonMap;
				}

				JavaType javaType = getJavaType(paramType);

				if (Collection.class.isAssignableFrom(paramType)) {
					javaType = javaType
							.withContentType((JavaType)((ParameterizedType) type).getActualTypeArguments()[0]);
				}
				return mapper.readValue(text, javaType);
			}
		} catch (Exception e) {
			throw new JsonMappingException("Could not read request json parameter", e);
		}
		throw new UnsupportedOperationException("too many request json parameter '" + name
				+ "' for method parameter type [" + paramType + "], only support one json parameter");
	}

	protected JavaType getJavaType(Class<?> clazz) {
		return TypeFactory.defaultInstance().constructType(clazz);
	}

	@Override
	protected void handleMissingValue(String paramName, MethodParameter parameter) throws ServletException {
		String paramType = parameter.getParameterType().getName();
		throw new ServletRequestBindingException(
				"Missing request json parameter '" + paramName + "' for method parameter type [" + paramType + "]");
	}

	private class RequestJsonParamNamedValueInfo extends NamedValueInfo {

		private RequestJsonParamNamedValueInfo() {
			super("", false, null);
		}

		private RequestJsonParamNamedValueInfo(RequestJsonParam annotation) {
			super(annotation.value(), annotation.required(), null);
		}
	}

	/**
	 * spring 3.1之前
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, NativeWebRequest request) throws Exception {
		if (!supportsParameter(parameter)) {
			return WebArgumentResolver.UNRESOLVED;
		}
		return resolveArgument(parameter, null, request, null);
	}
}