package cn.jeeweb.core.disruptor.sms;

import com.lmax.disruptor.EventFactory;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: LongEventFactory.java
 * @package cn.jeeweb.core.disruptor.sms
 * @description: 定义事件工厂
 * @author: auth_team
 * @date: 2017年6月7日 下午11:18:32
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class SmsEventFactory implements EventFactory<SmsEvent> {
	public SmsEvent newInstance() {
		return new SmsEvent();
	}
}