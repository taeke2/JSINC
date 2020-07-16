package com.jsinc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.services.main.PasswordChangeService;
import com.jsinc.services.main.ProfileEditServiceImpl;
import com.jsinc.services.main.ProfileService;
import com.jsinc.services.main.ProfileValueServiceImpl;

// 작성자 : 허성택

@Controller
public class ProfileController {
	ApplicationContext ac = App.ac;
	ProfileService profileService;
	
	// 프로필 페이지
	@RequestMapping("profile")
	public String profile(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		profileService = ac.getBean("profileValueServiceImpl", ProfileValueServiceImpl.class);
		profileService.execute(model);
		return "profile";
	}
	
	// 프로필 수정하기
	@RequestMapping("editProfile")
	public String editProfile(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		profileService = ac.getBean("profileEditServiceImpl", ProfileEditServiceImpl.class);
		profileService.execute(model);
		return "redirect:profile";
	}

	// 비밀번호 변경
	@RequestMapping("changePw")
	public String changePw(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		profileService = ac.getBean("passwordChangeService", PasswordChangeService.class);
		profileService.execute(model);
		return "redirect:profile";
	}
}
