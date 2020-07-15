package com.jsinc.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MemberDTO;

@Service
public class MemberMngService implements ServiceIf{
	@Autowired
	MasterDAO dao;
	
	@Override
	public void execute(Model model) {
		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) dao.list();
		model.addAttribute("list", list);
	}

}
