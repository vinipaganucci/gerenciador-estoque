package com.example.Estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") int id) {

        Produtos produto = estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
       
        model.addAttribute("produtos", produto);
        return "editaForm";
    }
	
	
    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Produtos produto, BindingResult result, @PathVariable int id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }
        
        estoqueRepository.save(produto);
        return "redirect:/home";
    }
	
	@GetMapping("delete/{id}")
    @CacheEvict(value = "produtos", allEntries = true)
    public String delete(@PathVariable(name = "id") int id, Model model) {

        Produtos produto = estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        estoqueRepository.delete(produto);
        return "redirect:/home";
    }
}
