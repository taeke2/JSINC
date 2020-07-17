package com.jsinc.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityDTO;

// 작성자 : 허성택

// 관리자 커뮤니티 관리 페이지
@Service
public class CommunityService implements ServiceIf{
	@Autowired
	MasterDAO dao;
	@Autowired
	CommunityDAO com_dao;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		ArrayList<CommunityDTO> list = (ArrayList<CommunityDTO>) dao.listCom();	// list에 모든 커뮤니티 목록을 가져온다
		ArrayList<CommunityDTO> lists= new ArrayList<CommunityDTO>();
		
		
		CommunityDTO dto_com = new CommunityDTO();
		
		// list에서 각 커뮤니티의 회원수를 구해서 lists에 추가
		for(CommunityDTO dto : list) {
			dto_com.setTitle(dto.getTitle());
			dto.setMembers(com_dao.countMember(dto_com));	
	
			lists.add(dto);
		}
		model.addAttribute("list", lists);
		
	}

}
