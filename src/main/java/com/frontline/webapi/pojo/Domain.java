package com.frontline.webapi.pojo;

public class Domain {

	private long id;
	private String name;
	private String tag;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
