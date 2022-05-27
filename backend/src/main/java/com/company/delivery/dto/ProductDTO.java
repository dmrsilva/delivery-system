package com.company.delivery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.company.delivery.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	private String description;
	private String imgUri;
	
	public ProductDTO() {
	}
	
	public ProductDTO(Long id, String name, String description, String imgUri) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imgUri = imgUri;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		imgUri = entity.getImgUri();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}	
	
}
