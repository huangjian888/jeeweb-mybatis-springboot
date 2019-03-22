package com.company.generator.manager.common.definition.type;


import com.company.generator.manager.common.definition.data.Type;

import java.util.List;

public interface ITypeConvert {
	public Type getType(String type);

	public List<Type> getTypes();

	public List<String> getJavaTypes();

	public List<String> getFullTypes();

	public List<String> getDbTypes();
}
