package com.jsinc.services.survey;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.SurveyDAO;
import com.jsinc.jsincDTO.SurveyDTO;

// 작성자 : 허성택

// 설문 페이지 서비스
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
		SurveyDTO dto = dao.survey(title);
		// 설문 내용 줄바꿈 replace
		String text = dto.getText();
		text = text.replace("\n", "<br>");
		dto.setText(text);
		session.setAttribute("survey", dto);
	}

}
