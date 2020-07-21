package com.jsinc.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 로그인페이지 Controller
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// by성택_로그인 페이지_20200518
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		// user라는 application변수에 값의 존재 유무에 따라 로그인페이지 또는 메인페이지 경로로 간다.
		if (application.getAttribute("user") == null) {
			return "home";
		}
		return "redirect:index";
	}

}
