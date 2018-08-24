package cn.jeeweb.modules.sys.utils;

import cn.jeeweb.core.database.dynamic.dao.DynamicDBDao;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.modules.sys.entity.DataSource;
import cn.jeeweb.modules.sys.service.IDataSourceService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: DynamicDBUtils.java
 * @package cn.jeeweb.modules.sys.utils
 * @description: 多数据源操作工具 List<Map<String, Object>> list =
 *               DynamicDBUtils.getDynamicDBDao("neiwangbaogong") .queryList(
 *               "SELECT * from t_s_type");
 * @author: auth_team
 * @date: 2017年5月10日 下午1:18:12
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class DynamicDBUtils {
	private static IDataSourceService dataSourceService = SpringContextHolder.getBean(IDataSourceService.class);

	public static DynamicDBDao getDynamicDBDao(String dbKey) {
		DynamicDBDao dynamicDBDao = new DynamicDBDao();
		DataSource dataSource = dataSourceService.selectOne(new EntityWrapper<DataSource>().eq("dbKey", dbKey));
		if (dataSource == null) {
			return null;
		}
		dynamicDBDao.initJdbcTemplate(getDataSource(dataSource));
		return dynamicDBDao;
	}

	private static BasicDataSource getDataSource(DataSource dataSourceEntity) {
		BasicDataSource dataSource = new BasicDataSource();
		String driverClassName = dataSourceEntity.getDriverClass();
		String url = StringEscapeUtils.unescapeHtml4(dataSourceEntity.getUrl());
		String dbUser = dataSourceEntity.getDbUser();
		String dbPassword = dataSourceEntity.getDbPassword();

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
}
