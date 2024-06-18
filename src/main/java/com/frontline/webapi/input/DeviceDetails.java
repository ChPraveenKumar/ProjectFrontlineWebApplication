package com.frontline.webapi.input;

public class DeviceDetails {
	
	public String bluetoothMac;
    public String deviceCategory;
    public String deviceType;
    public String os;
    public String osBuildNumber;
    public int sdk;
    public String serialNumber;
    public String wifiMac;
	public String getBluetoothMac() {
		return bluetoothMac;
	}
	public void setBluetoothMac(String bluetoothMac) {
		this.bluetoothMac = bluetoothMac;
	}
	public String getDeviceCategory() {
		return deviceCategory;
	}
	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOsBuildNumber() {
		return osBuildNumber;
	}
	public void setOsBuildNumber(String osBuildNumber) {
		this.osBuildNumber = osBuildNumber;
	}
	public int getSdk() {
		return sdk;
	}
	public void setSdk(int sdk) {
		this.sdk = sdk;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getWifiMac() {
		return wifiMac;
	}
	public void setWifiMac(String wifiMac) {
		this.wifiMac = wifiMac;
	}
	@Override
	public String toString() {
		return "DeviceDetails [bluetoothMac=" + bluetoothMac + ", deviceCategory=" + deviceCategory + ", deviceType="
				+ deviceType + ", os=" + os + ", osBuildNumber=" + osBuildNumber + ", sdk=" + sdk + ", serialNumber="
				+ serialNumber + ", wifiMac=" + wifiMac + "]";
	}
    
	

}
