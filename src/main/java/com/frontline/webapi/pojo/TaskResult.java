package com.frontline.webapi.pojo;

import java.util.List;

public class TaskResult {

	private String aiOfflineToken;
	private List<Attachments> attachments;
	private long duration;
	private String endTime;
	private long id;
	private String name;
	private String startTime;
	private String status;
	private String stepID;
	private List<StepResults> stepResults;
	private String workflowResultUUID;
	
	public String getAiOfflineToken() {
		return aiOfflineToken;
	}
	public void setAiOfflineToken(String aiOfflineToken) {
		this.aiOfflineToken = aiOfflineToken;
	}
	public List<Attachments> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStepID() {
		return stepID;
	}
	public void setStepID(String stepID) {
		this.stepID = stepID;
	}
	public List<StepResults> getStepResults() {
		return stepResults;
	}
	public void setStepResults(List<StepResults> stepResults) {
		this.stepResults = stepResults;
	}
	public String getWorkflowResultUUID() {
		return workflowResultUUID;
	}
	public void setWorkflowResultUUID(String workflowResultUUID) {
		this.workflowResultUUID = workflowResultUUID;
	}
	@Override
	public String toString() {
		return "TaskResult [aiOfflineToken=" + aiOfflineToken + ", attachments=" + attachments + ", duration="
				+ duration + ", endTime=" + endTime + ", id=" + id + ", name=" + name + ", startTime=" + startTime
				+ ", status=" + status + ", stepID=" + stepID + ", stepResults=" + stepResults + ", workflowResultUUID="
				+ workflowResultUUID + "]";
	}
}
