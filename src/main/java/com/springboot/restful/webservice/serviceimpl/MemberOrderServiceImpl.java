package com.springboot.restful.webservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.webservice.exception.RecordNotFoundException;
import com.springboot.restful.webservice.model.Member;
import com.springboot.restful.webservice.model.MemberOrder;
import com.springboot.restful.webservice.model.MemberStatus;
import com.springboot.restful.webservice.model.OrderDetail;
import com.springboot.restful.webservice.model.OrderStatus;
import com.springboot.restful.webservice.model.PackingSlip;
import com.springboot.restful.webservice.model.Product;
import com.springboot.restful.webservice.repository.MemberOrderRepository;
import com.springboot.restful.webservice.repository.MemberRepository;
import com.springboot.restful.webservice.repository.OrderDetailRepository;
import com.springboot.restful.webservice.repository.PackingSlipRepository;
import com.springboot.restful.webservice.service.MemberOrderService;


@Service
public class MemberOrderServiceImpl implements MemberOrderService{
	
	@Autowired
	private MemberOrderRepository memberOrderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private PackingSlipRepository packingSlipRepository;

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
	public String addMemberOrder(MemberOrder memberOrder) {
		
		Member member = memberRepository.getById(memberOrder.getMember().getId());
		
		if (member.getMemberStatus().equals(MemberStatus.PASSIVE)) {
			return "An order can not be created for a passive member.";
		}else {
		
			long millis=System.currentTimeMillis();
			memberOrder.setOrderDate(new java.sql.Date(millis));
			memberOrder.setOrderTime(new java.sql.Timestamp(millis));
			memberOrder.setOrderStatus(OrderStatus.ORDER_IS_BEING_PREPARED);
					
			List<OrderDetail> orderDetails = memberOrder.getOrderDetails();
			Product product = new Product();
			Float totalAmount = 0.0f;
			boolean packingSlipForShipping = false;
			boolean packingSlipForRoyaltyDep = false;
			boolean neededFirstAidVideo = false;
			
			for (int i = 0; i < orderDetails.size(); i++) {
				OrderDetail orderDetail = orderDetails.get(i);
				product = productServiceImpl.getProductById(orderDetail.getProduct().getId()).get();
				orderDetail.setAmount(product.getPrice() * orderDetail.getOrderCount());
				orderDetail.setAgentCommissionAmount((product.getPrice() * product.getAgentCommissionRate())*orderDetail.getOrderCount());
				totalAmount = totalAmount + orderDetail.getAmount();
				
				if (product.getProductSubGroup().getProductGroup().isPhysical()) {
					packingSlipForShipping = true;
					
					if (product.getProductSubGroup().getProductGroup().getName().equals("Book")) {
						packingSlipForRoyaltyDep = true;
					}
					
					if (product.isNeedFirstAidVideo()) {
						neededFirstAidVideo = true;
					}
				}
			}
			
			memberOrder.setTotalAmount(totalAmount);
			MemberOrder savedMemberOrder= memberOrderRepository.save(memberOrder);	
			
			for (int i = 0; i < orderDetails.size(); i++) {
				OrderDetail orderDetail = orderDetails.get(i);
				orderDetail.setMemberOrder(savedMemberOrder);
				orderDetailRepository.save(orderDetail);
			}
			
	
			if (packingSlipForShipping) {
				PackingSlip packingSlip = new PackingSlip();
				packingSlip.setMemberOrder(savedMemberOrder);
				packingSlip.setNeededForShipping(true);
				packingSlip.setPressed(false);
				packingSlip.setNeededFirstAidVideo(neededFirstAidVideo);
							
				if (packingSlipForRoyaltyDep) {
					packingSlip.setNeededForRoyaltyDep(true);
				}else {
					packingSlip.setNeededForRoyaltyDep(false);
				}
				
				packingSlipRepository.save(packingSlip);
			}
			
			return "Order is generated successfully. Order id: " + savedMemberOrder.getId();
		}
	
	}

}
