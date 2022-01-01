package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agent {
	
	@Id
	private Long id;
	private String name;
	private String address;
	private Long telephone;
	
	public Agent() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", address=" + address + ", telephone=" + telephone + "]";
	}
	

}
