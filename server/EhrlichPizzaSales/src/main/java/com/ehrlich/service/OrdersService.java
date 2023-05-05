package com.ehrlich.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ehrlich.DTO.IOrdersDTO;
import com.ehrlich.entity.OrderDetails;
import com.ehrlich.entity.Orders;
import com.ehrlich.repo.IOrderDetailsRepo;
import com.ehrlich.repo.IOrdersRepo;

@Service
public class OrdersService {

	@Autowired
	private IOrdersRepo ordersRepo;
	
	@Autowired
	private IOrderDetailsRepo orderDetailsRepo;
	
	public String save(Orders orders) {
		
		try {
			
			long millis=System.currentTimeMillis();  
			
			orders.setDate(new java.sql.Date(millis));
			orders.setTime(java.sql.Time.valueOf(LocalTime.now()));
			
			OrderDetails ordersDetails = orders.getOrderDetails();
			
			Orders ordrs = ordersRepo.save(orders);
			
			ordersDetails.setOrder_id(ordrs.getOrder_id());
			
			OrderDetails orderDtls = orderDetailsRepo.save(ordersDetails);
			
			return "Saving Success";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<IOrdersDTO> getOrdersList(int page, int size) {
	
		try {
			Pageable pageable = PageRequest.of(page, size);
			List<IOrdersDTO> orderList = ordersRepo.getOrderList(pageable);
			return orderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public IOrdersDTO getOrder(Long orderId) {
		try {
			return ordersRepo.findOrderByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
