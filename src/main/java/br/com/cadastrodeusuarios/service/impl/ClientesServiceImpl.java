package br.com.cadastrodeusuarios.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cadastrodeusuarios.domain.dto.ClientesDto;
import br.com.cadastrodeusuarios.domain.entity.Clientes;
import br.com.cadastrodeusuarios.domain.exception.ClienteNaoEncontradoException;
import br.com.cadastrodeusuarios.repository.ClientesRepository;
import br.com.cadastrodeusuarios.service.ClientesService;
import br.com.cadastrodeusuarios.util.ClientesConverter;
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

			clientes.add(ClientesConverter.clienteDtoBuilder(c));

		}

		return clientes;

	}

	@Override
	public ClientesDto buscarPorNome(String nome) {

		Clientes c = repository.findByNome(nome);

		if (c == null) {
			throw new ClienteNaoEncontradoException("O cliente " + nome + " não existe");
		}

		return ClientesConverter.clienteDtoBuilder(c);
	}

	@Override
	public ClientesDto buscaPorDataNascimento(LocalDate data) {

		Clientes c = repository.findByDataNascimento(data);

		if (c == null) {
			throw new ClienteNaoEncontradoException("Não existem clientes nascidos em " + data);
		}

		return ClientesConverter.clienteDtoBuilder(c);

	}

	@Override
	public void inserir(ClientesDto dto) {

		try {
			repository.save(ClientesConverter.clienteBuilder(dto));
		} catch (Exception ex) {
			throw new IllegalArgumentException(ex.getCause().getCause().getMessage());
		}

	}

	@Override
	public void deletar(int id) {

		try {
			repository.deleteById(id);
		}catch (Exception e) {
			throw new ClienteNaoEncontradoException("O cliente número " + id + " não existe");
		}

	}

}
