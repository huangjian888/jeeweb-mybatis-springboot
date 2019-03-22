package com.company.generator.manager.common.xml.generator;


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


 
}
