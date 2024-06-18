package com.frontline.webapi.pojo;

import java.util.List;

public class Asset {
	
	    private String checksum;
	    private long createdAt;
	    private String createdBy;
	    private long deletedAt;
	    private String deletedBy;
	    private String description;
	    private String domain;
	    private String id;
	    private String name;
	    private String state;
	    private List<String> tags;
	    private String type;
	    private long updatedAt;
	    private String updatedBy;
	    private String uri;
	    private String version;
	    
		public String getChecksum() {
			return checksum;
		}
		public void setChecksum(String checksum) {
			this.checksum = checksum;
		}
		
		public long getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(long createdAt) {
			this.createdAt = createdAt;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public long getDeletedAt() {
			return deletedAt;
		}
		public void setDeletedAt(long deletedAt) {
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
		public List<String> getTags() {
			return tags;
		}
		public void setTags(List<String> tags) {
			this.tags = tags;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public long getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(long updatedAt) {
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
			return "Asset [checksum=" + checksum + ", createdAt=" + createdAt + ", createdBy=" + createdBy
					+ ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + ", description=" + description
					+ ", domain=" + domain + ", id=" + id + ", name=" + name + ", state=" + state + ", tags=" + tags
					+ ", type=" + type + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", uri=" + uri
					+ ", version=" + version + "]";
		}
}