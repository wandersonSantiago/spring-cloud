package com.microservice.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.fornecedor.model.Produto;
import com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findByEstado(String estado) {
		return repository.findByEstado(estado);
	}
	
	
}
