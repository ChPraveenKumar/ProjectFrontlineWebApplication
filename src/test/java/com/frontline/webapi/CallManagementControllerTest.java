package com.frontline.webapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.frontline.webapi.controller.CallManagementController;
import com.frontline.webapi.input.NodeViewModel;
import com.frontline.webapi.service.impl.CallManagementService;

@ExtendWith(MockitoExtension.class)
public class CallManagementControllerTest {

	@Autowired
	CallManagementController callManagementController;
	@Autowired
	CallManagementService callManagementService;
	
	@Test
	 void getCallmanagementTest(HttpServletRequest request)
	{
			 //String accessToken="accessToken";
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
      
/*
			private String nodeId;
			private String parentNodeId;
			private String title;
			private String level;
			private int userCount;
			private int adminCount;
			private int teamsCount;
			private int	numberOfChildren;
			private int levelsAbove	;
			private int levelsBelow;
			private String type;
			private CallSettings callSettings;
			*/
		 NodeViewModel nodeViewModel=new NodeViewModel();
		 nodeViewModel.setNodeId("100");
		 nodeViewModel.setParentNodeId("200");
		 nodeViewModel.setTitle("NodeModel");
		 
		/*ResponseEntity<NodeViewModel> callManagementNode = callManagementService.
				addCallManagement(accessToken, nodeViewModel);*/
			 Mockito.when(callManagementService.getCallManagementJson(Mockito.anyString()));
			 //String callManagementJson = callManagementService.getCallManagementJson(accessToken);
			 ResponseEntity entity=callManagementController.addCallManagement(nodeViewModel, request);
			 System.out.println("request :"+request    +"entity :"+entity);
			 Assertions.assertEquals("accessToken",entity);
	}
	/*
	 @Test
	void testCreateOrder() {
		Mockito.when(orderServiceImpl.createOrder(Mockito.any())).thenReturn(getOrderDTO());
		ResponseEntity<OrderDTO> createOrder = orderController.createOrders(new OrderDTO());
		Assertions.assertEquals(20000, createOrder.getBody().getOrderPrice());
	}
	
	private OrderDTO getOrderDTO() {
		OrderItemDTO idto = new OrderItemDTO();
		idto.setQuantity(1);
		OrderDTO dto = new OrderDTO();
		dto.setFromAddress("gooty");
		dto.setShippingAddress("bng");
		dto.setOrderBy("dush");
		dto.setOrderPrice(20000);
		dto.setItemList(List.of(idto));
		return dto;
	}
	 */
	/*
	public ResponseEntity<NodeViewModel> addCallManagement(@RequestBody NodeViewModel nodeViewModel,
			HttpServletRequest request) {
		// Use the access token for authentication
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");

		ResponseEntity<NodeViewModel> callManagementNode = callManagementService.
				addCallManagement(accessToken, nodeViewModel);

		return callManagementNode;

	}
	*/
	@Test
	public void addCallManagement() {
		
	}
	
}
