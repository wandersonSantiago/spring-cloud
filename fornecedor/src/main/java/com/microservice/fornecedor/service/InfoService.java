package com.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.fornecedor.model.Info;
import com.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	
	@Autowired
	private InfoRepository repository;

	public Info findByEstado(String estado) {
		return repository.findByEstado(estado);
	}
	
	
}
