package com.jsinc.services.community;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityConDTO;
import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class ContentSaveServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getExe(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String content = request.getParameter("content");
		String coNo = (String) request.getParameter("cno");
		int cno = Integer.parseInt(coNo);
		content = content.replace("  ", "&nbsp;&nbsp;");
		content = content.replace("\n", "<br>");

		// 게시판 번호,사원번호,이름,직급,내용,날짜를 보낸다
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO mdto = (MemberDTO) application.getAttribute("user");
		SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");
		String date = fm1.format(new Date());
		CommunityConDTO con = new CommunityConDTO();
		// 추가 후 dao로 보냄
		con.setEmpNo(mdto.getEmpNo());
		con.setName(mdto.getName());
		con.setRank(mdto.getRank());
		con.setContent(content);
		con.setcNo(cno);
		con.setCom_date(date);

		dao.content_save(con);

	}

}
