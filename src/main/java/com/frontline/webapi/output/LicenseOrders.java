package com.frontline.webapi.output;

import java.util.List;

public class LicenseOrders {
	
private String purchaseOrder;
	
	private List<LicenseRole> roles;

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public List<LicenseRole> getRoles() {
		return roles;
	}

	public void setRoles(List<LicenseRole> roles) {
		this.roles = roles;
	}

	

}
