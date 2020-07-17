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
import com.jsinc.services.community.ServiceCom;

// 작성자 : 서해준

// 메세지 읽음 여부 서비스
@Service
public class RecContentServiceImpl implements ServiceMes {
	@Autowired
	MessageDAO dao;

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext app = session.getServletContext();
		MemberDTO dto_Mem = (MemberDTO) app.getAttribute("user");

		MessageDTO dto = new MessageDTO();
		dto.setRecEmpNo(dto_Mem.getEmpNo());
		dto.setSentTime(request.getParameter("sentTime"));
		dto.setSender(request.getParameter("sender"));
		dto.setSenderDep(request.getParameter("senderDep"));
		dto.setSenderEmpNo(Integer.parseInt(request.getParameter("senderEmpNo")));
		dto.setSenderRank(request.getParameter("senderRank"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));

		dao.msgChk(dto); // 해당 메세지를 들어가면 메세지 읽음 여부를 'Y'로 바꾼다.

		model.addAttribute("subCon", dto);

	}

}
