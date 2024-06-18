package com.frontline.webapi.pojo;

public class InvitedContacts {

	 public String displayName;
	    private String domain;
	    private String email;
	    private long id;
	    private String inviteId;
	    private String locale;
	    private String phoneNumber;
	    private long userDbId;
	    private String userId;
	    
		public String getDisplayName() {
			return displayName;
		}
		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getInviteId() {
			return inviteId;
		}
		public void setInviteId(String inviteId) {
			this.inviteId = inviteId;
		}
		public String getLocale() {
			return locale;
		}
		public void setLocale(String locale) {
			this.locale = locale;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getUserDbId() {
			return userDbId;
		}
		public void setUserDbId(long userDbId) {
			this.userDbId = userDbId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		@Override
		public String toString() {
			return "InvitedContacts [displayName=" + displayName + ", domain=" + domain + ", email=" + email + ", id="
					+ id + ", inviteId=" + inviteId + ", locale=" + locale + ", phoneNumber=" + phoneNumber
					+ ", userDbId=" + userDbId + ", userId=" + userId + "]";
		}
}
