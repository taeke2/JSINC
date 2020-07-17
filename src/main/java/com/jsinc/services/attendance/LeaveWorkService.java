package com.jsinc.services.attendance;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.AttendanceDAO;
import com.jsinc.jsincDTO.AttendanceDTO;

// 작성자 : 허성택

// 퇴근 시간 기록과 DB 저장 서비스
@Service
public class LeaveWorkService implements ServiceIf {
	@Autowired
	private AttendanceDAO dao;

	@Override
	public AttendanceDTO execute(AttendanceDTO dto_att) {
		// 퇴근 시간 생성
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd ");
		SimpleDateFormat time = new SimpleDateFormat(":mm:ss");
		String end = format.format(date) + date.getHours() + time.format(date);
		System.out.println("퇴근" + end);
		dto_att.setLeaveWork(end);
		dto_att.setWorkTime(Double.parseDouble(String.format("%.1f", this.workTime(dto_att))));
		System.out.println("workTime : " + dto_att.getWorkTime());
		dao.input(dto_att); // DB에 저장
		return dto_att;
	}

	// 당일 근무 시간 계산 메소드
	public double workTime(AttendanceDTO dto) {
		String[] start = dto.getGoWork().substring(11, dto.getGoWork().length()).split(":");
		String[] end = dto.getLeaveWork().substring(11, dto.getLeaveWork().length()).split(":");
		double time = 0;
		int cnt = 60 * 60;
		for (int i = 0; i < 3; i++) {
			time += (Integer.parseInt(end[i]) - Integer.parseInt(start[i])) * cnt;
			cnt /= 60;
		}
		return time / (60 * 60);
	}

	@Override
	public void list(Model model) {

	}

}
