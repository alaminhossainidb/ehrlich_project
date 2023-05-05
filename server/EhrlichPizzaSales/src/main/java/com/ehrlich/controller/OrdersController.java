package com.ehrlich.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehrlich.DTO.IOrdersDTO;
import com.ehrlich.entity.Orders;
import com.ehrlich.entity.Pizzas;
import com.ehrlich.service.OrdersService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/order")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/save")
	public String save(HttpServletRequest req, @RequestHeader("key") String key, @RequestBody Orders orders) {
		
		if (!key.equals("AA123#$")) {
			return "Unauthorized User.";
		}
		
		return ordersService.save(orders);
	}
	
	@GetMapping("/get/orders/list")
	public List<IOrdersDTO> getOrderList(HttpServletRequest req, @RequestHeader("key") String key,
		@RequestHeader("page") int page, @RequestHeader("size") int size) {
		
		if (!key.equals("AA123#$")) {
			return null;
		}
		
		return ordersService.getOrdersList(page, size);
	}
	
	@GetMapping("/get/order")
	public IOrdersDTO getOrder(HttpServletRequest req, @RequestHeader("key") String key,@RequestHeader("orderId") Long orderId ) {
		
		if (!key.equals("AA123#$")) {
			return null;
		}
		return ordersService.getOrder(orderId);
	}
}
