package com.ehrlich.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ehrlich.DTO.IOrdersDTO;
import com.ehrlich.entity.Orders;

public interface IOrdersRepo extends JpaRepository<Orders, Long>{

	@Query(value="SELECT o.order_id as orderId, o.date as date, o.time as time, od.order_details_id as orderDetailsId, od.pizza_id as pizzasId, od.quantity as quantity\r\n"
			+ " from orders o, order_details od where o.order_id = od.order_id", nativeQuery = true)
	List<IOrdersDTO> getOrderList(Pageable pageable);

	@Query(value="SELECT o.order_id as orderId, o.date as date, o.time as time, od.order_details_id as orderDetailsId, od.pizza_id as pizzasId, od.quantity as quantity\r\n"
			+ " from orders o, order_details od where o.order_id = od.order_id and o.order_id = :orderId", nativeQuery = true)
	IOrdersDTO findOrderByOrderId(@Param("orderId") Long orderId);

}
