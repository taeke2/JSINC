package com.jsinc.master;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

// 작성자 : 허성택

// 커뮤니티 승인
@Service
public class CommunityPermissionService implements ServiceIf{
	@Autowired
	MasterDAO dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		dao.permissionCom(request.getParameter("title"));
	}

}
