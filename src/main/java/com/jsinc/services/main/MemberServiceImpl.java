package com.jsinc.services.main;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.MemberDAO;
import com.jsinc.jsincDTO.MemberDTO;

@Service
public class MemberServiceImpl implements ServiceIf {
	@Autowired
	MemberDAO dao;

	// 회원가입
	@Override
	public int execute(Model model) throws Exception {
		Map<String, Object> map = model.asMap();
		MemberDTO dto = (MemberDTO) map.get("dto");
		
		String rank = dto.getRank();
		if(rank.equals("사원"))
			dto.setAuthority(1);
		else if(rank.equals("주임"))
			dto.setAuthority(2);
		else if(rank.equals("대리"))
			dto.setAuthority(3);
		else if(rank.equals("과장"))
			dto.setAuthority(4);
		else if(rank.equals("부장"))
			dto.setAuthority(5);
		else if(rank.equals("이사"))
			dto.setAuthority(6);
		else if(rank.equals("대표"))
			dto.setAuthority(7);
		
		dao.memReg(dto);
		return 0;
	}

	@Override
	public int empNoChk(MemberDTO dto) throws Exception {
		return dao.empNoChk(dto);
	}

	@Override
	public int userEmailChk(String userEmail) throws Exception {
		return dao.userEmailChk(userEmail);
	}

	@Override
	public void sentPw(MemberDTO dto) throws Exception {
		dao.sentPw(dto);
	}

}
