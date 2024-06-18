package com.frontline.webapi.pojo;

import java.util.List;

public class PositionGroups {

	 private long currentPosition;
	 private long id;
	 private String name;
	 private List<Positions> positions;
	 
	public long getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(long currentPosition) {
		this.currentPosition = currentPosition;
	}
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
	public List<Positions> getPositions() {
		return positions;
	}
	public void setPositions(List<Positions> positions) {
		this.positions = positions;
	}
	@Override
	public String toString() {
		return "PositionGroups [currentPosition=" + currentPosition + ", id=" + id + ", name=" + name + ", positions="
				+ positions + "]";
	} 
}
