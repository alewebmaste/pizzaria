package br.com.pizzaria.repository.custom;

import java.time.LocalDate;

import br.com.pizzaria.domain.entity.Clientes;

public interface ClientesRepositoryCustom {

	Clientes findByNome(String nome);

	Clientes findByDataNascimento(LocalDate data);

}
