package com.springboot.restful.webservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.webservice.email.SendingEmail;
import com.springboot.restful.webservice.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private SendingEmail sendingEmail;

	@Override
	public void sendEmailForMembershipUpgrade(String toEmailAddress, String memberName) {
		sendingEmail.setToAddress(toEmailAddress);
		sendingEmail.setContent(prepareHtml(memberName, "upgraded"));
		sendingEmail.setSubject("Membership upgrade is successful");
		sendingEmail.sendEmail();
	}

	@Override
	public void sendEmailForMembershipActivation(String toEmailAddress, String memberName) {
		sendingEmail.setToAddress(toEmailAddress);
		sendingEmail.setContent(prepareHtml(memberName, "activated"));
		sendingEmail.setSubject("Membership activation is successful");
		sendingEmail.sendEmail();
	}

	public String prepareHtml(String mmbrName, String action) {
		
		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html>");
		htmlBuilder.append("<head>");
		htmlBuilder.append("<style>");
		htmlBuilder.append("table {");
		htmlBuilder.append("border-collapse: collapse;");
		htmlBuilder.append("width: 100%;");
		htmlBuilder.append("background-color: #D6EEEE;");
		htmlBuilder.append("}");
		htmlBuilder.append("td {");
		htmlBuilder.append("text-align: left;");
		htmlBuilder.append("padding: 8px;");
		htmlBuilder.append("}");
		htmlBuilder.append("</style>");
		htmlBuilder.append("</head>");
		htmlBuilder.append("<body>");
		htmlBuilder.append("<table>");
		htmlBuilder.append("  <tr><td>Congratulations <b>");
		htmlBuilder.append(mmbrName);	
		htmlBuilder.append(" </b>!</td></tr>");
		htmlBuilder.append(" <tr><td>Your membership has been <b>"
				+ action
				+ "</b>.</td></tr>");
		htmlBuilder.append("</table>");
		htmlBuilder.append("</body>");
		htmlBuilder.append("</html>");

		String content = htmlBuilder.toString();
		return content;
	}
}
