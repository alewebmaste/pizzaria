package br.com.pizzaria.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pizzaria.domain.dto.PizzaDto;
import br.com.pizzaria.service.PizzaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
	
	//private final PizzaRepository repository;

	@Override
	public List<PizzaDto> buscar() {
		return null;
	}
	
	

}
