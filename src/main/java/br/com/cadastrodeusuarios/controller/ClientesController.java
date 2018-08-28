package br.com.cadastrodeusuarios.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodeusuarios.domain.dto.ClientesDto;
import br.com.cadastrodeusuarios.service.ClientesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {

	private final ClientesService service;

	@GetMapping
	List<ClientesDto> buscar() {

		List<ClientesDto> clientes = service.buscar();

		return clientes;
	}

	@GetMapping("/{nome}")
	ClientesDto buscarPorNome(@PathVariable String nome){

		ClientesDto cliente = service.buscarPorNome(nome);

		return cliente;
	}

	@GetMapping("/dataNascimento/{data}")
	ClientesDto buscarPorDataNascimento(@PathVariable @DateTimeFormat(pattern = "ddMMyyyy") LocalDate data) {

		ClientesDto cliente = service.buscaPorDataNascimento(data);

		return cliente;
	}

	@PutMapping
	void inserir(@RequestBody ClientesDto dto) {

		service.inserir(dto);

	}

	@DeleteMapping("/{id}")
	void deletar(@PathVariable int id) {

		service.deletar(id);

	}
	
}
