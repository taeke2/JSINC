package com.jsinc.services.sign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsinc.jsincDAO.SignDAO;
import com.jsinc.jsincDTO.SignDTO;

import groovy.sql.Sql;
@Service
public class signServiceImpl implements signService {

	@Autowired
	SignDAO dao;
	
	@Override
	public void createSign(SignDTO dto) {
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
		dao.createSign(dto);
	}

	@Override
	public SignDTO read(int bno) {
		return dao.read(bno);
	}

	@Override
	public List<SignDTO> lists(String target) {
		return dao.lists(target);
	}

	@Override
	public void delete(int bno) {
		dao.delete(bno);
	}

	@Override
	public List<SignDTO> waitList(int empno) {
		return dao.waitList(empno);
	}

	@Override
	public List<SignDTO> successList() {
		return dao.successList();
	}

	@Override
	public void update(SignDTO dto) {
		dao.update(dto);
	}

}
