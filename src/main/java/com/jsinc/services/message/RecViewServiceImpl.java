package com.jsinc.services.message;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MessageDAO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.MessageDTO;

// 작성자 : 서해준

// 받은 메세지함 서비스
@Service
public class RecViewServiceImpl implements ServiceMes {
	@Autowired
	MessageDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext app = session.getServletContext();
		MemberDTO dto = (MemberDTO) app.getAttribute("user");
		int recEmpNo = dto.getEmpNo();
		ArrayList<MessageDTO> list = (ArrayList<MessageDTO>) dao.recView(recEmpNo); // 해당 사원의 받은 메세지함에서 메세지를 list에 저장
		model.addAttribute("list", list);
	}

}
