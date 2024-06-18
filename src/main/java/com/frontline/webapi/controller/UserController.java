package com.frontline.webapi.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.frontline.webapi.output.EditUserRequest;
import com.frontline.webapi.output.EditUserResponse;
import com.frontline.webapi.output.PageUserViewModel;
import com.frontline.webapi.output.User;
import com.frontline.webapi.input.MultiUserInput;
import com.frontline.webapi.service.impl.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/users")
@Tag(name = "UserController")
public class UserController {

	@Autowired
	private UserService userService;

	// Note:-This API is to list all server roles
	@GetMapping(value = "/getUserDetails/{userid}")
	public List<User> getUserDetails(@PathVariable String userid, HttpServletRequest request) {
		// Use the access token for authentication

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");

		List<User> userDetails = userService.getUserDetails(accessToken, userid);

		return userDetails;

	}

	@GetMapping(value = "/getAllUser")
	public List<User> getUsers(HttpServletRequest request) {
		// Use the access token for authentication

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");
        System.out.println("UserController accessToken :"+accessToken);
		List<User> userDetails = userService.getAllUser(accessToken);

		return userDetails;

	}

	@GetMapping(value = "/getUserList", produces = { MediaType.APPLICATION_JSON_VALUE })
	public PageUserViewModel getUserList(@PageableDefault(size = 100, page = 0) Pageable pageable,
			@RequestParam(required = false) List<String> userid,
			@RequestParam(required = false) List<String> displayname,
			@RequestParam(required = false) List<String> email,
			@RequestParam(required = false) List<String> licenseTier,
			@RequestParam(required = false) List<String> status, @RequestParam(required = false) boolean licensed,
			@RequestParam(required = false) boolean twoFA, @RequestParam(required = false) boolean lockedOut,
			@RequestParam(required = false) List<String> searchFilter,
			@RequestParam(required = false) boolean excludeSelf, @RequestParam(required = false) Number page,
			@RequestParam(required = false) Number size, HttpServletRequest request) {

		Sort sortObject = Sort.unsorted();

		Map<String, List<String>> queryParms = new HashMap<>();
		queryParms.put("userid", userid);
		queryParms.put("displayname", displayname);
		queryParms.put("email", email);
		queryParms.put("licenseTier", licenseTier);
		queryParms.put("searchFilter", searchFilter);
		queryParms.put("page", Collections.singletonList(String.valueOf(page)));
		queryParms.put("size", Collections.singletonList(String.valueOf(size)));
		System.out.println("sortObject");
		System.out.println(sortObject);

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");

		PageUserViewModel userDetails = userService.getUserList(queryParms, accessToken);

		return userDetails;

	}

	@PostMapping(value = "/createOrUpdate")
	public ResponseEntity<EditUserResponse> editUser(@RequestBody EditUserRequest editUserRequest,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute("accessToken");

		ResponseEntity<EditUserResponse> response = userService.editUser(accessToken, editUserRequest);

		System.out.println(response);

		return response;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			// Read the uploaded file as JSON using Jackson
			ObjectMapper objectMapper = new ObjectMapper();

			String userDetailsInfo = objectMapper.writeValueAsString(file.getInputStream());
			JsonNode jsonNode = objectMapper.readTree(userDetailsInfo);

			System.out.println("File Upload");

			for (JsonNode user : jsonNode) {

				String userId = user.get("userId").asText();
				String displayname = user.get("realName").asText();
				String email = user.get("email").asText();
				String searchFilter = user.get("searchFilter").asText();

				System.out.println("user upload");

				System.out.println("localhost:8080/api/users/getUserList?userid=" + userId + "&displayname="
						+ displayname + "&licenseTier=null&sort=realName,asc&email=" + email
						+ "&page=0&size=100&searchFilter=" + searchFilter + "");

			}

			// Pass the JSON payload to another REST API
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(
					"localhost:8080/api/users/getUserList?userid=&displayname=&licenseTier=null&sort=realName,asc&email=&page=0&size=100&searchFilter=",
					HttpMethod.GET, requestEntity, String.class);

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				return ResponseEntity.ok("File uploaded and processed successfully");
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the file");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read the file");
		}

	}

	@PostMapping("/uploadUserInput")
	public ResponseEntity<String> handleJsonInput(@RequestBody MultiUserInput[] userinputs,
			HttpServletRequest request) {

		boolean JsonValue = true;

		try {
			// Read the uploaded file as JSON using Jackson
			ObjectMapper objectMapper = new ObjectMapper();

			String userDetailsInfo = objectMapper.writeValueAsString(userinputs);
			JsonNode jsonNode = objectMapper.readTree(userDetailsInfo);

			System.out.println("User Input Json Upload");
			System.out.println(userDetailsInfo);
			System.out.println(jsonNode);

			HttpSession session = request.getSession();
			String accessToken = (String) session.getAttribute("accessToken");

			System.out.println("accessToken");

			System.out.println(accessToken);

			for (JsonNode user : jsonNode) {

				System.out.println("user loop ");
				System.out.println(user);
				// !user.isNull()
				if (user.isNull()) {
					JsonValue = false;
					System.out.println(JsonValue + "json status");
				} else {
					System.out.println(user);
					System.out.println(JsonValue + "json status");
				}

				List<String> userId = new ArrayList<>();
				userId.add(user.get("userId").asText());

				List<String> email = new ArrayList<>();
				email.add(user.get("email").asText());

				List<String> displayname = new ArrayList<>();
				displayname.add(user.get("realName").asText());

				System.out.println("user upload");

				Map<String, List<String>> queryParms = new HashMap<>();
				queryParms.put("userid", userId);
				queryParms.put("displayname", displayname);
				queryParms.put("email", email);

				PageUserViewModel userDetails = userService.getUserList(queryParms, accessToken);

				System.out.println("multi edit controller");

				System.out.println(userDetails);
			}

			if (JsonValue == true) {
				return ResponseEntity.ok("File uploaded and processed successfully");
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User is empty");
			}
		} catch (Exception e) {

			return ResponseEntity.ok("Already updated");
		}
	}

}
