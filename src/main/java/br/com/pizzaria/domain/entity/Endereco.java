package br.com.pizzaria.domain.entity;

import br.com.pizzaria.domain.dto.DadosEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String cidade;
    private String uf;
    private String complemento;
    private String cep;
    private String bairro;

    public Endereco(DadosEndereco endereco) {

        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.cep = endereco.cep();
        this.bairro = endereco.bairro();

    }

    public void atualizar(DadosEndereco endereco) {

        if (endereco.logradouro() != null)
            this.logradouro = endereco.logradouro();

        if (endereco.bairro() != null)
            this.bairro = endereco.bairro();

        if (endereco.numero() != null)
            this.numero = endereco.numero();

        if (endereco.cidade() != null)
            this.cidade = endereco.cidade();

        if (endereco.cep() != null)
            this.cep = endereco.cep();

        if (endereco.uf() != null)
            this.uf = endereco.uf();

        if (endereco.complemento()!=null)
            this.complemento = endereco.complemento();

    }
}
