package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.ReportDTO;

// 작성자 : 임재만

// 보고 DAO
@Repository
public class ReportDAO {
	private static final String namespace = "com.jsinc.mybatis.Report";
	
	@Autowired
	private SqlSession sqlSession;
	
	// 보고 작성
	public void writeReport(ReportDTO dto) {
		sqlSession.insert(namespace + ".insert", dto);
	}
	
	// 보고 리스트 가져오기
	public List<ReportDTO> listAll(String dep) {
		return sqlSession.selectList(namespace + ".listAll", dep);
	}
	
	// 보고서 가져오기
	public ReportDTO read(int bno) {
		return sqlSession.selectOne(namespace + ".read", bno);
	}
	
	// 보고서 수정
	public void update(ReportDTO dto) {
		sqlSession.update(namespace + ".update", dto);
	}
	
	// 보고서 삭제
	public void delete(int bno) {
		sqlSession.delete(namespace + ".delete", bno);
	}
}
