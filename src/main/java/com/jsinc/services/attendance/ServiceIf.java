package com.jsinc.services.attendance;

import org.springframework.ui.Model;

import com.jsinc.jsincDTO.AttendanceDTO;

// 근태 정보 서비스 인터페이스
public interface ServiceIf {
	public AttendanceDTO execute(AttendanceDTO dto_att); // 출&퇴근 기록을 위한 메소드(매개변수가 AttendanceDTO타입)

	public void list(Model model); // 사원 리스트 받아오기 위한 메소드(Model)
}
