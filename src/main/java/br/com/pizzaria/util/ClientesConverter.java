package br.com.pizzaria.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pizzaria.domain.dto.ClientesDto;
import br.com.pizzaria.domain.dto.PedidosDto;
import br.com.pizzaria.domain.entity.Clientes;
import br.com.pizzaria.domain.entity.Pedidos;

public class ClientesConverter {

	public static ClientesDto clienteDtoBuilder(Clientes c) {
		
		List<PedidosDto> pedidosDtoList = new ArrayList<>();
		
		for (Pedidos pedidos : c.getPedidos()) {			
			pedidosDtoList.add(PedidosDto.builder().idPedido(pedidos.getId()).valor(pedidos.getValor()).build());			
		}
		
		return ClientesDto.builder()
				.id(c.getId())
				.nome(c.getNome())
				.endereco(c.getEndereco())
				.telefone(c.getTelefone())
				.email(c.getEmail())
				.dataNascimento(c.getDataNascimento())
				.cadastro(c.getCadastro()).pedidos(pedidosDtoList)
				.build();
	}
	
	public static Clientes clienteBuilder(ClientesDto dto) {
		
		return Clientes.builder().id(dto.getId())
				.nome(dto.getNome())
				.endereco(dto.getEndereco())
				.telefone(dto.getTelefone())
				.email(dto.getEmail())
				.dataNascimento(dto.getDataNascimento())
				.cadastro(LocalDate.now())
				.build();
	}

}
