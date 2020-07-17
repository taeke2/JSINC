package com.jsinc.services.board;

import java.util.List;
import java.util.Map;

import com.jsinc.jsincDTO.BoardDTO;

// 작성자 : 임재만

// 자료실 서비스 인터페이스
public interface referenceService {

	public void create(BoardDTO dto) throws Exception;

	public BoardDTO fileView(int bno) throws Exception;

	public void fileUpdate(BoardDTO dto) throws Exception;

	public void fileDelete(int bno) throws Exception;

	public List<BoardDTO> fileListAll() throws Exception;

	public BoardDTO file(String realfile) throws Exception;
}
