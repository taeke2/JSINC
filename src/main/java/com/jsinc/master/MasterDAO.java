package com.jsinc.master;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.CommunityDTO;
import com.jsinc.jsincDTO.MemberDTO;
import com.jsinc.jsincDTO.SurveyDTO;

@Repository
public class MasterDAO {
	private static final String namespace = "com.jsinc.mybatis.Master";
	@Autowired
	private SqlSession sqlSession;

	public List<MemberDTO> list() {
		return sqlSession.selectList(namespace + ".listAll");
	}

	public MemberDTO member(int empNo) {
		return sqlSession.selectOne(namespace + ".member", empNo);
	}

	public void edit(MemberDTO dto) {
		sqlSession.update(namespace + ".edit", dto);
	}

	public void delete(int empNo) {
		sqlSession.delete(namespace + ".delete", empNo);
	}

	// 커뮤니티
	public List<CommunityDTO> listCom() {
		return sqlSession.selectList(namespace + ".comAll");
	}

	public void permissionCom(String title) {
		sqlSession.update(namespace + ".permissionCom", title);
	}

	public void delCom(String title) {
		sqlSession.delete(namespace + ".delCom", title);
	}

	// 설문
	public List<SurveyDTO> listSur() {
		return sqlSession.selectList(namespace + ".surAll");
	}

	public void permissionSur(String title) {
		sqlSession.update(namespace + ".permissionSur", title);
	}

	public void delSur(String title) {
		sqlSession.delete(namespace + ".delSur", title);
	}
}
