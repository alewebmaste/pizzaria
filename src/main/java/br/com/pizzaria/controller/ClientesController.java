package br.com.pizzaria.controller;

import br.com.pizzaria.domain.dto.DadosAtualizaCliente;
import br.com.pizzaria.domain.dto.DadosCliente;
import br.com.pizzaria.domain.dto.DadosListagemCliente;
import br.com.pizzaria.domain.entity.Cliente;
import br.com.pizzaria.repository.ClientesRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
@SecurityRequirement(name = "bearer-key")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("listar")
    public ResponseEntity listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {

        var clientes = clientesRepository.findAll(paginacao).map(DadosListagemCliente::new);
        return ResponseEntity.ok(clientes);

    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCliente dadosCliente, UriComponentsBuilder uriBuilder) {

        var cliente = new Cliente(dadosCliente);
        clientesRepository.save(cliente);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemCliente(cliente));

    }

	@GetMapping("/{id}")
	public ResponseEntity buscar(@PathVariable Long id) {

        var cliente =  clientesRepository.getReferenceById(id);

		return ResponseEntity.ok(new DadosCliente(cliente));
	}



	@PutMapping
    @Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaCliente dados) {

		var cliente = clientesRepository.getReferenceById(dados.id());
        cliente.atualizar(dados);
        return ResponseEntity.ok(new DadosCliente(cliente));

	}

	@DeleteMapping("/{id}")
    @Transactional
	public ResponseEntity excluir(@PathVariable Long id) {

        var cliente = clientesRepository.findById(id);
        if (cliente.isEmpty())
            return ResponseEntity.notFound().build();

        clientesRepository.deleteById(cliente.get().getId());
		return ResponseEntity.noContent().build();

	}

}
