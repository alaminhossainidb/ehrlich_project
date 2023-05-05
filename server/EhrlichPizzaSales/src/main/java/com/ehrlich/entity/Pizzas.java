package com.ehrlich.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pizzas")
public class Pizzas {

	@Id
	@Column(name = "pizza_id")
	private String pizza_id;
	
	@Column(name = "pizza_type_id")
	private String pizza_type_id;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "price")
	private Double price;

	public String getPizza_id() {
		return pizza_id;
	}

	public void setPizza_id(String pizza_id) {
		this.pizza_id = pizza_id;
	}

	public String getPizza_type_id() {
		return pizza_type_id;
	}

	public void setPizza_type_id(String pizza_type_id) {
		this.pizza_type_id = pizza_type_id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
