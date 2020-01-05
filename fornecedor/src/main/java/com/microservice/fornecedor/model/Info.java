package com.microservice.fornecedor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document
public class Info {

	@Id
	private String id;
	
	private String nome;
	
	private String estado;
	
	private String endereco;
	
}
