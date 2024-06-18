package com.frontline.webapi.service.impl;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.frontline.webapi.GlobalConfig;
import com.frontline.webapi.input.NodeViewModel;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import com.frontline.webapi.input.NodeUsersViewModel;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CallManagementService {

	@Autowired
	private GlobalConfig globalConfig;

	@Autowired
	private RestTemplate restTemplate;

	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	String todayDate = formatter.format(date);

	String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";

	public String getCallManagementJson(String accessToken) {

		String apiUrl = globalConfig.getApiUrl();

		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
		header.setContentType(MediaType.APPLICATION_JSON);

		String getCMCallSettingsUrl = apiUrl + "expert-identification/get";

		URI getCMCallSettingsUri = UriComponentsBuilder.fromUriString(getCMCallSettingsUrl).build().toUri();
		System.out.println("CallManagementSettingsURI:" + getCMCallSettingsUri);

		ResponseEntity<NodeViewModel[]> callManagementSettingsResponse = restTemplate.exchange(getCMCallSettingsUri,
				HttpMethod.GET, new HttpEntity<>(header), NodeViewModel[].class);

		NodeViewModel[] modelArray = callManagementSettingsResponse.getBody();
		List<NodeViewModel> nodeArray = Arrays.asList(modelArray);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = JsonNodeFactory.instance.objectNode();
		try {
			String nodes = objectMapper.writeValueAsString(nodeArray);
			jsonNode = objectMapper.readTree(nodes);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		List<String> nodeIdList = Arrays.stream(modelArray).map(NodeViewModel::getNodeId).collect(Collectors.toList());

		String callManagementSettingsJsonPath = desktopPath + "/CallManagement_Settings_Backup_" + todayDate + ".json";

		try (PrintWriter out = new PrintWriter(new FileWriter(callManagementSettingsJsonPath))) {
			out.write(jsonNode.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ---------------------------------CallManagement Users and Teams------------------------------------------
		StringBuilder usersJsonResponse = new StringBuilder("[");
		for (int i = 0; i < nodeIdList.size(); i++) {
			String getCMUsersUrl = apiUrl + "expert-identification/users/get";
			URI getCMUsersUri = UriComponentsBuilder.fromUriString(getCMUsersUrl)
					.queryParam("nodeId", nodeIdList.get(i)).build().toUri();
			System.out.println("CallManagementUsersURI:" + getCMUsersUri);

			ResponseEntity<JSONObject> callManagementUsersResponse = restTemplate.exchange(getCMUsersUri,
					HttpMethod.GET, new HttpEntity<>(header), JSONObject.class);
			if (i == 0) {
				usersJsonResponse.append(callManagementUsersResponse.getBody());
			} else {
				usersJsonResponse.append("," + callManagementUsersResponse.getBody());
			}

		}
		usersJsonResponse.append("]");

		String callManagementUsersJsonPath = desktopPath + "/CallManagement_Users_Backup_" + todayDate + ".json";
		try (PrintWriter out = new PrintWriter(new FileWriter(callManagementUsersJsonPath))) {
			out.write(usersJsonResponse.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "CallManagementSetting and CallManagementUser backup Files Created on the desktop.";

	}


	public ResponseEntity<NodeViewModel> addCallManagement(String accessToken, NodeViewModel nodeViewModel) {

		String apiUrl = globalConfig.getApiUrl();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + accessToken);
		// Give The URL
		String url = apiUrl + "expert-identification/createOrUpdate";

		try {
			ResponseEntity<NodeViewModel> addCallNode = restTemplate.exchange(url, HttpMethod.POST,
					new HttpEntity<>(nodeViewModel, headers), NodeViewModel.class);
			System.out.println("Call  Management response");
			System.out.println(addCallNode);
			System.out.println(addCallNode.getBody());
			return ResponseEntity.ok(addCallNode.getBody());
		} catch (HttpClientErrorException.BadRequest ex) {
			return ResponseEntity.badRequest().body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

	public ResponseEntity<NodeViewModel[]> restoreCallManagementDeleted(String accessToken,
			NodeViewModel[] nodeViewModelBackupArray) {

		String apiUrl = globalConfig.getApiUrl();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + accessToken);

		try {
			String url = apiUrl + "expert-identification/get";

			URI uri = UriComponentsBuilder.fromUriString(url).build().toUri();
			System.out.println("URI:" + uri);

			ResponseEntity<JSONArray> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers),
					JSONArray.class);

			String responseJsonString = response.getBody().toString();
			String postUrl = apiUrl + "expert-identification/createOrUpdate";
			String postUserUrl = apiUrl + "expert-identification/users/save";

			for (int i = 0; i < nodeViewModelBackupArray.length; i++) {
				System.out.println("Iterating node :" + nodeViewModelBackupArray[i].getNodeId());
				String backupNodeId = nodeViewModelBackupArray[i].getNodeId();
				if (!responseJsonString.contains(backupNodeId)) {
					NodeViewModel nodeViewModelUpdate = nodeViewModelBackupArray[i];
					restTemplate.exchange(postUrl, HttpMethod.POST, new HttpEntity<>(nodeViewModelUpdate, headers),
							NodeViewModel.class);

					System.out.println("-------------reading users backup file-------------");
					byte[] jsonData = Files.readAllBytes(
							Paths.get(desktopPath + "/CallManagement_Users_Backup_" + todayDate + ".json"));
					ObjectMapper objectMapper = new ObjectMapper();

					JsonNode[] userNodeList = objectMapper.readValue(jsonData, JsonNode[].class);

					for (int j = 0; j < userNodeList.length; j++) {
						JsonNode node = userNodeList[j];
						if (node.toString().contains(backupNodeId)) {
							System.out.println("Updating user for nodeId:" + node);
							NodeUsersViewModel jNodeUpdate = objectMapper.convertValue(node, NodeUsersViewModel.class);
							restTemplate.exchange(postUserUrl, HttpMethod.POST, new HttpEntity<>(jNodeUpdate, headers),
									NodeUsersViewModel.class);
						}
					}

				}

			}

		} catch (HttpClientErrorException.BadRequest ex) {
			return ResponseEntity.badRequest().body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return new ResponseEntity<NodeViewModel[]>(HttpStatus.OK);

	}

}
