package br.com.pizzaria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.domain.entity.Cliente;
import br.com.pizzaria.repository.custom.ClientesRepositoryCustom;

@Repository
public interface ClientesRepository extends PagingAndSortingRepository<Cliente, Integer> ,CrudRepository<Cliente, Integer>,ClientesRepositoryCustom {

}
