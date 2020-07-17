package com.jsinc.services.community;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 서해준

// 커뮤니티 탈퇴 서비스
@Service
public class LeaveServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();

		MemberDTO memDto = (MemberDTO) application.getAttribute("user");
		int empNo = memDto.getEmpNo();
		String title = request.getParameter("title");

		CommunityDTO dto = new CommunityDTO();
		dto.setEmpNo(empNo);
		dto.setTitle(title);
		dao.leave(dto);

	}

}
