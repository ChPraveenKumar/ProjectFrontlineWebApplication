package com.frontline.webapi.input;

public class MultiUserInput {

	private String realName;
	private String userId;
	private String email;
	private String searchFilter;
	
	public MultiUserInput(String realName, String userId, String email, String searchFilter) {
		super();
		this.realName = realName;
		this.userId = userId;
		this.email = email;
		this.searchFilter = searchFilter;
	}

	public MultiUserInput() {
		
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

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}
	
}
