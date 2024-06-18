package com.frontline.webapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontline.webapi.output.License;
import com.frontline.webapi.service.impl.LicenseService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/license")
@Tag(name = "LicenseController")
public class LicenseController {

	@Autowired
	private LicenseService licenseService;

	@GetMapping(value = "/getAllLicense")
	public List<License> getLicence(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		System.out.println("Authorization bearer = " + accessToken);
		List<License> response = licenseService.getLicense(accessToken);
		return response;
	}
}
