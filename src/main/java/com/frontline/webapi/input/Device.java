package com.frontline.webapi.input;

import java.util.ArrayList;
import java.util.Date;

public class Device {
	
	public String appType;
    public Attributes attributes;
    public Date changeDate;
    public String changedBy;
    public String clientId;
    public String clientName;
    public Date createDate;
    public String currentBuildId;
    public int currentUserId;
    public String currentUserName;
    public DeviceDetails deviceDetails;
    public Domain domain;
    public int id;
    public String ipAddress;
    public ArrayList<LocalAppConfig> localAppConfig;
    public int recentUserId;
    public String recentUserName;
    public String status;
    public String wifi;
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCurrentBuildId() {
		return currentBuildId;
	}
	public void setCurrentBuildId(String currentBuildId) {
		this.currentBuildId = currentBuildId;
	}
	public int getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(int currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public DeviceDetails getDeviceDetails() {
		return deviceDetails;
	}
	public void setDeviceDetails(DeviceDetails deviceDetails) {
		this.deviceDetails = deviceDetails;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public ArrayList<LocalAppConfig> getLocalAppConfig() {
		return localAppConfig;
	}
	public void setLocalAppConfig(ArrayList<LocalAppConfig> localAppConfig) {
		this.localAppConfig = localAppConfig;
	}
	public int getRecentUserId() {
		return recentUserId;
	}
	public void setRecentUserId(int recentUserId) {
		this.recentUserId = recentUserId;
	}
	public String getRecentUserName() {
		return recentUserName;
	}
	public void setRecentUserName(String recentUserName) {
		this.recentUserName = recentUserName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	@Override
	public String toString() {
		return "Root [appType=" + appType + ", attributes=" + attributes + ", changeDate=" + changeDate + ", changedBy="
				+ changedBy + ", clientId=" + clientId + ", clientName=" + clientName + ", createDate=" + createDate
				+ ", currentBuildId=" + currentBuildId + ", currentUserId=" + currentUserId + ", currentUserName="
				+ currentUserName + ", deviceDetails=" + deviceDetails + ", domain=" + domain + ", id=" + id
				+ ", ipAddress=" + ipAddress + ", localAppConfig=" + localAppConfig + ", recentUserId=" + recentUserId
				+ ", recentUserName=" + recentUserName + ", status=" + status + ", wifi=" + wifi + "]";
	}
    
    

}
