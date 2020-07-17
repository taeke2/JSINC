package com.jsinc.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 허성택

// 사원 관리 페이지
@Service
public class MemberMngService implements ServiceIf {
	@Autowired
	MasterDAO dao;

	@Override
	public void execute(Model model) {
		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) dao.list(); // 모든 사원 정보 리스트 가져오기
		model.addAttribute("list", list);
	}

}
