package com.company.manerger.sys.ui.tag.html.builder;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @description: 组建构造器具
 *
 */
public interface HtmlComponentBuilder {
	/**
	 * JSMap
	 * 
	 * @return
	 */
	public Map<String, String> getJsComponents();

	/**
	 * css语句map
	 * 
	 * @return
	 */
	public Map<String, String> getCssComponents();
	
	/**
	 * html语句map
	 * 
	 * @return
	 */
	public Map<String, String> getFragmentComponents();

	/**
	 * 初始化
	 * 
	 * @throws IOException
	 */
	public void init() throws IOException;
}