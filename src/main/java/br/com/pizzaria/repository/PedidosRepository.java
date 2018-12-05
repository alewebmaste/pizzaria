package br.com.pizzaria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.domain.entity.Pedidos;

@Repository
public interface PedidosRepository extends CrudRepository<Pedidos, Integer> {

}
