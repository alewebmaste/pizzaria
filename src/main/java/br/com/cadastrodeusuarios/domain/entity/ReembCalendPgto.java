package br.com.cadastrodeusuarios.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the REEMB_CALEND_PGTO database table.
 * 
 */
@Entity
@Table(name="REEMB_CALEND_PGTO",schema="OW_REEMBOLSO")
@NamedQuery(name="ReembCalendPgto.findAll", query="SELECT r FROM ReembCalendPgto r")
@Getter
@Setter
public class ReembCalendPgto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_REEM_CALEN_PGT")
	private Long codReemCalenPgt;

	@Column(name="DAT_ALTERACAO")
	private LocalDate datAlteracao;

	@Column(name="DAT_INCLUSAO")
	private LocalDate datInclusao;

	@Column(name="DAT_PAGAMENTO")
	private LocalDate datPagamento;

	@Column(name="DAT_PGT_PRESTIGE")
	private LocalDate datPgtPrestige;

	@Column(name="DAT_PROCESSAMENTO")
	private LocalDate datProcessamento;

	@Column(name="NME_LOGIN")
	private String nmeLogin;

	

}