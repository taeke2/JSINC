package com.jsinc.services.message;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MessageDAO;
import com.jsinc.jsincDTO.MessageDTO;

// 작성자 : 서해준

// 받는 사람 메세지 삭제 서비스
@Service
public class RecMsgDelServiceImpl implements ServiceMes {
	@Autowired
	MessageDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MessageDTO dto = new MessageDTO();

		dto.setSenderEmpNo(Integer.parseInt(request.getParameter("senderEmpNo")));
		dto.setRecEmpNo(Integer.parseInt(request.getParameter("recEmpNo")));
		dto.setSubject(request.getParameter("subject"));
		dto.setSentTime(request.getParameter("sentTime"));

		// 받는 사람 메세지 DB에서 해당 메세지를 삭제 (보낸사람의 보낸 메세지함에는 정보가 남아있음)
		dao.recMsgDel(dto);
	}
}
