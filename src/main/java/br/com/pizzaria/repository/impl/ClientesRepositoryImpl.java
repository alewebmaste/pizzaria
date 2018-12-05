package br.com.pizzaria.repository.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.pizzaria.domain.entity.Cliente;
import br.com.pizzaria.domain.entity.QCliente;
import br.com.pizzaria.repository.custom.ClientesRepositoryCustom;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClientesRepositoryImpl implements ClientesRepositoryCustom {

	private final EntityManager em;

	QCliente cliente = QCliente.cliente;

	@Override
	public Cliente findByNome(String nome) {

		JPAQueryFactory queryFactory = new JPAQueryFactory(em);

		Cliente c = queryFactory.selectFrom(cliente).where(cliente.nome.eq(nome)).fetchOne();

		return c;
	}

	@Override
	public Cliente findByDataNascimento(LocalDate data) {

		JPAQueryFactory queryFactory = new JPAQueryFactory(em);

		try {
			Cliente c = queryFactory.selectFrom(cliente).where(cliente.dataNascimento.eq(data)).fetchOne();
			return c;
		} catch (Exception ex) {
			System.out.println("A data é inválida");
		}

		return null;

	}

}
