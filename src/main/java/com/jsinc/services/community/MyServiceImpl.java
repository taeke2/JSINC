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

// 작성자 : 서해준

// 가입한 커뮤니티 리스트 서비스
@Service
public class MyServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO memDto = (MemberDTO) application.getAttribute("user");
		int empNo = memDto.getEmpNo();
		System.out.println("service::::" + empNo);
		ArrayList<CommunityDTO> list = (ArrayList<CommunityDTO>) dao.myCom(empNo);
		ArrayList<CommunityDTO> lists = new ArrayList<CommunityDTO>();
		CommunityDTO dto_com = new CommunityDTO();

		for (CommunityDTO dto : list) {
			dto_com.setEmpNo(empNo);
			dto_com.setTitle(dto.getTitle());
			dto.setMembers(dao.countMember(dto_com));
			dto.setJoin("가입");
			lists.add(dto);
		}
		if (lists.size() == 0) {
			model.addAttribute("noData", "0");
		} else if (lists.size() != 0) {
			model.addAttribute("allList", lists);
		}

	}

}
