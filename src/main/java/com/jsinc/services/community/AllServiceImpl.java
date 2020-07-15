package com.jsinc.services.community;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class AllServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	// 전체 커뮤니티 리스트를 가져온다.
	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO memDto = (MemberDTO) application.getAttribute("user");

		int empNo = memDto.getEmpNo();
		ArrayList<CommunityDTO> list = (ArrayList<CommunityDTO>) dao.allCom();
		ArrayList<CommunityDTO> lists = new ArrayList<CommunityDTO>();

		CommunityDTO dto_com = new CommunityDTO();

		int result = 0;
		for (CommunityDTO dto : list) {
			dto_com.setEmpNo(empNo);
			dto_com.setTitle(dto.getTitle());
			dto.setMembers(dao.countMember(dto_com));
			result = dao.joinOrNot(dto_com);
			if (result == 1) {
				dto.setJoin("가입");
			} else {
				dto.setJoin("미가입");
			}
			lists.add(dto);
		}

		model.addAttribute("allList", lists);
	}

}
