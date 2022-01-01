package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberType {

	@Id
	private Integer id;
	private String name;
	private String description;
	
	public MemberType() {
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
	
	@Override
	public String toString() {
		return "MemberType [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
		
}
