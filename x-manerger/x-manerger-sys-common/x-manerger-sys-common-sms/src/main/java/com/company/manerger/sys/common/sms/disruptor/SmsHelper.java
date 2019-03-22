package com.company.manerger.sys.common.sms.disruptor;

import com.company.manerger.sys.common.sms.client.ISmsClient;
import com.company.manerger.sys.common.sms.config.SmsConfigProperties;
import com.company.manerger.sys.common.sms.data.SmsResult;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SmsHelper {
	private SmsDao smsDao = null;
	private int handlerCount = 1;
	private int bufferSize = 1024;
	private Disruptor<SmsEvent> disruptor;
	private SmsEventProducer smsEventProducer;
	private ISmsClient smsClient = null;

	public SmsHelper() {

	}

	public SmsHelper(int handlerCount, int bufferSize, ISmsClient smsClient) {
		this.handlerCount = handlerCount;
		this.bufferSize = bufferSize;
		this.smsClient = smsClient;
	}

	public ISmsClient getSmsClient() {
		return smsClient;
	}

	public void setSmsClient(ISmsClient smsClient) {
		this.smsClient = smsClient;
	}

	@PostConstruct
	private void start() {
		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();

		// The factory for the event
		SmsEventFactory factory = new SmsEventFactory();

		// Specify the size of the ring buffer, must be power of 2.

		// Construct the Disruptor
		// 单线程模式，获取额外的性能
		disruptor = new Disruptor<SmsEvent>(factory, bufferSize, executor, ProducerType.SINGLE,
				new BlockingWaitStrategy());
		List<SmsHandler> smsHandlers = new ArrayList<SmsHandler>();
		for (int i = 0; i < handlerCount; i++) {
			smsHandlers.add(new SmsHandler(smsClient, smsDao));
		}
		disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
		// 多个消费者，每个消费者竞争消费不同数据
		disruptor.handleEventsWithWorkerPool(smsHandlers.toArray(new SmsHandler[smsHandlers.size()]));
		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<SmsEvent> ringBuffer = disruptor.getRingBuffer();
		smsEventProducer = new SmsEventProducer(ringBuffer, smsDao);
	}

	/**
	 * 停止
	 */
	public void shutdown() {
		doHalt();
	}

	private void doHalt() {
		disruptor.halt();
	}


	public String sendAsyncSms(String eventId, String phone, String smsTemplate, SmsConfigProperties smsConfigProperties, Map<String, Object> datas) {
		return smsEventProducer.sendSms(eventId,phone, smsTemplate,smsConfigProperties, datas);
	}

	public String sendAsyncSms(String eventId,String phone, String smsTemplate, SmsConfigProperties smsConfigProperties, Map<String, Object> datas, SmsHandlerCallBack callBack) {
		return smsEventProducer.sendSms(eventId,phone, smsTemplate, smsConfigProperties, datas,callBack);
	}


	public SmsResult sendSyncSms(String eventId, String phone, String smsTemplate, SmsConfigProperties smsConfigProperties, Map<String, Object> datas) {
		// 异步的时候发送短信日志
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setSmsConfigProperties(smsConfigProperties);
		smsData.setDatas(datas);
		// 写入数据
		SmsEvent smsEvent = new SmsEvent();
		smsEvent.setId(eventId);
		smsEvent.setSmsData(smsData);
		SmsResult smsResult = smsClient.send(phone, smsTemplate, datas);
		if (smsDao != null) {
			smsDao.doResult(eventId, smsData, smsResult);
		}
       return smsResult;
	}

	public int getHandlerCount() {
		return handlerCount;
	}

	public void setHandlerCount(int handlerCount) {
		this.handlerCount = handlerCount;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public SmsDao getSmsDao() {
		return smsDao;
	}

	public void setSmsDao(SmsDao smsDao) {
		this.smsDao = smsDao;
	}

}
