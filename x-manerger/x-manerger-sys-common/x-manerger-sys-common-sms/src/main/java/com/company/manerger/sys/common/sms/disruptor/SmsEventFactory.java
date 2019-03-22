package com.company.manerger.sys.common.sms.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @description: 定义事件工厂
 *
 */
public class SmsEventFactory implements EventFactory<SmsEvent> {
	public SmsEvent newInstance() {
		return new SmsEvent();
	}
}