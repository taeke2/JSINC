package com.jsinc.services.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsinc.jsincDAO.BoardDAO;
import com.jsinc.jsincDTO.BoardDTO;

// 작성자 : 임재만

// 부서별 게시판 서비스
@Service
public class departmentServiceImpl implements departmentService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public void create(BoardDTO dto) {
		dao.depCreate(dto);
		
	}

	@Override
	public BoardDTO depRead(int bno) {
		BoardDTO dto = dao.depRead(bno);
		String content = dto.getContent();
		content = content.replace("\n", "<br>");
		dto.setContent(content);
		
		return dao.depRead(bno);
	}

	@Override
	public void depUpdate(BoardDTO dto) {
		dao.depUpdate(dto);
	}

	@Override
	public void depDelete(int bno) {
		dao.depDelete(bno);
	}

	@Override
	public List<BoardDTO> allList() {
		return dao.allList();
	}

	@Override
	public List<BoardDTO> develop() {
		return dao.develop();
	}

	@Override
	public List<BoardDTO> support() {
		return dao.support();
	}

	@Override
	public List<BoardDTO> accounting() {
		return dao.accounting();
	}

	@Override
	public List<BoardDTO> quality() {
		return dao.quality();
	}

	@Override
	public List<BoardDTO> overseas() {
		return dao.overseas();
	}

}
