package com.example.Estoque.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Estoque.model.Produtos;




public interface EstoqueRepository extends JpaRepository<Produtos, Integer>{

	
}
