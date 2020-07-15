package com.jsinc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.services.message.MsgAlarmServiceImpl;
import com.jsinc.services.message.RecContentServiceImpl;
import com.jsinc.services.message.RecMsgDelServiceImpl;
import com.jsinc.services.message.RecViewServiceImpl;
import com.jsinc.services.message.ReplyViewServiceImpl;
import com.jsinc.services.message.SenderServiceImpl;
import com.jsinc.services.message.SentMsgDelServiceImpl;
import com.jsinc.services.message.SentViewServiceImpl;
import com.jsinc.services.message.ServiceMes;
import com.jsinc.services.message.ViewContentServiceImpl;

@Controller
public class MessageController {
	ApplicationContext ac = App.ac;
	private ServiceMes service;
	ServiceMes msgService;
	
	//보낸 쪽지함
	@RequestMapping("sentMessage")
	public String sentMessage(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		service=ac.getBean("sentViewServiceImpl",SentViewServiceImpl.class);
		service.execute(model);
		msgService=ac.getBean("msgAlarmServiceImpl",MsgAlarmServiceImpl.class);
		model.addAttribute("request",request);
		msgService.execute(model);
		
		return "message/sentView";
	}
	//받은 쪽지함
	@RequestMapping("RecMessage")
	public String RecMessage(Model model,HttpServletRequest request) {
		model.addAttribute("request",request);
		service=ac.getBean("recViewServiceImpl",RecViewServiceImpl.class);
		service.execute(model);
		msgService=ac.getBean("msgAlarmServiceImpl",MsgAlarmServiceImpl.class);
		model.addAttribute("request",request);
		msgService.execute(model);
		return "message/recView";
	}
	//메세지 전송 버튼 클릭 시 (접속유저의 내용을 같이 등록함)
	@RequestMapping("mesWriteView")
	public String mesWriteView(Model model,HttpServletRequest request) {
		String name=request.getParameter("name");
		if(name!=null) {
		int empNo=Integer.parseInt(request.getParameter("empNo"));
		String rank=request.getParameter("rank");
		String dep=request.getParameter("dep");
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setEmpNo(empNo);
		dto.setDep(dep);
		dto.setRank(rank);
		model.addAttribute("emp",dto);
		}else if(name == null) {
		HttpSession session = request.getSession();
		MemberDTO dto= (MemberDTO) session.getAttribute("emp");
		model.addAttribute("emp",dto);	
		}
		

		return "message/mesWriteView";
	}
	//메세지 (보내기)등록
	@RequestMapping("sending")
	public String sending(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		service=ac.getBean("senderServiceImpl",SenderServiceImpl.class);
		service.execute(model);
		return "redirect:sentMessage";
	}
	//보낸 메세지내용 클릭
	@RequestMapping("sentContentView")
	public String sentContentView(HttpServletRequest request,Model model) {
		service=ac.getBean("viewContentServiceImpl",ViewContentServiceImpl.class);
		model.addAttribute("request",request);
		service.execute(model);
		return "message/sentContentView";
	}
	//받은 메세지내용 클릭
	@RequestMapping("recContentView")
	public String recContentView(HttpServletRequest request,Model model) {
	
		service=ac.getBean("recContentServiceImpl",RecContentServiceImpl.class);
		model.addAttribute("request",request);
		service.execute(model);
		return "message/recContentView";
	}
	
	//답장하기 view
	@RequestMapping("replyMes")
	public String replyMes(Model model,HttpServletRequest request) {
		service=ac.getBean("replyViewServiceImpl",ReplyViewServiceImpl.class);
		model.addAttribute("request",request);
		service.execute(model);
		return "redirect:mesWriteView";
	}
	//보낸 메세지 삭제 
	@RequestMapping("sentMsgDel")
	public String sentMsgDel(Model model,HttpServletRequest request) {
		service=ac.getBean("sentMsgDelServiceImpl",SentMsgDelServiceImpl.class);
		model.addAttribute("request",request);
		service.execute(model);
		return "redirect:sentMessage";
	}
	//받은 메세지 삭제
	@RequestMapping("recMsgDel")
	public String recMsgDel(Model model,HttpServletRequest request) {
		service=ac.getBean("recMsgDelServiceImpl",RecMsgDelServiceImpl.class);
		model.addAttribute("request",request);
		service.execute(model);
		return "redirect:RecMessage";
	}
	
	
	
	
}
