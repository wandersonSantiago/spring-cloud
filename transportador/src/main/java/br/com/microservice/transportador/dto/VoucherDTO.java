package br.com.microservice.transportador.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoucherDTO {

	private String numero;
	
	private LocalDate previsaoParaEntrega;


}
