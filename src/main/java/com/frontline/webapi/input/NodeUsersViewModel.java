package com.frontline.webapi.input;

import java.util.List;

import com.frontline.webapi.output.Team;
import com.frontline.webapi.output.UserListViewModel;

public class NodeUsersViewModel {
	
	private List<UserListViewModel> admins;
	private String nodeId;
	private List<Team> teams;
	private List<UserListViewModel> users;
	
	public NodeUsersViewModel() {
		
	}
	
	public NodeUsersViewModel(List<UserListViewModel> admins, String nodeId, List<Team> teams,
			List<UserListViewModel> users) {
		super();
		this.admins = admins;
		this.nodeId = nodeId;
		this.teams = teams;
		this.users = users;
	}

	public List<UserListViewModel> getAdmins() {
		return admins;
	}

	public void setAdmins(List<UserListViewModel> admins) {
		this.admins = admins;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<UserListViewModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserListViewModel> users) {
		this.users = users;
	}

}
