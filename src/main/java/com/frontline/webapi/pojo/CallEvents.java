package com.frontline.webapi.pojo;

import java.util.Date;

public class CallEvents {

	private Asset asset;
	private String assetUri;
	private String comment;
	private Contact contact;
	private long deletedAt;
	private String deletedBy;
	private long id;
	private String locale;
	private Date time;
	private String type;
	
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public String getAssetUri() {
		return assetUri;
	}
	public void setAssetUri(String assetUri) {
		this.assetUri = assetUri;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "CallEvents [asset=" + asset + ", assetUri=" + assetUri + ", comment=" + comment + ", contact=" + contact
				+ ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + ", id=" + id + ", locale=" + locale
				+ ", time=" + time + ", type=" + type + "]";
	}
}
