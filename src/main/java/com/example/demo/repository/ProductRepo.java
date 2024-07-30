package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

	@Query(value="select p from Product p where LOWER(p.product_name) = LOWER(:product_name)")
	Product findByproduct(@Param("product_name") String product_name);

	@Query("select p from Product p")
	List<Product> findall();

	List<Product> findByCategory(String opt);

	@Query(value="select p from Product p where LOWER(p.product_name) = LOWER(:product_name)")
	List<Product> findByProduct_name(@Param("product_name")String product_name);



}
