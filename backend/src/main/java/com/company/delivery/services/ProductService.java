package com.company.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Product;
import com.company.delivery.repositories.ProductRepository;

public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findAllProducts() {
		List<Product> products = repository.findAll();
		return products.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	

}
