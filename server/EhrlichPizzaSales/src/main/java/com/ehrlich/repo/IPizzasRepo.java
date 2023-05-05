package com.ehrlich.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrlich.entity.Pizzas;

public interface IPizzasRepo extends JpaRepository<Pizzas, String>{

}
