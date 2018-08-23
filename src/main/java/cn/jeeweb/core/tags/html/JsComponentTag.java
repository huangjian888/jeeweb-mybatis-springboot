package cn.jeeweb.core.tags.html;

@SuppressWarnings("serial")
public class JsComponentTag extends AbstractHtmlTag {
	private static final String[] SUPPORT_TYPES = { "JS" };

	@Override
	public String[] getSupportTypes() {
		return SUPPORT_TYPES;
	}

}
