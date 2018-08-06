package br.com.cadastrodeusuarios.domain.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientesDto {

	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private LocalDate dataNascimento;

}
