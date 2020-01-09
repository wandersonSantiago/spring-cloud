package com.microservice.fornecedor.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.fornecedor.model.Produto;
import com.microservice.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/{estado}")
	public List<Produto> getInfoByEstado(@PathVariable String estado) {
		return service.findByEstado(estado);
	}

}