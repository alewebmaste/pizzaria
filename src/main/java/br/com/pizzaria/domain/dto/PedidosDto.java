package br.com.pizzaria.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PedidosDto {
	
	private int idPedido;
	private String valor;

}
