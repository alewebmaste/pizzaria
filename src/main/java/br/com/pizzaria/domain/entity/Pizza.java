package br.com.pizzaria.domain.entity;

import java.math.BigDecimal;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Pizza {

	@Id
	private int id;

	private String nome;

	private String ingredientes;

	private BigDecimal preco;

}
