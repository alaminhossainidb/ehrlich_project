package com.ehrlich.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehrlich.entity.Pizzas;
import com.ehrlich.repo.IPizzasRepo;

@Service
public class PizzaSalesService {

	@Autowired
	private IPizzasRepo pizzasRepo;
	
	public Optional<Pizzas> getPizzas() {
		
		return pizzasRepo.findById("bbq_ckn_s");
	}

}
