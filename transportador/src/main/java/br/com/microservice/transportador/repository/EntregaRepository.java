package br.com.microservice.transportador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.microservice.transportador.model.Entrega;

public interface EntregaRepository extends MongoRepository<Entrega, String>{

}
