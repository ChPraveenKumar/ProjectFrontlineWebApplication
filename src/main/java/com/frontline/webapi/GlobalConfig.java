package com.frontline.webapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {
	
	@Value("${api.url}")
	private String apiUrl;
	
	public String getApiUrl() {
		return apiUrl;
	}

}
