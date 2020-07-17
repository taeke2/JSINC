package com.jsinc.services.sign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsinc.jsincDAO.SignDAO;
import com.jsinc.jsincDTO.SignDTO;

import groovy.sql.Sql;

// 작성자 : 임재만

// 전자 결재 서비스
@Service
public class signServiceImpl implements signService {

	@Autowired
	SignDAO dao;
	
	// 결재 등록
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
	
	// 결재 보기
	@Override
	public SignDTO read(int bno) {
		return dao.read(bno);
	}
	
	// 결재 리스트 가져오기
	@Override
	public List<SignDTO> lists(String target) {
		return dao.lists(target);
	}
	
	// 결재 삭제
	@Override
	public void delete(int bno) {
		dao.delete(bno);
	}
	
	// 결재 대기 리스트
	@Override
	public List<SignDTO> waitList(int empno) {
		return dao.waitList(empno);
	}
	
	// 결재 승인 리스트
	@Override
	public List<SignDTO> successList() {
		return dao.successList();
	}
	
	// 결재 수정
	@Override
	public void update(SignDTO dto) {
		dao.update(dto);
	}
}
