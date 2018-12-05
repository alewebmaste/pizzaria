package br.com.pizzaria.domain.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@NamedQuery(name = "Cliente.findAll", query = "SELECT e FROM Cliente e")
@Getter
@Setter
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Cliente {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nome_cliente")
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
	
	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedidos> pedidos;

}
