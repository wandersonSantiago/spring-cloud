package com.microservice.fornecedor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class ItemPedido {

	@Id
	private String id;	
	private Integer quantidade;	
	@DBRef
	private Produto produto;
	@JsonIgnore
	@DBRef
	private Pedido pedido;
	
}
