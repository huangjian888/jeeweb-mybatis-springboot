package com.company.manerger.sys.ui.tag.html;

import com.company.manerger.sys.ui.beetl.tag.annotation.BeetlTagName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@BeetlTagName("html.js")
public class JsComponentTag extends AbstractHtmlTag {
	private static final String[] SUPPORT_TYPES = { "JS" };

	@Override
	public String[] getSupportTypes() {
		return SUPPORT_TYPES;
	}

}
