package com.jsinc.master;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.controllers.App;

@Controller
public class MasterController {
	ApplicationContext ac = App.ac;
	ServiceIf service;

	@RequestMapping("masterLogin")
	public String masterLogin(HttpServletRequest request) {
		if(request.getParameter("empNo").isEmpty()) {
			return "home";
		}else if(request.getParameter("password").isEmpty()) {
			return "home";
		}else {
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			String password = request.getParameter("password");
			
			if (empNo == 1 && password.equals("master"))
				return "redirect:memberMng";
		}
		return "home";
	}

	@RequestMapping("memberMng")
	public String memberMng(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberMngService", MemberMngService.class);
		service.execute(model);
		return "master/memberMng";
	}

	@RequestMapping("memberInfo")
	public String memberInfo(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberInfoService", MemberInfoService.class);
		service.execute(model);
		return "master/memberInfo";
	}

	@RequestMapping("memberEdit")
	public String memberEdit(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberEditService", MemberEditService.class);
		service.execute(model);
		return "redirect:memberMng";
	}

	@RequestMapping("memberDel")
	public String memberDel(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("memberDeleteService", MemberDeleteService.class);
		service.execute(model);
		return "redirect:memberMng";
	}

	@RequestMapping("communityMng")
	public String communityMng(Model model) {
		service = ac.getBean("communityService", CommunityService.class);
		service.execute(model);
		return "master/communityMng";
	}

	@RequestMapping("permissionCom")
	public String permissionCom(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("communityPermissionService", CommunityPermissionService.class);
		service.execute(model);
		return "redirect:communityMng";
	}

	@RequestMapping("deleteCom")
	public String deleteCom(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("communityDeleteService", CommunityDeleteService.class);
		service.execute(model);
		return "redirect:communityMng";
	}

	@RequestMapping("surveyMng")
	public String surveyMng(Model model) {
		service = ac.getBean("surveyListService", SurveyListService.class);
		service.execute(model);
		return "master/surveyMng";
	}

	@RequestMapping("permissionSur")
	public String permissionSur(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("surveyPermissionService", SurveyPermissionService.class);
		service.execute(model);
		return "redirect:surveyMng";
	}

	@RequestMapping("delSur")
	public String delSur(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("surveyDeleteService", SurveyDeleteService.class);
		service.execute(model);
		return "redirect:surveyMng";
	}
}
