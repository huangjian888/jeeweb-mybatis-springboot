package cn.jeeweb.core.disruptor.sms;

import cn.jeeweb.core.disruptor.sms.SmsEvent.SmsHandlerCallBack;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.sms.data.SmsResult;
import cn.jeeweb.core.utils.sms.data.SmsTemplate;
import cn.jeeweb.core.utils.sms.sender.SmsSender;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SmsHelper {
	private int handlerCount = 1;
	private int bufferSize = 1024;
	private Disruptor<SmsEvent> disruptor;
	private SmsEventProducer smsEventProducer;
	private SmsSender smsSender = null;
	private SmsDao smsDao = null;

	public SmsHelper() {

	}

	public SmsHelper(int handlerCount, int bufferSize, SmsSender smsSender) {
		this.handlerCount = handlerCount;
		this.bufferSize = bufferSize;
		this.smsSender = smsSender;
	}

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void start() {
		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();

		// The factory for the event
		SmsEventFactory factory = new SmsEventFactory();

		// Specify the size of the ring buffer, must be power of 2.

		// Construct the Disruptor
		// 单线程模式，获取额外的性能
		disruptor = new Disruptor<SmsEvent>(factory, bufferSize, executor);
		List<SmsHandler> smsHandlers = new ArrayList<SmsHandler>();
		for (int i = 0; i < handlerCount; i++) {
			smsHandlers.add(new SmsHandler(smsSender, smsDao));
		}
		// 多个消费者，每个消费者竞争消费不同数据
		disruptor.handleEventsWithWorkerPool(smsHandlers.toArray(new SmsHandler[smsHandlers.size()]));
		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<SmsEvent> ringBuffer = disruptor.getRingBuffer();
		smsEventProducer = new SmsEventProducer(ringBuffer, smsDao);

		if (smsDao != null) {
			smsDao.doStart();
		}
	}

	/**
	 * 停止
	 */
	public void shutdown() {
		doHalt();
		if (smsDao != null) {
			smsDao.doShutdown();
		}
	}

	private void doHalt() {
		disruptor.halt();
	}

	public void sendAsyncSms(String phone, SmsTemplate smsTemplate, String... datas) {
		smsEventProducer.sendSms(phone, smsTemplate, datas);
	}

	public void sendAsyncSms(String phone, SmsTemplate smsTemplate, SmsHandlerCallBack callBack, String... datas) {
		smsEventProducer.sendSms(phone, smsTemplate, callBack, datas);
	}


	public SmsResult sendSyncSms(String phone, SmsTemplate smsTemplate, String... datas) {
		// 异步的时候发送短信日志
		String eventId = StringUtils.randomUUID();
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		// 写入数据
		SmsEvent smsEvent = new SmsEvent();
		smsEvent.setId(eventId);
		smsEvent.setSmsData(smsData);
		if (smsDao != null) {
			smsDao.doSend(eventId, smsData);
		}
		SmsResult smsResult = smsSender.send(phone, smsTemplate, datas);
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

	public SmsSender getSmsSender() {
		return smsSender;
	}

	public void setSmsSender(SmsSender smsSender) {
		this.smsSender = smsSender;
	}

	public SmsDao getSmsDao() {
		return smsDao;
	}

	public void setSmsDao(SmsDao smsDao) {
		this.smsDao = smsDao;
	}

}
