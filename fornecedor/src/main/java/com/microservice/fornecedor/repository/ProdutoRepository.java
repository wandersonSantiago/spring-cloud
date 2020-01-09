package com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.fornecedor.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

	List<Produto> findByEstado(String estado);

}
