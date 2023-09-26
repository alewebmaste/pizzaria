package br.com.pizzaria.domain.dto;

import br.com.pizzaria.domain.entity.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCliente(

        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{telefone.obrigatorio}")
        String telefone,
        @NotNull(message = "{dataNascimento.obrigatorio}")
        LocalDate dataNascimento,
        LocalDate dataCadastro,
        @NotNull(message = "{endereco.obrigatorio}")
        @Valid
        DadosEndereco endereco) {

    public DadosCliente(Cliente cliente) {
        this(cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDataNascimento(),
                cliente.getDataCadastro(),
                new DadosEndereco(cliente.getEndereco()));
    }

}
