package com.company.delivery.services;

import static org.mockito.ArgumentMatchers.any;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.company.delivery.dto.OrderDTO;
import com.company.delivery.entities.Order;
import com.company.delivery.repositories.OrderRepository;
import com.company.delivery.services.exceptions.DatabaseException;
import com.company.delivery.services.exceptions.ResourceNotFoundException;
import com.company.delivery.tests.Factory;

@ExtendWith(SpringExtension.class)
public class OrderServiceTests {

	@InjectMocks
	private OrderService service;

	@Mock
	private OrderRepository repository;

	private long existingId;
	private long nonExistingId;
	private long dependentId;
	private Order order;
	private OrderDTO orderDTO;
	private PageImpl<Order> page;

	@BeforeEach
	void setUp() throws Exception {

		existingId = 1L;
		nonExistingId = 2L;
		dependentId = 3L;
		order = Factory.createOrder();
		orderDTO = Factory.createOrderDTO();
		page = new PageImpl<>(List.of(order));

		Mockito.when(repository.findAll((Pageable)ArgumentMatchers.any())).thenReturn(page);

		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(order));

		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(order);

		Mockito.when(repository.getById(existingId)).thenReturn(order);

		Mockito.when(repository.getById(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		Mockito.doNothing().when(repository).deleteById(existingId);

		Mockito.doThrow(ResourceNotFoundException.class).when(repository).deleteById(nonExistingId);

		Mockito.doThrow(DatabaseException.class).when(repository).deleteById(dependentId);
	}

	@Test
	public void findAllPagedShouldReturnPage() {

		Pageable pageable = PageRequest.of(0, 5);
		
		Page<OrderDTO> result = service.findAllPagedOrders(pageable);
		
		Assertions.assertNotNull(result);
		Mockito.verify(repository).findAll(pageable);

	}

	@Test
	public void findByIdReturnOrderDTOWhenIdExists() {

		OrderDTO result = service.findByOrderId(existingId);

		Assertions.assertNotNull(result);

		Mockito.verify(repository).findById(existingId);
	}

	@Test
	public void findByIdThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findByOrderId(nonExistingId);
		});
	}

	@Test
	public void insertShouldReturnOrderDTO() {

		OrderDTO result = service.insertOrder(orderDTO);

		Assertions.assertNotNull(result);

		Mockito.verify(repository).save(any());
	}

	@Test
	public void updateReturnOrderDTOWhenIdDoesExist() {

		OrderDTO result = service.updateOrder(existingId, orderDTO);

		Assertions.assertNotNull(result);

		Mockito.verify(repository).getById(existingId);
		Mockito.verify(repository).save(any());
	}

	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.updateOrder(nonExistingId, orderDTO);
		});
	}

	@Test
	public void deleteShouldDoNothingWhenIdExists() {

		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});

		Mockito.verify(repository).deleteById(existingId);
	}

	@Test
	public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.delete(nonExistingId);
		});

		Mockito.verify(repository).deleteById(nonExistingId);
	}

	@Test
	public void deleteShouldThrowDatabaseExceptionWhenDependentId() {

		Assertions.assertThrows(DatabaseException.class, () -> {
			service.delete(dependentId);
		});

		Mockito.verify(repository).deleteById(dependentId);
	}

}
