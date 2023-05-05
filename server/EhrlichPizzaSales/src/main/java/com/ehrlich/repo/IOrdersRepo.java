package com.ehrlich.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehrlich.entity.Orders;

public interface IOrdersRepo extends JpaRepository<Orders, Long>{

}
