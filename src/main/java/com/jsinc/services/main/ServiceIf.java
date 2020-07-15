package com.jsinc.services.main;

import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MemberDTO;

public interface ServiceIf {
	public int execute(Model model) throws Exception;
	//사원번호 중복확인
	public int empNoChk(MemberDTO dto) throws Exception;
	//이메일 중복확인
	public int userEmailChk(String userEmail)throws Exception;

	public void sentPw(MemberDTO dto)throws Exception;
}
