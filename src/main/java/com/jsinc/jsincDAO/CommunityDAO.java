package com.jsinc.jsincDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.CommunityConDTO;
import com.jsinc.jsincDTO.CommunityDTO;

// 커뮤니티 DAO
@Repository
public class CommunityDAO {
	private static final String namespace = "com.jsinc.mybatis.community";
	@Autowired
	private SqlSession sqlSession;

	// by해준_커뮤니티 생성_20200602
	public void create(CommunityDTO dto) {
		sqlSession.insert(namespace + ".input", dto);
	}

	// by해준_전체 커뮤니티 보기_20200603
	public List<CommunityDTO> allCom() {
		return sqlSession.selectList(namespace + ".getAll");
	}

	// by해준_내가 가입한 커뮤니티_20200603
	public List<CommunityDTO> myCom(int empNo) {
		return sqlSession.selectList(namespace + ".myCom", empNo);
	}

	// by해준_커뮤니티 클릭 시 해당 커뮤니티 정보 가져오기_20200615 수정
	public CommunityDTO view(String title) {
		return sqlSession.selectOne(namespace + ".view", title);
	}

	// 커뮤니티 가입
	public void signUp(CommunityDTO dto) {
		sqlSession.insert(namespace + ".signUp", dto);
	}
	
	// by해준_가입/탈퇴 하기 버튼_20200604 
	public int signBut(CommunityDTO dto) {
		return sqlSession.selectOne(namespace + ".signBut", dto);
	}

	// by해준_가입여부 확인_20200603
	public int joinOrNot(CommunityDTO dto) {
		return sqlSession.selectOne(namespace + ".joinOrNot", dto);
	}

	// by해준_가입인원수 확인_20200603
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

	// 댓글 등록
	public int replySave(CommunityConDTO dto) {
		updateReply(dto);
		return sqlSession.insert(namespace + ".replySave", dto);
	}

	// 기존 댓글들의 step을 올림
	public void updateReply(CommunityConDTO dto) {
		int step = dto.getStep();
		System.out.println("dao updateReply step : " + step);
		sqlSession.update(namespace + ".updateReply", dto);
	}

}
