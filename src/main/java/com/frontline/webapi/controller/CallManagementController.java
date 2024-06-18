package com.frontline.webapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontline.webapi.input.NodeViewModel;
import com.frontline.webapi.service.impl.CallManagementService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/expert-identification")
@Tag(name = "ExpertIdentification")
public class CallManagementController {

	@Autowired
	private CallManagementService callManagementService;

	@GetMapping(value = "/get")
	public String getCallmanagement(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		
		System.out.println("accessToken :"+accessToken);

		return callManagementService.getCallManagementJson(accessToken);
	}

	@PostMapping(value = "/createOrUpdate")
	public ResponseEntity<NodeViewModel> addCallManagement(@RequestBody NodeViewModel nodeViewModel,
			HttpServletRequest request) {
		// Use the access token for authentication
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");

		ResponseEntity<NodeViewModel> callManagementNode = callManagementService.
				addCallManagement(accessToken, nodeViewModel);

		return callManagementNode;

	}

	@PostMapping(value = "/restoreDeleted")
	public ResponseEntity<NodeViewModel[]> restoreCallManagementDeleted(
			@RequestBody NodeViewModel[] nodeViewModelBackupJson, HttpServletRequest request) {
		// Use the access token for authentication
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");

		ResponseEntity<NodeViewModel[]> callManagementNodeUpdate = callManagementService
				.restoreCallManagementDeleted(accessToken, nodeViewModelBackupJson);

		return callManagementNodeUpdate;

	}
	
	

}
