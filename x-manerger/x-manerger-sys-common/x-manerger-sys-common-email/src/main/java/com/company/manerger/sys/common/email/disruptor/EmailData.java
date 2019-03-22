package com.company.manerger.sys.common.email.disruptor;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;

public class EmailData implements Serializable {

	private MimeMessage message;
	private MailProperties mailProperties;

	public MimeMessage getMimeMessage() {
		return message;
	}

	public void setMimeMessage(MimeMessage message) {
		this.message = message;
	}

	public MailProperties getMailProperties() {
		return mailProperties;
	}

	public void setMailProperties(MailProperties mailProperties) {
		this.mailProperties = mailProperties;
	}
}
