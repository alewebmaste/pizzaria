package br.com.pizzaria.service;

import java.time.LocalDate;

import br.com.pizzaria.domain.dto.ClientesDto;
import br.com.pizzaria.domain.dto.RelatorioClientesDto;

public interface ClientesService {

	RelatorioClientesDto buscar(Integer pageNo, Integer pageSize, String sortBy, StringBuffer url);

	ClientesDto buscarPorNome(String nome);

	ClientesDto buscaPorDataNascimento(LocalDate data);

	void inserir(ClientesDto dto);

	void deletar(int id);

}
