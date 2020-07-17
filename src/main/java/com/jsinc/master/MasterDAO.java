package com.jsinc.master;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.SurveyDTO;

// 작성자 : 허성택

// 관리자 페이지 DAO
@Repository
public class MasterDAO {
	private static final String namespace = "com.jsinc.mybatis.Master";
	@Autowired
	private SqlSession sqlSession;
	
	// 사원 정보 리스트 가져오기
	public List<MemberDTO> list() {
		return sqlSession.selectList(namespace + ".listAll");
	}
	
	// 사원번호에 해당하는 사원 정보 가져오기
	public MemberDTO member(int empNo) {
		return sqlSession.selectOne(namespace + ".member", empNo);
	}
	
	// 사원 정보 수정
	public void edit(MemberDTO dto) {
		sqlSession.update(namespace + ".edit", dto);
	}
	
	// 사원 정보 삭제
	public void delete(int empNo) {
		sqlSession.delete(namespace + ".delete", empNo);
	}

	// 커뮤니티 전체 리스트 가져오기
	public List<CommunityDTO> listCom() {
		return sqlSession.selectList(namespace + ".comAll");
	}
	
	// 커뮤니티 승인
	public void permissionCom(String title) {
		sqlSession.update(namespace + ".permissionCom", title);
	}
	
	// 커뮤니티 승인 취소 & 삭제
	public void delCom(String title) {
		sqlSession.delete(namespace + ".delCom", title);
	}

	// 설문 전체 리스트 가져오기
	public List<SurveyDTO> listSur() {
		return sqlSession.selectList(namespace + ".surAll");
	}
	
	// 설문 승인
	public void permissionSur(String title) {
		sqlSession.update(namespace + ".permissionSur", title);
	}
	
	// 설문 승인 취소 & 삭제
	public void delSur(String title) {
		sqlSession.delete(namespace + ".delSur", title);
	}
}
