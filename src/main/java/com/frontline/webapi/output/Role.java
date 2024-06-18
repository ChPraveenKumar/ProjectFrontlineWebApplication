package com.frontline.webapi.output;

public class Role {

	private String name;
    private boolean disabled;

    public Role() {
		
	} 

    public Role(String name, boolean disabled) {
		super();
		this.name = name;
		this.disabled = disabled;
	}
    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
