package com.frontline.webapi.input;

import com.fasterxml.jackson.databind.JsonNode;

public class NodeViewModel {

	private String nodeId;
	private String parentNodeId;
	private String title;
	private String level;
	private int userCount;
	private int adminCount;
	private int teamsCount;
	private int	numberOfChildren;
	private int levelsAbove	;
	private int levelsBelow;
	private String type;
	private CallSettings callSettings;
	
	private JsonNode attributes;
	
	public int getAdminCount() {
		return adminCount;
	}
	public void setAdminCount(int adminCount) {
		this.adminCount = adminCount;
	}
	public JsonNode getAttributes() {
		return attributes;
	}
	public void setAttributes(JsonNode attributes) {
		this.attributes = attributes;
	}
	public CallSettings getCallSettings() {
		return callSettings;
	}
	public void setCallSettings(CallSettings callSettings) {
		this.callSettings = callSettings;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getLevelsAbove() {
		return levelsAbove;
	}
	public void setLevelsAbove(int levelsAbove) {
		this.levelsAbove = levelsAbove;
	}
	public int getLevelsBelow() {
		return levelsBelow;
	}
	public void setLevelsBelow(int levelsBelow) {
		this.levelsBelow = levelsBelow;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public String getParentNodeId() {
		return parentNodeId;
	}
	public void setParentNodeId(String parentNodeId) {
		this.parentNodeId = parentNodeId;
	}
	public int getTeamsCount() {
		return teamsCount;
	}
	public void setTeamsCount(int teamsCount) {
		this.teamsCount = teamsCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
}
