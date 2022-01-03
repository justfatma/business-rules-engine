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
import com.springboot.restful.webservice.serviceimpl.MemberServiceImpl;

@RestController
public class MemberManagementController {
	
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
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
				
		return memberServiceImpl.activateMembership(memberId);
	}
	
	@PutMapping("/upgrade/{memberId}")
	public String upgradeMembership(@PathVariable Long memberId) {
				
		return memberServiceImpl.upgradeMembership(memberId);
	}

}
