package com.microservice.fornecedor.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.fornecedor.model.Info;
import com.microservice.fornecedor.service.InfoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/info")
public class InfoResource {
	
	
	@Autowired
	private InfoService service;
	
	@GetMapping("/{estado}")
	public Info getInfoByEstado(@PathVariable String estado) {
		log.info("Efetuando busca de informações no serviço Fornecedor");
		return service.findByEstado(estado);
	}

}
