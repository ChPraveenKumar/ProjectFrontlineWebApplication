package com.frontline.webapi.pojo;

import java.util.Date;
import java.util.List;

public class Content {

	private boolean anonymousJoinAllowed;
	private List<Asset> assets;
	private Date callEnd;
	private List<CallEvents> callEvents;
	private String callId;
	private String callManagementGroup;
	private String callReason;
	private Date callStart;
	private String callStatus;
	private String callType;
	private CreatorContact creatorContact;
	private long deletedAt;
	private String deletedBy;
	private String description;
	private String domainId;
	private long id;
	private String inviteLink;
	private List<InvitedContacts> invitedContacts;
	private List<InvitedTeams> invitedTeams;
	private String plannedDateTime;
	private PostTask postTask;
	private String postprocessingStatus;
	private String reason;
	private List<Tags> tags;
	private String title;
	
	
	public boolean isAnonymousJoinAllowed() {
		return anonymousJoinAllowed;
	}
	public void setAnonymousJoinAllowed(boolean anonymousJoinAllowed) {
		this.anonymousJoinAllowed = anonymousJoinAllowed;
	}
	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}
	public Date getCallEnd() {
		return callEnd;
	}
	public void setCallEnd(Date callEnd) {
		this.callEnd = callEnd;
	}
	public List<CallEvents> getCallEvents() {
		return callEvents;
	}
	public void setCallEvents(List<CallEvents> callEvents) {
		this.callEvents = callEvents;
	}
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public String getCallManagementGroup() {
		return callManagementGroup;
	}
	public void setCallManagementGroup(String callManagementGroup) {
		this.callManagementGroup = callManagementGroup;
	}
	public String getCallReason() {
		return callReason;
	}
	public void setCallReason(String callReason) {
		this.callReason = callReason;
	}
	public Date getCallStart() {
		return callStart;
	}
	public void setCallStart(Date callStart) {
		this.callStart = callStart;
	}
	public String getCallStatus() {
		return callStatus;
	}
	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public CreatorContact getCreatorContact() {
		return creatorContact;
	}
	public void setCreatorContact(CreatorContact creatorContact) {
		this.creatorContact = creatorContact;
	}
	public long getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(long deletedAt) {
		this.deletedAt = deletedAt;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInviteLink() {
		return inviteLink;
	}
	public void setInviteLink(String inviteLink) {
		this.inviteLink = inviteLink;
	}
	public List<InvitedContacts> getInvitedContacts() {
		return invitedContacts;
	}
	public void setInvitedContacts(List<InvitedContacts> invitedContacts) {
		this.invitedContacts = invitedContacts;
	}
	public List<InvitedTeams> getInvitedTeams() {
		return invitedTeams;
	}
	public void setInvitedTeams(List<InvitedTeams> invitedTeams) {
		this.invitedTeams = invitedTeams;
	}
	public String getPlannedDateTime() {
		return plannedDateTime;
	}
	public void setPlannedDateTime(String plannedDateTime) {
		this.plannedDateTime = plannedDateTime;
	}
	public PostTask getPostTask() {
		return postTask;
	}
	public void setPostTask(PostTask postTask) {
		this.postTask = postTask;
	}
	public String getPostprocessingStatus() {
		return postprocessingStatus;
	}
	public void setPostprocessingStatus(String postprocessingStatus) {
		this.postprocessingStatus = postprocessingStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Content [anonymousJoinAllowed=" + anonymousJoinAllowed + ", assets=" + assets + ", callEnd=" + callEnd
				+ ", callEvents=" + callEvents + ", callId=" + callId + ", callManagementGroup=" + callManagementGroup
				+ ", callReason=" + callReason + ", callStart=" + callStart + ", callStatus=" + callStatus
				+ ", callType=" + callType + ", creatorContact=" + creatorContact + ", deletedAt=" + deletedAt
				+ ", deletedBy=" + deletedBy + ", description=" + description + ", domainId=" + domainId + ", id=" + id
				+ ", inviteLink=" + inviteLink + ", invitedContacts=" + invitedContacts + ", invitedTeams="
				+ invitedTeams + ", plannedDateTime=" + plannedDateTime + ", postTask=" + postTask
				+ ", postprocessingStatus=" + postprocessingStatus + ", reason=" + reason + ", tags=" + tags
				+ ", title=" + title + "]";
	}
}