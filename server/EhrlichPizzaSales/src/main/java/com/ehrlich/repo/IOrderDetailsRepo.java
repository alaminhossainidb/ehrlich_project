package com.ehrlich.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrlich.entity.OrderDetails;

public interface IOrderDetailsRepo extends JpaRepository<OrderDetails, Long>{

}
