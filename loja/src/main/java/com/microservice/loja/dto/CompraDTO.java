package com.microservice.loja.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class CompraDTO {

	@JsonIgnore
	private String id;
	
	private List<ItemDaCompraDTO> itens;
	private EnderecoDTO endereco;
	
}
