package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;


@Service
public class ProdService {
	
	@Autowired
	ProductRepo prodrepo;

	public Product createProduct(ProductDTO pdo) {
		
		Product p=new Product();
		p.setCategory(pdo.getCategory());
		p.setEmail(pdo.getEmail());
		p.setExpiration_date(pdo.getExpiration_date());
		p.setImage(pdo.getImage());
		p.setPrice(pdo.getPrice());
		p.setProduced_date(pdo.getProduced_date());
		p.setProduct_name(pdo.getProduct_name());
		p.setQuantity(pdo.getQuantity());
		return prodrepo.save(p);
	}

	public List<Product> getProduct() {
		
			List<Product> p=prodrepo.findall();
			for (Product product : p) {
			    System.out.println(product.getCategory());
			}

			System.out.print(p);
			return p;
	}

	public Product editProduct(ProductDTO pdo) {
		 Product p = prodrepo.findByproduct(pdo.getProduct_name());
		 p.setPrice(pdo.getPrice());
		 p.setQuantity(pdo.getQuantity());
		 p.setExpiration_date(pdo.getExpiration_date());
		 p.setProduced_date(pdo.getProduced_date());
		 return prodrepo.save(p);
	}

	

	public Product searchProduct(String opt) {
		
		return prodrepo.findByproduct(opt);
	}

	public List<Product> getCategory(String opt) {
		// TODO Auto-generated method stub
		List<Product> p=prodrepo.findByCategory(opt);
		return p;
	}

	public List<Product> searchProducts(String opt) {
		List<Product> p=prodrepo.findByProduct_name(opt);
		return p;
	}

}
