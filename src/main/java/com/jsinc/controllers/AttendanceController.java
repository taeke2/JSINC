package com.jsinc.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.jsincDTO.AttendanceDTO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.services.attendance.AttendanceListService;
import com.jsinc.services.attendance.GoWorkService;
import com.jsinc.services.attendance.LeaveWorkService;
import com.jsinc.services.attendance.ServiceIf;

// 작성자 : 허성택

@Controller
public class AttendanceController {
	ApplicationContext ac = App.ac;
	AttendanceDTO dto_att = new AttendanceDTO(); // 사원의 출&퇴근 시간 기록을 저장하는 dto
	private ServiceIf service;

	// 출/퇴근 페이지
	@RequestMapping("attendance")
	public String attendance(Model model) {
		return "attendance/attendance";
	}

	// 출근
	@RequestMapping("goWork")
	public String goWork(HttpSession session) {
		ServletContext application = session.getServletContext();
		// 출근 시간 기록이 저장되는 start라는 application 변수가 비어있을 때 출근 버튼이 동작한다.
		if (application.getAttribute("start") == null) {
			MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
			dto_att.setEmpNo(dto_mem.getEmpNo());
			service = ac.getBean("goWorkService", GoWorkService.class);
			dto_att = service.execute(dto_att); // 출근 시간 기록이 지워지지 않도록 dto_att를 넘겨준다.
			application.setAttribute("start", dto_att);
		}
		return "redirect:attendance";
	}

	// 퇴근
	@RequestMapping("leaveWork")
	public String leaveWork(HttpSession session) {
		ServletContext application = session.getServletContext();
		// 출근 시간이 기록되어있고 퇴근 시간이 없는 경우에 동작한다.
		if (application.getAttribute("start") != null) {
			if (application.getAttribute("end") == null) {
				service = ac.getBean("leaveWorkService", LeaveWorkService.class);
				dto_att = service.execute(dto_att); // 출근 시간이 기록된 dto_att를 퇴근 기록 Service에 넘겨준다.
				application.setAttribute("end", dto_att);
			}
		}
		return "redirect:attendance";
	}

	// 출/퇴근 기록 리스트 보기
	@RequestMapping("list")
	public String list(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("attendanceListService", AttendanceListService.class);
		service.list(model);
		return "redirect:attendance";
	}
}