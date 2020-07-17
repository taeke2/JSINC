package com.jsinc.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.SurveyDTO;

// 작성자 : 허성택

// 설문 관리 목록 페이지
@Service
public class SurveyListService implements ServiceIf {
	@Autowired
	MasterDAO dao;

	@Override
	public void execute(Model model) {
		ArrayList<SurveyDTO> list = (ArrayList<SurveyDTO>) dao.listSur(); // 설문 모든 리스트 가져오기
		model.addAttribute("list", list);
	}

}
