package com.jsinc.services.survey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.jsinc.jsincDTO.SurveyResultDTO;

@Service
public class ProceedingListService implements ServiceIf {
	@Autowired
	SurveyDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");

		// 마감 날짜 확인을 위해 현재시간 생성
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("hhmmss");
		SimpleDateFormat format3 = new SimpleDateFormat("aa");
		String day = format.format(date);
		String chk = format3.format(date);
		
		// 현재 시간을 숫자로 표현
		int time = 0;
		if (chk.equals("오후"))
			time = Integer.parseInt(format2.format(date)) + 120000;
		else
			time = Integer.parseInt(format2.format(date));
		
		ArrayList<SurveyDTO> list = (ArrayList<SurveyDTO>) dao.list("진행중");
		ArrayList<SurveyDTO> gList = new ArrayList<SurveyDTO>();
		ArrayList<SurveyDTO> rList = new ArrayList<SurveyDTO>();

		int result = 0;
		for (SurveyDTO dto : list) {
			// 마감 날짜의 18:00가 넘어가면 설문의 state가 '마감됨'으로 바뀐다.  
			if (dto.geteDate().equals(day)) {
				if (time >= 180000) {
					dto.setState("마감됨");
					dao.endChk(dto);
					continue;
				}
			}
			
			SurveyResultDTO dto_sr = new SurveyResultDTO();
			dto_sr.setEmpNo(dto_mem.getEmpNo());
			dto_sr.setTitle(dto.getTitle());
			result = dao.resultChk(dto_sr);
			if (result == 1)
				rList.add(dto);
			else
				gList.add(dto);

		}
		model.addAttribute("gList", gList);
		model.addAttribute("rList", rList);
	}
}
