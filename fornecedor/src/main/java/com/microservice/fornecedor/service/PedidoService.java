package com.microservice.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.fornecedor.enuns.StatusEnum;
import com.microservice.fornecedor.model.Pedido;
import com.microservice.fornecedor.repository.ItemPedidoRepository;
import com.microservice.fornecedor.repository.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository repository;
	@Autowired
	private ItemPedidoRepository itemRepository;
	

	public Pedido insert(Pedido pedido) {
		pedido.setStatus(StatusEnum.RECEBIDO);
		pedido.setTempoDePreparo(2);
		repository.save(pedido);
		saveItens(pedido);
		return pedido;
	}
	
	private void saveItens(Pedido pedido) {
		pedido.getItens()
		.forEach(item ->{
			item.setPedido(pedido);
			itemRepository.save(item);
		});
	}

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	
	
}
