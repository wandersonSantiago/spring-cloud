package com.microservice.loja.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDaCompraDTO {
	
	private Long id;
	private Long quantidade;
	private Produto produto;

	@Getter
	@Setter
	public class Produto {
		private String id;
	}
}

