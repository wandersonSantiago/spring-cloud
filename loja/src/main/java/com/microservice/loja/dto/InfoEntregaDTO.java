package com.microservice.loja.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoEntregaDTO {
	
	
	private String pedidoId;

	private LocalDate dataParaEntrega;

	private String enderecoOrigem;

	private String enderecoDestino;

}
