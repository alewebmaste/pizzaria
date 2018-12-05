package br.com.pizzaria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaria.domain.entity.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer>{

}
