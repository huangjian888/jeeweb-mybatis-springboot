package cn.jeeweb.modules.codegen.codegenerator.utils.type;

import cn.jeeweb.modules.codegen.codegenerator.xml.definition.Type;

import java.util.List;

public interface ITypeConvert {
	public Type getType(String type);

	public List<Type> getTypes();

	public List<String> getJavaTypes();

	public List<String> getFullTypes();

	public List<String> getDbTypes();
}
