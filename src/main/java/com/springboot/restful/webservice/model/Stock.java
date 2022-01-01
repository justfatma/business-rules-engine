package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Stock {
	
	@Id
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Product product;
	private Long count;
	
	public Stock() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", product=" + product + ", count=" + count + "]";
	}
	
}
