package com.company.manerger.sys.common.mybatis.injector;

import com.baomidou.mybatisplus.entity.TableFieldInfo;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * @description: 自动注入器
 *
 */
public class AutoSqlInjector extends com.baomidou.mybatisplus.mapper.AutoSqlInjector {
	@Override
	public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
                       Class<?> modelClass, TableInfo table) {
		/* 添加一个自定义方法 */
		// deleteAllUser(mapperClass, modelClass, table);
		// 测试 com.baomidou.mybatisplus.test.mysql.MetaObjectHandlerTest
		// deleteLogicById(mapperClass, modelClass, table);
	}

	public void deleteAllUser(Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
		/* 执行 SQL ，动态 SQL 参考类 SqlMethod */
		String sql = "delete from " + table.getTableName();
		/* mapper 接口方法名一致 */
		String method = "deleteAll";
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
		this.addDeleteMappedStatement(mapperClass, method, sqlSource);
	}

	@Override
	protected String sqlSelectColumns(TableInfo table, boolean entityWrapper) {
		StringBuilder columns = new StringBuilder();
		if (null != table.getResultMap()) {
			/*
			 * 存在 resultMap 映射返回
			 */
			if (entityWrapper) {
				columns.append(
						"<choose><when test=\"ew != null and ew.sqlSelect != null\">${ew.sqlSelect}</when><otherwise>");
			}
			columns.append("*");
			if (entityWrapper) {
				columns.append("</otherwise></choose>");
			}
		} else {
			/*
			 * 普通查询
			 */
			if (entityWrapper) {
				columns.append(
						"<choose><when test=\"ew != null and ew.sqlSelect != null\">${ew.sqlSelect}</when><otherwise>");
			}
			List<TableFieldInfo> fieldList = table.getFieldList();
			int _size = 0;
			if (null != fieldList) {
				_size = fieldList.size();
			}

			// 主键处理
			if (StringUtils.isNotEmpty(table.getKeyProperty())) {
				if (table.isKeyRelated()) {
					columns.append(table.getKeyColumn()).append(" AS ").append(sqlWordConvert(table.getKeyProperty()));
				} else {
					columns.append(sqlWordConvert(table.getKeyProperty()));
				}
				if (_size >= 1) {
					// 判断其余字段是否存在
					columns.append(",");
				}
			}

			if (_size >= 1) {
				// 字段处理
				int i = 0;
				Iterator<TableFieldInfo> iterator = fieldList.iterator();
				while (iterator.hasNext()) {
					TableFieldInfo fieldInfo = iterator.next();
					if (StringUtils.isEmpty(fieldInfo.getEl()) || fieldInfo.getEl().equals(fieldInfo.getProperty())) {
						// 匹配转换内容
						String wordConvert = sqlWordConvert(fieldInfo.getProperty());
						if (fieldInfo.getColumn().equals(wordConvert)) {
							columns.append(wordConvert);
						} else {
							// 字段属性不一致
							columns.append(fieldInfo.getColumn());
							columns.append(" AS ").append(wordConvert);
						}
					} else {
						// 匹配转换内容
						String wordConvert = sqlWordConvert(fieldInfo.getProperty());
						if (fieldInfo.getColumn().equals(wordConvert)) {
							columns.append(wordConvert);
						} else {
							// 字段属性不一致
							columns.append(fieldInfo.getColumn());
						}
						columns.append(" AS ").append("\"" + fieldInfo.getEl() + "\"");
					}

					if (i + 1 < _size) {
						columns.append(",");
					}
					i++;
				}
			}
			if (entityWrapper) {
				columns.append("</otherwise></choose>");
			}
		}

		/*
		 * 返回所有查询字段内容
		 */
		return columns.toString();
	}
}
