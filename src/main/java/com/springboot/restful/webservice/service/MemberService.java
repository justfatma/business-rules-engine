package com.springboot.restful.webservice.service;

import java.util.Optional;
import java.util.List;
import com.springboot.restful.webservice.model.Member;

public interface MemberService {
	
	public Optional<Member> getMemberById(Long memberId);
	public List<Member> getMemberList();
	public String activateMembership(Long memberId);
	public String upgradeMembership(Long memberId);
}
