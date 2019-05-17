package com.zjm.gbpm.db.model;

import java.io.Serializable;


public class Gbpm_taskTypeTask implements Serializable {
	
	private String taskType_ID;//任务类型ID
	private String taskManager_ID;//任务ID
	
	
	public String getTaskType_ID() {
		return taskType_ID;
	}
	public void setTaskType_ID(String taskType_ID) {
		this.taskType_ID = taskType_ID;
	}
	public String getTaskManager_ID() {
		return taskManager_ID;
	}
	public void setTaskManager_ID(String taskManager_ID) {
		this.taskManager_ID = taskManager_ID;
	}

	
}
