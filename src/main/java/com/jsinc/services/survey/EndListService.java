package com.jsinc.services.survey;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.SurveyDAO;
import com.jsinc.jsincDTO.SurveyDTO;

// 작성자 : 허성택

// 마감 설문 리스트 서비스
@Service
public class EndListService implements ServiceIf {
	@Autowired
	SurveyDAO dao;

	@Override
	public void execute(Model model) {
		ArrayList<SurveyDTO> list = (ArrayList<SurveyDTO>) dao.list("마감됨");
		model.addAttribute("endList", list);
	}

}
