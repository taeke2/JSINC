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

@Service
public class ViewServiceImpl implements ServiceCom {
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
		MemberDTO dto_mem = (MemberDTO)application.getAttribute("user");
		
		String title = request.getParameter("title");
		if(title == null) {
			CommunityDTO dto = (CommunityDTO) session.getAttribute("view");
			title = dto.getTitle();
		}
		
		CommunityDTO dto = dao.view(title);
		dto.setEmpNo(dto_mem.getEmpNo());
		
		int cno = dto.getcNo();
		ArrayList<CommunityConDTO> list = (ArrayList<CommunityConDTO>) dao.contentGet(cno);
		
		int signBut = dao.signBut(dto);
		model.addAttribute("signBut", signBut);
		
		session.setAttribute("view", dto);
		session.setAttribute("conList", list);
	}

}
