package com.example.Estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Estoque.model.Produtos;
import com.example.Estoque.model.repository.EstoqueRepository;



@Controller
public class EstoqueContoller {

	@Autowired
    EstoqueRepository estoqueRepository;

    // Acessa o formulario
    @GetMapping("/form")
    public String produtosForm(Produtos produto) {

        return "addEstoqueForm";
    }

    // Adiciona novo produto
    @PostMapping("/add")
    public String novo(@Valid Produtos produto, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }

        estoqueRepository.save(produto);

        return "redirect:/home";
    }
 // Acessa o formulario de edição
    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable(name = "id") int id) {

        Produtos produto = estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
       
        model.addAttribute("produto", produto);
        return "atualizaForm";
    }

    // Atualiza funcionario
    @PostMapping("update/{id}")
    public String alterarProduto(@Valid Produtos produto, BindingResult result, @PathVariable int id) {

        if (result.hasErrors()) {
            return "redirect:/form";
        }
        
        estoqueRepository.save(produto);
        return "redirect:/home";
    }
    
    @GetMapping("delete/{id}")
    
    public String delete(@PathVariable(name = "id") int id, Model model) {

        Produtos produto = estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        estoqueRepository.delete(produto);
        return "redirect:/home";
    }
}
