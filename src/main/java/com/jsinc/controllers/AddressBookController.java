package com.jsinc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.services.addressBook.AddressBookService;


@Controller
public class AddressBookController {
	@Autowired
	AddressBookService service;
	
	@RequestMapping("addressBook")
	public String addressBook(Model model) {
		service.execute(model);
		return "addressBook/addressBook";
	}
}
