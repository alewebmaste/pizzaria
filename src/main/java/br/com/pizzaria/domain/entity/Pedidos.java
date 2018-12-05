package br.com.pizzaria.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@NamedQuery(name = "Pedidos.findAll", query = "SELECT e FROM Pedidos e")
@Getter
@Setter
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Pedidos {
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "valor")
	private String valor;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY	)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;	

}
