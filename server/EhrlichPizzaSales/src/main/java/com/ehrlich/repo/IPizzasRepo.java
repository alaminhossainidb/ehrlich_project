package com.ehrlich.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ehrlich.entity.Pizzas;

public interface IPizzasRepo extends JpaRepository<Pizzas, String>{

	@Query(value="Select * from Pizzas", nativeQuery = true)
	List<Pizzas> getPizza(Pageable pageable);

}
