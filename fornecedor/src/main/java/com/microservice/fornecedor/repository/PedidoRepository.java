package com.microservice.fornecedor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String>{


}
