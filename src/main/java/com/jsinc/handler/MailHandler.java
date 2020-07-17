package com.jsinc.handler;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

// 작성자 : 서해준

public class MailHandler {
	private JavaMailSender sender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	// 메인 핸들러
	public MailHandler(JavaMailSender sender) throws MessagingException {
		this.sender = sender;
		this.message = this.sender.createMimeMessage();
		this.messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	// 보내는 메일 설정
	public void setFrom(String mail, String name) throws UnsupportedEncodingException, MessagingException {
		messageHelper.setFrom(mail, name);
	}

	// 받는 메일 설정
	public void setTo(String mail) throws MessagingException {
		messageHelper.setTo(mail);
	}
	
	// 메일 제목 설정
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}
	
	// 메일 내용 설정
	public void setText(String text) throws MessagingException {
		messageHelper.setText(text, true);
	}
	
	// 메일 보내기
	public void send() {
		try {
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}