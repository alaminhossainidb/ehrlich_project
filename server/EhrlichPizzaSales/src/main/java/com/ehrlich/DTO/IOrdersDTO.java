package com.ehrlich.DTO;

import java.sql.Date;
import java.sql.Time;

public interface IOrdersDTO {
	
	public String getOrderId();
	public Date getDate();
	public Time getTime();
	public String getOrderDetailsId();
	public String getPizzasId();
	public int getQuantity();
}
