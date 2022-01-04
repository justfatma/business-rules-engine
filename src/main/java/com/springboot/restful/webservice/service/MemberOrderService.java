package com.springboot.restful.webservice.service;

import java.util.List;
import java.util.Optional;

import com.springboot.restful.webservice.model.MemberOrder;

public interface MemberOrderService {
	
	public Optional<MemberOrder> getMemberOrderById(Long memberOrderId);
	public List<MemberOrder> getMemberOrderList();
	public String addMemberOrder(MemberOrder memberOrder);
}
