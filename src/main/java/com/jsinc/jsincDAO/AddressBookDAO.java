package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.MemberDTO;

@Repository
public class AddressBookDAO {
	private static final String namespace = "com.jsinc.mybatis.AddressBook";
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberDTO> listAll(String dep){
		return sqlSession.selectList(namespace + ".listAll", dep);
	}
}
