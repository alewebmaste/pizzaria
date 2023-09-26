package br.com.pizzaria.domain.entity;

import java.time.LocalDate;
import java.util.List;

import br.com.pizzaria.domain.dto.DadosAtualizaCliente;
import br.com.pizzaria.domain.dto.DadosCliente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    @Column(name = "dat_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "dat_cadastro")
    private LocalDate dataCadastro;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCliente dadosCliente) {

        this.nome = dadosCliente.nome();
        this.email = dadosCliente.email();
        this.telefone = dadosCliente.telefone();
        this.dataNascimento = dadosCliente.dataNascimento();
        this.dataCadastro = dadosCliente.dataCadastro();
        this.endereco = new Endereco(dadosCliente.endereco());
        this.dataCadastro = LocalDate.now();
        this.dataNascimento = dadosCliente.dataNascimento();

    }

    public void atualizar(DadosAtualizaCliente dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.email() != null)
            this.email = dados.email();

        if (dados.telefone() != null)
            this.telefone = dados.telefone();

        if (dados.endereco() != null)
            this.endereco.atualizar(dados.endereco());

    }
}
