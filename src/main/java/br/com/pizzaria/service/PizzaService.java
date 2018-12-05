package br.com.pizzaria.service;

import java.util.List;

import br.com.pizzaria.domain.dto.PizzaDto;

public interface PizzaService {

	List<PizzaDto> buscar();
	
}
