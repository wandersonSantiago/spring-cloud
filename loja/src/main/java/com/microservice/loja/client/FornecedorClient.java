package com.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.microservice.loja.dto.CompraDTO;
import com.microservice.loja.dto.InfoFornecedorDTO;
import com.microservice.loja.dto.InfoPedidoDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfoByEstado(@PathVariable String estado);
	
	@PostMapping("/pedidos")
	InfoPedidoDTO createdPedido(CompraDTO compra);
	
}
