package com.example.Estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Estoque.model.Produtos;
import com.example.Estoque.model.repository.EstoqueRepository;

@Service("produtoService")
public class ProdutosServiceImpl implements ProdutoService {

	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Override
	public Optional<Produtos> getProdutoById(Integer id) {
		 return estoqueRepository.findById(id);
	}

	@Override
	public List<Produtos> getAllProdutos() {
		 return estoqueRepository.findAll();
	}

	@Override
	public void deleteAllProdutos() {
		estoqueRepository.deleteAll();
		
	}

	@Override
	public void deleteProdutoById(Integer id) {
		estoqueRepository.deleteById(id);
		
	}

	@Override
	public void updateProdutoById(Integer id, Produtos produto) {
		Optional<Produtos> getProduto = getProdutoById(id);

        getProduto.get().setProduto(produto.getProduto());

        getProduto.get().setQuantidade(produto.getQuantidade());
        
        getProduto.get().setValor(produto.getValor());



        estoqueRepository.save(produto);
		
	}

	@Override
	public void updateProduto(Produtos produto) {
		estoqueRepository.save(produto);
		
	}

	@Override
	public void insertProduto(Produtos produto) {
		estoqueRepository.save(produto);
		
	}

}
