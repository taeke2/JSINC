package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.SignDTO;

// 작성자 : 임재만

// 결재 DAO
@Repository
public class SignDAO {

	private static final String namespace = "com.jsinc.mybatis.Sign";

	@Autowired
	private SqlSession sqlSession;
	
	// 결재 등록
	public void createSign(SignDTO dto) {
		sqlSession.insert(namespace + ".insert", dto);
	}
	
	// 결재 리스트 가져오기
	public List<SignDTO> lists(String target) {
		return sqlSession.selectList(namespace + ".lists", target);
	}
	
	// 결재 가져오기
	public SignDTO read(int bno) {
		return sqlSession.selectOne(namespace + ".read", bno);
	}
	
	// 결재 삭제
	public void delete(int bno) {
		sqlSession.delete(namespace + ".delete", bno);
	}
	
	// 대기 결재 리스트
	public List<SignDTO> waitList(int empno) {
		return sqlSession.selectList(namespace + ".waitList", empno);
	}
	
	// 결재 승인 리스트
	public List<SignDTO> successList() {
		return sqlSession.selectList(namespace + ".successList");
	}
	
	// 결재 수정
	public void update(SignDTO dto) {
		sqlSession.update(namespace + ".chkSign", dto);
	}

}
