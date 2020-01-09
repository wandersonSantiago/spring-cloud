package com.microservice.fornecedor.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Produto {

	@Id
	private String id;
	
	private String nome;
	
	private String estado;
	
	private String descricao;
	
	private BigDecimal preco;
	
}
