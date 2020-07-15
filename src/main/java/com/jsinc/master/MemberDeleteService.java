package com.jsinc.master;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MemberDeleteService implements ServiceIf{
	@Autowired
	MasterDAO dao;
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String , Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		dao.delete(empNo);
	}
}
