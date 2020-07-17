package com.jsinc.services.board;

import java.util.List;

import com.jsinc.jsincDTO.BoardDTO;

// 작성자 : 임재만

// 부서별 게시판 서비스 인터페이스
public interface departmentService {

	public void create(BoardDTO dto);
	
	public BoardDTO depRead(int bno);
	
	public void depUpdate(BoardDTO dto);
	
	public void depDelete(int bno);
	
	public List<BoardDTO> allList();
	
	public List<BoardDTO> develop();
	public List<BoardDTO> support();
	public List<BoardDTO> accounting();
	public List<BoardDTO> quality();
	public List<BoardDTO> overseas();
}
