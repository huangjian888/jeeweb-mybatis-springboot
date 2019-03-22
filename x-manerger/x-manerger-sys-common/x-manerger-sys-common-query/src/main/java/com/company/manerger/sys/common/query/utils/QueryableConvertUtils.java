
package com.company.manerger.sys.common.query.utils;

import com.company.manerger.sys.common.query.data.Condition;
import com.company.manerger.sys.common.query.data.Condition.Filter;
import com.company.manerger.sys.common.query.data.Condition.Operator;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.exception.QueryException;
import com.company.manerger.sys.common.utils.convert.DateConvertEditor;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@SuppressWarnings({ "unchecked", "rawtypes" })
public final class QueryableConvertUtils {

	private static volatile ConversionService conversionService;

	public static void setConversionService(ConversionService conversionService) {
		QueryableConvertUtils.conversionService = conversionService;
	}

	public static ConversionService getConversionService() {
		if (conversionService == null) {
			synchronized (QueryableConvertUtils.class) {
				if (conversionService == null) {
					try {
						conversionService = new DefaultConversionService();
					} catch (Exception e) {
						throw new QueryException(
								"conversionService is null, " + "query param convert must use conversionService. "
										+ "please see [com.sishuok.es.common.entity.query.utils."
										+ "QueryableConvertUtils#setConversionService]");
					}
				}
			}
		}
		return conversionService;
	}

	/**
	 * @param query
	 *            查询条件
	 * @param entityClass
	 *            实体类型
	 * @param <T>
	 */
	public static <T> void convertQueryValueToEntityValue(final Queryable query, final Class<T> entityClass) {

		if (query.isConverted()) {
			return;
		}

		Condition condition = query.getCondition();
		BeanWrapperImpl beanWrapper = new BeanWrapperImpl(entityClass);
		beanWrapper.setAutoGrowNestedPaths(true);
		beanWrapper.setConversionService(getConversionService());
		beanWrapper.registerCustomEditor(Date.class, new DateConvertEditor());
		if (condition != null) {
			for (Filter filter : condition) {
				convert(beanWrapper, filter);
			}
		}

	}

	
	private static void convert(BeanWrapperImpl beanWrapper, Filter filter) {
		String property = filter.getProperty();

		// 自定义的也不转换
		if (filter.getOperator() == Operator.custom) {
			return;
		}

		// 一元运算符不需要计算
		if (filter.isUnaryFilter()) {
			return;
		}

		Object value = filter.getValue();

		Object newValue = null;
		boolean isCollection = value instanceof Collection;
		boolean isArray = value != null && value.getClass().isArray();
		if (isCollection || isArray) {
			List<Object> list = Lists.newArrayList();
			if (isCollection) {
				list.addAll((Collection) value);
			} else {
				list = Lists.newArrayList(CollectionUtils.arrayToList(value));
			}
			int length = list.size();
			for (int i = 0; i < length; i++) {
				list.set(i, getConvertedValue(beanWrapper, property, list.get(i)));
			}
			newValue = list;
		} else {
			newValue = getConvertedValue(beanWrapper, property, value);
		}
		filter.setValue(newValue);
	}

	private static Object getConvertedValue(final BeanWrapperImpl beanWrapper, final String property,
                                            final Object value) {

		Object newValue;
		try {
			beanWrapper.setPropertyValue(property, value);
			newValue = beanWrapper.getPropertyValue(property);
		} catch (InvalidPropertyException e) {
			newValue = null;
			// throw new InvalidQueryPropertyException(property, e);
		} catch (Exception e) {
			newValue = null;
			// throw new InvalidQueryValueException(property, value, e);
		}

		return newValue;
	}

}
