package br.com.cadastrodeusuarios.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastrodeusuarios.domain.dto.ClientesDto;
import br.com.cadastrodeusuarios.domain.entity.Clientes;
import br.com.cadastrodeusuarios.repository.ClientesRepository;
import br.com.cadastrodeusuarios.service.ClientesService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientesServiceImpl implements ClientesService {

	private final ClientesRepository repository;

	@Override
	public List<ClientesDto> buscar() {

		Iterable<Clientes> todosClientes = repository.findAll();

		List<ClientesDto> clientes = new ArrayList<>();

		for (Clientes c : todosClientes) {

			ClientesDto cliente = new ClientesDto();

			cliente.setId(c.getId());
			cliente.setNome(c.getNome());
			cliente.setEndereco(c.getEndereco());
			cliente.setTelefone(c.getTelefone());
			cliente.setEmail(c.getEmail());

			clientes.add(cliente);

		}

		return clientes;

	}

	@Override
	public ClientesDto buscarPorNome(String nome) {
		Clientes cliente = repository.findByNome(nome);

		ClientesDto dto = new ClientesDto();

		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setEndereco(cliente.getEndereco());
		dto.setTelefone(cliente.getTelefone());
		dto.setEmail(cliente.getEmail());
		dto.setDataNascimento(cliente.getDataNascimento());

		return dto;
	}

	@Override
	public ClientesDto buscaPorDataNascimento(LocalDate data) {
		
		Clientes cliente = repository.findByDataNascimento(data);
	
		ClientesDto dto = new ClientesDto();

		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setEndereco(cliente.getEndereco());
		dto.setTelefone(cliente.getTelefone());
		dto.setEmail(cliente.getEmail());

		return dto;
	}

}