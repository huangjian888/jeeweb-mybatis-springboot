package com.company.manerger.sys.ui.beetl.tag.form;

import org.beetl.core.Context;

abstract class TagIdGenerator {

	private static final String PAGE_CONTEXT_ATTRIBUTE_PREFIX = TagIdGenerator.class.getName() + ".";

	public static String nextId(String name, Context pageContext) {
		String attributeName = PAGE_CONTEXT_ATTRIBUTE_PREFIX + name;
		Integer currentCount = (Integer) pageContext.globalVar.get(attributeName);
		currentCount = (currentCount != null ? currentCount + 1 : 1);
		pageContext.globalVar.put(attributeName, currentCount);
		return (name + currentCount);
	}

}
