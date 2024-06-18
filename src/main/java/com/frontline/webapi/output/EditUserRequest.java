package com.frontline.webapi.output;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditUserRequest {
	
	
		@JsonProperty("domainTag")
		private String domainTag;
	
		@JsonProperty("user")
		private User user;
	    
	    @JsonProperty("licenseTiers")
	    private List<LicenseTier> licenseTiers;
	    
	    @JsonProperty("roles")
	    private List<Role> roles;
	    
	    @JsonProperty("password")
	    private String password;
	    
	    @JsonProperty("wmsPassword")
	    private String wmsPassword;
	    
	    @JsonProperty("setWmsPassword")
	    private boolean setWmsPassword;
	        
	    @JsonProperty("setPassword")
	    private boolean setPassword;
	    	    
	    @JsonProperty("pin")
	    private String pin;
	    

	    public List<LicenseTier> getLicenseTiers() {
	        return licenseTiers;
	    }

	    public void setLicenseTiers(List<LicenseTier> licenseTiers) {
	        this.licenseTiers = licenseTiers;
	    }

	    public List<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(List<Role> roles) {
	        this.roles = roles;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

		public String getDomainTag() {
			return domainTag;
		}

		public void setDomainTag(String domainTag) {
			this.domainTag = domainTag;
		}

		public String getWmsPassword() {
			return wmsPassword;
		}

		public void setWmsPassword(String wmsPassword) {
			this.wmsPassword = wmsPassword;
		}

		public String getPin() {
			return pin;
		}

		public void setPin(String pin) {
			this.pin = pin;
		}

		public boolean isSetWmsPassword() {
			return setWmsPassword;
		}

		public void setSetWmsPassword(boolean setWmsPassword) {
			this.setWmsPassword = setWmsPassword;
		}

		public boolean isSetPassword() {
			return setPassword;
		}

		public void setSetPassword(boolean setPassword) {
			this.setPassword = setPassword;
		}

		public void setUser(User user) {
			this.user = user;
		}


}
