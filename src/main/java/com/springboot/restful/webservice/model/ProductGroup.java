package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductGroup {
	
	@Id
	private Integer id;
	private String name;
	private String description;
	private boolean isPhysical;
	
	public ProductGroup() {
		super();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public boolean isPhysical() {
		return isPhysical;
	}

	public void setPhysical(boolean isPhysical) {
		this.isPhysical = isPhysical;
	}


	@Override
	public String toString() {
		return "ProductGroup [id=" + id + ", name=" + name + ", description=" + description + ", isPhysical="
				+ isPhysical + "]";
	}
	
}
