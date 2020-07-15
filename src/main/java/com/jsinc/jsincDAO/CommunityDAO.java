package com.jsinc.jsincDAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.CommunityConDTO;
import com.jsinc.jsincDTO.CommunityDTO;

@Repository
public class CommunityDAO {
	private static final String namespace = "com.jsinc.mybatis.community";
	@Autowired
	private SqlSession sqlSession;

	// 커뮤니티 만들기
	public void create(CommunityDTO dto) {
		sqlSession.insert(namespace + ".input", dto);
	}

	// 전체 커뮤니티 보기
	public List<CommunityDTO> allCom() {
		return sqlSession.selectList(namespace + ".getAll");
	}

	// 내가 가입한 커뮤니티
	public List<CommunityDTO> myCom(int empNo) {
		return sqlSession.selectList(namespace + ".myCom", empNo);
	}

	// 커뮤니티 클릭 시
	public CommunityDTO view(String title) {
		return sqlSession.selectOne(namespace + ".view", title);
	}

	// 커뮤니티 가입
	public void signUp(CommunityDTO dto) {
		sqlSession.insert(namespace + ".signUp", dto);
	}

	// 가입 하기 버튼
	public int signBut(CommunityDTO dto) {
		return sqlSession.selectOne(namespace + ".signBut", dto);
	}

	// 가입여부
	public int joinOrNot(CommunityDTO dto) {
		return sqlSession.selectOne(namespace + ".joinOrNot", dto);
	}

	// 가입인원
	public int countMember(CommunityDTO dto) {
		return sqlSession.selectOne(namespace + ".countMember", dto);
	}

	// 게시글 등록(내용)
	public void content_save(CommunityConDTO dto) {

		sqlSession.insert(namespace + ".contentsave", dto);
	}

	// 게시글 내용 가져오기
	public List<CommunityConDTO> contentGet(int cno) {
		return sqlSession.selectList(namespace + ".contentGet", cno);
	}

	// 회원 탈퇴
	public int leave(CommunityDTO dto) {
		return sqlSession.delete(namespace + ".leave", dto);
	}
	//댓글 등록
	public int replySave(CommunityConDTO dto) {
		updateReply(dto);
		return sqlSession.insert(namespace+".replySave",dto);
	}
	//기존 댓글들의 step을 올림
	public void updateReply(CommunityConDTO dto) {
		int step=dto.getStep();
		System.out.println("dao updateReply step : " + step);
		sqlSession.update(namespace+".updateReply",dto);
	}

}
