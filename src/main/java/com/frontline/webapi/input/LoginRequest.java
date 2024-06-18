package com.frontline.webapi.input;

public class LoginRequest {
	
	private String  username;
    private String  password;
	private String  domain;
	private String twoFactorVerificationCode;
	private String agreedToTos;
	
	
	public LoginRequest( String  username, String  password, String  domain, String twoFactorVerificationCode, String agreedToTos) {
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.twoFactorVerificationCode = twoFactorVerificationCode;
		this.agreedToTos = agreedToTos;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getTwoFactorVerificationCode() {
		return twoFactorVerificationCode;
	}
	public void setTwoFactorVerificationCode(String twoFactorVerificationCode) {
		this.twoFactorVerificationCode = twoFactorVerificationCode;
	}
	public String getAgreedToTos() {
		return agreedToTos;
	}
	public void setAgreedToTos(String agreedToTos) {
		this.agreedToTos = agreedToTos;
	}

}
