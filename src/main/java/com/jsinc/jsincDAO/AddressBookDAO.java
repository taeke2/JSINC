package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.MemberDTO;

// 작성자 : 허성택

// 주소록 DAO
@Repository
public class AddressBookDAO {
	private static final String namespace = "com.jsinc.mybatis.AddressBook";
	@Autowired
	private SqlSession sqlSession;
	
	// 전 사원 리스트 불러오기
	public List<MemberDTO> listAll(String dep){
		return sqlSession.selectList(namespace + ".listAll", dep);
	}
}
