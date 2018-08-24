package cn.jeeweb.core.disruptor.sms;

import cn.jeeweb.core.disruptor.sms.SmsEvent.SmsHandlerCallBack;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.sms.data.SmsTemplate;
import com.lmax.disruptor.RingBuffer;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: LongEventProducer.java
 * @package cn.jeeweb.core.disruptor.sms
 * @description: 内容生产者
 * @author: auth_team
 * @date: 2017年6月7日 下午11:19:15
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class SmsEventProducer {
	private final RingBuffer<SmsEvent> ringBuffer;
	private SmsDao smsDao;

	public SmsEventProducer(RingBuffer<SmsEvent> ringBuffer, SmsDao smsDao) {
		this.ringBuffer = ringBuffer;
		this.smsDao = smsDao;
	}

	private void sendSms(SmsData smsData, SmsHandlerCallBack callBack) {
		// 获取下一个序号
		long sequence = ringBuffer.next();
		String eventId = StringUtils.randomUUID();
		try {
			// 写入数据
			SmsEvent smsEvent = ringBuffer.get(sequence);
			smsEvent.setId(eventId);
			smsEvent.setSmsData(smsData);
			smsEvent.setHandlerCallBack(callBack);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 通知消费者该资源可以消费了
			ringBuffer.publish(sequence);
		}
		if (smsDao != null) {
			smsDao.doSend(eventId, smsData);
		}
	}

	private void sendSms(SmsData smsData) {
		sendSms(smsData, null);
	}

	public void sendSms(String phone, SmsTemplate smsTemplate, String... datas) {
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		sendSms(smsData);
	}

	public void sendSms(String phone, SmsTemplate smsTemplate, SmsHandlerCallBack callBack, String... datas) {
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		sendSms(smsData, callBack);
	}
}