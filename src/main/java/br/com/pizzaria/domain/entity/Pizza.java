package br.com.pizzaria.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Pizza {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "ingredientes")
	private String ingredientes;

	@Column(name = "preco")
	private BigDecimal preco;

}
