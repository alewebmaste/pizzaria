package br.com.pizzaria.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pizzaria.domain.dto.ClientesDto;
import br.com.pizzaria.domain.dto.PedidosDto;
import br.com.pizzaria.domain.entity.Cliente;

public class ClientesConverter {

	public static ClientesDto clienteDtoBuilder(Cliente c) {
		
		List<PedidosDto> pedidosDtoList = new ArrayList<>();
		
		c.getPedidos().forEach(p -> pedidosDtoList.add(
			PedidosDto.builder()
			.idPedido(p.getId())
			.valor(p.getValor())
			.build())
		);
				
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
	
	public static Cliente clienteBuilder(ClientesDto dto) {
		
		return Cliente.builder()
				.id(dto.getId())
				.nome(dto.getNome())
				.endereco(dto.getEndereco())
				.telefone(dto.getTelefone())
				.email(dto.getEmail())
				.dataNascimento(dto.getDataNascimento())
				.cadastro(LocalDate.now())
				.build();
	}

}
