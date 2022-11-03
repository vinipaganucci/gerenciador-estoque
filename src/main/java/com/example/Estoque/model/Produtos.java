package com.example.Estoque.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Produtos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String produto;
    private int quantidade;
    private double valor;
    
    
    
    
}
