package com.jsinc.services.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsinc.jsincDAO.ReportDAO;
import com.jsinc.jsincDTO.ReportDTO;
@Service
public class reportServiceImpl implements reportService {

	@Autowired
	ReportDAO dao;
	
	@Override
	public void reportWrite(ReportDTO dto) {
		
		dao.writeReport(dto);
	}

	@Override
	public ReportDTO read(int bno) {
		ReportDTO dto = dao.read(bno);
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
		return dao.read(bno);
	}

	@Override
	public void update(ReportDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(int bno) {
		dao.delete(bno);
	}


	@Override
	public List<ReportDTO> listAll(String dep) {
		return dao.listAll(dep);
	}

}
