package com.company.generator.manager.common.definition;

import com.company.generator.manager.common.definition.data.Definition;

import java.util.List;

public class DefinitionUtils {
	public static DefinitionUtils definitionUtils = null;

	public static DefinitionUtils getDefinitionUtils() {
		if (definitionUtils == null) {
			definitionUtils = new DefinitionUtils();
		}
		return definitionUtils;
	}

	public Definition getDefinition(String dbType) {
		if (DefinitionBuilder.getDefinitionBuilder().getDefinitionMap().containsKey(dbType)){
			return DefinitionBuilder.getDefinitionBuilder().getDefinitionMap().get(dbType);
		}
		return null;
	}

	public List<Definition> getDefinitionList() {
		return  DefinitionBuilder.getDefinitionBuilder().getDefinitionList();
	}
}
