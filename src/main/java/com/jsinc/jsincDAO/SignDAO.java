package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.SignDTO;

@Repository
public class SignDAO {
	
	private static final String namespace = "com.jsinc.mybatis.Sign";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void createSign(SignDTO dto) {
		sqlSession.insert(namespace+".insert",dto);
	}
	public List<SignDTO> lists(String target) {
		return sqlSession.selectList(namespace+".lists",target);
	}
	public SignDTO read(int bno) {
		return sqlSession.selectOne(namespace+".read",bno);
	}
	public void delete(int bno) {
		sqlSession.delete(namespace+".delete",bno);
	}
	public List<SignDTO> waitList(int empno){
		return sqlSession.selectList(namespace+".waitList",empno);
	}
	public List<SignDTO> successList(){
		return sqlSession.selectList(namespace+".successList");
	}
	public void update(SignDTO dto) {
		sqlSession.update(namespace+".chkSign",dto);
	}
	
}
