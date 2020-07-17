package com.jsinc.services.message;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.MessageDTO;


// 작성자 : 서해준

// 답장 페이지 서비스
@Service
public class ReplyViewServiceImpl implements ServiceMes {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();

		MemberDTO dto = new MemberDTO();
		dto.setEmpNo(Integer.parseInt(request.getParameter("recEmpNo")));
		dto.setName(request.getParameter("receiver"));
		dto.setDep(request.getParameter("recDep"));
		dto.setRank(request.getParameter("recRank"));

		session.setAttribute("emp", dto);
	}

}
