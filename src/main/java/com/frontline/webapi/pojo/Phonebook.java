package com.frontline.webapi.pojo;

public class Phonebook {

	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Phonebook [id=" + id + "]";
	}
	
}
