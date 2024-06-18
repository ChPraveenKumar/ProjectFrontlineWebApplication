package com.frontline.webapi.output;

import java.util.Date;

public class LicenseRole {

	private String id;

	private int amount;
	private String licenseTier;
	private Date startDate;
	private Date stopDate;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getLicenseTier() {
		return licenseTier;
	}

	public void setLicenseTier(String licenseTier) {
		this.licenseTier = licenseTier;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LicenseRole [id=" + id + ", amount=" + amount + ", licenseTier=" + licenseTier + ", startDate="
				+ startDate + ", stopDate=" + stopDate + "]";
	}

}
