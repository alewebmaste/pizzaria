package br.com.cadastrodeusuarios.domain.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReembCalendPgtoDto {
	
	private Long codReemCalenPgt;
	private LocalDate datAlteracao;
	private LocalDate datInclusao;
	private LocalDate datPagamento;
	private LocalDate datPgtPrestige;
	private LocalDate datProcessamento;
	private String nmeLogin;

}
