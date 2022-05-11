package com.company.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.delivery.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
