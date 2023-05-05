package com.ehrlich.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehrlich.entity.Pizzas;
import com.ehrlich.service.PizzaSalesService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/pizza")
public class PizzaSalesController {

	@Autowired
	private PizzaSalesService pizzaSalesService;
	
	@GetMapping("/")
	public String Test(HttpServletRequest req, @RequestHeader("key") String key) {
		
		if (!key.equals("AA123#$")) {
			return "Unauthorized User.";
		}
		
		Optional<Pizzas> p = pizzaSalesService.getPizzas();
		return p.get().getPizza_type_id();
	}
	
}
