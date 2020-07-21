package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.MemberDTO;

// 주소록 DAO
@Repository
public class AddressBookDAO {
	private static final String namespace = "com.jsinc.mybatis.AddressBook";
	@Autowired
	private SqlSession sqlSession;
	
	//by 성택_해당 부서 사원 리스트 불러오기_20200603
	public List<MemberDTO> listAll(String dep){
		return sqlSession.selectList(namespace + ".listAll", dep);
	}
}
