package com.company.delivery.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Product;
import com.company.delivery.repositories.ProductRepository;
import com.company.delivery.services.exceptions.DatabaseException;
import com.company.delivery.services.exceptions.ResourceNotFoundException;

@Service
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
		Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
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
		try {
			Product product = repository.getById(id);
			copyDtoToEntity(dto, product);
			product = repository.save(product);
			return new ProductDTO(product);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product product) {
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setImgUri(dto.getImgUri());
	}
	
}
