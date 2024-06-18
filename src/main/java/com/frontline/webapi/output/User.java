package com.frontline.webapi.output;

import java.util.List;

import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

//@RestController
public class User {

	@JsonProperty("id")
	private int id;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("preferredLocale")
	private String preferredLocale;

	@JsonProperty("licensed")
	private boolean licensed;

	@JsonProperty("licenseTiers")
	private List<LicenseTier> licenseTiers;

	@JsonProperty("lastLoginIpAddress")
	private String lastLoginIpAddress;

	@JsonProperty("attributes")
	private Map<String, String> attributes;

	@JsonProperty("teams")
	private List<Team> teams;

	@JsonProperty("serverRoles")
	private List<ServerRole> serverRoles;

	@JsonProperty("status")
	private String status;

	@JsonProperty("realName")
	private String realName;

	@JsonProperty("wmsUser")
	private Object wmsUser;

	@JsonProperty("webEnabled")
	private boolean webEnabled;

	@JsonProperty("wearableEnabled")
	private boolean wearableEnabled;

	@JsonProperty("technical")
	private boolean technical;

	@JsonProperty("apiKey")
	private String apiKey;

	@JsonProperty("lastApiTokenChange")
	private Object lastApiTokenChange;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("email")
	private String email;

	@JsonProperty("changedBy")
	private String changedBy;

	@JsonProperty("lastLogin")
	@DateTimeFormat()
	private String lastLogin;

	@JsonProperty("createDate")
	@DateTimeFormat()
	private String createDate;

	@JsonProperty("changeDate")
	@DateTimeFormat()
	private String changeDate;

	@JsonProperty("expireDate")
	private Object expireDate;

	@JsonProperty("phoneNumber")
	private Object phoneNumber;

	@JsonProperty("twoFactorEnabled")
	private boolean twoFactorEnabled;

	@JsonProperty("twoFactorInitialSetupDone")
	private boolean twoFactorInitialSetupDone;

	@JsonProperty("domainTag")
	private String domainTag;

	@JsonProperty("domainName")
	private String domainName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getLastLoginIpAddress() {
		return lastLoginIpAddress;
	}

	public void setLastLoginIpAddress(String lastLoginIpAddress) {
		this.lastLoginIpAddress = lastLoginIpAddress;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Object getWmsUser() {
		return wmsUser;
	}

	public void setWmsUser(Object wmsUser) {
		this.wmsUser = wmsUser;
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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Object getLastApiTokenChange() {
		return lastApiTokenChange;
	}

	public void setLastApiTokenChange(Object lastApiTokenChange) {
		this.lastApiTokenChange = lastApiTokenChange;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Object getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Object expireDate) {
		this.expireDate = expireDate;
	}

	public Object getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Object phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isTwoFactorEnabled() {
		return twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public boolean isTwoFactorInitialSetupDone() {
		return twoFactorInitialSetupDone;
	}

	public void setTwoFactorInitialSetupDone(boolean twoFactorInitialSetupDone) {
		this.twoFactorInitialSetupDone = twoFactorInitialSetupDone;
	}

	public String getDomainTag() {
		return domainTag;
	}

	public void setDomainTag(String domainTag) {
		this.domainTag = domainTag;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

}
