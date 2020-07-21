package com.jsinc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.services.addressBook.AddressBookService;

// 주소록 컨트롤러
@Controller
public class AddressBookController {
	@Autowired
	AddressBookService service;
	
	// by 성택_주소록 페이지 나타내기_20200603
	@RequestMapping("addressBook")
	public String addressBook(Model model) {
		service.execute(model);
		return "addressBook/addressBook";
	}
}
