package com.example.Estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Estoque.model.Produtos;
import com.example.Estoque.model.repository.EstoqueRepository;


@Controller
public class HomeController {

	@Autowired
    private EstoqueRepository estoqueRepository;	
    
    @GetMapping("/home")
    public String home(Model model) {
    	List<Produtos> funcionarios = estoqueRepository	.findAll();
    	
        model.addAttribute("funcionarios", funcionarios);
        return "home";

    }
    
    
}
