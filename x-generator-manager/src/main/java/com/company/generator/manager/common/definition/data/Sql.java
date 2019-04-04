package com.company.generator.manager.common.definition.data;

import javax.xml.bind.annotation.XmlElement;

public class Sql {
	private String id; // 主键
	private String description; // 描述
	private String content; // SQL

	@XmlElement(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}