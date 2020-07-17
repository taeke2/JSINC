package com.jsinc.services.community;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 서해준

// 커뮤니티 가입하기 서비스
@Service
public class SignUpServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	@Override
	public void execute(CommunityDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getExe(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String title = request.getParameter("title");
		int cno = Integer.parseInt(request.getParameter("cno"));
		String join = "Y";
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		MemberDTO memDto = (MemberDTO) application.getAttribute("user");
		CommunityDTO dto = new CommunityDTO();
		dto.setcNo(cno);
		dto.setEmpNo(memDto.getEmpNo());
		dto.setTitle(title);
		dto.setname(memDto.getName());
		dto.setRank(memDto.getRank());
		dto.setJoin(join);
		
		dao.signUp(dto);
	}

}
