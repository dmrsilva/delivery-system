package com.company.delivery.tests;

import java.time.Instant;

import com.company.delivery.dto.OrderDTO;
import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Order;
import com.company.delivery.entities.Product;
import com.company.delivery.entities.enums.OrderStatus;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(1L, "Bolo", "Bolo de chocolate", "http://bolos.com");
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product);
	}
	
	public static Order createOrder() {
		Order order = new Order(1L, Instant.parse("2022-05-10T18:25:20.12345Z"), OrderStatus.PENDING);
		return order;
	}
	
	public static OrderDTO createOrderDTO() {
		Order order = createOrder();
		return new OrderDTO(order);
	}	
	
}
