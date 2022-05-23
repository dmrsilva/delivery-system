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

import com.company.delivery.dto.OrderDTO;
import com.company.delivery.entities.Order;
import com.company.delivery.repositories.OrderRepository;
import com.company.delivery.services.exceptions.DatabaseException;
import com.company.delivery.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAllOrders() {
		List<Order> orders = repository.findAll();
		return orders.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public OrderDTO findByOrderId(Long id) {
		Optional<Order> obj = repository.findById(id);
		Order order = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new OrderDTO(order);
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
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(OrderDTO dto, Order order) {
		order.setMoment(dto.getMoment());
		order.setStatus(dto.getStatus());
	}
	
}
