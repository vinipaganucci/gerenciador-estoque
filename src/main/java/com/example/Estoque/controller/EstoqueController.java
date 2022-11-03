package com.example.Estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Estoque.model.Produtos;
import com.example.Estoque.model.repository.EstoqueRepository;



@Controller
public class EstoqueController {
	@Autowired
	EstoqueRepository estoqueRepository;

	@GetMapping("/form.html")
	public ModelAndView form() {
	    return new ModelAndView("form.html");
	}
	
	@PostMapping("/add")
    public String novo(@Valid Produtos produto, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }

        estoqueRepository.save(produto);

        return "redirect:/home";
    }
}
