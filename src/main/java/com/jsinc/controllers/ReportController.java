package com.jsinc.controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.ReportDTO;
import com.jsinc.services.report.reportService;

// 작성자 : 임재만

@Controller
public class ReportController {

	@Autowired
	reportService rs;

	ApplicationContext ac = App.ac;
	
	@RequestMapping("report")
	public ModelAndView listAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");

		List<ReportDTO> list = rs.listAll(dto_mem.getDep());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/report");
		mav.addObject("report", list);
		return mav;
	}
	
	@RequestMapping("writeReport")
	public String writeReport() {
		return "report/writeReport";
	}

	@RequestMapping(value = "rpWrite", method = RequestMethod.POST)
	public String write(@ModelAttribute ReportDTO dto) {
		rs.reportWrite(dto);
		return "redirect:report";
	}
	
	
	@RequestMapping("contentReport")
	public ModelAndView contentReport(@RequestParam int bno) {
		ReportDTO dto = rs.read(bno);
		String content = dto.getContent();
		content = content.replace("\n", "<br>");
		dto.setContent(content);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/contentReport");
		mav.addObject("rp", dto);
		return mav;
	}

	@RequestMapping(value = "updateRp", method = RequestMethod.POST)
	public String update(@ModelAttribute ReportDTO dto) {
		rs.update(dto);
		return "redirect:contentReport?bno=" + dto.getBno();
	}

	@RequestMapping("deleteRp")
	public String delete(@RequestParam int bno) {
		rs.delete(bno);
		return "redirect:report";
	}

	@RequestMapping("updateReport")
	public ModelAndView updateReport(@RequestParam int bno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/updateReport");
		mav.addObject("rp", rs.read(bno));
		return mav;
	}

}
