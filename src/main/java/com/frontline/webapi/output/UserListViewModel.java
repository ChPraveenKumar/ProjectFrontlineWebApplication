package com.frontline.webapi.output;

import java.util.List;

public class UserListViewModel {
	
	private int id;
	private String realName;
	private String userId;
	private String email;
	private String domainTag;
	private String phoneNumber;
	private String preferredLocale;
	private boolean licensed;
	private boolean twoFactorEnabled;
	private boolean webEnabled;
	private boolean wearableEnabled;
	private boolean technical;
	private String createDate;
	private String changeDate;
	private String lastLogin;
	private String changedBy;
	private String apiKey;
	private String wmsUser;
	private boolean hasWMSPassword;
	private StatusEnum status;
    private Attributes attributes;
    private List<Team> teams;
    private List<ServerRole> serverRoles;
    private List<LicenseTier> licenseTiers;
    private String oidcIdentifier;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
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
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
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
	public String getOidcIdentifier() {
		return oidcIdentifier;
	}
	public void setOidcIdentifier(String oidcIdentifier) {
		this.oidcIdentifier = oidcIdentifier;
	}
    
    

}
