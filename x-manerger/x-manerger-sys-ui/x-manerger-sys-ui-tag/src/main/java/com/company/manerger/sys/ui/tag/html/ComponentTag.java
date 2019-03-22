package com.company.manerger.sys.ui.tag.html;


public class ComponentTag extends AbstractHtmlTag {
	private static final String[] SUPPORT_TYPES = { "CSS", "JS" };

	@Override
	public String[] getSupportTypes() {
		return SUPPORT_TYPES;
	}

}
