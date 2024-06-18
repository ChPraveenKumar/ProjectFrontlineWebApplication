package com.frontline.webapi.pojo;

import java.util.List;

public class PostTask {

	private String assignedWorkflowBundleId;
	private String assignedWorkflowBundleVersion;
	private String attributes;
	private String changeDate;
	private String changedBy;
	private String comment;
	private long commentsCount;
	private boolean containsResult;
	private String createDate;
	private String createdBy;
	private String datePlanned;
	private String domain;
	private String doneDate;
	private long duration;
	private String externalId;
	private long id;
	private long mediasCount;
	private String name;
	private long parentId;
	private List<PositionGroups> positionGroups;
	private String postprocessingStatus;
	private long priority;
	private String processType;
	private boolean repeatable;
	private String startDate;
	private String status;
	private String statusDescription;
	private List<String> tags;
	private TaskResult taskResult;
	private boolean template;
	private String userId;
	private String workflowType;
	
	public String getAssignedWorkflowBundleId() {
		return assignedWorkflowBundleId;
	}
	public void setAssignedWorkflowBundleId(String assignedWorkflowBundleId) {
		this.assignedWorkflowBundleId = assignedWorkflowBundleId;
	}
	public String getAssignedWorkflowBundleVersion() {
		return assignedWorkflowBundleVersion;
	}
	public void setAssignedWorkflowBundleVersion(String assignedWorkflowBundleVersion) {
		this.assignedWorkflowBundleVersion = assignedWorkflowBundleVersion;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(long commentsCount) {
		this.commentsCount = commentsCount;
	}
	public boolean isContainsResult() {
		return containsResult;
	}
	public void setContainsResult(boolean containsResult) {
		this.containsResult = containsResult;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDatePlanned() {
		return datePlanned;
	}
	public void setDatePlanned(String datePlanned) {
		this.datePlanned = datePlanned;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDoneDate() {
		return doneDate;
	}
	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMediasCount() {
		return mediasCount;
	}
	public void setMediasCount(long mediasCount) {
		this.mediasCount = mediasCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public List<PositionGroups> getPositionGroups() {
		return positionGroups;
	}
	public void setPositionGroups(List<PositionGroups> positionGroups) {
		this.positionGroups = positionGroups;
	}
	public String getPostprocessingStatus() {
		return postprocessingStatus;
	}
	public void setPostprocessingStatus(String postprocessingStatus) {
		this.postprocessingStatus = postprocessingStatus;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public boolean isRepeatable() {
		return repeatable;
	}
	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public TaskResult getTaskResult() {
		return taskResult;
	}
	public void setTaskResult(TaskResult taskResult) {
		this.taskResult = taskResult;
	}
	public boolean isTemplate() {
		return template;
	}
	public void setTemplate(boolean template) {
		this.template = template;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWorkflowType() {
		return workflowType;
	}
	public void setWorkflowType(String workflowType) {
		this.workflowType = workflowType;
	}
	@Override
	public String toString() {
		return "PostTask [assignedWorkflowBundleId=" + assignedWorkflowBundleId + ", assignedWorkflowBundleVersion="
				+ assignedWorkflowBundleVersion + ", attributes=" + attributes + ", changeDate=" + changeDate
				+ ", changedBy=" + changedBy + ", comment=" + comment + ", commentsCount=" + commentsCount
				+ ", containsResult=" + containsResult + ", createDate=" + createDate + ", createdBy=" + createdBy
				+ ", datePlanned=" + datePlanned + ", domain=" + domain + ", doneDate=" + doneDate + ", duration="
				+ duration + ", externalId=" + externalId + ", id=" + id + ", mediasCount=" + mediasCount + ", name="
				+ name + ", parentId=" + parentId + ", positionGroups=" + positionGroups + ", postprocessingStatus="
				+ postprocessingStatus + ", priority=" + priority + ", processType=" + processType + ", repeatable="
				+ repeatable + ", startDate=" + startDate + ", status=" + status + ", statusDescription="
				+ statusDescription + ", tags=" + tags + ", taskResult=" + taskResult + ", template=" + template
				+ ", userId=" + userId + ", workflowType=" + workflowType + "]";
	}
}
