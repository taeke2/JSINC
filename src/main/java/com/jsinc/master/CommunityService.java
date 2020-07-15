package com.jsinc.master;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityDTO;

@Service
public class CommunityService implements ServiceIf{
	@Autowired
	MasterDAO dao;
	@Autowired
	CommunityDAO com_dao;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		ArrayList<CommunityDTO> list = (ArrayList<CommunityDTO>) dao.listCom();
		ArrayList<CommunityDTO> lists= new ArrayList<CommunityDTO>();
		
		
		CommunityDTO dto_com = new CommunityDTO();
		
		for(CommunityDTO dto : list) {
			dto_com.setTitle(dto.getTitle());
			dto.setMembers(com_dao.countMember(dto_com));
	
			lists.add(dto);
		}
		model.addAttribute("list", lists);
		
	}

}
