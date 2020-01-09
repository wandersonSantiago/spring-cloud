package com.microservice.loja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.loja.model.Compra;

public interface CompraRepository extends MongoRepository<Compra, String>{

}
