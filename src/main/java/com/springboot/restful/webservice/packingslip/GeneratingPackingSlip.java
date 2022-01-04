package com.springboot.restful.webservice.packingslip;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

import com.springboot.restful.webservice.model.MemberOrder;
import com.springboot.restful.webservice.model.OrderDetail;

@Component
public class GeneratingPackingSlip {
	
	private MemberOrder memberOrder;
	private String forWhom;
	private boolean needFirstAidVideo;
	private static final String pathName = "C:\\Users\\Lenovo\\Desktop\\packingslip\\packingslip-";
	
	public GeneratingPackingSlip() {
		super();
	}
				
	public boolean isNeedFirstAidVideo() {
		return needFirstAidVideo;
	}

	public void setNeedFirstAidVideo(boolean needFirstAidVideo) {
		this.needFirstAidVideo = needFirstAidVideo;
	}

	public MemberOrder getMemberOrder() {
		return memberOrder;
	}

	public void setMemberOrder(MemberOrder memberOrder) {
		this.memberOrder = memberOrder;
	}
		
	public String getForWhom() {
		return forWhom;
	}

	public void setForWhom(String forWhom) {
		this.forWhom = forWhom;
	}

	public void generatePackingSlip() {
	    try {
	      File packingSlip = new File(pathName+ memberOrder.getId() + "-" + forWhom +".html");
	      
	      if (packingSlip.createNewFile()) {
	        System.out.println("File created: " + packingSlip.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred while creating the packing slip file.");
	      e.printStackTrace();
	    }
	    
	    try {
	    	Path fileName = Path.of(pathName + memberOrder.getId() + "-" + forWhom + ".html");
		        
	    	StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<html>");
			htmlBuilder.append("<head>");
			htmlBuilder.append("<style>");
			htmlBuilder.append("table {");
			htmlBuilder.append("border-collapse: collapse;");
			htmlBuilder.append("border: 1px solid black;");
			htmlBuilder.append("width: 100%;");
			htmlBuilder.append("background-color: #D6EEEE;");
			htmlBuilder.append("}");
			htmlBuilder.append("th, td {");
			htmlBuilder.append("border: 1px solid black;");
			htmlBuilder.append("text-align: left;");
			htmlBuilder.append("padding: 8px;");
			htmlBuilder.append("}");
			htmlBuilder.append("</style>");
			htmlBuilder.append("</head>");
			htmlBuilder.append("<body style='background-color: #F2E0F8;'>");
			
			htmlBuilder.append("<h2>Order Id : "+ memberOrder.getId() + "</h2>"
				
					+ "<p>The details of the order are below.</p>");
			
			
			htmlBuilder.append("<table>");
			htmlBuilder.append("<tr><th style='width:25%'>Product</th><th style='width:25%'>Price</th><th style='width:25%'>Count</th><th style='width:25%'>Amount</th></tr>");			
			Float totalAmount=0.0f;
			
			for (int i = 0; i < memberOrder.getOrderDetails().size(); i++) {
				OrderDetail orderDetail = memberOrder.getOrderDetails().get(i);
				if (orderDetail.getProduct().getProductSubGroup().getProductGroup().isPhysical()) {
					htmlBuilder.append("<tr><td>" + orderDetail.getProduct().getProductSubGroup().getProductGroup().getName() + " - " +
													orderDetail.getProduct().getName() + "</td><td>" +
												    orderDetail.getProduct().getPrice() + "</td><td>" +
												    orderDetail.getOrderCount()	+ "</td><td>" +
												    orderDetail.getAmount()		+ "</td></tr>");
					totalAmount = totalAmount + orderDetail.getAmount()	;
				}
			}
			
			if (needFirstAidVideo) {
				htmlBuilder.append("<tr><td>First Aid Video </td><td>0.0</td><td>1</td><td>0.0</td></tr>");
			}
			
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><th colspan=3 style='text-align: right;'>TOTAL AMOUNT</th><td>"+ totalAmount +"</td></tr>");
			htmlBuilder.append("</table>");
			
			htmlBuilder.append("</br>");
			htmlBuilder.append("</br>");
			htmlBuilder.append("<table>");
			htmlBuilder.append("<tr><th style='width:25%'>Name Surname</th><th>Telephone</th><th>Email</th><th>Address</th></tr>");
			htmlBuilder.append("<tr><td style='width:25%'>"+memberOrder.getMember().getName()+" "+memberOrder.getMember().getSurname()+
					"</td><td style='width:25%'>"+ memberOrder.getMember().getTelephone()+
					"</td><td style='width:25%'>"+ memberOrder.getMember().getEmailAddress() +
					"</td><td style='width:25%'>"+ memberOrder.getMember().getAddress() + "</td></tr>");
			
			htmlBuilder.append("</table>");
			htmlBuilder.append("</body>");
			htmlBuilder.append("</html>");

			String content = htmlBuilder.toString();
	        
	        
	        Files.writeString(fileName, content);
		} catch (Exception e) {
			System.out.println("An error occurred while creating the packing slip content");
		    e.printStackTrace();
		}
	    
	}

}
