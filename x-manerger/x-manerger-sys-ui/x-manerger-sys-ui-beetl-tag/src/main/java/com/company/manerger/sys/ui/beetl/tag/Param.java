package com.company.manerger.sys.ui.beetl.tag;

import org.springframework.lang.Nullable;


public class Param {

	@Nullable
	private String name;

	@Nullable
	private String value;


	/**
	 * Set the raw name of the parameter.
	 */
	public void setName(@Nullable String name) {
		this.name = name;
	}

	/**
	 * Return the raw parameter name.
	 */
	@Nullable
	public String getName() {
		return this.name;
	}

	/**
	 * Set the raw value of the parameter.
	 */
	public void setValue(@Nullable String value) {
		this.value = value;
	}

	/**
	 * Return the raw parameter value.
	 */
	@Nullable
	public String getValue() {
		return this.value;
	}


	@Override
	public String toString() {
		return "JSP Tag Param: name '" + this.name + "', value '" + this.value + "'";
	}

}
