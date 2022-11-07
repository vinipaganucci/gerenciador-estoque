package com.example.Estoque.service;

import java.util.List;
import java.util.Optional;

import com.example.Estoque.model.Produtos;

public interface ProdutoService {

	Optional<Produtos> getProdutoById(Integer id);

    List<Produtos> getAllProdutos();

    void deleteAllProdutos();

    void deleteProdutoById(Integer id);

    void updateProdutoById(Integer id, Produtos aluno);

    void updateProduto(Produtos produto);

    void insertProduto(Produtos produto);
}
