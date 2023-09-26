package br.com.pizzaria.domain.dto;

public record DadosAtualizaCliente(Long id, String nome, String email, String telefone, DadosEndereco endereco) {
}
