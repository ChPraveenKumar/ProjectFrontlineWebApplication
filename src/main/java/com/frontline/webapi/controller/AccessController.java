package com.frontline.webapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontline.webapi.service.impl.AccessService;
import com.frontline.webapi.input.ServerRoles;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/access-control")
@Tag(name = "AccessController")
public class AccessController {

	@Autowired
	private AccessService accessService;

	// Note:-This API is to list all server roles
	@GetMapping(value = "/getAllServerRoles")
	public List<ServerRoles> getAllServerRolls(HttpServletRequest request) {
		// Use the access token for authentication
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		List<ServerRoles> serverRolesArray = accessService.getAllServerRolls(accessToken);
       System.out.println("session :"+session+  "    accessToken :"+accessToken+   "   serverRolesArray :"+serverRolesArray);
		return serverRolesArray;
	}
}
