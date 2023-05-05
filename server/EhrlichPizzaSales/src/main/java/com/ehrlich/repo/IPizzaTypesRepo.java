package com.ehrlich.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrlich.entity.PizzaTypes;

public interface IPizzaTypesRepo extends JpaRepository<PizzaTypes, String>{

}
