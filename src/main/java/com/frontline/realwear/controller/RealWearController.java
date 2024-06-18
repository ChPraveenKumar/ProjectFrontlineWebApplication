package com.frontline.realwear.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping(path = "/realapi")
public class RealWearController {

	@PostMapping(value = "/compare")
	public JsonNode compareDevices(@RequestBody String jsonInput) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode input = mapper.readTree(jsonInput);

		JsonNode devicesNode = input.get("devices");
		JsonNode groupNodes = input.get("group");

		ArrayNode resultDevicesArray = mapper.createArrayNode();
		Set<String> allDevices = new HashSet<>();
		List<JsonNode> unmatchedDevices = new ArrayList<>();

		for (JsonNode groupNode : groupNodes) {
			// Get the group information
			String groupId = groupNode.get("deviceGroupId").asText();
			String groupName = groupNode.get("name").asText();
			String groupDescription = groupNode.get("description").asText();

			for (JsonNode Groupdevice : groupNode.get("devices")) {

				System.out.println("device group List");
				System.out.println(Groupdevice.asText());

				allDevices.add(Groupdevice.asText());
			}

			// Iterate through devices and add group information to matching devices
			for (JsonNode device : devicesNode) {
				String deviceId = device.get("id").asText();

				// Check if the device ID is present in the group's device list
				ArrayNode devicesInGroup = (ArrayNode) groupNode.get("devices");

				boolean deviceMatched = false;
				for (JsonNode groupIdNode : devicesInGroup) {
					if (groupIdNode.asText().equals(deviceId)) {
						deviceMatched = true;
						break;
					}
				}

				// If the device is in the group, add the group information
				if (deviceMatched) {
					ObjectNode deviceWithGroupNode = mapper.createObjectNode();
					deviceWithGroupNode.setAll((ObjectNode) device);
					deviceWithGroupNode.put("deviceGroupId", groupId);
					deviceWithGroupNode.put("groupUpdated", groupNode.get("updated").asText());
					deviceWithGroupNode.put("groupWorkspaceId", groupNode.get("workspaceId").asText());
					deviceWithGroupNode.put("groupName", groupName);
					deviceWithGroupNode.put("groupDescription", groupDescription);
					resultDevicesArray.add(deviceWithGroupNode);
				}
			}
		}

		for (JsonNode device : devicesNode) {
			String deviceId = device.get("id").asText();
			if (!allDevices.contains(deviceId)) {
				unmatchedDevices.add(device);
			}
		}

		if (!unmatchedDevices.isEmpty()) {
			for (JsonNode IndividualDevic : unmatchedDevices) {
				resultDevicesArray.add(IndividualDevic);
			}
		}

		System.out.println("list of device in group");
		System.out.println(allDevices);

		System.out.println("Unmatched device");
		System.out.println(unmatchedDevices);

		ObjectNode resultNode = mapper.createObjectNode();
		resultNode.set("devices", resultDevicesArray);

		return resultNode;
	}

}
