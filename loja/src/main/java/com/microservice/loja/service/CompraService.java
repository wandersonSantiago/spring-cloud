package com.microservice.loja.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.loja.client.FornecedorClient;
import com.microservice.loja.client.TransportadorClient;
import com.microservice.loja.dto.CompraDTO;
import com.microservice.loja.dto.InfoEntregaDTO;
import com.microservice.loja.dto.InfoFornecedorDTO;
import com.microservice.loja.dto.InfoPedidoDTO;
import com.microservice.loja.dto.VoucherDTO;
import com.microservice.loja.enuns.StatusEnum;
import com.microservice.loja.model.Compra;
import com.microservice.loja.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;
	@Autowired
	private TransportadorClient transportadorClient;
	@Autowired
	private CompraRepository repository;

	@HystrixCommand(fallbackMethod = "hystrixFalback", threadPoolKey = "insertThreadPool")
	public Compra insert(CompraDTO compra) {
		
		Compra compraSalva = new Compra();
		compraSalva.setStatus(StatusEnum.RECEBIDO);
		compraSalva.setEnderecoDeDestino(compra.getEndereco().toString());
		repository.save(compraSalva);
		compra.setId(compraSalva.getId());
		
		InfoFornecedorDTO info = fornecedorClient.getInfoByEstado(compra.getEndereco().getEstado());		
		InfoPedidoDTO pedido =  fornecedorClient.createdPedido(compra);
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setStatus(StatusEnum.PEDIDO_REALIZADO);
		repository.save(compraSalva);
		
		
		InfoEntregaDTO entregaDTO = new InfoEntregaDTO();
		entregaDTO.setPedidoId(pedido.getId());
		entregaDTO.setDataParaEntrega(LocalDate.now().plusDays(pedido.getTempoDePreparo()));
		entregaDTO.setEnderecoOrigem(info.getEndereco());
		entregaDTO.setEnderecoDestino(compra.getEndereco().toString());
		
		VoucherDTO voucher = transportadorClient.reservaEntrega(entregaDTO);
		compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
		compraSalva.setVoucher(voucher.getNumero());
		compraSalva.setStatus(StatusEnum.RESERVA_ENTREGA_REALIZADA);
		repository.save(compraSalva);
		
		
		return compraSalva;
		
		
	}
	
	public Compra hystrixFalback(CompraDTO compra) {
		//adicionar um caminho alternativo
		if(compra.getId() != null) {
			return repository.findById(compra.getId()).orElse(null);
		}
		Compra compraFalback = new Compra();
		compraFalback.setEnderecoDeDestino(compra.getEndereco().toString());
		
		return compraFalback;
	}
	
	@HystrixCommand(threadPoolKey = "findByIdThreadPool")
	public Compra findById(String id) {
		return repository.findById(id).orElse(null);
	}

}
