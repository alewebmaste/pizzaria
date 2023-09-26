package br.com.pizzaria.domain.dto;

import br.com.pizzaria.domain.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "{logradouro.obrigatorio}")
        String logradouro,
        @NotBlank(message = "{numero.obrigatorio}")
        String numero,
        @NotBlank(message = "{bairro.obrigatorio}")
        String bairro,
        @NotBlank(message = "{cidade.obrigatorio}")
        String cidade,
        @NotBlank(message = "{uf.obrigatorio}")
        String uf,
        @NotBlank(message = "{cep.obrigatorio}")
        @Pattern(regexp = "\\d{8}")
        String cep,
        String complemento
) {

    public DadosEndereco(Endereco endereco) {
        this(endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep(),
                endereco.getComplemento());
    }
}
