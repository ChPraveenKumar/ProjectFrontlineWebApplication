package com.frontline.webapi.pojo;

public class Attachments {

	private String assetUri;
	private String changeDate;
	private long id;
	private String payload;
	private String type;
	
	public String getAssetUri() {
		return assetUri;
	}
	public void setAssetUri(String assetUri) {
		this.assetUri = assetUri;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Attachments [assetUri=" + assetUri + ", changeDate=" + changeDate + ", id=" + id + ", payload="
				+ payload + ", type=" + type + "]";
	}
}
