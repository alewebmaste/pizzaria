package br.com.cadastrodeusuarios.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@NamedQuery(name = "Clientes.findAll", query = "SELECT e FROM Clientes e")
@Getter
@Setter
@Builder
public class Clientes {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "cadastro")
	private LocalDate cadastro;

}
