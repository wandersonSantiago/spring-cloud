package com.microservice.fornecedor.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.fornecedor.model.Info;
import com.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoResource {
	
	
	@Autowired
	private InfoService service;
	
	@GetMapping("/{estado}")
	public Info getInfoByEstado(@PathVariable String estado) {
		return service.findByEstado(estado);
	}

}
