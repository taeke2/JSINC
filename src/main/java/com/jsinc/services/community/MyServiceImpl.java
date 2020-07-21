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

// 가입한 커뮤니티 리스트 서비스
@Service
public class MyServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	// 사용안함
	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	// by해준_가입한 커뮤니티 리스트_20200603
	// by성택_가입한 커뮤니티 리스트_20200615 수정
	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO memDto = (MemberDTO) application.getAttribute("user");
		int empNo = memDto.getEmpNo();

		ArrayList<CommunityDTO> list = (ArrayList<CommunityDTO>) dao.myCom(empNo); // by성택_가입한 커뮤니티 리스트 가져오기_20200615 수정
		ArrayList<CommunityDTO> lists = new ArrayList<CommunityDTO>(); // by성택_'가입'표시와 가입된 회원수를 dto에 set하여 lists에 추가_20200615 수정
		CommunityDTO dto_com = new CommunityDTO();

		for (CommunityDTO dto : list) {
			dto_com.setEmpNo(empNo);
			dto_com.setTitle(dto.getTitle());
			dto.setMembers(dao.countMember(dto_com)); // 가입한 회원 수 dto에 set
			dto.setJoin("가입");
			lists.add(dto);
		}
		if (lists.size() == 0) {
			model.addAttribute("noData", "0"); // 가입 목록이 없는 경우
		} else if (lists.size() != 0) {
			model.addAttribute("allList", lists);
		}

	}

}
