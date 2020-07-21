package com.jsinc.services.addressBook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.AddressBookDAO;
import com.jsinc.jsincDTO.MemberDTO;

// 주소록 서비스
@Service
public class AddressBookService implements ServiceIf{
	// 주소록 DAO 객체 생성
	@Autowired
	AddressBookDAO dao;
	
	// by성택_전 사원 리스트 가져오기_20200603
	@Override
	public void execute(Model model) {
		// 사원 정보들을 부서별로 ArrayList에 저장
		ArrayList<MemberDTO> management = (ArrayList<MemberDTO>)dao.listAll("경영지원부");
		ArrayList<MemberDTO> development = (ArrayList<MemberDTO>)dao.listAll("개발부");
		ArrayList<MemberDTO> accountancy = (ArrayList<MemberDTO>)dao.listAll("경리부");
		ArrayList<MemberDTO> quality = (ArrayList<MemberDTO>)dao.listAll("품질관리부");
		ArrayList<MemberDTO> overseas = (ArrayList<MemberDTO>)dao.listAll("해외영업부");
		
		model.addAttribute("mg", management);
		model.addAttribute("dp", development);
		model.addAttribute("at", accountancy);
		model.addAttribute("ql", quality);
		model.addAttribute("os", overseas);
	}

}
