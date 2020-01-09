package com.microservice.loja.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.microservice.loja.enuns.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Compra {

	@Id
	private String id;	
	private String pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDeDestino;
	private LocalDate dataParaEntrega;
	private String voucher;
	private StatusEnum status;
}
