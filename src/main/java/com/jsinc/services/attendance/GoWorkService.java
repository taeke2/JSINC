package com.jsinc.services.attendance;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.AttendanceDTO;

@Service
public class GoWorkService implements ServiceIf{

	@Override
	public AttendanceDTO execute(AttendanceDTO dto_att) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd ");
		SimpleDateFormat time = new SimpleDateFormat(":mm:ss");
		String start = format.format(date) + date.getHours() + time.format(date);
		System.out.println("출근 : " + start);
		dto_att.setGoWork(start);
		return dto_att;
	}

	@Override
	public void list(Model model) {
		
	}
}
