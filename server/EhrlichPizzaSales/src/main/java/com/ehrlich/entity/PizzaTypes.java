package com.ehrlich.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pizza_types")
public class PizzaTypes {

	@Id
	@Column(name = "pizza_type_id")
	private String pizza_type_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "category")
	private String category;

	@Column(name = "ingredients")
	private String ingredients;

	public String getPizza_type_id() {
		return pizza_type_id;
	}

	public void setPizza_type_id(String pizza_type_id) {
		this.pizza_type_id = pizza_type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
