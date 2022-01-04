package com.springboot.restful.webservice.packingslip;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PackingSlip {
	
//	private Long memberOrderId;
//	private List<OrderDetail> orderDetails;
	
	public static void main(String[] args) {
	    try {
	      File packingSlip = new File("C:\\Users\\fatma\\business-rules-engine\\src\\main\\resources\\packingSlip\\packingslip.html");
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
	    	Path fileName = Path.of("C:\\Users\\fatma\\business-rules-engine\\src\\main\\resources\\packingSlip\\packingslip.html");
		        
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
			htmlBuilder.append("<body>");
			
			htmlBuilder.append("<h2>Order Id : "+ 32323 + "</h2>"
				
					+ "<p>The details of the order are below.</p>");
			
			
			htmlBuilder.append("<table>");
			htmlBuilder.append("<tr><th style='width:25%'>Product</th><th style='width:25%'>Price</th><th style='width:25%'>Count</th><th style='width:25%'>Amount</th></tr>");			
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><td></td><td></td><td></td><td></td></tr>");
			htmlBuilder.append("<tr><th colspan=3 style='text-align: right;'>TOTAL AMOUNT</th><td></td></tr>");
			htmlBuilder.append("</table>");
			
			htmlBuilder.append("</br>");
			htmlBuilder.append("</br>");
			htmlBuilder.append("<table style='background-color: #ECC9F9;'>");
			htmlBuilder.append("<tr><th style='width:25%'>Name Surname</th><th>Telephone</th><th>Email</th><th>Address</th></tr>");
			htmlBuilder.append("<tr><td style='width:25%'></td><td style='width:25%'></td><td style='width:25%'></td><td style='width:25%'></td></tr>");
			
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
