package com.springboot.restful.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restful.webservice.model.MemberOrder;
import com.springboot.restful.webservice.serviceimpl.MemberOrderServiceImpl;

@RestController
public class OrderManagementController {

	@Autowired
	private MemberOrderServiceImpl memberOrderServiceImpl;
	
	@GetMapping("/orders")
    public List<MemberOrder> getOrders() {	
    	List<MemberOrder> memberOrderList= memberOrderServiceImpl.getMemberOrderList();
    	if (memberOrderList!= null && memberOrderList.size()>0) {
    		return memberOrderList;
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
    	}
    }
	
	@GetMapping("/orders/{orderId}")
	public MemberOrder getOrderById(@PathVariable Long orderId) {
				
		return Optional.ofNullable(memberOrderServiceImpl.getMemberOrderById(orderId))
    			.get()
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
    @PostMapping("/order")
    public String addMemberOrder(@RequestBody MemberOrder memberOrder) {
    	
    	Long addedOrderId= memberOrderServiceImpl.addMemberOrder(memberOrder);
    	return "Order created successfully. Order Id: " + addedOrderId;
    }
}
