package cn.jeeweb.core.query.wrapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.entity.Column;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.toolkit.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: EntityWrapper.java
 * @package cn.jeeweb.core.query.wrapper
 * @description: 对象封装操作类，定义T-SQL语法
 * @author: auth_team
 * @date: 2017年7月16日 下午12:08:48
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class EntityWrapper<T> extends Wrapper<T> {
	/**
	 * 占位符
	 */
	private static final String PLACE_HOLDER = "{%s}";
	/**
	 * 数据库表映射实体类
	 */
	protected T entity = null;

	private String tableAlias = "";
	protected Class<T> entityClass;
	private Map<String, String> attrFieldMap;

	public EntityWrapper() {
	}

	public EntityWrapper(Class<T> entityClass) {
		/* 注意，传入查询参数 */
		this.entityClass = entityClass;
		initFieldMap();
	}

	public EntityWrapper(T entity) {
		this.entity = entity;
	}

	public EntityWrapper(T entity, String sqlSelect) {
		this.entity = entity;
		this.sqlSelect = sqlSelect;
	}

	public void initFieldMap() {
		/* 注意，传入查询参数 */
		if (this.entityClass == null) {
			this.entityClass = (Class<T>) getTClass();
			initFieldMap();
		}
		attrFieldMap = new HashMap<String, String>();
		List<Field> allField = getAllFields(entityClass);
		for (Field field : allField) {
			/* 获取注解属性，自定义字段 */
			TableField tableField = field.getAnnotation(TableField.class);
			if (tableField != null) {
				String fieldName = field.getName();
				if (StringUtils.isNotEmpty(tableField.el())) {
					fieldName = tableField.el();
				}
				if (StringUtils.isNotEmpty(tableField.value())) {
					String columnName = tableField.value();
//					if(this.entityClass.getClass() == Log.class.getClass()){
//						if(fieldName.equals("createDate")){
//							columnName = "t."+tableField.value();
//						}
//					}
					attrFieldMap.put(fieldName, columnName);
				}
			} else {
				String fieldName = field.getName();
				String columnName = StringUtils.camelToUnderline(fieldName);
				attrFieldMap.put(fieldName, columnName);
			}
		}
		System.out.println("attrFieldMap:"+ JSON.toJSONString(attrFieldMap));

	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getTableAlias() {
		return tableAlias;
	}

	public void setTableAlias(String tableAlias) {
		this.tableAlias = tableAlias;
	}

	/**
	 * SQL 片段
	 */
	@Override
	public String getSqlSegment() {
		/*
		 * 无条件
		 */
		String sqlWhere = sql.toString();
		if (StringUtils.isEmpty(sqlWhere)) {
			return null;
		}
		/*
		 * //在沒提交的时候不报错 if (!sqlWhere.contains("WHERE")) { sqlWhere =
		 * "WHERE 1=1 " + sqlWhere; }
		 */

		/*
		 * 根据当前实体判断是否需要将WHERE替换成 AND 增加实体不为空但所有属性为空的情况
		 */
		String sqlSegment = isWhere != null ? (isWhere ? sqlWhere : sqlWhere.replaceFirst("WHERE", AND_OR))
				: sqlWhere.replaceFirst("WHERE", AND_OR);

//		System.out.println("----------sqlWhere:"+sqlWhere);
		return sqlSegment;
	}

	private String handleColumn(String column) {
		System.out.println("column:"+column);
		if (attrFieldMap != null && attrFieldMap.containsKey(column)) {
			column = attrFieldMap.get(column);
		}
		// 处理表前缀
		if (column != null && !column.contains(".") && !column.trim().equals("1")) {
			column = tableAlias + column;
		}
		return column;
	}

	/**
	 * <p>
	 * 等同于SQL的"field=value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> eq(boolean condition, String column, Object params) {
		return super.eq(condition, handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field=value"表达式
	 * </p>
	 *
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> eq(String column, Object params) {
		return super.eq(handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field <> value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> ne(boolean condition, String column, Object params) {
		return super.ne(condition, handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field <> value"表达式
	 * </p>
	 *
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> ne(String column, Object params) {
		return super.ne(handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field=value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param params
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Wrapper<T> allEq(boolean condition, Map<String, Object> params) {
		if (condition && MapUtils.isNotEmpty(params)) {
			Iterator iterator = params.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
				Object value = entry.getValue();
				if (StringUtils.checkValNotNull(value)) {
					String column = handleColumn(entry.getKey());
					sql.WHERE(formatSql(String.format("%s = {0}", column, entry.getValue())));
				}

			}

		}
		return this;
	}

	/**
	 * <p>
	 * 等同于SQL的"field=value"表达式
	 * </p>
	 *
	 * @param params
	 * @return
	 */
	public Wrapper<T> allEq(Map<String, Object> params) {
		return allEq(true, params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field>value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> gt(boolean condition, String column, Object params) {
		return super.gt(condition, handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field>value"表达式
	 * </p>
	 *
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> gt(String column, Object params) {
		return super.gt(handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field>=value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> ge(boolean condition, String column, Object params) {
		return super.ge(condition, handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field>=value"表达式
	 * </p>
	 *
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> ge(String column, Object params) {
		return super.ge(handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field<value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> lt(boolean condition, String column, Object params) {
		return super.lt(condition, handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field<value"表达式
	 * </p>
	 *
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> lt(String column, Object params) {
		return super.lt(handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field<=value"表达式
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> le(boolean condition, String column, Object params) {
		return super.le(condition, handleColumn(column), params);
	}

	/**
	 * <p>
	 * 等同于SQL的"field<=value"表达式
	 * </p>
	 *
	 * @param column
	 * @param params
	 * @return
	 */
	public Wrapper<T> le(String column, Object params) {
		return super.le(handleColumn(column), params);
	}

	/**
	 * <p>
	 * LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @return this
	 */
	public Wrapper<T> like(boolean condition, String column, String value) {
		return super.like(condition, handleColumn(column), value);
	}

	/**
	 * <p>
	 * LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @return this
	 */
	public Wrapper<T> like(String column, String value) {
		return super.like(handleColumn(column), value);
	}

	/**
	 * <p>
	 * NOT LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @return this
	 */
	public Wrapper<T> notLike(boolean condition, String column, String value) {
		return super.like(condition, handleColumn(column), value);
	}

	/**
	 * <p>
	 * NOT LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @return this
	 */
	public Wrapper<T> notLike(String column, String value) {
		return super.notLike(handleColumn(column), value);
	}

	/**
	 * <p>
	 * LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @param type
	 * @return this
	 */
	public Wrapper<T> like(boolean condition, String column, String value, SqlLike type) {
		return super.like(condition, handleColumn(column), value);
	}

	/**
	 * <p>
	 * LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @param type
	 * @return this
	 */
	public Wrapper<T> like(String column, String value, SqlLike type) {
		return super.like(handleColumn(column), value, type);
	}

	/**
	 * <p>
	 * NOT LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @param type
	 * @return this
	 */
	public Wrapper<T> notLike(boolean condition, String column, String value, SqlLike type) {
		return super.notLike(condition, handleColumn(column), value, type);
	}

	/**
	 * <p>
	 * NOT LIKE条件语句，value中无需前后%
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值
	 * @param type
	 * @return this
	 */
	public Wrapper<T> notLike(String column, String value, SqlLike type) {
		return super.notLike(handleColumn(column), value, type);
	}

	/**
	 * <p>
	 * is not null 条件
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param columns
	 *            字段名称。多个字段以逗号分隔。
	 * @return this
	 */
	public Wrapper<T> isNotNull(boolean condition, String columns) {
		if (columns==null) {
			return super.isNotNull(condition, columns);
		}
		String[] columnArr = columns.split(",");
		String columnNews = "";
		for (String column : columnArr) {
			if (!columnNews.isEmpty()) {
				columnNews += ",";
			}
			columnNews += handleColumn(column);
		}
		return super.isNotNull(condition, columnNews);
	}

	/**
	 * <p>
	 * is not null 条件
	 * </p>
	 *
	 * @param columns
	 *            字段名称。多个字段以逗号分隔。
	 * @return this
	 */
	public Wrapper<T> isNotNull(String columns) {
		return isNotNull(true, columns);
	}

	/**
	 * <p>
	 * is not null 条件
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param columns
	 *            字段名称。多个字段以逗号分隔。
	 * @return this
	 */
	public Wrapper<T> isNull(boolean condition, String columns) {
		String[] columnArr = columns.split(",");
		String columnNews = "";
		for (String column : columnArr) {
			if (!columnNews.isEmpty()) {
				columnNews += ",";
			}
			columnNews += handleColumn(column);
		}
		return super.isNull(condition, columnNews);
	}

	/**
	 * <p>
	 * is not null 条件
	 * </p>
	 *
	 * @param columns
	 *            字段名称。多个字段以逗号分隔。
	 * @return this
	 */
	public Wrapper<T> isNull(String columns) {
		return isNull(true, columns);
	}

	/**
	 * <p>
	 * IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            逗号拼接的字符串
	 * @return this
	 */
	public Wrapper<T> in(boolean condition, String column, String value) {
		if (condition && StringUtils.isNotEmpty(value)) {
			in(column, StringUtils.splitWorker(value, ",", -1, false));
		}
		return this;
	}

	/**
	 * <p>
	 * IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            逗号拼接的字符串
	 * @return this
	 */
	public Wrapper<T> in(String column, String value) {
		return in(true, column, value);
	}

	/**
	 * <p>
	 * NOT IN条件语句
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            逗号拼接的字符串
	 * @return this
	 */
	public Wrapper<T> notIn(boolean condition, String column, String value) {
		if (condition && StringUtils.isNotEmpty(value)) {
			notIn(column, StringUtils.splitWorker(value, ",", -1, false));
		}
		return this;
	}

	/**
	 * <p>
	 * NOT IN条件语句
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            逗号拼接的字符串
	 * @return this
	 */
	public Wrapper<T> notIn(String column, String value) {
		return notIn(true, column, value);
	}

	/**
	 * <p>
	 * IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 List集合
	 * @return this
	 */
	public Wrapper<T> in(boolean condition, String column, Collection<?> value) {
		if (condition && CollectionUtils.isNotEmpty(value))
			sql.WHERE(formatSql(inExpression(column, value, false), value.toArray()));
		return this;
	}

	/**
	 * <p>
	 * IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 List集合
	 * @return this
	 */
	public Wrapper<T> in(String column, Collection<?> value) {
		return in(true, column, value);
	}

	/**
	 * <p>
	 * NOT IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 List集合
	 * @return this
	 */
	public Wrapper<T> notIn(boolean condition, String column, Collection<?> value) {
		if (condition && CollectionUtils.isNotEmpty(value))
			sql.WHERE(formatSql(inExpression(column, value, true), value.toArray()));
		return this;
	}

	/**
	 * <p>
	 * NOT IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 List集合
	 * @return this
	 */
	public Wrapper<T> notIn(String column, Collection<?> value) {
		return notIn(true, column, value);
	}

	/**
	 * <p>
	 * IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 object数组
	 * @return this
	 */
	public Wrapper<T> in(boolean condition, String column, Object[] value) {
		if (condition && ArrayUtils.isNotEmpty(value))
			sql.WHERE(formatSql(inExpression(column, Arrays.asList(value), false), value));
		return this;
	}

	/**
	 * <p>
	 * IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 object数组
	 * @return this
	 */
	public Wrapper<T> in(String column, Object[] value) {
		return in(true, column, value);
	}

	/**
	 * <p>
	 * NOT IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 object数组
	 * @return this
	 */
	public Wrapper<T> notIn(boolean condition, String column, Object... value) {
		if (condition && ArrayUtils.isNotEmpty(value))
			sql.WHERE(formatSql(inExpression(column, Arrays.asList(value), true), value));
		return this;
	}

	/**
	 * <p>
	 * NOT IN 条件语句，目前适配mysql及oracle
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            匹配值 object数组
	 * @return this
	 */
	public Wrapper<T> notIn(String column, Object... value) {
		return notIn(true, column, value);
	}

	/**
	 * <p>
	 * 获取in表达式
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param value
	 *            集合List
	 * @param isNot
	 *            是否为NOT IN操作
	 */
	private String inExpression(String column, Collection<?> value, boolean isNot) {
		column = handleColumn(column);
		if (StringUtils.isNotEmpty(column) && CollectionUtils.isNotEmpty(value)) {
			StringBuilder inSql = new StringBuilder();
			inSql.append(column);
			if (isNot) {
				inSql.append(" NOT");
			}
			inSql.append(" IN ");
			inSql.append("(");
			int size = value.size();
			for (int i = 0; i < size; i++) {
				inSql.append(String.format(PLACE_HOLDER, i));
				if (i + 1 < size) {
					inSql.append(",");
				}
			}
			inSql.append(")");
			return inSql.toString();
		}
		return null;
	}

	/**
	 * <p>
	 * betwwee 条件语句
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param val1
	 * @param val2
	 * @return this
	 */
	public Wrapper<T> between(boolean condition, String column, Object val1, Object val2) {
		return super.between(condition, handleColumn(column), val1, val2);
	}

	/**
	 * <p>
	 * betwwee 条件语句
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param val1
	 * @param val2
	 * @return this
	 */
	public Wrapper<T> between(String column, Object val1, Object val2) {
		return super.between(handleColumn(column), val1, val2);
	}

	/**
	 * <p>
	 * NOT betwwee 条件语句
	 * </p>
	 *
	 * @param condition
	 *            拼接的前置条件
	 * @param column
	 *            字段名称
	 * @param val1
	 * @param val2
	 * @return this
	 */
	public Wrapper<T> notBetween(boolean condition, String column, Object val1, Object val2) {
		return super.notBetween(condition, handleColumn(column), val1, val2);
	}

	/**
	 * <p>
	 * NOT betwwee 条件语句
	 * </p>
	 *
	 * @param column
	 *            字段名称
	 * @param val1
	 * @param val2
	 * @return this
	 */
	public Wrapper<T> notBetween(String column, Object val1, Object val2) {
		return super.notBetween(handleColumn(column), val1, val2);
	}

	/**
	 * 获取该类的所有属性列表
	 *
	 * @param clazz
	 *            反射类
	 * @return
	 */
	public static List<Field> getAllFields(Class<?> clazz) {
		List<Field> fieldList = ReflectionKit.getFieldList(clazz);
		if (CollectionUtils.isNotEmpty(fieldList)) {
			Iterator<Field> iterator = fieldList.iterator();
			while (iterator.hasNext()) {
				Field field = iterator.next();
				/* 过滤注解非表字段属性 */
				TableField tableField = field.getAnnotation(TableField.class);
				if (tableField != null && !tableField.exist()) {
					iterator.remove();
				}
			}
		}
		return fieldList;
	}

	/**
	 * <p>
	 * 使用对象封装的setsqlselect
	 * </p>
	 *
	 * @param column
	 *            字段
	 * @return
	 */
	public Wrapper<T> setSqlSelect(Column... column) {
		if (ArrayUtils.isNotEmpty(column)) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < column.length; i++) {
				if (column[i] != null) {
					String col = column[i].getColumn();
					String as = column[i].getAs();
					if (StringUtils.isEmpty(col)) {
						continue;
					}
					builder.append(col).append(as);
					if (i < column.length - 1) {
						builder.append(",");
					}
				}
			}
			this.sqlSelect = builder.toString();
		}
		return this;
	}

	// 获取传入的泛型类
	public Class<T> getTClass() {
		@SuppressWarnings("unchecked")
		Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return tClass;
	}

	@Override
	public Wrapper<T> orderBy(boolean condition, String columns) {
		if (columns==null) {
			return super.orderBy(condition, columns);
		}
		String[] columnArr = columns.split(",");
		String columnNews = "";
		for (String column : columnArr) {
			if (!columnNews.isEmpty()) {
				columnNews += ",";
			}
			columnNews += handleColumn(column);
		}
		return super.orderBy(condition, columnNews);
	}

	@Override
	public Wrapper<T> orderBy(boolean condition, String columns, boolean isAsc) {
		if (columns==null) {
			return super.orderBy(condition, columns, isAsc);
		}
		String[] columnArr = columns.split(",");
		String columnNews = "";
		for (String column : columnArr) {
			if (!columnNews.isEmpty()) {
				columnNews += ",";
			}
			columnNews += handleColumn(column);
		}
		return super.orderBy(condition, columnNews, isAsc);
	}

	@Override
	public Wrapper<T> orderBy(String columns) {
		if (columns==null) {
			return super.orderBy(columns);
		}
		String[] columnArr = columns.split(",");
		String columnNews = "";
		for (String column : columnArr) {
			if (!columnNews.isEmpty()) {
				columnNews += ",";
			}
			columnNews += handleColumn(column);
		}
		return super.orderBy(columnNews);
	}
}
