package com.springboot.restful.webservice.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class MemberOrder {

	@Id
	@GeneratedValue
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Member member;
	
	private Float totalAmount;
	private Date orderDate;
	private Timestamp orderTime;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	private Date deliveryDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy="memberOrder", fetch = FetchType.EAGER)
	private List<OrderDetail> orderDetails;
	
	public MemberOrder() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	
		
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	@Override
	public String toString() {
		return "MemberOrder [id=" + id + ", member=" + member + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + ", orderTime=" + orderTime + ", paymentMethod=" + paymentMethod + ", deliveryDate="
				+ deliveryDate + ", orderStatus=" + orderStatus + ", orderDetails=" + orderDetails + "]";
	}

	
}
