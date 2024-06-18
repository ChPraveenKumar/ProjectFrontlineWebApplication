package com.frontline.webapi.output;

import java.util.List;


public class Team {
	
    private int id;
    private String name;
    private int userCount;
    private Boolean twoFactorEnabled;
    private Object phonebook;
    private List<ServerRole> serverRoles;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public Boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Object getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(Object phonebook) {
        this.phonebook = phonebook;
    }

    public List<ServerRole> getServerRoles() {
        return serverRoles;
    }

    public void setServerRoles(List<ServerRole> serverRoles) {
        this.serverRoles = serverRoles;
    }

}
