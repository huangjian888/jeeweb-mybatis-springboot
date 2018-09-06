package cn.jeeweb.core.database.dynamic.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: DynamicDBDao.java
 * @package cn.jeeweb.core.database.dynamic.dao
 * @description: 多数据源到层
 * @author: auth_team
 * @date: 2017年5月10日 上午11:41:13
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class DynamicDBDao {

	private JdbcTemplate jdbcTemplate;

	public DynamicDBDao() {

	}

	public DynamicDBDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * @title: getJdbcTemplate
	 * @description:不滿足方便获取操作
	 * @return
	 * @return: JdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void initJdbcTemplate(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Map<String, Object>> queryList(String sql, Object... param) {
		List<Map<String, Object>> list;
		if (ArrayUtils.isEmpty(param)) {
			list = jdbcTemplate.queryForList(sql);
		} else {
			list = jdbcTemplate.queryForList(sql, param);
		}
		return list;
	}

	public <T> List<T> queryList(String sql, Class<T> clazz, Object... param) {
		List<T> list;

		if (ArrayUtils.isEmpty(param)) {
			list = jdbcTemplate.queryForList(sql, clazz);
		} else {
			list = jdbcTemplate.queryForList(sql, clazz, param);
		}
		return list;
	}
}
