package com.springboot.restful.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restful.webservice.model.MemberOrder;
import com.springboot.restful.webservice.model.Product;
import com.springboot.restful.webservice.serviceimpl.MemberOrderServiceImpl;
import com.springboot.restful.webservice.serviceimpl.ProductServiceImpl;

@RestController
public class OrderManagementController {

	@Autowired
	private MemberOrderServiceImpl memberOrderServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
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
    
    @GetMapping("/products")
    public List<Product> getProducts() {	
    	List<Product> productList= productServiceImpl.getProductList();
    	if (productList!= null && productList.size()>0) {
    		return productList;
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
    	}
    }
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable Long productId) {
				
		return Optional.ofNullable(productServiceImpl.getProductById(productId))
    			.get()
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
    
}
