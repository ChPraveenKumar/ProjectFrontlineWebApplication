package com.frontline.webapi.service.impl;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.frontline.webapi.GlobalConfig;
import com.frontline.webapi.pojo.RtcCalls;

@Service
public class RtcService {
	
	@Autowired
	private GlobalConfig globalConfig;

	private RestTemplate restTemplate;
	
	public RtcService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	
	/*
	public RtcCalls getFilteredCallLogsV2(String accessToken) {
		
		String apiUrl = globalConfig.getApiUrl();
		
		HttpHeaders header = new HttpHeaders();
		
		header.add("Authorization", "Bearer " + accessToken);
		
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>(header);
		// Give The URL
		String url = apiUrl + "/rtc/getFilteredCallLogsV2";
		
		URI getRtcUri = UriComponentsBuilder.fromUriString(url).build().toUri();
		
		System.out.println("getRtcUri:" + getRtcUri);
		
		ResponseEntity<RtcCalls> rtcList = restTemplate.exchange(getRtcUri, HttpMethod.GET, entity, RtcCalls.class);
		
		System.out.println("rtcList :"+rtcList);
		RtcCalls responseBody = rtcList.getBody();
		
		//String token = (String) responseBody.getToken();
		System.out.println(" responseBody:"+responseBody);
		
		System.out.println(responseBody.getContent());
		return responseBody;

	}
	*/
	
	public RtcCalls getFilteredCallLogsV2(Map<String, List<String>> queryParms,String accessToken) {
		String apiUrl = globalConfig.getApiUrl();
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(header);
		// Give The URL
		String url = apiUrl + "/rtc/getFilteredCallLogsV2";
		/* URI getRtcUri = UriComponentsBuilder.fromUriString(url).build().toUri(); */
		UriComponentsBuilder getRtcUri = UriComponentsBuilder.fromUriString(url);
		// Add query parameters
				for (Map.Entry<String, List<String>> entry : queryParms.entrySet()) {
                      String paramName = entry.getKey();
					List<String> paramValues = entry.getValue();
					for (String paramValue : paramValues) {

						getRtcUri.queryParam(paramName, paramValue);

					}
				}
				URI uri = getRtcUri.build().toUri();
				System.out.println("Ford buildup url");
				System.out.println(uri);
		System.out.println("getRtcUri:" + getRtcUri);
		/*

		 * ResponseEntity<RtcCalls> rtcList = restTemplate.exchange(getRtcUri,

		 * HttpMethod.GET, entity, RtcCalls.class);

		 */
		ResponseEntity<RtcCalls> rtcList = restTemplate.exchange(uri, HttpMethod.GET, entity, RtcCalls.class);
		System.out.println("rtcList :" + rtcList);
		RtcCalls responseBody = rtcList.getBody();
		// String token = (String) responseBody.getToken();
		System.out.println(" responseBody:" + responseBody);
		System.out.println(responseBody.getContent());
		return responseBody;
	}
}

