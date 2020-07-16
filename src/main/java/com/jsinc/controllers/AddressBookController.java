package com.jsinc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.services.addressBook.AddressBookService;

// 작성자 : 허성택

@Controller
public class AddressBookController {
	@Autowired
	AddressBookService service;
	
	// 주소록
	@RequestMapping("addressBook")
	public String addressBook(Model model) {
		service.execute(model);
		return "addressBook/addressBook";
	}
}
