package br.com.cadastrodeusuarios.service;

import java.time.LocalDate;
import java.util.List;

import br.com.cadastrodeusuarios.domain.dto.ClientesDto;

public interface ClientesService {

	List<ClientesDto> buscar();

	ClientesDto buscarPorNome(String nome);

	ClientesDto buscaPorDataNascimento(LocalDate data);

	void inserir(ClientesDto dto);

	void deletar(int id);
	
}
