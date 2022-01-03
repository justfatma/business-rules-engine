package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetail {
	
	@Id
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private MemberOrder memberOrder;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Product product;
	private Long orderCount;
	private Float amount;
	private Float agentCommissionAmount;
	
	public OrderDetail() {
		super();
	}

	public void setMemberOrder(MemberOrder order) {
		this.memberOrder = order;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", memberOrder=" + memberOrder + ", product=" + product + ", orderCount="
				+ orderCount + ", amount=" + amount + ", agentCommissionAmount=" + agentCommissionAmount + "]";
	}
	

}
