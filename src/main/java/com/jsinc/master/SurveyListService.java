package com.jsinc.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.SurveyDTO;

@Service
public class SurveyListService implements ServiceIf{
	@Autowired
	MasterDAO dao;
	
	@Override
	public void execute(Model model) {
		ArrayList<SurveyDTO> list = (ArrayList<SurveyDTO>) dao.listSur();
		model.addAttribute("list", list);
	}

}
