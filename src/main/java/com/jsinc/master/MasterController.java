package com.jsinc.master;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.controllers.App;

// 작성자 : 허성택

// 관리자 페이지 Controller
@Controller
public class MasterController {
	ApplicationContext ac = App.ac;
	ServiceIf service;

	// 관리자 로그인
	@RequestMapping("masterLogin")
	public String masterLogin(HttpServletRequest request) {
		if (request.getParameter("empNo").isEmpty()) { // 사원 번호 입력란이 비어있으면 로그인 페이지로 이동
			return "home";
		} else if (request.getParameter("password").isEmpty()) { // 비밀번호 입력란이 비어있으면 로그인 페이지로 이동
			return "home";
		} else {
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			String password = request.getParameter("password");

			if (empNo == 1 && password.equals("master")) // 관리자 아이디 : 1, 비밀번호 : master
				return "redirect:memberMng"; // 일치시 사원관리 페이지 이동
		}
		return "home";
	}

	// 사원 관리 페이지
	@RequestMapping("memberMng")
	public String memberMng(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberMngService", MemberMngService.class);
		service.execute(model);
		return "master/memberMng";
	}

	// 수정 버튼 클릭 시 사원 정보 페이지로 이동
	@RequestMapping("memberInfo")
	public String memberInfo(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberInfoService", MemberInfoService.class);
		service.execute(model);
		return "master/memberInfo";
	}

	// 사원 정보 수정
	@RequestMapping("memberEdit")
	public String memberEdit(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberEditService", MemberEditService.class);
		service.execute(model);
		return "redirect:memberMng";
	}

	// 사원 삭제
	@RequestMapping("memberDel")
	public String memberDel(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberDeleteService", MemberDeleteService.class);
		service.execute(model);
		return "redirect:memberMng";
	}

	// 커뮤니티 관리 페이지
	@RequestMapping("communityMng")
	public String communityMng(Model model) {
		service = ac.getBean("communityService", CommunityService.class);
		service.execute(model);
		return "master/communityMng";
	}

	// 커뮤니티 승인
	@RequestMapping("permissionCom")
	public String permissionCom(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("communityPermissionService", CommunityPermissionService.class);
		service.execute(model);
		return "redirect:communityMng";
	}

	// 커뮤니티 승인 취소 & 삭제
	@RequestMapping("deleteCom")
	public String deleteCom(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("communityDeleteService", CommunityDeleteService.class);
		service.execute(model);
		return "redirect:communityMng";
	}

	// 설문 관리 페이지
	@RequestMapping("surveyMng")
	public String surveyMng(Model model) {
		service = ac.getBean("surveyListService", SurveyListService.class);
		service.execute(model);
		return "master/surveyMng";
	}

	// 설문 승인
	@RequestMapping("permissionSur")
	public String permissionSur(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("surveyPermissionService", SurveyPermissionService.class);
		service.execute(model);
		return "redirect:surveyMng";
	}

	// 설문 승인 취소 & 삭제
	@RequestMapping("delSur")
	public String delSur(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("surveyDeleteService", SurveyDeleteService.class);
		service.execute(model);
		return "redirect:surveyMng";
	}
}
