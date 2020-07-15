package com.jsinc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsinc.services.todo.AddListService;
import com.jsinc.services.todo.CheckService;
import com.jsinc.services.todo.DeleteService;
import com.jsinc.services.todo.EditPageService;
import com.jsinc.services.todo.EditService;
import com.jsinc.services.todo.ServiceIf;
import com.jsinc.services.todo.TodoListService;

@Controller
public class ToDoListController {
	ApplicationContext ac = App.ac;
	ServiceIf service;
	
	@RequestMapping("toDoList")
	public String toDoList(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("todoListService", TodoListService.class);
		service.execute(model);
		return "toDoList/toDoList";
	}
	
	@RequestMapping("addTodo")
	public String addTodo() {
		return "toDoList/addTodo";
	}
	
	@RequestMapping("addList")
	public String addList(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("addListService", AddListService.class);
		service.execute(model);
		return "redirect:toDoList";
	}
	
	@RequestMapping("check")
	public String check(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("checkService", CheckService.class);
		service.execute(model);
		return "redirect:toDoList";
	}
	
	@RequestMapping("editPage")
	public String editPage(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("editPageService", EditPageService.class);
		service.execute(model);
		return "toDoList/editPage";
	}
	
	@RequestMapping("edit")
	public String edit(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("editService", EditService.class);
		service.execute(model);
		return "redirect:toDoList";
	}
	
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		service = ac.getBean("deleteService", DeleteService.class);
		service.execute(model);
		return "redirect:toDoList";
	}
}
