package com.company.delivery.tests;

import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(1L, "Bolo", "Bolo de chocolate", "http://bolos.com");
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product);
	}
	
}
