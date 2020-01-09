package com.microservice.fornecedor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.fornecedor.model.ItemPedido;

public interface ItemPedidoRepository extends MongoRepository<ItemPedido, String>{


}
