package com.company.generator.manager.common.definition.type;

import com.company.generator.manager.common.definition.DefinitionUtils;
import com.company.generator.manager.common.definition.data.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbTypeConvert implements ITypeConvert {
	public final static String TYPE_DB_TO_JAVA = "dbtojava";
	public final static String JAVA_TO_CLASS = "javatoclass";

	public Map<String, Type> typeMap = new HashMap<String, Type>();
	public List<Type> typeList = new ArrayList<Type>();

	public static Map<String, DbTypeConvert> dbTypeConvertMap = new HashMap<String, DbTypeConvert>();

	public static ITypeConvert getTypeConvert(String type,String dbType) {
		if (dbTypeConvertMap.containsKey(type)) {
			return dbTypeConvertMap.get(type);
		} else {
			DbTypeConvert typeConvert = new DbTypeConvert(type,dbType);
			dbTypeConvertMap.put(type, typeConvert);
			return typeConvert;
		}
	}

	public DbTypeConvert(String convertType,String dbType) {
		if (convertType.equals(TYPE_DB_TO_JAVA)) {
			for (Type type : DefinitionUtils.getDefinitionUtils().getDefinition(dbType).getDbtojavaTypes()) {
				typeMap.put(type.getDbType(), type);
				typeList.add(type);
			}
		} else {
			for (Type type : DefinitionUtils.getDefinitionUtils().getDefinition(dbType).getJavatoclassTypes()) {
				typeMap.put(type.getJavaType(), type);
				typeList.add(type);
			}
		}
	}

	@Override
	public Type getType(String type) {
		return typeMap.get(type);
	}

	@Override
	public List<Type> getTypes() {
		return typeList;
	}

	@Override
	public List<String> getJavaTypes() {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Type> m : typeMap.entrySet()) {
			Type type = m.getValue();
			if (!list.contains(type.getJavaType())) {
				list.add(type.getJavaType());
			}
		}
		return list;
	}

	@Override
	public List<String> getFullTypes() {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Type> m : typeMap.entrySet()) {
			Type type = m.getValue();
			if (!list.contains(type.getFullType())) {
				list.add(type.getFullType());
			}
		}
		return list;
	}

	@Override
	public List<String> getDbTypes() {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Type> m : typeMap.entrySet()) {
			Type type = m.getValue();
			if (!list.contains(type.getDbType())) {
				list.add(type.getDbType());
			}
		}
		return list;
	}

}
