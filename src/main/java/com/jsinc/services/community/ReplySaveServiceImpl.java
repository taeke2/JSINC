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
public class ReplySaveServiceImpl implements ServiceCom{
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
		HttpSession session = request.getSession();
		ServletContext app = session.getServletContext();
		MemberDTO mem_dto = (MemberDTO) app.getAttribute("user");
		CommunityConDTO dto = new CommunityConDTO();
		//시간
		Date date = new Date();
	    SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년 MM월 dd일 ");
	    SimpleDateFormat fm2 = new SimpleDateFormat("시 mm분");
	      String time = fm1.format(date) + date.getHours() + fm2.format(date);
		
		//내용 추가
		dto.setcNo(Integer.parseInt(request.getParameter("cno")));
		dto.setName(mem_dto.getName());
		dto.setContent(request.getParameter("reply"));
		dto.setIdgroup(Integer.parseInt(request.getParameter("idGroup")));
		dto.setStep(Integer.parseInt(request.getParameter("step")));
		dto.setIndent(Integer.parseInt(request.getParameter("indent")));
		dto.setEmpNo(mem_dto.getEmpNo());
		dto.setRank(mem_dto.getRank());
		dto.setCom_date(time);
		System.out.println("step====== 값 :"+dto.getStep());
		
		
		
		
		int result = dao.replySave(dto);
		
	}
	
}
