package com.jsinc.services.main;

import org.springframework.ui.Model;

import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 허성택, 서해준

// 메인 페이지 서비스 인터페이스
public interface ServiceIf {
	public int execute(Model model) throws Exception;

	// 사원번호 중복확인
	public int empNoChk(MemberDTO dto) throws Exception;

	// 이메일 중복확인
	public int userEmailChk(String userEmail) throws Exception;

	// 비밀번호 초기화
	public void sentPw(MemberDTO dto) throws Exception;
}
