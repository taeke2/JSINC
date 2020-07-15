package com.jsinc.services.survey;

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
import com.jsinc.jsincDTO.SurveyResultDTO;

@Service
public class SurveyResultService implements ServiceIf {
	@Autowired
	SurveyDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();

		SurveyDTO dto_sur = (SurveyDTO) session.getAttribute("survey");
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
		SurveyResultDTO dto_sr = new SurveyResultDTO();
		dto_sr.setEmpNo(dto_mem.getEmpNo());
		dto_sr.setTitle(dto_sur.getTitle());
		dto_sr.setResult(request.getParameter("button"));
		int result = dao.resultChk(dto_sr);
		System.out.println(result);
		if (result == 0) {
			dao.inputResult(dto_sr);
		}
		session.removeAttribute("survey");
	}

}
