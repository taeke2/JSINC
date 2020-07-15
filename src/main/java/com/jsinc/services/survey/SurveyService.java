package com.jsinc.services.survey;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.SurveyDAO;
import com.jsinc.jsincDTO.SurveyDTO;

@Service
public class SurveyService implements ServiceIf{
	@Autowired
	SurveyDAO dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		System.out.println(title);
		SurveyDTO dto = dao.survey(title);
		String text = dto.getText();
		text = text.replace("\n", "<br>");
		dto.setText(text);
		System.out.println("dto.opt : " + dto.getOpt());
		session.setAttribute("survey", dto);
	}

}
