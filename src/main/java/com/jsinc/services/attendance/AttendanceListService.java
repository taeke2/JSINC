package com.jsinc.services.attendance;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.AttendanceDAO;
import com.jsinc.jsincDTO.AttendanceDTO;
import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 허성택

// 출&퇴근 시간 기록 리스트 서비스
@Service
public class AttendanceListService implements ServiceIf {
	@Autowired
	AttendanceDAO dao;

	@Override
	public AttendanceDTO execute(AttendanceDTO dto_att) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void list(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		double totWorkTime = 0.0; // 한달 총 근무 시간

		String month = request.getParameter("month"); // 해당 월
		System.out.println(month);

		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO member = (MemberDTO) application.getAttribute("user"); // 로그인 한 사원의 사원 번호
		String user = member.getEmpNo() + "";

		ArrayList<AttendanceDTO> listAll = (ArrayList<AttendanceDTO>) dao.list(user); // 사원의 모든 출&퇴근 기록을 listAll 리스트에 담기

		// 해당 월에 해당되는 날짜의 출&퇴근 기록을 list에 담기
		ArrayList<AttendanceDTO> list = new ArrayList<AttendanceDTO>();
		for (int i = 0; i < listAll.size(); i++) {
			if (listAll.get(i).getGoWork().substring(0, 7).equals("2020." + month)) {
				AttendanceDTO dto = new AttendanceDTO();
				dto.setEmpNo(member.getEmpNo());
				dto.setGoWork(listAll.get(i).getGoWork());
				dto.setLeaveWork(listAll.get(i).getLeaveWork());
				dto.setWorkTime(listAll.get(i).getWorkTime());
				totWorkTime += listAll.get(i).getWorkTime();
				list.add(dto);
			}
		}

		// 해당 월의 총 근무 시간 계산
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getEmpNo() + ", " + list.get(i).getGoWork() + ", "
					+ list.get(i).getLeaveWork() + ", " + list.get(i).getWorkTime());
		}
		System.out.println(month + "월 총 근무 시간 : " + String.format("%.1f", totWorkTime) + "시간");

		session.setAttribute("month", month); // 해당 월 세션에 등록
		session.setAttribute("totWorkTime", String.format("%.1f", totWorkTime)); // 해당 월 총 근무시간 세션에 등록
		session.setAttribute("lists", list); // 해당 월 출&퇴근 기록 list 세션에 등록
	}

}
