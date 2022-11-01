package com.example.Estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Estoque.model.Produtos;
import com.example.Estoque.model.repository.EstoqueRepository;



@Controller
public class HomeController {

	@Autowired
    private EstoqueRepository estoqueRepository;	
    
    @GetMapping("/home")
    public String home(Model model) {
    	List<Produtos> produtos = estoqueRepository	.findAll();
    	
        model.addAttribute("produtos", produtos);
        return "home";

    }
    
    
    
}
