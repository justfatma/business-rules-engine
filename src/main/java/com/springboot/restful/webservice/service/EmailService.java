package com.springboot.restful.webservice.service;

public interface EmailService {

	public void sendEmailForMembershipUpgrade(String toEmailAddress, String memberName);
	public void sendEmailForMembershipActivation(String toEmailAddress, String memberName);
}
