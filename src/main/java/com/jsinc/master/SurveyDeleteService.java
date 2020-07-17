package com.jsinc.master;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

// 작성자 : 허성택

// 설문 승인 취소 & 삭제
@Service
public class SurveyDeleteService implements ServiceIf {
	@Autowired
	MasterDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		dao.delSur(request.getParameter("title")); // 해당 제목 데이터 삭제
	}
}
