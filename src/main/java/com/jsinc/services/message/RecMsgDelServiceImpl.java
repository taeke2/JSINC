package com.jsinc.services.message;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MessageDAO;
import com.jsinc.jsincDTO.MessageDTO;
@Service
public class RecMsgDelServiceImpl implements ServiceMes{
	@Autowired
	MessageDAO dao;
	
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MessageDTO dto = new MessageDTO();
		
		dto.setSenderEmpNo(Integer.parseInt(request.getParameter("senderEmpNo")));
		dto.setRecEmpNo(Integer.parseInt(request.getParameter("recEmpNo")));
		dto.setSubject(request.getParameter("subject"));
		dto.setSentTime(request.getParameter("sentTime"));
		
		int result=dao.recMsgDel(dto);
		
		
	}
	

}
