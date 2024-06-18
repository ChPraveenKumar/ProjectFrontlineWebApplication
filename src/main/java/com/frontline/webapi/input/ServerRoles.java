package com.frontline.webapi.input;

import java.util.List;

public class ServerRoles {
	
	
	private boolean custom;
	
	private String domainTag;
	private Number id;
	private  String name;
	private List <String> permissions;
	
	
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public String getDomainTag() {
		return domainTag;
	}
	public void setDomainTag(String domainTag) {
		this.domainTag = domainTag;
	}
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "ServerRoles [custom=" + custom + ", domainTag=" + domainTag + ", id=" + id + ", name=" + name
				+ ", permissions=" + permissions + "]";
	}
}

