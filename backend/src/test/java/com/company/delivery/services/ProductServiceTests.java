package com.company.delivery.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Product;
import com.company.delivery.repositories.ProductRepository;
import com.company.delivery.tests.Factory;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

	@InjectMocks
	private ProductService service;
	
	@Mock
	private ProductRepository repository;
	
	private long existingId;
	private Product product;
	private ProductDTO productDTO;
	private List<Product> list;
	
	@BeforeEach
	void setUp() throws Exception {
		
		existingId = 1L;
		product = Factory.createProduct();
		productDTO = Factory.createProductDTO();
		list = new ArrayList<>(List.of(product));
		
		Mockito.when(repository.findAll()).thenReturn(list);
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(product));
		
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(product);
		
		Mockito.when(repository.getById(existingId)).thenReturn(product);
		
		Mockito.doNothing().when(repository).deleteById(existingId);
	}
	
	@Test
	public void findAllShouldReturnList() {
		
		List<ProductDTO> result = service.findAllProducts();
		
		Assertions.assertNotNull(result);
		
		Mockito.verify(repository).findAll();		
	}
	
	@Test
	void findByIdReturnProductDTOWhenIdExists() {
		
		ProductDTO result = service.findByProductId(existingId);
		
		Assertions.assertNotNull(result);
		
		Mockito.verify(repository).findById(existingId);		
	}
	
	@Test
	public void insertShouldReturnProductDTO() {
		
		ProductDTO result = service.insertProduct(productDTO);
		
		Assertions.assertNotNull(result);

		Mockito.verify(repository).save(any());
	}
	
	@Test
	public void updateReturnProductDTOWhenIdDoesExist() {

		ProductDTO result = service.updateProduct(existingId, productDTO);
		
		Assertions.assertNotNull(result);	
	}

	@Test
	public void deleteShouldDoNothingWhenIdExists() {
		
		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});
		
		Mockito.verify(repository).deleteById(existingId);		
	}
	
}
