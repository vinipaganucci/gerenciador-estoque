package com.example.Estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Estoque.model.Produtos;
import com.example.Estoque.service.ProdutoService;

@Controller
public class SpringBdController {

	@Autowired

    private ProdutoService produtoService;

		

    @RequestMapping(value = "/insert", method = RequestMethod.GET)

    public ModelAndView insert() {

        return new ModelAndView("insert", "produtos", new Produtos());

    }



    @RequestMapping(value = "/insert", method = RequestMethod.POST)

    public String submitInsert(@Valid @ModelAttribute("produtos")Produtos produto, BindingResult result, ModelMap model) {



        if (result.hasErrors()) {

            return "error";

        }



        produtoService.insertProduto(produto);



        return "redirect:";

    }



    @RequestMapping(value = "/delete", method = RequestMethod.GET)

    public ModelAndView delete(Integer id) {



        return new ModelAndView("delete", "produtos", produtoService.getProdutoById(id).get());

    }



    @RequestMapping(value = "/delete", method = RequestMethod.POST)

    public String submitDelete(@Valid @ModelAttribute("produtos")Produtos produto, BindingResult result, ModelMap model) {



        if (result.hasErrors()) {

            return "error";

        }



        produtoService.deleteProdutoById(produto.getId());



        return "redirect:";

    }



    @RequestMapping(value = "/update", method = RequestMethod.GET)

    public ModelAndView update(Integer id) {



        return new ModelAndView("update", "produtos", produtoService.getProdutoById(id).get());

    }



    @RequestMapping(value = "/update", method = RequestMethod.POST)

    public String submitUpdate(@Valid @ModelAttribute("produto")Produtos produto, BindingResult result, ModelMap model) {



        if (result.hasErrors()) {

            return "error";

        }



        produtoService.updateProduto(produto);



        return "redirect:";

    }



    @RequestMapping(value = "/read", method = RequestMethod.GET)

    public ModelAndView read() {



        ModelAndView mav = new ModelAndView("read");

        mav.addObject("produtos", produtoService.getAllProdutos());

        return mav;

    }



    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView form() {



        ModelAndView mav = new ModelAndView("form");

        mav.addObject("produto", produtoService.getAllProdutos());

        return mav;

    }
}
