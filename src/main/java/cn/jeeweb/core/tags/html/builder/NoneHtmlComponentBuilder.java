package cn.jeeweb.core.tags.html.builder;

import java.io.IOException;
import java.util.Map;

import com.google.common.collect.Maps;

public class NoneHtmlComponentBuilder implements HtmlComponentBuilder {

	@Override
	public Map<String, String> getJsComponents() {
		return Maps.newHashMap();
	}

	@Override
	public Map<String, String> getCssComponents() {
		return Maps.newHashMap();
	}

	@Override
	public void init() throws IOException {

	}

	@Override
	public Map<String, String> getFragmentComponents() {
		return Maps.newHashMap();
	}

}
