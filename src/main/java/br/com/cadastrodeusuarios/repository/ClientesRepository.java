package br.com.cadastrodeusuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodeusuarios.domain.entity.Clientes;
import br.com.cadastrodeusuarios.repository.custom.ClientesRepositoryCustom;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer>,ClientesRepositoryCustom {

}
