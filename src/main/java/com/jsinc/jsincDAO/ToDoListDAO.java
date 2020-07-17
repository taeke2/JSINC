package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.ToDoListDTO;

// 작성자 : 허성택

// 스케쥴 DAO
@Repository
public class ToDoListDAO {
	private static final String namespace = "com.jsinc.mybatis.todoList";
	@Autowired
	private SqlSession sqlSession;
	
	// 오늘의 할일 리스트 가져오기
	public List<ToDoListDTO> list(ToDoListDTO dto) { 
		return sqlSession.selectList(namespace + ".listAll", dto);
	}
	
	// 새 할일 등록
	public void add(ToDoListDTO dto) {
		sqlSession.insert(namespace + ".addList", dto);
	}
	
	// 체크 버튼 클릭 시
	public void check(ToDoListDTO dto) {
		sqlSession.update(namespace + ".check", dto);
	}
	
	// 수정 버튼 클릭시
	public ToDoListDTO editPage(String todo) {
		return sqlSession.selectOne(namespace + ".editPage", todo);
	}
	
	// 할 일 수정
	public void edit(ToDoListDTO dto) {
		sqlSession.update(namespace + ".edit", dto);
	}
	
	// 할 일 삭제
	public void delete(String todo) {
		sqlSession.delete(namespace + ".del", todo);
	}
}
