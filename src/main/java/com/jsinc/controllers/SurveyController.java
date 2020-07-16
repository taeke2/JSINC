package com.jsinc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.services.survey.CreateSurveyService;
import com.jsinc.services.survey.EndListService;
import com.jsinc.services.survey.MyListService;
import com.jsinc.services.survey.ProceedingListService;
import com.jsinc.services.survey.ResultService;
import com.jsinc.services.survey.ServiceIf;
import com.jsinc.services.survey.SurveyResultService;
import com.jsinc.services.survey.SurveyService;

// 작성자 : 허성택

@Controller
public class SurveyController {
	ApplicationContext ac = App.ac;
	ServiceIf service;

	// 진행중인 설문
	@RequestMapping("startedSurvey")
	public String startedSurvey(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("proceedingListService", ProceedingListService.class);
		service.execute(model);
		return "survey/startedSurvey";
	}

	// 새 설문 등록 페이지
	@RequestMapping("createSurvey")
	public String createSurvey() {
		return "survey/createSurvey";
	}

	// 마감된 설문
	@RequestMapping("endSurvey")
	public String endSurvey(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("endListService", EndListService.class);
		service.execute(model);
		return "survey/endSurvey";
	}

	// 내가 만든 설문
	@RequestMapping("mySurvey")
	public String mySurvey(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("myListService", MyListService.class);
		service.execute(model);
		return "survey/mySurvey";
	}

	// 설문 등록하기
	@RequestMapping("surveyInput")
	public String surveyInput(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("createSurveyService", CreateSurveyService.class);
		service.execute(model);
		return "redirect:startedSurvey";
	}

	// 설문 페이지 들어가기
	@RequestMapping("survey")
	public String survey(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("surveyService", SurveyService.class);
		service.execute(model);
		return "survey/survey";
	}

	// 설문 결과 페이지
	@RequestMapping("surveyResult")
	public String surveyResult(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("surveyResultService", SurveyResultService.class);
		service.execute(model);
		return "redirect:startedSurvey";
	}

	// 설문 결과 등록
	@RequestMapping("result")
	public String result(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("resultService", ResultService.class);
		service.execute(model);
		return "survey/result";
	}
}
