package com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.loja.dto.CompraDTO;
import com.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	private RestTemplate client;
	
	
	public void insert(CompraDTO compra) {
		
		ResponseEntity<InfoFornecedorDTO> exchange = 
				client.exchange("http://fornecedor/info/" + compra.getEndereco().getEstado()
				, HttpMethod.GET, null, InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
