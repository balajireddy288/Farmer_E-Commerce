package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProdService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProdController {
	
	@Autowired
	ProdService prodser;
	
	@PostMapping("/post")
	public  ResponseEntity<?> CreateProduct (@RequestBody ProductDTO pdo )
	{
	
		try {
			Product prod=prodser.createProduct(pdo);
			 return ResponseEntity.status(201).body(prod);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}
	
	@GetMapping("/post")
	public  ResponseEntity<?> GetProduct ()
	{
	
		try {
			List<Product> prod=prodser.getProduct();
			 return ResponseEntity.status(201).body(prod);
			
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
	}
	
	@GetMapping("/post/{opt}")
	public  ResponseEntity<?> GetProduct (@PathVariable("opt") String opt)
	{
	
		try {
			List<Product> prod=prodser.getCategory(opt);
			 return ResponseEntity.status(201).body(prod);
			
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
	}
	
	
	@PostMapping("/edit")
	public  ResponseEntity<?> EditProduct (@RequestBody ProductDTO pdo )
	{
		try {
			Product prod=prodser.editProduct(pdo);
			 return ResponseEntity.status(201).body(prod);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}
	
	@GetMapping("/buy/{opt}")
	public  ResponseEntity<?> buyProduct (@PathVariable("opt") String opt )
	{
		try {
			Product prod=prodser.searchProduct(opt);
			 return ResponseEntity.status(201).body(prod);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}

  
	
	@GetMapping("/search/{opt}")
	public  ResponseEntity<?> SearchProduct (@PathVariable("opt") String opt )
	{
		try {
			List<Product> prod= prodser.searchProducts(opt);
			 return ResponseEntity.status(201).body(prod);
		}catch (IllegalArgumentException e) {
            return ResponseEntity.status(422).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
		
	}




}
