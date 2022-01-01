package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private ProductSubGroup productSubGroup;
	private String name;
	private String description;
	private Float price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Agent agent;
	private Float agentCommissionRate;
	private boolean needFirstAidVideo;
	private Long stockCount;
	
	public Product() {
		super();
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getAgentCommissionRate() {
		return agentCommissionRate;
	}
	public void setAgentCommissionRate(Float agentCommissionRate) {
		this.agentCommissionRate = agentCommissionRate;
	}
	public boolean isNeedFirstAidVideo() {
		return needFirstAidVideo;
	}
	public void setNeedFirstAidVideo(boolean needFirstAidVideo) {
		this.needFirstAidVideo = needFirstAidVideo;
	}

	public ProductSubGroup getProductSubGroup() {
		return productSubGroup;
	}

	public void setProductSubGroup(ProductSubGroup productSubGroup) {
		this.productSubGroup = productSubGroup;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public Long getStockCount() {
		return stockCount;
	}

	public void setStockCount(Long stockCount) {
		this.stockCount = stockCount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productSubGroup=" + productSubGroup + ", name=" + name + ", description="
				+ description + ", price=" + price + ", agent=" + agent + ", agentCommissionRate=" + agentCommissionRate
				+ ", needFirstAidVideo=" + needFirstAidVideo + ", stockCount=" + stockCount + "]";
	}

}
