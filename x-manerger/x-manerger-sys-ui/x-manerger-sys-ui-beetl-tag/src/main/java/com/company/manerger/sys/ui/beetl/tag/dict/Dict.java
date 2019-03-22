package com.company.manerger.sys.ui.beetl.tag.dict;

import java.io.Serializable;

public class Dict implements Serializable {

	/** 键值名称 */
	private String label;
	/** 值 */
	private String value;

	public Dict() {
	}

	public Dict(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
