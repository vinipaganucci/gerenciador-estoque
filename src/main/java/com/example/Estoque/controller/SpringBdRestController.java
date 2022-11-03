package com.example.Estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Estoque.model.Produtos;
import com.example.Estoque.service.ProdutoService;

public class SpringBdRestController {

	@Autowired

    private ProdutoService produtoService;



    @RequestMapping(value = "/rest/getAll", method = RequestMethod.GET)

    public List<Produtos> getProduto() {

        return produtoService.getAllProdutos();

    }

    @RequestMapping(value = "/rest/get/{id}", method = RequestMethod.GET)

    public Optional<Produtos> getProduto(@PathVariable("id") Integer id) {

        return produtoService.getProdutoById(id);

    }

        

    @RequestMapping(value = "/rest/deleteAll", method = RequestMethod.DELETE)

    public void deleteProduto() {

        produtoService.deleteAllProdutos();

    }

        

    @RequestMapping(value = "/rest/delete/{id}", method = RequestMethod.DELETE)

    public void deleteProduto(@PathVariable("id") Integer id) {

        produtoService.deleteProdutoById(id);

    }

        

    @RequestMapping(value = "/rest/update/{id}", method = RequestMethod.POST)

    public void updateProduto(@RequestBody Produtos produto, @PathVariable("id") Integer id) {

        produtoService.updateProdutoById(id, produto);

    }

        

    @RequestMapping(value = "/rest/insert", method = RequestMethod.POST)

    public void updateProduto(@RequestBody Produtos produto) {

        produtoService.insertProduto(produto);

    }
}
