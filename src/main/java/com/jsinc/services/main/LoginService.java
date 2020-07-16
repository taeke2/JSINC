package com.jsinc.services.main;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class LoginService implements ServiceIf {
	private final int CHK_OK = 0;
	private final int CHK_NO = 1;

	@Autowired
	MemberDAO dao;

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String empNo = request.getParameter("empNo");
		String password = request.getParameter("password");
		MemberDTO dto = dao.list(empNo);
		if (dto != null) {
			// Login Success 
			if (password.equals(dto.getPassword())) {
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("MM");
				SimpleDateFormat day = new SimpleDateFormat("dd");
				String month = format.format(date);
				String days = day.format(date);
				HttpSession session = request.getSession();
				ServletContext application = session.getServletContext();
				application.setAttribute("user", dto);
				application.setAttribute("loginMonth", month);
				application.setAttribute("loginDay", days);
				return CHK_OK;	// 0
			}
		}
		return CHK_NO;	// 1
	}

	@Override
	public int empNoChk(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userEmailChk(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sentPw(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}
}
