package com.frontline.webapi.output;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;


//@RestController
public class FrontlineLoginResponse {
	
		@JsonProperty("token")
		private String token;
		
		@JsonProperty("refreshToken")
	    private String refreshToken;
		
		@JsonProperty("permissions")
	    private List<String> permissions;
		
		@JsonProperty("refreshTokenValidUntil")
	    private Long refreshTokenValidUntil;
		
		@JsonProperty("domainTag")
	    private String domainTag;
		
		@JsonProperty("userId")
	    private String userId;
		
		@JsonProperty("previousLogin")
	    private String previousLogin;
		
		@JsonProperty("displayName")
	    private String displayName;
		
		@JsonProperty("locale")
	    private String locale;
		
		@JsonProperty("refreshTokenExistsAlready")
	    private boolean refreshTokenExistsAlready;
		
		@JsonProperty("user")
	    private User user;
		
		@JsonProperty("isFirstTwoFactorLogin")
	    private Boolean isFirstTwoFactorLogin;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getRefreshToken() {
			return refreshToken;
		}

		public void setRefreshToken(String refreshToken) {
			this.refreshToken = refreshToken;
		}

		public List<String> getPermissions() {
			return permissions;
		}

		public void setPermissions(List<String> permissions) {
			this.permissions = permissions;
		}

		public Long getRefreshTokenValidUntil() {
			return refreshTokenValidUntil;
		}

		public void setRefreshTokenValidUntil(Long refreshTokenValidUntil) {
			this.refreshTokenValidUntil = refreshTokenValidUntil;
		}

		public String getDomainTag() {
			return domainTag;
		}

		public void setDomainTag(String domainTag) {
			this.domainTag = domainTag;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPreviousLogin() {
			return previousLogin;
		}

		public void setPreviousLogin(String previousLogin) {
			this.previousLogin = previousLogin;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

		public boolean isRefreshTokenExistsAlready() {
			return refreshTokenExistsAlready;
		}

		public void setRefreshTokenExistsAlready(boolean refreshTokenExistsAlready) {
			this.refreshTokenExistsAlready = refreshTokenExistsAlready;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Boolean getIsFirstTwoFactorLogin() {
			return isFirstTwoFactorLogin;
		}

		public void setIsFirstTwoFactorLogin(Boolean isFirstTwoFactorLogin) {
			this.isFirstTwoFactorLogin = isFirstTwoFactorLogin;
		}
	


}
