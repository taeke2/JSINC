package com.jsinc.services.survey;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.SurveyDAO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.SurveyDTO;

// 작성자 : 허성택

// 내가 만든 설문 리스트 서비스
@Service
public class MyListService implements ServiceIf{
	@Autowired
	SurveyDAO dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
		String empNo = Integer.toString(dto_mem.getEmpNo());
		
		ArrayList<SurveyDTO> list = (ArrayList<SurveyDTO>) dao.myList(empNo);
		model.addAttribute("myList", list);
	}
	
}
