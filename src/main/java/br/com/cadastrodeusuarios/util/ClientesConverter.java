package br.com.cadastrodeusuarios.util;

import java.time.LocalDate;

import br.com.cadastrodeusuarios.domain.dto.ClientesDto;
import br.com.cadastrodeusuarios.domain.entity.Clientes;

public class ClientesConverter {

	public static ClientesDto clienteDtoBuilder(Clientes c) {
		return ClientesDto.builder()
				.id(c.getId())
				.nome(c.getNome())
				.endereco(c.getEndereco())
				.telefone(c.getTelefone())
				.email(c.getEmail())
				.dataNascimento(c.getDataNascimento())
				.cadastro(c.getCadastro())
				.build();
	}
	
	public static Clientes clienteBuilder(ClientesDto dto) {
		return Clientes.builder()
				.nome(dto.getNome())
				.endereco(dto.getEndereco())
				.telefone(dto.getTelefone())
				.email(dto.getEmail())
				.dataNascimento(dto.getDataNascimento())
				.cadastro(LocalDate.now())
				.build();
	}

}
