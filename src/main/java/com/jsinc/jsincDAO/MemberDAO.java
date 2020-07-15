package com.jsinc.jsincDAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.MemberDTO;

@Repository
public class MemberDAO {

	private static final String namespace = "com.jsinc.mybatis.Member";
	@Autowired
	private SqlSession sqlSession;

	public MemberDTO list(String empNo) {
		return sqlSession.selectOne(namespace + ".list", empNo);
	}

	// 아이디 중복체크
	public int empNoChk(MemberDTO dto) throws Exception {
		int result = sqlSession.selectOne(namespace + ".empNoChk", dto.getEmpNo());
		return result;
	}

	// 이메일 중복체크
	public int userEmailChk(String userEmail) throws Exception {
		int result = sqlSession.selectOne(namespace + ".userEmailChk", userEmail);
		return result;
	}

	// 회원가입
	public void memReg(MemberDTO dto) throws Exception {
		sqlSession.insert(namespace + ".regMem", dto);
	}

	// 임시 비밀번호
	public void sentPw(MemberDTO dto) throws Exception {
		sqlSession.update(namespace + ".newPw", dto);
	}

	// 프로필 수정
	public void editProfile(MemberDTO dto) throws Exception {
		sqlSession.update(namespace + ".editProfile", dto);
	}
	
	// 비밀번호 변경
	public void passwordChange(MemberDTO dto) {
		sqlSession.update(namespace + ".passwordChange", dto);
	}

}
