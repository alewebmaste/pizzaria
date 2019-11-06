package br.com.pizzaria.service;

import java.time.LocalDate;
import java.util.List;

import br.com.pizzaria.domain.dto.ClientesDto;
import br.com.pizzaria.domain.entity.Cliente;

public interface ClientesService {

	List<ClientesDto> buscar();

	ClientesDto buscarPorNome(String nome);

	ClientesDto buscaPorDataNascimento(LocalDate data);

	void inserir(ClientesDto dto);

	void deletar(int id);

	List<Cliente> getAllClientes(Integer pageNo, Integer pageSize, String sortBy);

}
