package com.frontline.webapi.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frontline.webapi.pojo.RtcCalls;
import com.frontline.webapi.service.impl.RtcService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/rtc")
@Tag(name = "RtcController")
public class RtcController {

	
 @Autowired
 private RtcService rtcService;

 /*
	@GetMapping(value = "/getFilteredCallLogsV2")
	public RtcCalls getFilteredCallLogsV2(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		System.out.println("Authorization bearer = " + accessToken);
		
		RtcCalls response = rtcService.getFilteredCallLogsV2(accessToken);

		return response;
		*/
 
 @GetMapping(value = "/getFilteredCallLogsV2")
	public RtcCalls getFilteredCallLogsV2(HttpServletRequest request,@RequestParam(required = false) Number size) {
	  Map<String, List<String>> queryParms = new HashMap<>();
	  queryParms.put("size", Collections.singletonList(String.valueOf(size)));
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		System.out.println("Authorization bearer = " + accessToken);
		RtcCalls response = rtcService.getFilteredCallLogsV2(queryParms,accessToken);
		return response;

	}
}
