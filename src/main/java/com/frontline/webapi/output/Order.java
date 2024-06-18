package com.frontline.webapi.output;

import java.util.List;

public class Order {

	private String id;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", purchaseOrder=" + purchaseOrder + ", roles=" + roles + "]";
	}

}
