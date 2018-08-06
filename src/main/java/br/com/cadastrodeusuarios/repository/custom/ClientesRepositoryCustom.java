package br.com.cadastrodeusuarios.repository.custom;

import java.time.LocalDate;

import br.com.cadastrodeusuarios.domain.entity.Clientes;

public interface ClientesRepositoryCustom {
	
	Clientes findByNome(String nome);
	
	Clientes findByDataNascimento(LocalDate data);

}
