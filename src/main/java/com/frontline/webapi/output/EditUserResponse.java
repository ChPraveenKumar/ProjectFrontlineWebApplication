package com.frontline.webapi.output;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class EditUserResponse {
	
	@JsonProperty("id")
    private int id;
	
	@JsonProperty("realName")
    private String realName;
	
	@JsonProperty("userId")
    private String userId;
	
	@JsonProperty("email")
    private String email;
	
	@JsonProperty("domainTag")
    private String domainTag;
	
	@JsonProperty("phoneNumber")
    private String phoneNumber;
	
	@JsonProperty("preferredLocale")
    private String preferredLocale;
	
	@JsonProperty("licensed")
    private boolean licensed;
	
	@JsonProperty("twoFactorEnabled")
    private boolean twoFactorEnabled;
	
	@JsonProperty("webEnabled")
    private boolean webEnabled;
	
	@JsonProperty("wearableEnabled")
    private boolean wearableEnabled;
	
	@JsonProperty("technical")
    private boolean technical;
	
	@JsonProperty("createDate")
    private String createDate;
	
	@JsonProperty("changeDate")
    private String changeDate;
	
	@JsonProperty("lastLogin")
    private String lastLogin;
	
	@JsonProperty("changedBy")
    private String changedBy;
	
	@JsonProperty("apiKey")
    private String apiKey;
	
	@JsonProperty("wmsUser")
    private String wmsUser;
	
	@JsonProperty("hasWMSPassword")
    private boolean hasWMSPassword;
	
	@JsonProperty("status")
    private String status;
	
	@JsonProperty("attributes")
    private Attributes attributes;
	
	@JsonProperty("teams")
    private List<Team> teams;
	
	@JsonProperty("serverRoles")
    private List<ServerRole> serverRoles;
	
	@JsonProperty("licenseTiers")
    private List<LicenseTier> licenseTiers;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomainTag() {
		return domainTag;
	}
	public void setDomainTag(String domainTag) {
		this.domainTag = domainTag;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPreferredLocale() {
		return preferredLocale;
	}
	public void setPreferredLocale(String preferredLocale) {
		this.preferredLocale = preferredLocale;
	}
	public boolean isLicensed() {
		return licensed;
	}
	public void setLicensed(boolean licensed) {
		this.licensed = licensed;
	}
	public boolean isTwoFactorEnabled() {
		return twoFactorEnabled;
	}
	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}
	public boolean isWebEnabled() {
		return webEnabled;
	}
	public void setWebEnabled(boolean webEnabled) {
		this.webEnabled = webEnabled;
	}
	public boolean isWearableEnabled() {
		return wearableEnabled;
	}
	public void setWearableEnabled(boolean wearableEnabled) {
		this.wearableEnabled = wearableEnabled;
	}
	public boolean isTechnical() {
		return technical;
	}
	public void setTechnical(boolean technical) {
		this.technical = technical;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getWmsUser() {
		return wmsUser;
	}
	public void setWmsUser(String wmsUser) {
		this.wmsUser = wmsUser;
	}
	public boolean isHasWMSPassword() {
		return hasWMSPassword;
	}
	public void setHasWMSPassword(boolean hasWMSPassword) {
		this.hasWMSPassword = hasWMSPassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public List<ServerRole> getServerRoles() {
		return serverRoles;
	}
	public void setServerRoles(List<ServerRole> serverRoles) {
		this.serverRoles = serverRoles;
	}
	public List<LicenseTier> getLicenseTiers() {
		return licenseTiers;
	}
	public void setLicenseTiers(List<LicenseTier> licenseTiers) {
		this.licenseTiers = licenseTiers;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}


}
