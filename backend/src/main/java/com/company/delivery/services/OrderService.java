package com.company.delivery.services;

import java.time.Instant;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.delivery.dto.OrderDTO;
import com.company.delivery.dto.ProductDTO;
import com.company.delivery.entities.Order;
import com.company.delivery.entities.Product;
import com.company.delivery.repositories.OrderRepository;
import com.company.delivery.repositories.ProductRepository;
import com.company.delivery.services.exceptions.DatabaseException;
import com.company.delivery.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public Page<OrderDTO> findAllPagedOrders(Pageable pageable) {
		Page<Order> orders = repository.findAll(pageable);
		return orders.map(x -> new OrderDTO(x, x.getProducts()));
	}

	@Transactional(readOnly = true)
	public OrderDTO findByOrderId(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order order = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new OrderDTO(order, order.getProducts());
	}
	
	@Transactional
	public OrderDTO insertOrder(OrderDTO dto) {
		Order order = new Order();
		copyDtoToEntity(dto, order);
		order = repository.save(order);
		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO updateOrder(Long id, OrderDTO dto) {
		try {
			Order order = repository.getById(id);
			copyDtoToEntity(dto, order);
			order = repository.save(order);
			return new OrderDTO(order);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(OrderDTO dto, Order order) {
		order.setMoment(Instant.now());
		order.setStatus(dto.getStatus());

		for (ProductDTO prodDTO : dto.getProducts()) {
			Product product = productRepository.getById(prodDTO.getId());
			order.getProducts().add(product);
		}
	}

}
