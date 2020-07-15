package com.jsinc.services.main;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.AttendanceDAO;
import com.jsinc.jsincDTO.AttendanceDTO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class ProfileValueServiceImpl implements ProfileService{
   @Autowired
   AttendanceDAO dao;
   
   @Override
   public void execute(Model model) {
      Map<String, Object> map = model.asMap();
      HttpServletRequest request = (HttpServletRequest) map.get("request");

      double totWorkTime = 0.0;
      int workDays = 0;

      HttpSession session = request.getSession();
      ServletContext application = session.getServletContext();
      MemberDTO member = (MemberDTO) application.getAttribute("user");
      String month = (String) application.getAttribute("loginMonth");
      String user = member.getEmpNo() + "";

      ArrayList<AttendanceDTO> listAll = (ArrayList<AttendanceDTO>) dao.list(user);
      for (int i = 0; i < listAll.size(); i++) {
         if (listAll.get(i).getGoWork().substring(0, 7).equals("2020." + month)) {
            AttendanceDTO dto = new AttendanceDTO();
            workDays++;
            totWorkTime += listAll.get(i).getWorkTime();
         }
      }
      application.setAttribute("workTimes", String.format("%.1f", totWorkTime));
      application.setAttribute("workDays", workDays+"");
   }

}