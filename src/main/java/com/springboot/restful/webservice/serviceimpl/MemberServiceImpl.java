package com.springboot.restful.webservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.webservice.exception.RecordNotFoundException;
import com.springboot.restful.webservice.model.Member;
import com.springboot.restful.webservice.model.MemberStatus;
import com.springboot.restful.webservice.model.MemberType;
import com.springboot.restful.webservice.repository.MemberRepository;
import com.springboot.restful.webservice.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Optional<Member> getMemberById(Long memberId) {
		Optional<Member> member =  memberRepository.findById(memberId);
		
		if (!member.isPresent()) {   
			throw new RecordNotFoundException("MemberServiceImpl/getMemberById : Member not found. memberId -> " + memberId);
		}
				
		return member;
	}

	@Override
	public List<Member> getMemberList() {
		List<Member> memberList = memberRepository.findAll();
		
		if (memberList == null || memberList.size() == 0) {
			throw new RecordNotFoundException("MemberServiceImpl/getMemberList: Member list is empty. ");
		}
		
		return memberList;
	}

	@Override
	public String activateMembership(Long memberId) {
		Optional<Member> optMember =  memberRepository.findById(memberId);
		
		if (!optMember.isPresent()) {   
			throw new RecordNotFoundException("MemberServiceImpl/activateMembership: Member not found. memberId -> " + memberId);
		}
		
		Member member = optMember.get();
		
		if (member.getMemberStatus().equals(MemberStatus.ACTIVE)) {
			return "Member is already active";
		}else {
			member.setMemberStatus(MemberStatus.ACTIVE);
			memberRepository.save(member);
			
			return "Membership is activated successfully.";
		}
	
	}

	@Override
	public String upgradeMembership(Long memberId) {
		Optional<Member> optMember =  memberRepository.findById(memberId);
		
		if (!optMember.isPresent()) {   
			throw new RecordNotFoundException("MemberServiceImpl/upgradeMembership: Member not found. memberId-> " + memberId);
		}
		
		Member member = optMember.get();
		
		if (member.getMemberStatus().equals(MemberStatus.PASSIVE)) {
			return "Membership can not be upgrated for passive members.";
		}else {
			if (member.getMemberType().getName().equals("Premium")) {
				return "Membership is already premium.";
			}else {
				MemberType memberType= new MemberType();
				memberType.setId(2);
				memberType.setDescription("Premium");
				member.setMemberType(memberType);
				memberRepository.save(member);
				return "Membership is upgrated successfully.";
			}
		}
		
	}

}
