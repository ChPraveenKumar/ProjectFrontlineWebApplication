package com.frontline.webapi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.frontline.webapi.GlobalConfig;
import com.frontline.webapi.input.LoginRequest;
import com.frontline.webapi.output.FrontlineLoginResponse;

@Service
public class FrontlineApiService {

	@Autowired
	private GlobalConfig globalConfig;

	private RestTemplate restTemplate;

	public FrontlineApiService(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response,
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

	}

	public ResponseEntity<FrontlineLoginResponse> login(LoginRequest loginRequest) {

		String apiUrl = globalConfig.getApiUrl();
		// Build request headers

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Send login request to external API
		ResponseEntity<FrontlineLoginResponse> response = restTemplate.exchange(apiUrl + "login", HttpMethod.POST,
				new HttpEntity<>(loginRequest, headers), FrontlineLoginResponse.class);
		
		System.out.println("response.getBody() :"+response.getBody());
		FrontlineLoginResponse responseBody = response.getBody();

		String token = (String) responseBody.getToken();

		System.out.println("bearer token ");
		System.out.println(token);

		return response;
	}

}
