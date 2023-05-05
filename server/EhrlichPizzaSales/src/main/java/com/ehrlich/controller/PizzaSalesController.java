package com.ehrlich.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ehrlich.entity.Pizzas;
import com.ehrlich.service.PizzaSalesService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/pizza")
public class PizzaSalesController {

	@Autowired
	private PizzaSalesService pizzaSalesService;
	
	@GetMapping("/")
	public String Test(HttpServletRequest req) {
		Optional<Pizzas> p = pizzaSalesService.getPizzas();
		return p.get().getPizza_type_id();
	}
	
}
