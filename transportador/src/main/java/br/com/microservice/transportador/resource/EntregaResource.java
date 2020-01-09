package br.com.microservice.transportador.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.transportador.dto.EntregaDTO;
import br.com.microservice.transportador.dto.VoucherDTO;
import br.com.microservice.transportador.service.EntregaService;

@RestController
@RequestMapping("/entrega")
public class EntregaResource {

	@Autowired
	private EntregaService entregaService;

	@PostMapping
	public VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		return entregaService.reservaEntrega(pedidoDTO);
	}
}
