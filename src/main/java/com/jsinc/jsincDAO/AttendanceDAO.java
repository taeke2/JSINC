package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.AttendanceDTO;

@Repository
public class AttendanceDAO {
	private static final String namespace = "com.jsinc.mybatis.Attendance";
	@Autowired
	private SqlSession sqlSession;

	public void input(AttendanceDTO dto) {
		sqlSession.insert(namespace + ".input", dto);
	}

	public List<AttendanceDTO> list(String user) {
		return sqlSession.selectList(namespace + ".listAll", user);
	}
}
