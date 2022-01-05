package applicationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.springboot.restful.webservice.Application;
import com.springboot.restful.webservice.exception.RecordNotFoundException;
import com.springboot.restful.webservice.model.Member;
import com.springboot.restful.webservice.model.MemberOrder;
import com.springboot.restful.webservice.model.Product;
import com.springboot.restful.webservice.service.MemberOrderService;
import com.springboot.restful.webservice.service.MemberService;
import com.springboot.restful.webservice.service.ProductService;



@ContextConfiguration
@SpringBootTest(classes = Application.class)
public class ApplicationTestCases {

	@Autowired
    MemberOrderService memberOrderService;
     
	@Autowired
    MemberService memberService;
		
	@Autowired
    ProductService productService;
	
	
	@Test
	public void shouldReturnMemberFromService(){
		
		Optional<Member> member=memberService.getMemberById(1L);
		assertEquals(true, !member.isEmpty());
	}
    
	
	@Test
	public void shouldThrowExceptionIfMemberNotFound(){
		
		try {		
			Optional<Member> member=memberService.getMemberById(100L);
		}catch (RecordNotFoundException e) {
			assertEquals(true, e.getMessage().length()>0);
		}
	}
 
	@Test
	public void shouldReturnMemberListFromService(){
		
		List<Member> memberList=memberService.getMemberList();
		assertEquals(true, !memberList.isEmpty());
	}
	
	@Test
	public void shouldReturnProductFromService(){
		
		Optional<Product> product=productService.getProductById(8L);
		assertEquals(true ,!product.isEmpty());
	}
	
	
	@Test
	public void shouldThrowExceptionIfProductNotFound(){
		
		try {		
			Optional<Product> product=productService.getProductById(10001L);
		}catch (RecordNotFoundException e) {
			assertEquals(true, e.getMessage().length()>0);	
		}
	}
	
	
	@Test
	public void shouldReturnProductListFromService(){
		
		List<Product> productList=productService.getProductList();
		assertEquals(true, !productList.isEmpty());
	}
	
	
	@Test
	public void shouldReturnMemberOrderFromService(){
		
		Optional<MemberOrder> memberOrder=memberOrderService.getMemberOrderById(111111L);
		assertEquals(true, !memberOrder.isEmpty());
	}
	
	
	@Test
	public void shouldThrowExceptionIfMemberOrderNotFound(){
		
		try {		
			Optional<MemberOrder> memberOrder=memberOrderService.getMemberOrderById(99999L);
		}catch (RecordNotFoundException e) {
			assertEquals(true, e.getMessage().length()>0);	
		}
	}
	
    
	@Test
	public void shouldReturnMemberOrderListFromService(){
		
		List<MemberOrder> memberOrderList=memberOrderService.getMemberOrderList();
		assertEquals(true, !memberOrderList.isEmpty());
	}




}
