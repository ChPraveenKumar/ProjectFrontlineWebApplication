package com.frontline.webapi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.frontline.webapi.controller.AccessController;
import com.frontline.webapi.input.ServerRoles;
import com.frontline.webapi.service.impl.AccessService;

@ExtendWith(MockitoExtension.class)
public class AccessControllerTest {

	@Autowired
	AccessController AccessController;
	
	@Autowired
    AccessService accessService;
	
	@Test
	public List<ServerRoles> getAllServerRollsTest(HttpServletRequest request) {
		// Use the access token for authentication
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		Mockito.when(accessService.getAllServerRolls(Mockito.anyString())).thenReturn(List.of(getAccessTokenResponse()));
	  // List<ServerRoles> serverRolesArray = accessService.getAllServerRolls(accessToken);
		List<ServerRoles> allServerRolls = AccessController.getAllServerRolls(request);
    
		return allServerRolls;
	}
	/*
	 @Test
	void getAllOrderItemTest() {
		Mockito.when(orderItemServiceImpl.getAllOrdersItem()).thenReturn(List.of((getOrderItemResponse())));
		ResponseEntity<List<OrderItemResponse>> allOrderItems = orderItemController.getAllOrderItems();
		Assertions.assertEquals(1, allOrderItems.getBody().get(0).getOrderItemId());
	}
	 */
	/*
	 @Test
	void testGetAllOrders() {
		Order order=new Order();
		order.setOrderId(10);
		order.setOrderDate(new Date());
		order.setOrderPrice(2000);
		order.setOrderBy("praveen");
		order.setFromAddress("Hyd");
		order.setShippingAddress("Chennai");
		Mockito.when(orderServiceImpl.getAllOrders()).thenReturn(List.of(getOrderRequest()));
		ResponseEntity<List<OrderRequest>> allorders=orderController.getAllOrders();
		Assertions.assertEquals(2000, allorders.getBody().get(0).getOrderPrice());
	}
	 */

	private ServerRoles getAccessTokenResponse() {
		
		ServerRoles serverRoles=new ServerRoles();
		serverRoles.setCustom(true);
		serverRoles.setDomainTag("ubimax");
		serverRoles.setId(1);
		serverRoles.setName("Administrator");
		return serverRoles;
	}
	
}
