package br.com.pizzaria.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.pizzaria.domain.dto.ClientesDto;
import br.com.pizzaria.domain.dto.RelatorioClientesDto;
import br.com.pizzaria.domain.entity.Cliente;
import br.com.pizzaria.domain.exception.ClienteNaoEncontradoException;
import br.com.pizzaria.repository.ClientesRepository;
import br.com.pizzaria.service.ClientesService;
import br.com.pizzaria.util.ClientesConverter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientesServiceImpl implements ClientesService {
	
	@Autowired
	ServletContext context;

	private final ClientesRepository repository;
	
	int total = 0;

	@Override
	public RelatorioClientesDto buscar(Integer pageNo, Integer pageSize, String sortBy, StringBuffer url) {		
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		total = 0;
		
		repository.findAll().forEach(c -> total++);		
		 
		Page<Cliente> todosClientes = repository.findAll(paging);		

		List<ClientesDto> clientes = new ArrayList<>();
		
		todosClientes.forEach( c -> clientes.add(ClientesConverter.clienteDtoBuilder(c)));
			
	    RelatorioClientesDto relatorioClientes = new RelatorioClientesDto();
	     
	    relatorioClientes.setClientes(clientes);
	    relatorioClientes.setTotalPaginas(todosClientes.getTotalPages());
	    relatorioClientes.setPaginaAtual(pageNo + 1); 
	    relatorioClientes.setTotalElements(total);
     
	    relatorioClientes.setPrimeiraPag(url + "?pageNo=0&pageSize=" + pageSize);
			
		if(pageNo == 0) {
			relatorioClientes.setPagAnterior(null);			
		}else {			
			relatorioClientes.setPagAnterior(url + "?pageNo=" + (pageNo - 1) +"&pageSize=" + pageSize);			
		}
		
		int ultimaPagina = (relatorioClientes.getTotalElements() / pageSize) - 1;
		
		if(relatorioClientes.getPaginaAtual() != relatorioClientes.getTotalPaginas()) {
			relatorioClientes.setProximaPag(url + "?pageNo=" + (pageNo + 1) +"&pageSize=" + pageSize);
		}else {
			relatorioClientes.setProximaPag(null);
		}
		
		relatorioClientes.setUltimaPag(url + "?pageNo=" + ultimaPagina +"&pageSize=" + pageSize);	     

		return relatorioClientes;

	}
	
	
	@Override
	public ClientesDto buscarPorNome(String nome) {

		Cliente c = repository.findByNome(nome);

		if (c == null) {
			throw new ClienteNaoEncontradoException("O cliente " + nome + " não existe");
		}	

		return ClientesConverter.clienteDtoBuilder(c);
	}

	@Override
	public ClientesDto buscaPorDataNascimento(LocalDate data) {

		Cliente c = repository.findByDataNascimento(data);

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
