package com.frontline.webapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontline.webapi.input.LoginRequest;
import com.frontline.webapi.output.FrontlineLoginResponse;
import com.frontline.webapi.service.impl.FrontlineApiService;

@RestController
@RequestMapping(path = "/api")
public class FrontlineLoginController {

	@Autowired
	private FrontlineApiService loginService;

	private static String accessToken = "";

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {

		System.out.println("response debugg");

		ResponseEntity<FrontlineLoginResponse> response = loginService.login(loginRequest);

		System.out.println("response debug :"+response);

		System.out.println(response.getBody().getToken());

		accessToken = response.getBody().getToken();

		HttpSession session = request.getSession();

		session.setAttribute("accessToken", accessToken);
		
		String tokenSecret = (String)session.getAttribute("accessToken");
		   System.out.println("tokenSecret :"+tokenSecret);
			System.out.printf("Session timeout defined at application level : %s\n", session.getMaxInactiveInterval());
			//session.setMaxInactiveInterval(20*60); //session timeout in seconds (600second -- 10 mints)
			//session.getServletContext().setSessionTimeout(5);
			System.out.printf("Session timeout defined at code level : %s\n", session.getMaxInactiveInterval());
			//session.getServletContext().setSessionTimeout(5); // session timeout in minits.
			//System.out.println("Praveen token");
			//Object attribute = session.getAttribute(accessToken);
			//System.out.println(attribute);
			//response.getBody().setRefreshToken(accessToken);
		return response.getBody().getToken();
	}
}
