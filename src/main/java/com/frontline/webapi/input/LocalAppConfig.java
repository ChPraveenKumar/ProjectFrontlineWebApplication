package com.frontline.webapi.input;

import java.util.Date;

public class LocalAppConfig {
	
	public String apkAssetId;
    public String apkAssetVersion;
    public String apkBuildId;
    public String apkPackageName;
    public Date changeDate;
    public String configBundleAssetId;
    public String configBundleAssetVersion;
    public Date createDate;
    public String displayNameApplication;
    public String displayNameDescription;
    public String displayNameVersion;
    public String domain;
    public int id;
    public String template;
    public String token;
    public int versionCode;
	public String getApkAssetId() {
		return apkAssetId;
	}
	public void setApkAssetId(String apkAssetId) {
		this.apkAssetId = apkAssetId;
	}
	public String getApkAssetVersion() {
		return apkAssetVersion;
	}
	public void setApkAssetVersion(String apkAssetVersion) {
		this.apkAssetVersion = apkAssetVersion;
	}
	public String getApkBuildId() {
		return apkBuildId;
	}
	public void setApkBuildId(String apkBuildId) {
		this.apkBuildId = apkBuildId;
	}
	public String getApkPackageName() {
		return apkPackageName;
	}
	public void setApkPackageName(String apkPackageName) {
		this.apkPackageName = apkPackageName;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getConfigBundleAssetId() {
		return configBundleAssetId;
	}
	public void setConfigBundleAssetId(String configBundleAssetId) {
		this.configBundleAssetId = configBundleAssetId;
	}
	public String getConfigBundleAssetVersion() {
		return configBundleAssetVersion;
	}
	public void setConfigBundleAssetVersion(String configBundleAssetVersion) {
		this.configBundleAssetVersion = configBundleAssetVersion;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDisplayNameApplication() {
		return displayNameApplication;
	}
	public void setDisplayNameApplication(String displayNameApplication) {
		this.displayNameApplication = displayNameApplication;
	}
	public String getDisplayNameDescription() {
		return displayNameDescription;
	}
	public void setDisplayNameDescription(String displayNameDescription) {
		this.displayNameDescription = displayNameDescription;
	}
	public String getDisplayNameVersion() {
		return displayNameVersion;
	}
	public void setDisplayNameVersion(String displayNameVersion) {
		this.displayNameVersion = displayNameVersion;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	@Override
	public String toString() {
		return "LocalAppConfig [apkAssetId=" + apkAssetId + ", apkAssetVersion=" + apkAssetVersion + ", apkBuildId="
				+ apkBuildId + ", apkPackageName=" + apkPackageName + ", changeDate=" + changeDate
				+ ", configBundleAssetId=" + configBundleAssetId + ", configBundleAssetVersion="
				+ configBundleAssetVersion + ", createDate=" + createDate + ", displayNameApplication="
				+ displayNameApplication + ", displayNameDescription=" + displayNameDescription
				+ ", displayNameVersion=" + displayNameVersion + ", domain=" + domain + ", id=" + id + ", template="
				+ template + ", token=" + token + ", versionCode=" + versionCode + "]";
	}
    
    

}
