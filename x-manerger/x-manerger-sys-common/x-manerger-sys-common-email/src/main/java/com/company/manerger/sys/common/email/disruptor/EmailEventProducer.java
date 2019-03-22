package com.company.manerger.sys.common.email.disruptor;

import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import javax.mail.internet.MimeMessage;

/**
 *
 * @description: 内容生产者
 *
 */
public class EmailEventProducer {
	private static Logger logger = LoggerFactory.getLogger(EmailEventProducer.class);
	private final RingBuffer<EmailEvent> ringBuffer;
	private EmailDao emailDao;

	public EmailEventProducer(RingBuffer<EmailEvent> ringBuffer, EmailDao emailDao) {
		this.ringBuffer = ringBuffer;
		this.emailDao = emailDao;
	}

	private String send(String eventId,EmailData emailData, EmailHandlerCallBack callBack) {
		// 获取下一个序号
		long sequence = ringBuffer.next();
		try {
			// 写入数据
			EmailEvent emailEvent = ringBuffer.get(sequence);
			emailEvent.setId(eventId);
			emailEvent.setEmailData(emailData);
			emailEvent.setHandlerCallBack(callBack);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} finally {
			// 通知消费者该资源可以消费了
			ringBuffer.publish(sequence);
		}
		return eventId;
	}

	public String send(String eventId, MimeMessage message, MailProperties mailProperties) {
		return send(eventId,message,mailProperties,null);
	}

	public String send(String eventId, MimeMessage message, MailProperties mailProperties, EmailHandlerCallBack callBack) {
		EmailData emailData = new EmailData();
		emailData.setMailProperties(mailProperties);
		emailData.setMimeMessage(message);
		return send(eventId,emailData, callBack);
	}
}