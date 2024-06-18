package com.frontline.webapi.pojo;

import java.util.ArrayList;

public class Assets {

	private String checksum;
	private int createdAt;
	private String createdBy;
	private int deletedAt;
	private String deletedBy;
	private String description;
	private String domain;
	private String id;
	private String name;
	private String state;
	private ArrayList<String> tags;
	private String type;
	private int updatedAt;
	private String updatedBy;
	private String uri;
	private String version;
	
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public int getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(int deletedAt) {
		this.deletedAt = deletedAt;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Assets [checksum=" + checksum + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", deletedAt="
				+ deletedAt + ", deletedBy=" + deletedBy + ", description=" + description + ", domain=" + domain
				+ ", id=" + id + ", name=" + name + ", state=" + state + ", tags=" + tags + ", type=" + type
				+ ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", uri=" + uri + ", version=" + version
				+ "]";
	}	
}
