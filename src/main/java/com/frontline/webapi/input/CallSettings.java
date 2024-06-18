package com.frontline.webapi.input;

public class CallSettings {

	private int ascendants ;
	private CallNotificationType callNotificationType;	
	private boolean canBeCalled	;
	private boolean	canCallChildGroups;	
	private boolean canCallOwnGbooleanroup;	
	private boolean canCallParentGroups	;
	private boolean canCallSameLevel;
	private int descendants;
	private boolean includeTeamMembersAsUsers;
	public int getAscendants() {
		return ascendants;
	}
	public void setAscendants(int ascendants) {
		this.ascendants = ascendants;
	}
	public CallNotificationType getCallNotificationType() {
		return callNotificationType;
	}
	public void setCallNotificationType(CallNotificationType callNotificationType) {
		this.callNotificationType = callNotificationType;
	}
	public boolean isCanBeCalled() {
		return canBeCalled;
	}
	public void setCanBeCalled(boolean canBeCalled) {
		this.canBeCalled = canBeCalled;
	}
	public boolean isCanCallChildGroups() {
		return canCallChildGroups;
	}
	public void setCanCallChildGroups(boolean canCallChildGroups) {
		this.canCallChildGroups = canCallChildGroups;
	}
	public boolean isCanCallOwnGbooleanroup() {
		return canCallOwnGbooleanroup;
	}
	public void setCanCallOwnGbooleanroup(boolean canCallOwnGbooleanroup) {
		this.canCallOwnGbooleanroup = canCallOwnGbooleanroup;
	}
	public boolean isCanCallParentGroups() {
		return canCallParentGroups;
	}
	public void setCanCallParentGroups(boolean canCallParentGroups) {
		this.canCallParentGroups = canCallParentGroups;
	}
	public boolean isCanCallSameLevel() {
		return canCallSameLevel;
	}
	public void setCanCallSameLevel(boolean canCallSameLevel) {
		this.canCallSameLevel = canCallSameLevel;
	}
	public int getDescendants() {
		return descendants;
	}
	public void setDescendants(int descendants) {
		this.descendants = descendants;
	}
	public boolean isIncludeTeamMembersAsUsers() {
		return includeTeamMembersAsUsers;
	}
	public void setIncludeTeamMembersAsUsers(boolean includeTeamMembersAsUsers) {
		this.includeTeamMembersAsUsers = includeTeamMembersAsUsers;
	}
	
	
}
