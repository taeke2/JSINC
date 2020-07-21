package com.jsinc.services.community;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityConDTO;
import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;

// 해당 커뮤니티 페이지 보기 서비스
@Service
public class ViewServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;
	
	// 사용 안함
	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}
	
	// by해준_해당 커뮤니티 페이지 보기_20200604
	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
		
		// by성택_페이지가 리다이렉트 될 때 request에 title이 없으면 세션에서 view를 가져와 title을 가져올 수 있도록 함_20200615 추가
		String title = request.getParameter("title");
		if (title == null) {
			CommunityDTO dto = (CommunityDTO) session.getAttribute("view");
			title = dto.getTitle();
		}

		CommunityDTO dto = dao.view(title);	// 커뮤니티 정보 가져오기
		dto.setEmpNo(dto_mem.getEmpNo());
		
		int cno = dto.getcNo();
		ArrayList<CommunityConDTO> list = (ArrayList<CommunityConDTO>) dao.contentGet(cno);

		int signBut = dao.signBut(dto);
		model.addAttribute("signBut", signBut);

		session.setAttribute("view", dto);
		session.setAttribute("conList", list);
	}

}
