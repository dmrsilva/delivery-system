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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.company.delivery.dto.ProductDTO;
import com.company.delivery.services.ProductService;
import com.company.delivery.services.exceptions.DatabaseException;
import com.company.delivery.services.exceptions.ResourceNotFoundException;
import com.company.delivery.tests.Factory;
import com.company.delivery.tests.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductResourceTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService service;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private TokenUtil tokenUtil;

	private long existingId;
	private long nonExistingId;
	private long dependentId;
	private ProductDTO productDTO;
	private List<ProductDTO> list;
	
	private String username;
	private String password;

	@BeforeEach
	void setUp() throws Exception {
		
		username = "maria@gmail.com";
		password = "123456";

		existingId = 1L;
		nonExistingId = 2L;
		dependentId = 3L;

		productDTO = Factory.createProductDTO();

		when(service.findAllProducts()).thenReturn(list);

		when(service.findByProductId(existingId)).thenReturn(productDTO);
		when(service.findByProductId(nonExistingId)).thenThrow(ResourceNotFoundException.class);

		when(service.insertProduct(any())).thenReturn(productDTO);

		when(service.updateProduct(eq(existingId), any())).thenReturn(productDTO);
		when(service.updateProduct(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);

		doNothing().when(service).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
		doThrow(DatabaseException.class).when(service).delete(dependentId);
	}

	@Test
	public void findAllShouldReturnList() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		ResultActions result =
				mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + accessToken));

		result.andExpect(status().isOk());
	}

	@Test
	public void findByIdShouldReturnProductWhenIdExists() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		ResultActions result =
				mockMvc.perform(get("/products/{id}", existingId).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + accessToken));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.name").exists());
		result.andExpect(jsonPath("$.description").exists());
		result.andExpect(jsonPath("$.price").exists());
	}

	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		ResultActions result =
				mockMvc.perform(get("/products/{id}", nonExistingId).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + accessToken));

		result.andExpect(status().isNotFound());
	}

	@Test
	public void insertShouldReturnCreateAndProductDTO() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		String jsonBody = objectMapper.writeValueAsString(productDTO);

		ResultActions result = mockMvc.perform(post("/products")
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isCreated());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.name").exists());
		result.andExpect(jsonPath("$.description").exists());
		result.andExpect(jsonPath("$.price").exists());
	}

	@Test
	public void updateShouldReturnProductDTOWhenIdExists() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		String jsonBody = objectMapper.writeValueAsString(productDTO);

		ResultActions result = mockMvc.perform(put("/products/{id}", existingId)
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").exists());
		result.andExpect(jsonPath("$.name").exists());
		result.andExpect(jsonPath("$.description").exists());
		result.andExpect(jsonPath("$.price").exists());
	}

	@Test
	public void updateShouldReturnNotFoundWhenIdDoesNoExists() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		String jsonBody = objectMapper.writeValueAsString(productDTO);

		ResultActions result = mockMvc.perform(put("/products/{id}", nonExistingId)
				.header("Authorization", "Bearer " + accessToken)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}

	@Test
	public void deleteShouldReturnNoContentWhenIdExists() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		ResultActions result =
					mockMvc.perform(delete("/products/{id}", existingId)
					.header("Authorization", "Bearer " + accessToken));

		result.andExpect(status().isNoContent());
	}

	@Test
	public void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
		
		String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

		ResultActions result =
					mockMvc.perform(delete("/products/{id}", nonExistingId)
					.header("Authorization", "Bearer " + accessToken));

		result.andExpect(status().isNotFound());
	}

}
