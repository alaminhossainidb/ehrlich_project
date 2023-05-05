package com.ehrlich.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_details_id")
	private Long order_details_id;
	
	@Column(name = "order_id")
	private Long order_id;
	
	@Column(name = "pizza_id")
	private String pizza_id;
	
	@Column(name = "quantity")
	private int quantity;

	public Long getOrder_details_id() {
		return order_details_id;
	}

	public void setOrder_details_id(Long order_details_id) {
		this.order_details_id = order_details_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getPizza_id() {
		return pizza_id;
	}

	public void setPizza_id(String pizza_id) {
		this.pizza_id = pizza_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
