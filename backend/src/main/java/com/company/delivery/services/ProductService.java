package com.company.delivery.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Product;
import com.company.delivery.repositories.ProductRepository;

public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAllProducts() {
		List<Product> products = repository.findAll();
		return products.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ProductDTO findByProductId(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product product = obj.get();
		return new ProductDTO(product);
	}

	@Transactional
	public ProductDTO insertProduct(ProductDTO dto) {
		Product product = new Product();
		copyDtoToEntity(dto, product);
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	@Transactional
	public ProductDTO updateProduct(Long id, ProductDTO dto) {
		Product product = repository.getById(id);
		copyDtoToEntity(dto, product);
		product = repository.save(product);
		return new ProductDTO(product);
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product product) {
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setImgUri(dto.getImgUri());
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
