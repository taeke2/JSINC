package com.jsinc.services.survey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.SurveyDAO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.SurveyDTO;

// 작성자 : 허성택

// 새 설문 작성 서비스
@Service
public class CreateSurveyService implements ServiceIf {
	
	@Autowired
	SurveyDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		// 등록 날짜 생성
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = format.format(date);
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
		
		// 설문 등록
		SurveyDTO dto = new SurveyDTO();
		dto.setEmpNo(dto_mem.getEmpNo());
		dto.setTitle(request.getParameter("title"));
		dto.setText(request.getParameter("comment"));
		dto.setsDate(sDate);
		dto.seteDate(request.getParameter("eDate"));
		dto.setWriter(dto_mem.getName() + " " + dto_mem.getRank());
		dto.setState("진행중");
		dto.setOpt(Integer.parseInt(request.getParameter("optionsRadios")));
		dao.input(dto);
	}

}
