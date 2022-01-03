package com.springboot.restful.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restful.webservice.model.Member;
import com.springboot.restful.webservice.serviceimpl.EmailServiceImpl;
import com.springboot.restful.webservice.serviceimpl.MemberServiceImpl;

@RestController
public class MemberManagementController {
	
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@GetMapping("/members")
    public List<Member> getMembers() {	
    	List<Member> memberList= memberServiceImpl.getMemberList();
    	if (memberList!= null && memberList.size()>0) {
    		return memberList;
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
    	}
    }
	
	@GetMapping("/members/{memberId}")
	public Member getMemberById(@PathVariable Long memberId) {
				
		return Optional.ofNullable(memberServiceImpl.getMemberById(memberId))
    			.get()
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/activate/{memberId}")
	public String activateMembership(@PathVariable Long memberId) {
				
		String returnMessage = memberServiceImpl.activateMembership(memberId);
		if (returnMessage.equals("Membership is activated successfully.")) {
			Member member = memberServiceImpl.getMemberById(memberId).get();
			emailServiceImpl.sendEmailForMembershipActivation(member.getEmailAddress(), member.getName());
		}
		return returnMessage;
	}
	
	@PutMapping("/upgrade/{memberId}")
	public String upgradeMembership(@PathVariable Long memberId) {
				
		String returnMessage = memberServiceImpl.upgradeMembership(memberId);
		if(returnMessage.equals("Membership is upgrated successfully.")) {
			Member member = memberServiceImpl.getMemberById(memberId).get();
			emailServiceImpl.sendEmailForMembershipUpgrade(member.getEmailAddress(), member.getName());
		}
		return returnMessage;
	}

}
