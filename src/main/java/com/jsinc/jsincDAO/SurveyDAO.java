package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.SurveyDTO;
import com.jsinc.jsincDTO.SurveyResultDTO;

// 작성자 : 허성택

// 설문 DAO
@Repository
public class SurveyDAO {
	private static final String namespace = "com.jsinc.mybatis.Survey";
	@Autowired
	private SqlSession sqlSession;
	
	// 진행중 & 마감됨 설문 리스트 가져오기
	public List<SurveyDTO> list(String state) {
		return sqlSession.selectList(namespace + ".listAll", state);
	}
	
	// 내가만든 설문 리스트 가져오기
	public List<SurveyDTO> myList(String empNo) {
		return sqlSession.selectList(namespace + ".myList", empNo);
	}
	
	// 설문 등록
	public void input(SurveyDTO dto) {
		sqlSession.insert(namespace + ".input", dto);
	}
	
	// 설문지
	public SurveyDTO survey(String title) {
		return sqlSession.selectOne(namespace + ".survey", title);
	}
	
	// 마감된 설문인지 확인
	public void endChk(SurveyDTO dto) {
		sqlSession.update(namespace + ".endChk", dto);
	}

	// 설문 결과 저장
	public void inputResult(SurveyResultDTO dto) {
		sqlSession.insert(namespace + ".inputResult", dto);
	}
	
	// 설문 참여사람이 있는지 확인
	public int resultChk(SurveyResultDTO dto) {
		return sqlSession.selectOne(namespace + ".resultChk", dto);
	}
	
	// 해당 설문 총 참여자 수
	public int resultAll(String title) {
		return sqlSession.selectOne(namespace + ".resultAll", title);
	}
	
	// 설문에서 해당 답 갯수
	public int answerCnt(SurveyResultDTO dto) {
		return sqlSession.selectOne(namespace + ".answerCnt", dto);
	}

	// 최근 등록된 설문
	public List<SurveyDTO> todayList(String time) {
		return sqlSession.selectList(namespace + ".todayList", time);
	}
}
