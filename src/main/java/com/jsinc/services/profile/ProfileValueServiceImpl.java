package com.jsinc.services.profile;

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

// 프로필 페이지 서비스
@Service
public class ProfileValueServiceImpl implements ProfileService {
	@Autowired
	AttendanceDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		double totWorkTime = 0.0;
		int workDays = 0;

		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		// 사원의 사원번호
		MemberDTO member = (MemberDTO) application.getAttribute("user");
		// 사원이 로그인한 월
		String month = (String) application.getAttribute("loginMonth");
		String user = member.getEmpNo() + "";

		// 해당 월의 총 근무 일수와 총 근무 시간 계산
		ArrayList<AttendanceDTO> listAll = (ArrayList<AttendanceDTO>) dao.list(user);
		for (int i = 0; i < listAll.size(); i++) {
			if (listAll.get(i).getGoWork().substring(0, 7).equals("2020." + month)) {
				AttendanceDTO dto = new AttendanceDTO();
				workDays++;
				totWorkTime += listAll.get(i).getWorkTime();
			}
		}
		application.setAttribute("workTimes", String.format("%.1f", totWorkTime));
		application.setAttribute("workDays", workDays + "");
	}

}