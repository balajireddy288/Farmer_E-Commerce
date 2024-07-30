package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
	@Query("select p from Orders p where LOWER(p.email) = LOWER(:email)")
	List<Orders> findByEmail(@Param("email") String email);

	@Query("select p from Orders p where LOWER(p.email) = LOWER(:email) AND LOWER(p.product_name) = LOWER(:product_name) AND p.dateTime = :dateTime")
	Orders findByemail(@Param("email") String email,@Param("product_name") String product_name,@Param("dateTime") String dateTime);

	
}
