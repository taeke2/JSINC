package com.jsinc.master;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 허성택

// 사원 정보 수정
@Service
public class MemberEditService implements ServiceIf {
	@Autowired
	MasterDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("member"); // 원래 사원 정보 dto
		// dto에 수정한 정보 set ---------------------------
		dto.setName(request.getParameter("name"));
		dto.setBirth(request.getParameter("birth"));
		dto.setUserEmail(request.getParameter("email"));
		dto.setPhoneNumber(request.getParameter("pn"));
		dto.setGender(request.getParameter("gender"));
		dto.setRank(request.getParameter("rank"));
		dto.setDep(request.getParameter("dep"));
		// -------------------------------------------
		dao.edit(dto); // 새로 등록된 dto로 사원 정보 수정

		session.removeAttribute("member"); // 기존 세션에 등록되어있는 멤버 정보 삭제
	}

}
