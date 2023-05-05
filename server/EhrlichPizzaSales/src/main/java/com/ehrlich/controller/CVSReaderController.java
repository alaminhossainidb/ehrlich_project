package com.ehrlich.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ehrlich.entity.OrderDetails;
import com.ehrlich.entity.Orders;
import com.ehrlich.entity.PizzaTypes;
import com.ehrlich.entity.Pizzas;
import com.ehrlich.repo.IOrderDetailsRepo;
import com.ehrlich.repo.IOrdersRepo;
import com.ehrlich.repo.IPizzaTypesRepo;
import com.ehrlich.repo.IPizzasRepo;
import com.ehrlich.utils.CSVUtils;

@RestController
@RequestMapping(value = "/csv/read")
public class CVSReaderController {

	@Autowired
	private IPizzasRepo pizzasRepo;
	
	@Autowired
	private IPizzaTypesRepo pizzaTypesRepo;
	
	@Autowired
	private IOrdersRepo ordersRepo;
	
	@Autowired
	private IOrderDetailsRepo orderDetailsRepo;
	
	@PostMapping(value="/pizza",  consumes = "multipart/form-data")
	public String CVSReader(@RequestParam("file") MultipartFile file) {
		try {
			List<Pizzas> pizzas = pizzasRepo.saveAll(CSVUtils.readFile(Pizzas.class, file.getInputStream()));
			
			if (pizzas.size() > 0) {

				return "Success";
			}else {
				return "Failed to read file!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to read file!";
		}
		
	}
	
	@PostMapping(value="/pizza_type",  consumes = "multipart/form-data")
	public String CVSReaderPizzaType(@RequestParam("file") MultipartFile file) {
		try {
			List<PizzaTypes> pizzaTypes = pizzaTypesRepo.saveAll(CSVUtils.readFile(PizzaTypes.class, file.getInputStream()));
			
			if (pizzaTypes.size() > 0) {

				return "Success";
			}else {
				return "Failed to read file!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to read file!";
		}
		
	}
	
	@PostMapping(value="/orders",  consumes = "multipart/form-data")
	public String CVSReaderOrders(@RequestParam("file") MultipartFile file) {
		try {
			List<Orders> orders = ordersRepo.saveAll(CSVUtils.readFile(Orders.class, file.getInputStream()));
			
			if (orders.size() > 0) {

				return "Success";
			}else {
				return "Failed to read file!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to read file!";
		}
		
	}
	
	@PostMapping(value="/orders_details",  consumes = "multipart/form-data")
	public String CVSReaderOrdersDetails(@RequestParam("file") MultipartFile file) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			
			List<OrderDetails> orderDetails = orderDetailsRepo.saveAll(CSVUtils.readFile(OrderDetails.class, file.getInputStream()));
			
			if (orderDetails.size() > 0) {

				return "Success";
			}else {
				return "Failed to read file!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to read file!";
		}
		
	}
}
