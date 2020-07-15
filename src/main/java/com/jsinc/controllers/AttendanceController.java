package com.jsinc.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.jsincDTO.AttendanceDTO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.services.attendance.AttendanceListService;
import com.jsinc.services.attendance.GoWorkService;
import com.jsinc.services.attendance.LeaveWorkService;
import com.jsinc.services.attendance.ServiceIf;

@Controller
public class AttendanceController {
   ApplicationContext ac = App.ac;
   AttendanceDTO dto_att = new AttendanceDTO();
   private ServiceIf service;

   @RequestMapping("attendance")
   public String attendance(Model model) {
      return "attendance/attendance";
   }

   @RequestMapping("goWork")
   public String goWork(HttpSession session) {
      ServletContext application = session.getServletContext();
      if (application.getAttribute("start") == null) {
         MemberDTO dto_mem = (MemberDTO) application.getAttribute("user");
         dto_att.setEmpNo(dto_mem.getEmpNo());
         service = ac.getBean("goWorkService", GoWorkService.class);
         dto_att = service.execute(dto_att);
         application.setAttribute("start", dto_att);
      }
      return "redirect:attendance";
   }

   @RequestMapping("leaveWork")
   public String leaveWork(HttpSession session) {
      ServletContext application = session.getServletContext();
      if (application.getAttribute("start") != null) {
         if (application.getAttribute("end") == null) {
            service = ac.getBean("leaveWorkService", LeaveWorkService.class);
            dto_att = service.execute(dto_att);
            application.setAttribute("end", dto_att);
         }
      }
      return "redirect:attendance";
   }

   @RequestMapping("list")
   public String list(Model model, HttpServletRequest request) {
      model.addAttribute("request", request);
      service = ac.getBean("attendanceListService", AttendanceListService.class);
      service.list(model);
      return "redirect:attendance";
   }
}