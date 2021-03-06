package com.jsinc.services.message;

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

// 보낸 메세지 삭제 서비스
@Service
public class SentMsgDelServiceImpl implements ServiceMes {
	@Autowired
	MessageDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext app = session.getServletContext();
		MemberDTO dto_app = (MemberDTO) app.getAttribute("user");
		MessageDTO dto = new MessageDTO();

		dto.setSenderEmpNo(dto_app.getEmpNo());
		dto.setRecEmpNo(Integer.parseInt(request.getParameter("recEmpNo")));
		dto.setSubject(request.getParameter("subject"));
		dto.setSentTime(request.getParameter("sentTime"));

		dao.sentMsgDel(dto); // 보낸 메세지 DB를 삭제해도 받은 사람의 메세지함에는 기록이 그대로 남아있음
	}

}
