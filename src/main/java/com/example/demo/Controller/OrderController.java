package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrdersDTO;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrderService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	
	@Autowired
	OrderService ordser;
	
	@PostMapping("/buy")
	public  ResponseEntity<?> buyProduct (@RequestBody OrdersDTO ord )
	{
		System.out.println("In buying");
		try {
			 Orders order=ordser.buyproduct(ord);
			 return ResponseEntity.status(201).body(order);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}
	@GetMapping("/orders")
	public  ResponseEntity<?> getOrders( )
	{
		try {
			List<Orders> orders=ordser.getorders();
			 return ResponseEntity.status(201).body(orders);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}

	@GetMapping("/orders/{email}")
	public  ResponseEntity<?> getOrder(@PathVariable String email )
	{
		try {
			List<Orders> order=ordser.getorder(email);
			 return ResponseEntity.status(201).body(order);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}
	
	@PostMapping("/updateConfirm")
	public  ResponseEntity<?> confirm(@RequestBody OrdersDTO ord )
	{
		try {
			Orders order=ordser.confirm(ord);
			 return ResponseEntity.status(201).body(order);	
		
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}


	
}
