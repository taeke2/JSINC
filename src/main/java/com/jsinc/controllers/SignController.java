package com.jsinc.controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.SignDTO;
import com.jsinc.services.sign.signService;

// 작성자 : 임재만

@Controller
public class SignController {
	ApplicationContext ac = App.ac;

	@Autowired
	signService ss;

	@RequestMapping("newSign")
	public String newSign() {
		return "sign/new";
	}

	@RequestMapping(value = "signInsert", method = RequestMethod.POST)
	public String signInsert(@ModelAttribute SignDTO dto) {
		ss.createSign(dto);
		return "redirect:signWait";
	}

	@RequestMapping("aproved")
	public ModelAndView signAproved(@RequestParam int bno) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sign/aproved");
		mav.addObject("sign", ss.read(bno));
		return mav;
	}

	@RequestMapping("signApprove")
	public ModelAndView signApprove(HttpServletRequest request) {
		HttpSession sessoin = request.getSession();
		ServletContext application = sessoin.getServletContext();
		MemberDTO dto = (MemberDTO) application.getAttribute("user");
		String target = dto.getName() + " " + dto.getRank();
		List<SignDTO> list = ss.lists(target);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sign/list");
		mav.addObject("sign", ss.lists(target));
		return mav;
	}

	@RequestMapping("signSuccess")
	public ModelAndView signSuccess() {
		List<SignDTO> list = ss.successList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sign/success");
		mav.addObject("sign", list);
		return mav;
	}

	@RequestMapping("signWait")
	public ModelAndView signWaiting(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO dto = (MemberDTO) application.getAttribute("user");
		int empno = dto.getEmpNo();
		List<SignDTO> list = ss.waitList(empno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sign/waiting");
		mav.addObject("sign", list);
		return mav;
	}

	@RequestMapping("confirm")
	public String confirm(@RequestParam int bno) {
		SignDTO dto = new SignDTO();
		dto.setBno(bno);
		dto.setChecksign("승인");
		ss.update(dto);
		return "redirect:signSuccess";
	}

	@RequestMapping("reject")
	public String reject(@RequestParam int bno) {
		SignDTO dto = new SignDTO();
		dto.setBno(bno);
		dto.setChecksign("반려");
		ss.update(dto);
		return "redirect:signSuccess";
	}

	@RequestMapping("deleteSign")
	public String deleteSign(@RequestParam int bno) {
		ss.delete(bno);
		return "redirect:signWait";
	}

}
