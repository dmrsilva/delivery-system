package com.company.delivery.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.company.delivery.dto.OrderDTO;
import com.company.delivery.services.OrderService;
import com.company.delivery.services.exceptions.DatabaseException;
import com.company.delivery.services.exceptions.ResourceNotFoundException;
import com.company.delivery.tests.Factory;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(OrderResource.class)
public class OrderResourceTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService service;

	@Autowired
	private ObjectMapper objectMapper;

	private long existingId;
	private long nonExistingId;
	private long dependentId;
	private OrderDTO orderDTO;
	private List<OrderDTO> list;

	@BeforeEach
	void setUp() throws Exception {

		existingId = 1L;
		nonExistingId = 2L;
		dependentId = 3L;

		orderDTO = Factory.createOrderDTO();

		when(service.findAllOrders()).thenReturn(list);

		when(service.findByOrderId(existingId)).thenReturn(orderDTO);
		when(service.findByOrderId(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		when(service.insertOrder(any())).thenReturn(orderDTO);

		when(service.updateOrder(eq(existingId), any())).thenReturn(orderDTO);
		when(service.updateOrder(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);

		doNothing().when(service).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
		doThrow(DatabaseException.class).when(service).delete(dependentId);
	}

	@Test
	public void findAllShouldReturnList() throws Exception {

		ResultActions result = mockMvc.perform(get("/orders").accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
	}

	@Test
	public void findByIdShouldReturnOrderWhenIdExists() throws Exception {

		ResultActions result = mockMvc.perform(get("/orders/{id}", existingId).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.moment").exists());
		result.andExpect(jsonPath("$.status").exists());
	}

	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {

		ResultActions result = mockMvc.perform(get("/orders/{id}", nonExistingId).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}

	@Test
	public void insertShouldReturnCreateAndOrderDTO() throws Exception {

		String jsonBody = objectMapper.writeValueAsString(orderDTO);

		ResultActions result = mockMvc.perform(post("/orders").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.moment").exists());
		result.andExpect(jsonPath("$.status").exists());
	}

	@Test
	public void updateShouldReturnOrderDTOWhenIdExists() throws Exception {

		String jsonBody = objectMapper.writeValueAsString(orderDTO);

		ResultActions result = mockMvc.perform(put("/orders/{id}", existingId).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.moment").exists());
		result.andExpect(jsonPath("$.status").exists());
	}

	@Test
	public void updateShouldReturnNotFoundWhenIdDoesNoExists() throws Exception {

		String jsonBody = objectMapper.writeValueAsString(orderDTO);

		ResultActions result = mockMvc.perform(put("/orders/{id}", nonExistingId).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}

	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {

		ResultActions result = mockMvc.perform(delete("/orders/{id}", existingId));

		result.andExpect(status().isNoContent());
	}

	@Test
	public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {

		ResultActions result = mockMvc.perform(delete("/orders/{id}", nonExistingId));

		result.andExpect(status().isNotFound());
	}

}
