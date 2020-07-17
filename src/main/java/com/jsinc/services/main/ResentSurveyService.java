package com.jsinc.services.main;

import java.util.ArrayList;
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
import com.jsinc.jsincDTO.SurveyResultDTO;

// 작성자 : 허성택

// 최근 생성된 설문 서비스
@Service
public class ResentSurveyService implements ComponentService {
	@Autowired
	SurveyDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
		int empNo = dto_mem.getEmpNo();
		ArrayList<SurveyDTO> list = (ArrayList<SurveyDTO>) dao.list("진행중"); // 진행중인 설문 리스트 list에 담기

		// 최근 생성된 설문들 중 참여하지 않은 설문 list2에 담는다.
		ArrayList<SurveyDTO> list2 = new ArrayList<SurveyDTO>();
		SurveyResultDTO dto_sr = new SurveyResultDTO();
		for (SurveyDTO dto : list) {
			dto_sr.setEmpNo(empNo);
			dto_sr.setTitle(dto.getTitle());
			if (dao.resultChk(dto_sr) == 0) {
				list2.add(dto);
			}
		}
		model.addAttribute("survey", list2);
	}
}
