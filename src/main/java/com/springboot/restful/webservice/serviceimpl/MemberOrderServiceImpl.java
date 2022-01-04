package com.springboot.restful.webservice.serviceimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.webservice.exception.RecordNotFoundException;
import com.springboot.restful.webservice.model.MemberOrder;
import com.springboot.restful.webservice.model.OrderDetail;
import com.springboot.restful.webservice.model.OrderStatus;
import com.springboot.restful.webservice.model.Product;
import com.springboot.restful.webservice.repository.MemberOrderRepository;
import com.springboot.restful.webservice.repository.OrderDetailRepository;
import com.springboot.restful.webservice.service.MemberOrderService;

@Service
public class MemberOrderServiceImpl implements MemberOrderService{
	
	@Autowired
	private MemberOrderRepository memberOrderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Override
	public Optional<MemberOrder> getMemberOrderById(Long memberOrderId) {
		Optional<MemberOrder> memberOrder =  memberOrderRepository.findById(memberOrderId);
		
		if (!memberOrder.isPresent()) {   
			throw new RecordNotFoundException("MemberOrderServiceImpl/getMemberOrderById : Member order not found. memberOrderId -> " + memberOrderId);
		}
				
		return memberOrder;
	}

	@Override
	public List<MemberOrder> getMemberOrderList() {
		List<MemberOrder> memberOrderList = memberOrderRepository.findAll();
		
		if (memberOrderList == null || memberOrderList.size() == 0) {
			throw new RecordNotFoundException("MemberOrderServiceImpl/getMemberOrderList: Member order list is empty. ");
		}
		
		return memberOrderList;
	}

	@Override
	public Long addMemberOrder(MemberOrder memberOrder) {
		long millis=System.currentTimeMillis();
		memberOrder.setOrderDate(new java.sql.Date(millis));
		memberOrder.setOrderTime(new java.sql.Timestamp(millis));
		memberOrder.setOrderStatus(OrderStatus.ORDER_IS_BEING_PREPARED);
				
		List<OrderDetail> orderDetails = memberOrder.getOrderDetails();
		Product product = new Product();
		Float totalAmount = 0.0f;
		
		for (int i = 0; i < orderDetails.size(); i++) {
			OrderDetail orderDetail = orderDetails.get(i);
			product = productServiceImpl.getProductById(orderDetail.getProduct().getId()).get();
			orderDetail.setAmount(product.getPrice() * orderDetail.getOrderCount());
			orderDetail.setAgentCommissionAmount((product.getPrice() * product.getAgentCommissionRate())*orderDetail.getOrderCount());
			totalAmount = totalAmount + orderDetail.getAmount();
		}
		
		memberOrder.setTotalAmount(totalAmount);
		MemberOrder savedMemberOrder= memberOrderRepository.save(memberOrder);	
		
		for (int i = 0; i < orderDetails.size(); i++) {
			OrderDetail orderDetail = orderDetails.get(i);
			orderDetail.setMemberOrder(savedMemberOrder);
			orderDetailRepository.save(orderDetail);
		}
		
		return savedMemberOrder.getId();
	}

}
