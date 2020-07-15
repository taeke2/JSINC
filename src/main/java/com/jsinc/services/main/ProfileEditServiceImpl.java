package com.jsinc.services.main;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MemberDAO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class ProfileEditServiceImpl implements ProfileService{
   @Autowired
   MemberDAO dao;
   
   @Override
   public void execute(Model model) {
      Map<String, Object> map = model.asMap();
      HttpServletRequest request = (HttpServletRequest) map.get("request");
      HttpSession session = request.getSession();
      ServletContext application = session.getServletContext();
      
      MemberDTO user = (MemberDTO) application.getAttribute("user");
      MemberDTO dto = new MemberDTO();
      
      dto.setEmpNo(user.getEmpNo());
      dto.setPassword(user.getPassword());
      dto.setName(request.getParameter("name"));
      dto.setBirth(request.getParameter("birth"));
      dto.setUserEmail(user.getUserEmail());
      dto.setPhoneNumber(request.getParameter("phoneNumber"));
      dto.setGender(user.getGender());
      dto.setMailChk(request.getParameter("mailChk"));
      dto.setSmsChk(request.getParameter("smsChk"));
      dto.setRank(user.getRank());
      dto.setDep(user.getDep());
      dto.setImg(user.getImg());

      try {
         dao.editProfile(dto);
         application.setAttribute("user", dto);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }

}