package com.zjm.gbpm.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


public class Gbpm_nodeTask implements Serializable {
	
	private String nodeTask_ID;	//节点任务ID
	private String productID;//产品流程ID
	private String productNodeID;	//产品节点ID
	private String nodeNames;	//节点名称
	private String taskMangerID;	//任务ID
	private String taskName;//任务事项名称
	private Integer taskSort;	//任务顺序
	private String operationType;	//操作类型 选做任务 必做任务
	private Boolean isBeforeTask;	//是否有前置任务
	private String beforeTaskID;	//前置任务ID
	private String  beforeTaskName; //前置任务名称
	private Boolean isAfterTask;  //是否有后置任务
	private String afterTaskIDList; //后置任务ID集合，以逗号分开
	private String afterTaskNameList;//后置任务名称
	private String warnMethodIDList; //提醒方式ID集合，以逗号分开
	private String warnMethodNameList; //提醒方式名称 
	private String operaterTypeID; //操作者类型ID
	private String operaterTypeName; //操作者类型名称
	private String operatorID; //操作者详细类型ID
	private String operatorName; //操作者详细类型名称
	private Boolean isStartProcess;	//是否启动子流程
	private String processID;	//子流程ID
	private String processName;	//子流程名称
	private String unit_uid;	//担保机构编号unit_uid
	private String unit_uidName;	//担保机构名称
	private String updateUserName;	//最后修改人姓名
	private Date updateDateTime;	//最后修改时间
	
	private String handleUserID; //办理人ID   冗余字段  任务实例化的时候用
	private String handleUserName; //办理人名称 冗余字段  任务实例化的时候用
	private Map<String,String> handleUserMap; //办理人集合 冗余字段  任务实例化的时候用
	private String taskTypeID;//taskmanager表冗餘字段
	private String taskCode;//taskmanager表冗餘字段
	private String taskUrl;//taskmanager表冗餘字段
	private String viewTaskUrl;//taskmanager表冗餘字段
	
	public String getNodeTask_ID() {
		return nodeTask_ID;
	}
	public void setNodeTask_ID(String nodeTask_ID) {
		this.nodeTask_ID = nodeTask_ID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductNodeID() {
		return productNodeID;
	}
	public void setProductNodeID(String productNodeID) {
		this.productNodeID = productNodeID;
	}
	public String getTaskMangerID() {
		return taskMangerID;
	}
	public void setTaskMangerID(String taskMangerID) {
		this.taskMangerID = taskMangerID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getAfterTaskIDList() {
		return afterTaskIDList;
	}
	public void setAfterTaskIDList(String afterTaskIDList) {
		this.afterTaskIDList = afterTaskIDList;
	}
	public Integer getTaskSort() {
		return taskSort;
	}
	public void setTaskSort(Integer taskSort) {
		this.taskSort = taskSort;
	}
	public Boolean getIsBeforeTask() {
		return isBeforeTask;
	}
	public void setIsBeforeTask(Boolean isBeforeTask) {
		this.isBeforeTask = isBeforeTask;
	}
	public String getBeforeTaskID() {
		return beforeTaskID;
	}
	public void setBeforeTaskID(String beforeTaskID) {
		this.beforeTaskID = beforeTaskID;
	}
	public String getBeforeTaskName() {
		return beforeTaskName;
	}
	public void setBeforeTaskName(String beforeTaskName) {
		this.beforeTaskName = beforeTaskName;
	}
	public Boolean getIsAfterTask() {
		return isAfterTask;
	}
	public void setIsAfterTask(Boolean isAfterTask) {
		this.isAfterTask = isAfterTask;
	}
	public String getAfterTaskNameList() {
		return afterTaskNameList;
	}
	public void setAfterTaskNameList(String afterTaskNameList) {
		this.afterTaskNameList = afterTaskNameList;
	}
	public String getWarnMethodIDList() {
		return warnMethodIDList;
	}
	public void setWarnMethodIDList(String warnMethodIDList) {
		this.warnMethodIDList = warnMethodIDList;
	}
	public String getWarnMethodNameList() {
		return warnMethodNameList;
	}
	public void setWarnMethodNameList(String warnMethodNameList) {
		this.warnMethodNameList = warnMethodNameList;
	}
	public String getOperaterTypeID() {
		return operaterTypeID;
	}
	public void setOperaterTypeID(String operaterTypeID) {
		this.operaterTypeID = operaterTypeID;
	}
	public String getOperaterTypeName() {
		return operaterTypeName;
	}
	public void setOperaterTypeName(String operaterTypeName) {
		this.operaterTypeName = operaterTypeName;
	}
	public Boolean getIsStartProcess() {
		return isStartProcess;
	}
	public void setIsStartProcess(Boolean isStartProcess) {
		this.isStartProcess = isStartProcess;
	}
	public String getProcessID() {
		return processID;
	}
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
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
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public String getNodeNames() {
		return nodeNames;
	}
	public void setNodeNames(String nodeNames) {
		this.nodeNames = nodeNames;
	}
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getHandleUserID() {
		return handleUserID;
	}
	public void setHandleUserID(String handleUserID) {
		this.handleUserID = handleUserID;
	}
	public String getHandleUserName() {
		return handleUserName;
	}
	public void setHandleUserName(String handleUserName) {
		this.handleUserName = handleUserName;
	}
	public Map<String, String> getHandleUserMap() {
		return handleUserMap;
	}
	public void setHandleUserMap(Map<String, String> handleUserMap) {
		this.handleUserMap = handleUserMap;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getTaskTypeID() {
		return taskTypeID;
	}
	public void setTaskTypeID(String taskTypeID) {
		this.taskTypeID = taskTypeID;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getTaskUrl() {
		return taskUrl;
	}
	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}
	public String getViewTaskUrl() {
		return viewTaskUrl;
	}
	public void setViewTaskUrl(String viewTaskUrl) {
		this.viewTaskUrl = viewTaskUrl;
	}
	
}
