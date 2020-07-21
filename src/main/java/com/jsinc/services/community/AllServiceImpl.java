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

// 전체 커뮤니티 리스트 서비스
@Service
public class AllServiceImpl implements ServiceCom {
	// by해준_커뮤니티 DAO 객체 생성_20200603
	@Autowired
	CommunityDAO dao;
	
	// 사용안함
	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	// by해준_전체 커뮤니티 리스트_20200603
	// by성택_전체 커뮤니티 리스트_20200615 수정
	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO memDto = (MemberDTO) application.getAttribute("user");

		int empNo = memDto.getEmpNo();
		ArrayList<CommunityDTO> list = (ArrayList<CommunityDTO>) dao.allCom(); // by성택_승인된 모든 커뮤니티 리스트 list에 저장_20200615 수정
		ArrayList<CommunityDTO> lists = new ArrayList<CommunityDTO>(); // by성택_가입여부에 따른 커뮤니티 리스트 새로 저장할 lists_20200615 추가

		CommunityDTO dto_com = new CommunityDTO();
		// by성택_가입 여부에 따른 '가입'or'미가입'표시_20200615
		int result = 0;
		for (CommunityDTO dto : list) {
			dto_com.setEmpNo(empNo);
			dto_com.setTitle(dto.getTitle());
			dto.setMembers(dao.countMember(dto_com)); // 가입 멤버 수
			result = dao.joinOrNot(dto_com); // 해당 사원의 가입여부 확인
			if (result == 1) { // 결과가 1이면 가입 아니면 미가입
				dto.setJoin("가입");
			} else {
				dto.setJoin("미가입");
			}
			lists.add(dto); // 가입 여부 저장 후 lists에 추가
		}
		model.addAttribute("allList", lists);
	}

}
