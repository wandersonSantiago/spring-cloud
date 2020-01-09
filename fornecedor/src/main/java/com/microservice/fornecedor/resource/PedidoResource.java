package com.microservice.fornecedor.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.fornecedor.model.Pedido;
import com.microservice.fornecedor.service.PedidoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	
	@Autowired
	private PedidoService service;
	
	@PostMapping
	public Pedido insert(@RequestBody Pedido pedido) {
		log.info("Efetuando pedido no serviço Fornecedor");
		return service.insert(pedido);
	}
	
	@GetMapping
	public List<Pedido> findAll(){
		return  service.findAll();
	}

}
