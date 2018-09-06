package cn.jeeweb.core.query.parse;

import cn.jeeweb.core.query.data.Condition;
import cn.jeeweb.core.query.data.Condition.Filter;
import cn.jeeweb.core.query.data.Condition.Operator;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.utils.ObjectUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

public class QueryToWrapper<T> {

	public void parseCondition(Wrapper<T> wrapper, Queryable queryable) {
		Condition condition = queryable.getCondition();
		if (condition != null) {
			for (Filter filter : condition) {
				Object value = filter.getValue();
				if (!ObjectUtils.isNullOrEmpty(value)) {
					// 可以使用反射快速绑定
					Operator operator = filter.getOperator();
					String property = filter.getProperty();
					if (operator == Operator.custom) {
						continue;
					} else if (operator == Operator.isNull) {
						wrapper.isNull(property);
					} else if (operator == Operator.isNotNull) {
						wrapper.isNotNull(property);
					} else if (operator == Operator.between) {
						Object[] between = null;
						if (value instanceof List) {
							between = ((List<?>) value).toArray(new Object[((List<?>) value).size()]);
						} else {
							between = (Object[]) value;
						}
						if (between.length == 2) {
							wrapper.between(property, between[0], between[1]);
						}
					} else if (operator.name().toUpperCase(Locale.US).contains("LIKE")) {
						value = parseLike(filter);
						if (operator.name().contains("NOT")) {
							wrapper.notLike(filter.getProperty(), (String) value);

						} else {
							wrapper.like(filter.getProperty(), (String) value);
						}
					} else {
						//wrapper.eq(filter.getProperty(),  value);
						invokeWrapper(wrapper, filter);
					}
				}
			}
		}

	}

	public Object parseLike(Filter filter) {
		String operatorStr = filter.getOperator().name().toUpperCase(Locale.US);
		Object value = filter.getValue();
		if (operatorStr.contains("PREFIX")) {
			value = "%" + value;
		} else if (operatorStr.contains("SUFFIX")) {
			value = value + "%";
		} else {
			value = "%" + value + "%";
		}
		return value;
	}

	/**
	 * 
	 * 
	 * @param filter
	 * @return
	 */
	public void invokeWrapper(Wrapper<T> wrapper, Filter filter) {
		try {
			Method method = wrapper.getClass().getMethod(filter.getOperator().name(), String.class,
					Object.class);
			method.invoke(wrapper, filter.getProperty(), filter.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseSort(Wrapper<T> wrapper, Queryable queryable) {
		cn.jeeweb.core.query.data.Sort sort = queryable.getPageable().getSort();
		if (sort != null) {
			for (cn.jeeweb.core.query.data.Sort.Order order : sort) {
				if (order.getDirection() == cn.jeeweb.core.query.data.Sort.Direction.DESC) {
					wrapper.orderBy(order.getProperty(), false);
				} else if (order.getDirection() == cn.jeeweb.core.query.data.Sort.Direction.ASC) {
					wrapper.orderBy(order.getProperty(), true);
				}
			}
		}
	}

}
