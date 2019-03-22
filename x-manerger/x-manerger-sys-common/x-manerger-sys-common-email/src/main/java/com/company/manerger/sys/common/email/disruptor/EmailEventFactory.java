package com.company.manerger.sys.common.email.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @description: 定义事件工厂
 */
public class EmailEventFactory implements EventFactory<EmailEvent> {
	public EmailEvent newInstance() {
		return new EmailEvent();
	}
}