package cn.jeeweb.modules.codegen.codegenerator.utils;

import cn.jeeweb.modules.codegen.codegenerator.xml.definition.Sql;

import java.util.HashMap;
import java.util.Map;

public class SqlUtils {

	public static SqlUtils sqlUtils = null;
	private Map<String, Sql> sqlMap = new HashMap<String, Sql>();

	public static SqlUtils getSqlUtils() {
		if (sqlUtils == null) {
			sqlUtils = new SqlUtils();
		}
		return sqlUtils;
	}

	public SqlUtils() {
		for (Sql sql : DefinitionUtils.getDefinitionUtils().getDefinition().getDb().getSql()) {
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
