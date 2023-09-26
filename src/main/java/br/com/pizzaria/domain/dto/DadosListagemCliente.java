package br.com.pizzaria.domain.dto;

import br.com.pizzaria.domain.entity.Cliente;

public record DadosListagemCliente(Long id, String nome, String email, String telefone) {

    public DadosListagemCliente(Cliente cliente){

        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());


    }

}
