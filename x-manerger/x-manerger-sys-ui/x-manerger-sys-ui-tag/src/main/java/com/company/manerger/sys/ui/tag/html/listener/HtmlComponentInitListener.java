package com.company.manerger.sys.ui.tag.html.listener;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.company.manerger.sys.ui.tag.html.manager.HtmlComponentManager;

public class HtmlComponentInitListener implements ApplicationListener<ContextRefreshedEvent> {
	protected HtmlComponentManager htmlComponentManager = SpringContextHolder.getApplicationContext()
			.getBean(HtmlComponentManager.class);
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			htmlComponentManager.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}