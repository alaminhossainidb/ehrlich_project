package com.ehrlich.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
public class CSVReaderController {

	@Autowired
	private IPizzasRepo pizzasRepo;
	
	@Autowired
	private IPizzaTypesRepo pizzaTypesRepo;
	
	@Autowired
	private IOrdersRepo ordersRepo;
	
	@Autowired
	private IOrderDetailsRepo orderDetailsRepo;
	
	@PostMapping(value="/pizza",  consumes = "multipart/form-data")
	public String CVSReader(@RequestHeader("key") String key, @RequestParam("file") MultipartFile file) {
		
		if (!key.equals("AA123#$")) {
			return "Unauthorized User.";
		}
		
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
	public String CVSReaderPizzaType(@RequestHeader("key") String key,@RequestParam("file") MultipartFile file) {
		
		if (!key.equals("AA123#$")) {
			return "Unauthorized User.";
		}
		
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
	public String CVSReaderOrders(@RequestHeader("key") String key,@RequestParam("file") MultipartFile file) {
		
		if (!key.equals("AA123#$")) {
			return "Unauthorized User.";
		}
		
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
	public String CVSReaderOrdersDetails(@RequestHeader("key") String key,@RequestParam("file") MultipartFile file) {
		
		if (!key.equals("AA123#$")) {
			return "Unauthorized User.";
		}
		
		try {
			
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
