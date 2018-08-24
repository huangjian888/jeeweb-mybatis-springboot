package cn.jeeweb.core.disruptor.email;

import cn.jeeweb.core.disruptor.email.EmailEvent.EmailHandlerCallBack;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.email.Email;
import cn.jeeweb.core.utils.email.EmailResult;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EmailHelper {
	private int handlerCount = 1;
	private int bufferSize = 1024;
	private Disruptor<EmailEvent> disruptor;
	private EmailEventProducer emailEventProducer;
	private EmailDao emailDao = null;

	public EmailHelper() {

	}

	public EmailHelper(int handlerCount, int bufferSize) {
		this.handlerCount = handlerCount;
		this.bufferSize = bufferSize;
	}

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void start() {
		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();

		// The factory for the event
		EmailEventFactory factory = new EmailEventFactory();

		// Specify the size of the ring buffer, must be power of 2.

		// Construct the Disruptor
		// 单线程模式，获取额外的性能
		disruptor = new Disruptor<EmailEvent>(factory, bufferSize, executor);
		List<EmailHandler> emailHandlers = new ArrayList<EmailHandler>();
		for (int i = 0; i < handlerCount; i++) {
			emailHandlers.add(new EmailHandler(emailDao));
		}
		// 多个消费者，每个消费者竞争消费不同数据
		disruptor.handleEventsWithWorkerPool(emailHandlers.toArray(new EmailHandler[emailHandlers.size()]));
		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<EmailEvent> ringBuffer = disruptor.getRingBuffer();
		emailEventProducer = new EmailEventProducer(ringBuffer, emailDao);

		if (emailDao != null) {
			emailDao.doStart();
		}
	}

	/**
	 * 停止
	 */
	public void shutdown() {
		doHalt();
		if (emailDao != null) {
			emailDao.doShutdown();
		}
	}

	private void doHalt() {
		disruptor.halt();
	}

	public void sendAsyncEmail(String email, String subject, String content, String... datas) {
		emailEventProducer.sendEmail(email, subject, content, datas);
	}

	public void sendAsyncEmail(String email, String subject, String content, EmailHandlerCallBack callBack,
			String... datas) {
		emailEventProducer.sendEmail(email, subject, content, callBack, datas);
	}

	public EmailResult sendSyncEmail(String email, String subject, String content, String... datas) {
		// 异步的时候发送短信日志
		String eventId = StringUtils.randomUUID();
		EmailData emailData = new EmailData();
		emailData.setEmail(email);
		emailData.setContent(content);
		emailData.setSubject(subject);
		emailData.setDatas(datas);
		// 写入数据
		EmailEvent emailEvent = new EmailEvent();
		emailEvent.setId(eventId);
		emailEvent.setEmailData(emailData);
		if (emailDao != null) {
			emailDao.doSend(eventId, emailData);
		}
		EmailResult emailResult = Email.newEmail().send(email, subject, content);
		if (emailDao != null) {
			emailDao.doResult(eventId, emailData, emailResult);
		}
		return emailResult;
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

	public EmailDao getEmailDao() {
		return emailDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}
	
}
