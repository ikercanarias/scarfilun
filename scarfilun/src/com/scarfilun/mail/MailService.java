package com.scarfilun.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailService {
	
	private MailSender mailSender;
	private String from;
	private String to;
	
	private String subject;
	private String text;
	
	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String sendMail() {
		 
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(this.from);
		message.setTo(this.to);
		message.setSubject(this.subject);
		message.setText(this.text);
		mailSender.send(message);
		
		return "mail_sent";
	}
}
