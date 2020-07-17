package com.jsinc.services.main;

import java.util.Map;

// 작성자 : 서해준

// 메일 전송 서비스 인터페이스
public interface MailService {
	public Map<String, Object> send(String email, String title, String body);
}
