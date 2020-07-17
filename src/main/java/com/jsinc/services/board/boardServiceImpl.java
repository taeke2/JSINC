package com.jsinc.services.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jsinc.jsincDAO.BoardDAO;
import com.jsinc.jsincDTO.BoardDTO;


// 작성자 : 임재만

// 게시글 서비스
@Service
public class boardServiceImpl implements boardService {

	@Inject
	BoardDAO dao;

	// 게시글 작성
	@Override
	public void create(BoardDTO dto) throws Exception {
		dao.create(dto);
	}

	// 게시글 상세보기
	@Override
	public BoardDTO view(int bno) throws Exception {
		BoardDTO dto = dao.view(bno);
		String content = dto.getContent();
		content = content.replace("\n", "<br>");
		dto.setContent(content);
		return dao.view(bno);
	}

	// 게시글 수정
	@Override
	public void update(BoardDTO dto) throws Exception {
		dao.update(dto);
	}

	// 게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

	// 게시글 전체 목록
	@Override
	public List<BoardDTO> listAll() throws Exception {
		return dao.list();
	}

}
