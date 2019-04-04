package com.company.manerger.sys.common.query.data;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Condition implements Iterable<Condition.Filter>, Serializable {

	private static final long serialVersionUID = 5737186511678863905L;
	public static final Operator DEFAULT_OPERATOR = Operator.custom;

	private final List<Filter> filters = new ArrayList<Filter>();

	public Condition(Filter... filters) {
		this.filters.addAll(Arrays.asList(filters));
	}

	public Condition(List<Filter> filters) {

		if (null == filters || filters.isEmpty()) {
			throw new IllegalArgumentException("You have to provide at least one condition property to condition by!");
		}
		this.filters.addAll(filters);
	}

	public Condition and(Operator operator, final String property, final Object value) {
		Filter filter = new Filter(operator, property, value);
		filters.add(filter);
		return this;
	}

	public Condition and(Condition condition) {
		if (condition == null) {
			return this;
		}
		for (Filter filter : condition) {
			filters.add(filter);
		}
		return this;
	}

	public void remove(Filter filter) {
		if (filters.contains(filter)) {
			filters.remove(filter);
		}

	}

	public void remove(String property) {

		for (Filter filter : this) {
			if (filter.getProperty().equals(property)) {
				this.remove(filter);
			}
		}
	}

	public Filter getFilterFor(String property) {

		for (Filter filter : this) {
			if (filter.getProperty().equals(property)) {
				return filter;
			}
		}

		return null;
	}

	public Iterator<Filter> iterator() {
		return this.filters.iterator();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Condition)) {
			return false;
		}

		Condition that = (Condition) obj;

		return this.filters.equals(that.filters);
	}

	@Override
	public int hashCode() {

		int result = 17;
		result = 31 * result + filters.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return StringUtils.collectionToCommaDelimitedString(filters);
	}

	public static enum Operator {
		eq("等于", "="), ne("不等于", "!="), gt("大于", ">"), ge("大于等于", ">="), lt("小于", "<"), le("小于等于", "<="), isNull("空",
				"is null"), isNotNull("非空", "is not null"), in("包含", "in"), notIn("不包含", "not in"), between(
						"对应SQL的between子句", "between"), prefixLike("前缀模糊匹配", "like"), prefixNotLike("前缀模糊不匹配",
								"not like"), suffixLike("后缀模糊匹配", "like"), suffixNotLike("后缀模糊不匹配", "not like"), like(
										"模糊匹配", "like"), notLike("不匹配", "not like"), custom("自定义默认的", null);

		private final String info;
		private final String symbol;

		Operator(final String info, String symbol) {
			this.info = info;
			this.symbol = symbol;
		}

		public String getInfo() {
			return info;
		}

		public String getSymbol() {
			return symbol;
		}

		public static Operator fromString(String value) {

			try {
				return Operator.valueOf(value);
			} catch (Exception e) {
				throw new IllegalArgumentException(String.format(
						"Invalid value '%s' for filters given! Has to be either 'desc' or 'asc' (case insensitive).",
						value), e);
			}
		}

		public static Operator fromStringOrNull(String value) {

			try {
				return fromString(value);
			} catch (IllegalArgumentException e) {
				return null;
			}
		}

		public static String toStringAllOperator() {
			return Arrays.toString(Operator.values());
		}

		/**
		 * 操作符是否允许为空
		 *
		 * @param operator
		 * @return
		 */
		public static boolean isAllowBlankValue(final Operator operator) {
			return operator == Operator.isNotNull || operator == Operator.isNull;
		}
	}

	public static class Filter implements Serializable {

		private static final long serialVersionUID = 1522511010900108987L;
		private static final boolean DEFAULT_IGNORE_CASE = false;

		private final Operator operator;
		private final String property;
		private Object value;

		public Filter(String property, Object value) {
			this(DEFAULT_OPERATOR, property, value);
		}

		public Filter(Operator operator, String property, Object value) {

			this(operator, property, value, DEFAULT_IGNORE_CASE);
		}

		private Filter(Operator operator, String property, Object value, boolean ignoreCase) {

			if (!StringUtils.hasText(property)) {
				throw new IllegalArgumentException("Property must not null or empty!");
			}

			this.operator = operator == null ? DEFAULT_OPERATOR : operator;
			this.property = property;
			this.value = value;

		}

		public Operator getOperator() {
			return operator;
		}

		public String getProperty() {
			return property;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Filter with(Operator filter, Object value) {
			return new Filter(filter, this.property, value);
		}

		public Filter ignoreCase() {
			return new Filter(operator, property, true);
		}

		/**
		 * 是否是一元过滤 如is null is not null
		 *
		 * @return
		 */
		public boolean isUnaryFilter() {
			String operatorStr = getOperator().getSymbol();
			return !StringUtils.isEmpty(operatorStr) && operatorStr.startsWith("is");
		}

		@Override
		public int hashCode() {

			int result = 17;

			result = 31 * result + operator.hashCode();
			result = 31 * result + property.hashCode();

			return result;
		}

		@Override
		public boolean equals(Object obj) {

			if (this == obj) {
				return true;
			}

			if (!(obj instanceof Filter)) {
				return false;
			}

			Filter that = (Filter) obj;

			return this.operator.equals(that.operator) && this.property.equals(that.property);
		}

		@Override
		public String toString() {
			return String.format("%s: %s", property, operator);
		}
	}
}
