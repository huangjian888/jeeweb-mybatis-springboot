package com.company.manerger.sys.common.query.resolver;

import com.company.manerger.sys.common.query.annotation.FormModel;
import com.company.manerger.sys.common.utils.mapper.MapWapper;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FormModelMethodArgumentResolver implements HandlerMethodArgumentResolver {

	public FormModelMethodArgumentResolver() {
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.hasParameterAnnotation(FormModel.class)) {
			return true;
		}
		return false;
	}

	/**
	 * Resolve the argument from the model or if not found instantiate it with
	 * its default if it is available. The model attribute is then populated
	 * with request values via data binding and optionally validated if
	 * {@code @java.validation.Valid} is present on the argument.
	 * 
	 * @throws BindException
	 *             if data binding and validation result in an error and the
	 *             next method parameter is not of type {@link Errors}.
	 * @throws Exception
	 *             if WebDataBinder initialization fails.
	 */
	public final Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                        NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
		String name = parameter.getParameterAnnotation(FormModel.class).value();

		Object target = (mavContainer.containsAttribute(name)) ? mavContainer.getModel().get(name)
				: createAttribute(name, parameter, binderFactory, request);

		WebDataBinder binder = binderFactory.createBinder(request, target, name);
		target = binder.getTarget();
		if (target != null) {
			bindRequestParameters(mavContainer, binderFactory, binder, request, parameter);

			validateIfApplicable(binder, parameter);
			if (binder.getBindingResult().hasErrors()) {
				if (isBindExceptionRequired(binder, parameter)) {
					throw new BindException(binder.getBindingResult());
				}
			}
		}

		target = binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType());
		mavContainer.addAttribute(name, target);

		return target;
	}

	/**
	 * Extension point to create the model attribute if not found in the model.
	 * The default implementation uses the default constructor.
	 * 
	 * @param attributeName
	 *            the name of the attribute, never {@code null}
	 * @param parameter
	 *            the method parameter
	 * @param binderFactory
	 *            for creating WebDataBinder instance
	 * @param request
	 *            the current request
	 * @return the created model attribute, never {@code null}
	 */
	protected Object createAttribute(String attributeName, MethodParameter parameter,
                                     WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception {

		String value = getRequestValueForAttribute(attributeName, request);

		if (value != null) {
			Object attribute = createAttributeFromRequestValue(value, attributeName, parameter, binderFactory, request);
			if (attribute != null) {
				return attribute;
			}
		}
		Class<?> parameterType = parameter.getParameterType();
		if (parameterType.isArray() || List.class.isAssignableFrom(parameterType)) {
			return ArrayList.class.newInstance();
		}
		if (Set.class.isAssignableFrom(parameterType)) {
			return HashSet.class.newInstance();
		}

		if (MapWapper.class.isAssignableFrom(parameterType)) {
			return MapWapper.class.newInstance();
		}

		return BeanUtils.instantiateClass(parameter.getParameterType());
	}

	/**
	 * Obtain a value from the request that may be used to instantiate the model
	 * attribute through type conversion from String to the target type.
	 * <p>
	 * The default implementation looks for the attribute name to match a URI
	 * variable first and then a request parameter.
	 * 
	 * @param attributeName
	 *            the model attribute name
	 * @param request
	 *            the current request
	 * @return the request value to try to convert or {@code null}
	 */
	protected String getRequestValueForAttribute(String attributeName, NativeWebRequest request) {
		Map<String, String> variables = getUriTemplateVariables(request);
		if (StringUtils.hasText(variables.get(attributeName))) {
			return variables.get(attributeName);
		} else if (StringUtils.hasText(request.getParameter(attributeName))) {
			return request.getParameter(attributeName);
		} else {
			return null;
		}
	}

	protected final Map<String, String> getUriTemplateVariables(NativeWebRequest request) {
		Map<String, String> variables = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
		return (variables != null) ? variables : Collections.<String, String> emptyMap();
	}

	/**
	 * Create a model attribute from a String request value (e.g. URI template
	 * variable, request parameter) using type conversion.
	 * <p>
	 * The default implementation converts only if there a registered
	 * {@link Converter} that can perform the conversion.
	 * 
	 * @param sourceValue
	 *            the source value to create the model attribute from
	 * @param attributeName
	 *            the name of the attribute, never {@code null}
	 * @param parameter
	 *            the method parameter
	 * @param binderFactory
	 *            for creating WebDataBinder instance
	 * @param request
	 *            the current request
	 * @return the created model attribute, or {@code null}
	 * @throws Exception
	 */
	protected Object createAttributeFromRequestValue(String sourceValue, String attributeName,
                                                     MethodParameter parameter, WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception {
		DataBinder binder = binderFactory.createBinder(request, null, attributeName);
		ConversionService conversionService = binder.getConversionService();
		if (conversionService != null) {
			TypeDescriptor source = TypeDescriptor.valueOf(String.class);
			TypeDescriptor target = new TypeDescriptor(parameter);
			if (conversionService.canConvert(source, target)) {
				return binder.convertIfNecessary(sourceValue, parameter.getParameterType(), parameter);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Downcast {@link WebDataBinder} to {@link ServletRequestDataBinder} before
	 * binding.
	 * 
	 * @throws Exception
	 * @see ServletRequestDataBinderFactory
	 */
	protected void bindRequestParameters(ModelAndViewContainer mavContainer, WebDataBinderFactory binderFactory,
                                         WebDataBinder binder, NativeWebRequest request, MethodParameter parameter) throws Exception {

		Class<?> targetType = binder.getTarget().getClass();
		ServletRequest servletRequest = (ServletRequest) request;
		WebDataBinder simpleBinder = binderFactory.createBinder(request, null, null);

		if (Collection.class.isAssignableFrom(targetType)) {// bind collection

			Type type = parameter.getGenericParameterType();
			Class<?> componentType = Object.class;

			Collection target = (Collection) binder.getTarget();

			if (type instanceof ParameterizedType) {
				componentType = (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0];
			}

			if (parameter.getParameterType().isArray()) {
				componentType = parameter.getParameterType().getComponentType();
			}

			for (Object key : servletRequest.getParameterMap().keySet()) {
				String prefixName = getPrefixName((String) key);
				if (isSimpleComponent(prefixName)) { // bind simple type
					Map<String, Object> paramValues = WebUtils.getParametersStartingWith(servletRequest, prefixName);
					for (Object value : paramValues.values()) {
						target.add(simpleBinder.convertIfNecessary(value, componentType));
					}
				} else {

					Object component = BeanUtils.instantiate(componentType);
					WebDataBinder componentBinder = binderFactory.createBinder(request, component, null);
					component = componentBinder.getTarget();

					if (component != null) {
						ServletRequestParameterPropertyValues pvs = new ServletRequestParameterPropertyValues(
								servletRequest, prefixName, "");
						componentBinder.bind(pvs);
						validateIfApplicable(componentBinder, parameter);
						if (componentBinder.getBindingResult().hasErrors()) {
							if (isBindExceptionRequired(componentBinder, parameter)) {
								throw new BindException(componentBinder.getBindingResult());
							}
						}

						target.add(component);
					}
				}
			}
		} else if (MapWapper.class.isAssignableFrom(targetType)) {

			Type type = parameter.getGenericParameterType();
			Class<?> keyType = Object.class;
			Class<?> valueType = Object.class;

			if (type instanceof ParameterizedType) {
				keyType = (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0];
				valueType = (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[1];
			}

			Map target = new HashMap();
			((MapWapper) binder.getTarget()).setInnerMap(target);

			for (Object key : servletRequest.getParameterMap().keySet()) {
				String prefixName = getPrefixName((String) key);

				Object keyValue = simpleBinder.convertIfNecessary(getMapKey(prefixName), keyType);

				if (isSimpleComponent(prefixName)) { // bind simple type
					Map<String, Object> paramValues = WebUtils.getParametersStartingWith(servletRequest, prefixName);

					for (Object value : paramValues.values()) {
						target.put(keyValue, simpleBinder.convertIfNecessary(value, valueType));
					}
				} else {
					Object component = BeanUtils.instantiate(valueType);
					WebDataBinder componentBinder = binderFactory.createBinder(request, component, null);
					component = componentBinder.getTarget();

					if (component != null) {
						ServletRequestParameterPropertyValues pvs = new ServletRequestParameterPropertyValues(
								servletRequest, prefixName, "");
						componentBinder.bind(pvs);

						validateComponent(componentBinder, parameter);

						target.put(keyValue, component);
					}
				}
			}
		} else {// bind model
			ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder;
			servletBinder.bind(servletRequest);
		}
	}

	private Object getMapKey(String prefixName) {
		String key = prefixName;
		if (key.startsWith("['")) {
			key = key.replaceAll("\\[\'", "").replaceAll("\'\\]", "");
		}
		if (key.startsWith("[\"")) {
			key = key.replaceAll("\\[\"", "").replaceAll("\"\\]", "");
		}
		if (key.endsWith(".")) {
			key = key.substring(0, key.length() - 1);
		}
		return key;
	}

	private boolean isSimpleComponent(String prefixName) {
		return !prefixName.endsWith(".");
	}

	private String getPrefixName(String name) {

		int begin = 0;

		int end = name.indexOf("]") + 1;

		if (name.indexOf("].") >= 0) {
			end = end + 1;
		}

		return name.substring(begin, end);
	}

	private String getNewParameterName(String parameterName, String modelPrefixName) {
		int modelPrefixNameLength = modelPrefixName.length();

		if (parameterName.charAt(modelPrefixNameLength) == '.') {
			return parameterName.substring(modelPrefixNameLength + 1);
		}

		if (parameterName.charAt(modelPrefixNameLength) == '[') {
			return parameterName.substring(modelPrefixNameLength);
		}
		throw new IllegalArgumentException(
				"illegal request parameter, can not binding to @FormBean(" + modelPrefixName + ")");
	}

	private boolean isFormModelAttribute(String parameterName, String modelPrefixName) {
		int modelPrefixNameLength = modelPrefixName.length();

		if (parameterName.length() == modelPrefixNameLength) {
			return false;
		}

		if (!parameterName.startsWith(modelPrefixName)) {
			return false;
		}

		char ch = (char) parameterName.charAt(modelPrefixNameLength);

		if (ch == '.' || ch == '[') {
			return true;
		}

		return false;
	}

	protected void validateComponent(WebDataBinder binder, MethodParameter parameter) throws BindException {

		boolean validateParameter = validateParameter(parameter);
		Annotation[] annotations = binder.getTarget().getClass().getAnnotations();
		for (Annotation annot : annotations) {
			if (annot.annotationType().getSimpleName().startsWith("Valid") && validateParameter) {
				Object hints = AnnotationUtils.getValue(annot);
				binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] { hints });
			}
		}

		if (binder.getBindingResult().hasErrors()) {
			if (isBindExceptionRequired(binder, parameter)) {
				throw new BindException(binder.getBindingResult());
			}
		}
	}

	private boolean validateParameter(MethodParameter parameter) {
		Annotation[] annotations = parameter.getParameterAnnotations();
		for (Annotation annot : annotations) {
			if (annot.annotationType().getSimpleName().startsWith("Valid")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Validate the model attribute if applicable.
	 * <p>
	 * The default implementation checks for {@code @javax.validation.Valid}.
	 * 
	 * @param binder
	 *            the DataBinder to be used
	 * @param parameter
	 *            the method parameter
	 */
	protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
		Annotation[] annotations = parameter.getParameterAnnotations();
		for (Annotation annot : annotations) {
			if (annot.annotationType().getSimpleName().startsWith("Valid")) {
				Object hints = AnnotationUtils.getValue(annot);
				binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] { hints });
			}
		}
	}

	/**
	 * Whether to raise a {@link BindException} on bind or validation errors.
	 * The default implementation returns {@code true} if the next method
	 * argument is not of type {@link Errors}.
	 * 
	 * @param binder
	 *            the data binder used to perform data binding
	 * @param parameter
	 *            the method argument
	 */
	protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter parameter) {
		int i = parameter.getParameterIndex();
		Class<?>[] paramTypes = parameter.getMethod().getParameterTypes();
		boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));

		return !hasBindingResult;
	}
}
