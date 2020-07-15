package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.SurveyDTO;
import com.jsinc.jsincDTO.SurveyResultDTO;


@Repository
public class SurveyDAO {
	private static final String namespace = "com.jsinc.mybatis.Survey";
	@Autowired
	private SqlSession sqlSession;
	
	public List<SurveyDTO> list(String state) {
		return sqlSession.selectList(namespace + ".listAll", state);
	}
	
	public List<SurveyDTO> myList(String empNo) {
		return sqlSession.selectList(namespace + ".myList", empNo);
	}
	
	public void input(SurveyDTO dto) {
		sqlSession.insert(namespace + ".input", dto);
	}
	
	public SurveyDTO survey(String title) {
		return sqlSession.selectOne(namespace + ".survey", title);
	}
	
	public void endChk(SurveyDTO dto) {
		sqlSession.update(namespace + ".endChk", dto);
	}
	// ==========================================================================
	public void inputResult(SurveyResultDTO dto) {
		sqlSession.insert(namespace + ".inputResult", dto);
	}
	
	public int resultChk(SurveyResultDTO dto) {
		return sqlSession.selectOne(namespace + ".resultChk", dto);
	}
	
	public int resultAll(String title) {
		return sqlSession.selectOne(namespace + ".resultAll", title);
	}
	
	public int answerCnt(SurveyResultDTO dto) {
		return sqlSession.selectOne(namespace + ".answerCnt", dto);
	}
	// ==========================================================================
	public List<SurveyDTO> todayList(String time){
		return sqlSession.selectList(namespace + ".todayList" , time);
	}
}
