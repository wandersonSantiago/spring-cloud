package com.microservice.fornecedor.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.fornecedor.enuns.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Pedido {

	@Id
	private String id;
	
	private Integer tempoDePreparo;
	
	private StatusEnum status;
	
	private List<ItemPedido> itens;
	
}
