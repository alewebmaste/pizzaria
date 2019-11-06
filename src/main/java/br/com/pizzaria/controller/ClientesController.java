package br.com.pizzaria.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzaria.domain.dto.ClientesDto;
import br.com.pizzaria.domain.entity.Cliente;
import br.com.pizzaria.service.ClientesService;
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
	ClientesDto buscarPorNome(@PathVariable String nome) {

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
	
	
	
	@GetMapping("/pag")
    public ResponseEntity<List<Cliente>> getAllClientesPaginados(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) 
    {
        List<Cliente> list = service.getAllClientes(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK); 
    }	
	
}
