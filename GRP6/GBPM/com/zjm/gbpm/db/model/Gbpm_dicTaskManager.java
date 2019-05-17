package com.zjm.gbpm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Gbpm_dicTaskManager implements Serializable {

	private String taskManager_ID;	//任务事项ID
	private String taskName;	//任务事项名称
	private String taskCode;	//任务事项编号
	private String taskUrl;	//任务事项处理URL
	private String viewTaskUrl;	//任务事项查看URL
	
	private String remark;	//备注
	
	private String unit_uid;	//担保机构ID
	private String unit_uidName;	//担保机构名称
	private String update_user;	//最后更新人
	private Date updatedatetime;	//最后更新时间
	private Integer taskmanagerSort;	//任务顺序
	private Boolean isPersonTask;	//人工任务1/系统任务0  默认值1
	
	private String taskType_ID;	//任务事项类型 冗余字段
	private String taskTypeName;	//任务事项类型名称 冗余字段
	
	public String getTaskType_ID() {
		return taskType_ID;
	}
	public void setTaskType_ID(String taskType_ID) {
		this.taskType_ID = taskType_ID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskUrl() {
		return taskUrl;
	}
	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getUnit_uidName() {
		return unit_uidName;
	}
	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}
	public String getTaskManager_ID() {
		return taskManager_ID;
	}
	public void setTaskManager_ID(String taskManager_ID) {
		this.taskManager_ID = taskManager_ID;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getTaskTypeName() {
		return taskTypeName;
	}
	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}
	public String getViewTaskUrl() {
		return viewTaskUrl;
	}
	public void setViewTaskUrl(String viewTaskUrl) {
		this.viewTaskUrl = viewTaskUrl;
	}
	public Integer getTaskmanagerSort() {
		return taskmanagerSort;
	}
	public void setTaskmanagerSort(Integer taskmanagerSort) {
		this.taskmanagerSort = taskmanagerSort;
	}
	public Boolean getIsPersonTask() {
		return isPersonTask;
	}
	public void setIsPersonTask(Boolean isPersonTask) {
		this.isPersonTask = isPersonTask;
	}
	
}
