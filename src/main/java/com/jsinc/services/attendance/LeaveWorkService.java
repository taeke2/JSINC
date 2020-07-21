package com.jsinc.services.attendance;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.AttendanceDAO;
import com.jsinc.jsincDTO.AttendanceDTO;

// 퇴근 시간 기록과 DB저장 서비스
@Service
public class LeaveWorkService implements ServiceIf {
	// 출&퇴근 시간 DB에 저장하는 dao 생성
	@Autowired
	private AttendanceDAO dao;

	// by성택_퇴근시간 기록 및 출&퇴근시간 DB저장_20200528
	@Override
	public AttendanceDTO execute(AttendanceDTO dto_att) {
		// 퇴근 시간 생성
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd ");
		SimpleDateFormat time = new SimpleDateFormat(":mm:ss");
		String end = format.format(date) + date.getHours() + time.format(date);
		dto_att.setLeaveWork(end); // 퇴근 시간 저장
		dto_att.setWorkTime(Double.parseDouble(String.format("%.1f", this.workTime(dto_att)))); // 당일 근무 시간 저장
		dao.input(dto_att); // DB에 기록 저장
		return dto_att;
	}

	// by성택_당일 근무 시간 계산 메소드_20200528
	public double workTime(AttendanceDTO dto) {
		String[] start = dto.getGoWork().substring(11, dto.getGoWork().length()).split(":"); // 시:분:초 를 나눠서 저장
		String[] end = dto.getLeaveWork().substring(11, dto.getLeaveWork().length()).split(":");

		double time = 0; // 근무 시간
		int cnt = 60 * 60; // 초로 변환하기 위한 카운트
		for (int i = 0; i < 3; i++) {
			time += (Integer.parseInt(end[i]) - Integer.parseInt(start[i])) * cnt; // 초 단위로 변환 후 더함
			cnt /= 60;
		}
		return time / (60 * 60); // time(초)를 시간(h)으로 변환 후 return
	}

	// 사용 안함
	@Override
	public void list(Model model) {

	}
}
