package com.jsinc.services.attendance;

import org.springframework.ui.Model;

import com.jsinc.jsincDTO.AttendanceDTO;

// 작성자 : 허성택

// 근태 정보 서비스 인터페이스
public interface ServiceIf {
	public AttendanceDTO execute(AttendanceDTO dto_att);
	public void list(Model model);
}
