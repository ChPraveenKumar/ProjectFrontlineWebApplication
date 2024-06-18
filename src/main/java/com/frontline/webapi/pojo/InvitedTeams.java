package com.frontline.webapi.pojo;

import java.util.List;

public class InvitedTeams {

	private Domain domain;
	private String externalId;
	private long id;
	private String name;
	private Phonebook phonebook;
	private List<ServerRoles> serverRoles;
	private boolean twoFactorEnabled;
	private long userCount;
	
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Phonebook getPhonebook() {
		return phonebook;
	}
	public void setPhonebook(Phonebook phonebook) {
		this.phonebook = phonebook;
	}
	public List<ServerRoles> getServerRoles() {
		return serverRoles;
	}
	public void setServerRoles(List<ServerRoles> serverRoles) {
		this.serverRoles = serverRoles;
	}
	public boolean isTwoFactorEnabled() {
		return twoFactorEnabled;
	}
	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}
	public long getUserCount() {
		return userCount;
	}
	public void setUserCount(long userCount) {
		this.userCount = userCount;
	}
	@Override
	public String toString() {
		return "InvitedTeams [domain=" + domain + ", externalId=" + externalId + ", id=" + id + ", name=" + name
				+ ", phonebook=" + phonebook + ", serverRoles=" + serverRoles + ", twoFactorEnabled=" + twoFactorEnabled
				+ ", userCount=" + userCount + "]";
	}
}
