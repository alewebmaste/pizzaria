package br.com.pizzaria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.domain.entity.Clientes;
import br.com.pizzaria.repository.custom.ClientesRepositoryCustom;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer>,ClientesRepositoryCustom {

}
