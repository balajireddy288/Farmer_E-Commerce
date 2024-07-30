package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.dto.OrdersDTO;


@Service
public class OrderService {
	@Autowired
	ProductRepo prodrepo;
	
	@Autowired
	OrderRepo ordrepo;
	
	public Orders buyproduct(OrdersDTO ord) {
		System.out.println("in order buy product" + ord.getProduct_name());
		Product product = prodrepo.findByproduct(ord.getProduct_name());
        int remainingQuantity = Integer.parseInt(product.getQuantity()) - Integer.parseInt(ord.getQuantity());
        System.out.println(product.getQuantity() + remainingQuantity);
        String s=Integer.toString(remainingQuantity);
        System.out.println(s);
        product.setQuantity(s);
        System.out.println(product);
        prodrepo.save(product);

        Orders order=new Orders();
        order.setAddress(ord.getAddress());
        order.setDateTime(ord.getDateTime());
        order.setEmail(ord.getEmail());
        order.setPincode(ord.getPincode());
        order.setPrice(ord.getPrice());
        order.setProduct_name(ord.getProduct_name());
        order.setQuantity(ord.getQuantity());
        order.setStatus(ord.getStatus());
        order.setTotalAmount(ord.getTotalAmount());
        return ordrepo.save(order);
        
        
	}

	

	public List<Orders> getorders() {
		List<Orders> orders=ordrepo.findAll();
		return orders;
	}

	public List<Orders> getorder(String email) {
		List<Orders> order=ordrepo.findByEmail(email);
		return order;
	}

	public Orders confirm(OrdersDTO ord) {
		Orders order = ordrepo.findByemail(ord.getEmail(), ord.getProduct_name(), ord.getDateTime());
        order.setStatus("Delivered");
        return  ordrepo.save(order);
	}


}
