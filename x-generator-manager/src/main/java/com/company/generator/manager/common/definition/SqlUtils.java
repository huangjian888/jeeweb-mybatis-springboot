package com.company.generator.manager.common.definition;


import com.company.generator.manager.common.definition.data.Sql;

import java.util.HashMap;
import java.util.Map;

public class SqlUtils {

	public static Map<String,SqlUtils> sqlUtilsMap=new HashMap<String,SqlUtils>();
	private Map<String, Sql> sqlMap = new HashMap<String, Sql>();

	public static SqlUtils getSqlUtils(String dbType) {
		if(sqlUtilsMap.containsKey(dbType)){
			return sqlUtilsMap.get(dbType);
		}else{
			SqlUtils sqlUtils = new SqlUtils(dbType);
			sqlUtilsMap.put(dbType,sqlUtils);
			return sqlUtils;
		}
	}

	public SqlUtils(String dbType) {
		for (Sql sql : DefinitionUtils.getDefinitionUtils().getDefinition(dbType).getDb().getSql()) {
			sqlMap.put(sql.getId(), sql);
		}
	}

	public Sql getSqlByID(String sqlId) {
		return sqlMap.get(sqlId);
	}

	public String getSqlContent(String sqlId, Map<String, Object> data) {
		Sql sql = sqlMap.get(sqlId);
		String content = sql.getContent();
		for (String key : data.keySet()) {
			content = content.replaceAll("\\$\\{".concat(key).concat("\\}"), data.get(key).toString());
		}
		return content;
	}

}
