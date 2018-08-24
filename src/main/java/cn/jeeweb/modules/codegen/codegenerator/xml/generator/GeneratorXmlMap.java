package cn.jeeweb.modules.codegen.codegenerator.xml.generator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@SuppressWarnings("serial")
@XmlType(name = "generator")
public class GeneratorXmlMap implements Serializable {
	private String key = "";// 注册关键字
	private String layer = "";// 文件层
	private String templateFile = ""; // 模版名称
	private int codeType = 1; // 是否JSP,1.JAVA,2.页面代码
	private String nameFormat = ""; // 命名格式

	@XmlElement(name = "layer")
	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	@XmlElement(name = "template-file")
	public String getTemplateFile() {
		return templateFile;
	}

	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}

	@XmlElement(name = "code-type")
	public int getCodeType() {
		return codeType;
	}

	public void setCodeType(int codeType) {
		this.codeType = codeType;
	}

	@XmlElement(name = "name-format")
	public String getNameFormat() {
		return nameFormat;
	}

	public void setNameFormat(String nameFormat) {
		this.nameFormat = nameFormat;
	}

	@XmlElement(name = "key")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
