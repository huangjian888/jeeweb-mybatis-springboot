package com.company.manerger.sys.common.email.disruptor;

import com.company.manerger.sys.common.email.data.EmailResult;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;

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
		disruptor = new Disruptor<EmailEvent>(factory, bufferSize, executor, ProducerType.SINGLE,
				new BlockingWaitStrategy());
		List<EmailHandler> emailHandlers = new ArrayList<>();
		for (int i = 0; i < handlerCount; i++) {
			emailHandlers.add(new EmailHandler(emailDao));
		}
		disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
		// 多个消费者，每个消费者竞争消费不同数据
		disruptor.handleEventsWithWorkerPool(emailHandlers.toArray(new EmailHandler[emailHandlers.size()]));
		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<EmailEvent> ringBuffer = disruptor.getRingBuffer();
		emailEventProducer = new EmailEventProducer(ringBuffer, emailDao);
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

	public String sendAsync(String eventId, MimeMessage message, MailProperties mailProperties) {
		return emailEventProducer.send(eventId,message,mailProperties);
	}

	public String sendAsync(String eventId,MimeMessage message, MailProperties mailProperties,EmailHandlerCallBack callBack) {
		return emailEventProducer.send(eventId,message,mailProperties,callBack);
	}


	public EmailResult sendSync(String eventId, MimeMessage message, MailProperties mailProperties) {
		// 异步的时候发送短信日志
		EmailData emailData = new EmailData();
		emailData.setMimeMessage(message);
		emailData.setMailProperties(mailProperties);
		// 写入数据
		EmailEvent emailEvent = new EmailEvent();
		emailEvent.setId(eventId);
		emailEvent.setEmailData(emailData);
		EmailResult emailResult = EmailResult.success("发送成功");
		try {
			MailSenderFactory.build(mailProperties).send(message);
		} catch (Exception e) {
			e.printStackTrace();
			emailResult = EmailResult.fail("发送失败");
		}
		if (emailDao != null) {
			emailDao.doResult(eventId, emailData, emailResult);
		}
		return emailResult;
	}

	public MimeMessage createMimeMessage(MailProperties mailProperties){
		JavaMailSender javaMailSender = MailSenderFactory.build(mailProperties);
		return javaMailSender.createMimeMessage();
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