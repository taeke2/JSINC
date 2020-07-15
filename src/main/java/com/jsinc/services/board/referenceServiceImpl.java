package com.jsinc.services.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jsinc.jsincDAO.BoardDAO;
import com.jsinc.jsincDTO.BoardDTO;
@Service
public class referenceServiceImpl implements referenceService{
	
	@Inject
	BoardDAO dao;
	
	@Override
	public void create(BoardDTO dto) throws Exception {
		String title = dto.getTitle();
		String content = dto.getContent();
		String writer = dto.getWriter();
		// *태그문자 처리 (< ==> &lt; > ==> &gt;)
		// replace(A, B) A를 B로 변경
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace("<", "&gt;");
		// * 공백문자 처리
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		// * 줄바꿈 문자처리
		content = content.replace("\n", "<br>");
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		dao.upload(dto);
	}

	@Override
	public BoardDTO fileView(int bno) throws Exception {
		return dao.fileView(bno);
	}


	@Override
	public void fileUpdate(BoardDTO dto) throws Exception {
		dao.fileUpdate(dto);
	}

	@Override
	public void fileDelete(int bno) throws Exception {
		dao.fileDelete(bno);
	}

	@Override
	public List<BoardDTO> fileListAll() throws Exception {
		return dao.fileList();
	}

	@Override
	public BoardDTO file(String realfile) throws Exception {
		return dao.file(realfile);
	}


}
