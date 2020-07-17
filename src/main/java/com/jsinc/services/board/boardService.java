package com.jsinc.services.board;

import java.util.List;

import com.jsinc.jsincDTO.BoardDTO;

// 작성자 : 임재만

// 게시판 서비스 인터페이스
public interface boardService {

	public void create(BoardDTO dto) throws Exception;

	public BoardDTO view(int bno) throws Exception;

	public void update(BoardDTO dto) throws Exception;

	public void delete(int bno) throws Exception;

	public List<BoardDTO> listAll() throws Exception;

}
