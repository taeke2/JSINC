package com.jsinc.services.todo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.ToDoListDAO;
import com.jsinc.jsincDTO.ToDoListDTO;

// 작성자 : 허성택

// 수정 페이지 서비스
@Service
public class EditPageService implements ServiceIf {

	@Autowired
	ToDoListDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String todo = request.getParameter("btns");
		ToDoListDTO dto = dao.editPage(todo); // 할일 정보 dto에 저장
		session.setAttribute("editPage", dto);
	}

}
