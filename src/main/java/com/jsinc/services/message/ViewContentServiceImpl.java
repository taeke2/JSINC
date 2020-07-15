package com.jsinc.services.message;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MessageDTO;
@Service
public class ViewContentServiceImpl implements ServiceMes{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		MessageDTO dto = new MessageDTO();
		//receiver
		dto.setReceiver(request.getParameter("receiver"));
		dto.setRecDep(request.getParameter("recDep"));
		dto.setSentTime(request.getParameter("sentTime"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setRecRank(request.getParameter("recRank"));
		model.addAttribute("subCon",dto);
		
		
	}

}
