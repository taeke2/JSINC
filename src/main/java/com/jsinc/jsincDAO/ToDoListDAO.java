package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.ToDoListDTO;

@Repository
public class ToDoListDAO {
	private static final String namespace = "com.jsinc.mybatis.todoList";
	@Autowired
	private SqlSession sqlSession;
	
	public List<ToDoListDTO> list(ToDoListDTO dto){
		return sqlSession.selectList(namespace + ".listAll", dto);
	}
	
	public void add(ToDoListDTO dto) {
		sqlSession.insert(namespace + ".addList", dto);
	}
	
	public void check(ToDoListDTO dto) {
		sqlSession.update(namespace + ".check", dto);
	}
	
	public ToDoListDTO editPage(String todo) {
		return sqlSession.selectOne(namespace + ".editPage", todo);
	}
	
	public void edit(ToDoListDTO dto) {
		sqlSession.update(namespace + ".edit", dto);
	}
	
	public void delete(String todo) {
		sqlSession.delete(namespace + ".del", todo);
	}
}
