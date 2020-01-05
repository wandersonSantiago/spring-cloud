package com.microservice.fornecedor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.fornecedor.model.Info;

public interface InfoRepository extends MongoRepository<Info, String>{

	Info findByEstado(String estado);

}
