package com.microservice.loja.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.loja.dto.CompraDTO;
import com.microservice.loja.model.Compra;
import com.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compras")
public class ComprasResorce {
	
	@Autowired
	private CompraService service;
	
	
	@PostMapping
	public Compra insert(@RequestBody CompraDTO compra) {
		return service.insert(compra);
	}

	@GetMapping("/{id}")
	public Compra findById(@PathVariable String id) {
		return service.findById(id);
	}
}
