package com.frontline.webapi.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.frontline.webapi.GlobalConfig;
import com.frontline.webapi.input.ServerRoles;

@Service
public class AccessService {

	@Autowired
	private GlobalConfig globalConfig;

	private RestTemplate restTemplate;

	public AccessService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public List<ServerRoles> getAllServerRolls(String accessToken) {

		System.out.println("AccessSerevice Class :"+accessToken);
		String apiUrl = globalConfig.getApiUrl();
		System.out.println("bearer server =" + accessToken);
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<>(headers1);
		// Give The URL
		String url = apiUrl + "access-control/getAllServerRoles";

		ServerRoles roles=new ServerRoles();
		roles.setCustom(true);
		ResponseEntity<ServerRoles[]> serverroles = restTemplate.exchange(url, HttpMethod.GET, entity,
				ServerRoles[].class);
		ServerRoles[] serverRolesArray = serverroles.getBody();

		return Arrays.asList(serverRolesArray);
	}

}
