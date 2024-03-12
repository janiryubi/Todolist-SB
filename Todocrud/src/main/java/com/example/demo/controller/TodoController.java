package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Controller
@RequestMapping("todos")
public class TodoController {
	
	public final TodoRepository todoRepo;
	
	@Autowired
	public TodoController(TodoRepository todoRepo) {
		this.todoRepo = todoRepo;
	}
	
	@GetMapping
	public String list(Model model) {
		System.out.println("list() - findAll()");
		List<Todo> todoList = todoRepo.findAll();
		model.addAttribute("todos",todoList);
		return "list";
	}

}
