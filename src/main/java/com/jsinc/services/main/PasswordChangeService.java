package com.jsinc.services.main;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MemberDAO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class PasswordChangeService implements ProfileService {
	@Autowired
	MemberDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
		dto_mem.setPassword(request.getParameter("newPW"));
		System.out.println("바뀐 비밀번호 : " + dto_mem.getPassword());
		dao.passwordChange(dto_mem);
	}

}
