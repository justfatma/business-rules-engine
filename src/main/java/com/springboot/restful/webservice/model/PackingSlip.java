package com.springboot.restful.webservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PackingSlip {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	private MemberOrder memberOrder;
	
	private boolean neededForShipping;
	private boolean neededForRoyaltyDep;
	private boolean isPressed;
	private boolean neededFirstAidVideo;
	
	public PackingSlip() {
		super();
	}

		
	public boolean isNeededFirstAidVideo() {
		return neededFirstAidVideo;
	}



	public void setNeededFirstAidVideo(boolean neededFirstAidVideo) {
		this.neededFirstAidVideo = neededFirstAidVideo;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MemberOrder getMemberOrder() {
		return memberOrder;
	}
	public void setMemberOrder(MemberOrder memberOrder) {
		this.memberOrder = memberOrder;
	}
	public boolean isNeededForShipping() {
		return neededForShipping;
	}
	public void setNeededForShipping(boolean neededForShipping) {
		this.neededForShipping = neededForShipping;
	}
	
	public boolean isNeededForRoyaltyDep() {
		return neededForRoyaltyDep;
	}
	public void setNeededForRoyaltyDep(boolean neededForRoyaltyDep) {
		this.neededForRoyaltyDep = neededForRoyaltyDep;
	}


	public boolean isPressed() {
		return isPressed;
	}


	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}


	@Override
	public String toString() {
		return "PackingSlip [id=" + id + ", memberOrder=" + memberOrder + ", neededForShipping=" + neededForShipping
				+ ", neededForRoyaltyDep=" + neededForRoyaltyDep + ", isPressed=" + isPressed + ", neededFirstAidVideo="
				+ neededFirstAidVideo + "]";
	}

	
}
