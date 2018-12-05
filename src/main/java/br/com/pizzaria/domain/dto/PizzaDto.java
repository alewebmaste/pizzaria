package br.com.pizzaria.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PizzaDto {
	
	private String id;
	private String nomes;
	private String ingredientes;
	private String preco;


}
