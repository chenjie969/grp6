package com.zjm.gbpm.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * activiti 下步任务信息集合
 * @author mashuo add 20170717
 *
 */
public class Act_nextTask implements Serializable {
	private String nextTaskDefKey;//下步任务定义key
	private String nextTaskName;//下步任务名称
	private String nextLineName;//下步名称
	private String nextAssigneeID;//下步任务具体办理人ID
	private String nextAssigneeName;//下步任务具体办理人名称
	private List<String> nextUserIDs;//下步任务候选人集合
	private List<String> nextGroupIDs;//下步任务候选组集合
	private Map<String,String> userMap;//待选用户map集合
	private String taskType;//任务类型
	private Boolean multiple;//是否多选
	public Act_nextTask(){
		this.nextUserIDs=new ArrayList<String>();
		this.nextGroupIDs=new ArrayList<String>();
		this.userMap=new HashMap<>();
	}
	
	//==========get/set=============
	
	public String getNextTaskDefKey() {
		return nextTaskDefKey;
	}
	public void setNextTaskDefKey(String nextTaskDefKey) {
		this.nextTaskDefKey = nextTaskDefKey;
	}
	public String getNextAssigneeID() {
		return nextAssigneeID;
	}
	public void setNextAssigneeID(String nextAssigneeID) {
		this.nextAssigneeID = nextAssigneeID;
	}
	public List<String> getNextUserIDs() {
		return nextUserIDs;
	}
	public void setNextUserIDs(List<String> nextUserIDs) {
		this.nextUserIDs = nextUserIDs;
	}
	public List<String> getNextGroupIDs() {
		return nextGroupIDs;
	}
	public void setNextGroupIDs(List<String> nextGroupIDs) {
		this.nextGroupIDs = nextGroupIDs;
	}
	public Map<String, String> getUserMap() {
		return userMap;
	}
	public void setUserMap(Map<String, String> userMap) {
		this.userMap = userMap;
	}
	public String getNextTaskName() {
		return nextTaskName;
	}
	public void setNextTaskName(String nextTaskName) {
		this.nextTaskName = nextTaskName;
	}
	public String getNextAssigneeName() {
		return nextAssigneeName;
	}
	public void setNextAssigneeName(String nextAssigneeName) {
		this.nextAssigneeName = nextAssigneeName;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public Boolean getMultiple() {
		return multiple;
	}
	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public String getNextLineName() {
		return nextLineName;
	}

	public void setNextLineName(String nextLineName) {
		this.nextLineName = nextLineName;
	}
	
	
	
	
	
}
