package com.jsinc.services.community;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jsinc.jsincDAO.CommunityDAO;
import com.jsinc.jsincDTO.CommunityDTO;

// 작성자 : 서해준

// 커뮤니티 생성 서비스
@Service
public class CreateServiceImpl implements ServiceCom {
	@Autowired
	CommunityDAO dao;

	@Override
	public void execute(CommunityDTO dto) {
		String title = dto.getTitle();
		// *태그문자 처리 (< ==> &lt; > ==> &gt;)
		// replace(A, B) A를 B로 변경
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		// * 공백문자 처리
		title = title.replace("  ", "&nbsp;&nbsp;");

		String content = dto.getContent();
		content = content.replace("  ", "&nbsp;&nbsp;");
		content = content.replace("\n", "<br>");
		dto.setContent(content);
		SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		String date = fm1.format(new Date());
		dto.setCom_date(date);
		dao.create(dto);

	}

	@Override
	public void getExe(Model model) {
		// TODO Auto-generated method stub

	}

}
