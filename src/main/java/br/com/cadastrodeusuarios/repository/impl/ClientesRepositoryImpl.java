package br.com.cadastrodeusuarios.repository.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.cadastrodeusuarios.domain.entity.Clientes;
import br.com.cadastrodeusuarios.domain.entity.QClientes;
import br.com.cadastrodeusuarios.repository.custom.ClientesRepositoryCustom;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ClientesRepositoryImpl implements ClientesRepositoryCustom {

	private final EntityManager em;
	
	@Override
	public Clientes findByNome(String nome) {
		
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		
		QClientes cliente = QClientes.clientes;
		
		Clientes c = queryFactory.selectFrom(cliente).where(cliente.nome.eq(nome)).fetchOne();
		
		return c;
	}

	@Override
	public Clientes findByDataNascimento(LocalDate data) {
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		
		QClientes cliente = QClientes.clientes;
		
		Clientes c = queryFactory.selectFrom(cliente).where(cliente.dataNascimento.eq(data)).fetchOne();
		
		return c;
	}

}