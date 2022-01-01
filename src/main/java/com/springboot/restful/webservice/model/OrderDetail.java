package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetail {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Product product;
	private Long orderCount;
	private Float amount;
	private Float agentCommissionAmount;
	
	public OrderDetail() {
		super();
	}

	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getAgentCommissionAmount() {
		return agentCommissionAmount;
	}

	public void setAgentCommissionAmount(Float agentCommissionAmount) {
		this.agentCommissionAmount = agentCommissionAmount;
	}


	@Override
	public String toString() {
		return "OrderDetail [order=" + order + ", product=" + product + ", orderCount=" + orderCount + ", amount="
				+ amount + ", agentCommissionAmount=" + agentCommissionAmount + "]";
	}
	
}
