package com.jsinc.jsincDAO;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jsinc.jsincDTO.BoardDTO;

// 작성자 : 임재만

// 게시판 DAO
@Repository
public class BoardDAO {

	private static final String namespace = "com.jsinc.mybatis.Board";
	@Inject
	private SqlSession sqlSession;

	// 게시글 등록
	public void create(BoardDTO dto) throws Exception {
		sqlSession.insert(namespace + ".insert", dto);
	}

	// 게시글 상세보기
	public BoardDTO view(int bno) throws Exception {
		return sqlSession.selectOne(namespace + ".view", bno);
	}

	// 게시글 수정
	public void update(BoardDTO dto) throws Exception {
		sqlSession.update(namespace + ".update", dto);
	}

	// 게시글 삭제
	public void delete(int bno) throws Exception {
		sqlSession.delete(namespace + ".delete", bno);
	}

	// 게시글 전체목록
	public List<BoardDTO> list() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}

	///////////////////////////////////////////////////////////
	// 자료실 등록
	public void upload(BoardDTO dto) throws Exception {
		sqlSession.insert(namespace + ".fileUpload", dto);
	}

	// 자료실 전체목록
	public List<BoardDTO> fileList() throws Exception {
		return sqlSession.selectList(namespace + ".fileList");
	}

	// 자료실 상세보기
	public BoardDTO fileView(int bno) throws Exception {
		return sqlSession.selectOne(namespace + ".fileView", bno);
	}

	// 자료실 수정
	public void fileUpdate(BoardDTO dto) throws Exception {
		sqlSession.update(namespace + ".fileUpdate", dto);
	}

	// 자료실 삭제
	public void fileDelete(int bno) throws Exception {
		sqlSession.delete(namespace + ".fileDelete", bno);
	}

	// 파일 다운로드
	public BoardDTO file(String realfile) throws Exception {
		return sqlSession.selectOne(namespace + ".file", realfile);
	}

	///////////////////////////////////////////////////////////
	// 부서 게시판
	public List<BoardDTO> develop() {
		return sqlSession.selectList(namespace + ".develop");
	}

	public List<BoardDTO> support() {
		return sqlSession.selectList(namespace + ".support");
	}

	public List<BoardDTO> accounting() {
		return sqlSession.selectList(namespace + ".accounting");
	}

	public List<BoardDTO> quality() {
		return sqlSession.selectList(namespace + ".quality");
	}

	public List<BoardDTO> overseas() {
		return sqlSession.selectList(namespace + ".overseas");
	}

	public List<BoardDTO> allList() {
		return sqlSession.selectList(namespace + ".allList");
	}

	public void depCreate(BoardDTO dto) {
		sqlSession.insert(namespace + ".depCreate", dto);
	}

	public void depUpdate(BoardDTO dto) {
		sqlSession.update(namespace + ".depUpdate", dto);
	}

	public void depDelete(int bno) {
		sqlSession.delete(namespace + ".depDelete", bno);
	}

	public BoardDTO depRead(int bno) {
		return sqlSession.selectOne(namespace + ".depRead", bno);
	}
}
