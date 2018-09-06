package cn.jeeweb.core.tags.html;

@SuppressWarnings("serial")
public class ComponentTag extends AbstractHtmlTag {
	private static final String[] SUPPORT_TYPES = { "CSS", "JS" };

	@Override
	public String[] getSupportTypes() {
		return SUPPORT_TYPES;
	}

}
