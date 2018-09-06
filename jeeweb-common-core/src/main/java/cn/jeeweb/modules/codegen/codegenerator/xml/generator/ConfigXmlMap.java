package cn.jeeweb.modules.codegen.codegenerator.xml.generator;

import cn.jeeweb.core.mapper.JaxbMapper;
import cn.jeeweb.core.mapper.JsonMapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@XmlRootElement(name = "config")
public class ConfigXmlMap implements Serializable {

	List<GeneratorXmlMap> generatorXmpMapList;

	@XmlElementWrapper(name = "generators")
	@XmlElements({ @XmlElement(name = "generator", type = GeneratorXmlMap.class) })
	public List<GeneratorXmlMap> getGeneratorXmpMapList() {
		return generatorXmpMapList;
	}

	public void setGeneratorXmpMapList(List<GeneratorXmlMap> generatorXmpMapList) {
		this.generatorXmpMapList = generatorXmpMapList;
	}

	public static void main(String[] args) {
		ConfigXmlMap xmlMap = JaxbMapper.fromLocation("template/code_generator.xml", ConfigXmlMap.class);
		System.out.println(JsonMapper.toJsonString(xmlMap));
	}
 
}
