package com.frontline.webapi.input;

public class Domain {

	public int id;
    public String name;
    public String tag;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Domain [id=" + id + ", name=" + name + ", tag=" + tag + "]";
	}
    
	
}
