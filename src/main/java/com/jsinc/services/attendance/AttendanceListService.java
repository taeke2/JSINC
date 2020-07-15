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

		double totWorkTime = 0.0;

		String month = request.getParameter("month");
		System.out.println(month);

		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO member = (MemberDTO) application.getAttribute("user");
		String user = member.getEmpNo() + "";

		ArrayList<AttendanceDTO> listAll = (ArrayList<AttendanceDTO>) dao.list(user);

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

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getEmpNo() + ", " + list.get(i).getGoWork() + ", "
					+ list.get(i).getLeaveWork() + ", " + list.get(i).getWorkTime());
		}
		System.out.println(month + "월 총 근무 시간 : " + String.format("%.1f", totWorkTime) + "시간");
		session.setAttribute("month", month);
		session.setAttribute("totWorkTime", String.format("%.1f", totWorkTime));
		session.setAttribute("lists", list);
	}

}
