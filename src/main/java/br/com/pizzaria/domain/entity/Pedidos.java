package br.com.pizzaria.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
	
	@Id
	private int id;

	private String valor;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY	)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;	

}
