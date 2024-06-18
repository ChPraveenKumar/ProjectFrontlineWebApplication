package com.frontline.webapi.output;


public class LicenseTier {
	
	   private int id;
       private Domain domain;
       private String licenseTier;

       // Getters and Setters

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public Domain getDomain() {
           return domain;
       }

       public void setDomain(Domain domain) {
           this.domain = domain;
       }

       public String getLicenseTier() {
           return licenseTier;
       }

       public void setLicenseTier(String licenseTier) {
           this.licenseTier = licenseTier;
       }

}
