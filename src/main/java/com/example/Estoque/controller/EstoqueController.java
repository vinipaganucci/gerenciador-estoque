package com.example.Estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Estoque.model.repository.EstoqueRepository;


@Controller
public class EstoqueController {
	@Autowired
	EstoqueRepository estoqueRepository;

	@GetMapping("/form.html")
	public ModelAndView form() {
	    return new ModelAndView("form.html");
	}
}
