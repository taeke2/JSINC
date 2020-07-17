package com.jsinc.services.community;

import org.springframework.ui.Model;

import com.jsinc.jsincDTO.CommunityDTO;

// 작성자 : 서해준

// 커뮤니티 서비스 인터페이스
public interface ServiceCom {
	public void execute(CommunityDTO dto);
	public void getExe(Model model);
}
