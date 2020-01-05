package com.microservice.loja.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraDTO {

	private List<IntemDaCompraDTO> itens;
	private EnderecoDTO endereco;
}
