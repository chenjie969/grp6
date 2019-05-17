package com.zjm.gworkFlow.db.model;

import java.util.List;


/** 流程步骤实体类 */
public class Os_step {
	/** 流水号 */
	public long id;
	/** 流程实例ID */
	public long entryId;
	/** 流程名程 */
	public java.lang.String flowName_chn;
	/** 步骤ID */
	public int stepId;
	/** 步骤名称 */
	public java.lang.String stepName_chn;
	/** 动作ID */
	public int actionId;
	/** 计划执行者 */
	public java.lang.String owner_chn;
	/** 开始日期 */
	public java.sql.Timestamp startDate;
	/** 结束日期 */
	public java.sql.Timestamp finishDate;
	/** 截止日期 */
	public java.sql.Timestamp dueDate;
	/** 步骤状态中文名称 */
	public java.lang.String status_chn;
	/** 实际执行人 */
	public java.lang.String caller_chn;
	/** 项目号 */
	public java.lang.String projectCode;
	/** 客户名称 */
	public java.lang.String clientName_chn;
	/** 流程发起人 */
	public java.lang.String flowCreator_chn;
	/** 流程状态 */
	public java.lang.String flowStatues;

	/** 上一步骤的记录ID */
	public java.lang.String preID;

	/** 流程创建时间 */
	public java.sql.Timestamp flowCreateTime;

	/** 项目ID */
	public String projectID;

	/** 申请担保金额 ADD  2012-12-06 */
	public Double applysum;

	/** 客户经理 ADD 2012-12-06 */
	public String usergid;
	
	//流程类别zhongzk add
	public String projecttype;//业务类别，担保业务流程，打包流程，oa流程
	public String unit_uid;//担保机构id
	public String flowTempaleMapName;//流程文件名称

	// ls add 获取步骤上的所有动作的业务构建
	private List<OsGworkflowComponents> stepViewList;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}

	public java.lang.String getFlowName_chn() {
		return flowName_chn;
	}

	public void setFlowName_chn(java.lang.String flowName_chn) {
		this.flowName_chn = flowName_chn;
	}

	public int getStepId() {
		return stepId;
	}

	public void setStepId(int stepId) {
		this.stepId = stepId;
	}

	public java.lang.String getStepName_chn() {
		return stepName_chn;
	}

	public void setStepName_chn(java.lang.String stepName_chn) {
		this.stepName_chn = stepName_chn;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public java.lang.String getOwner_chn() {
		return owner_chn;
	}

	public void setOwner_chn(java.lang.String owner_chn) {
		this.owner_chn = owner_chn;
	}

	public java.sql.Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Timestamp startDate) {
		this.startDate = startDate;
	}

	public java.sql.Timestamp getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(java.sql.Timestamp finishDate) {
		this.finishDate = finishDate;
	}

	public java.sql.Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(java.sql.Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public java.lang.String getStatus_chn() {
		return status_chn;
	}

	public void setStatus_chn(java.lang.String status_chn) {
		this.status_chn = status_chn;
	}

	public java.lang.String getCaller_chn() {
		return caller_chn;
	}

	public void setCaller_chn(java.lang.String caller_chn) {
		this.caller_chn = caller_chn;
	}

	public java.lang.String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(java.lang.String projectCode) {
		this.projectCode = projectCode;
	}

	public java.lang.String getClientName_chn() {
		return clientName_chn;
	}

	public void setClientName_chn(java.lang.String clientName_chn) {
		this.clientName_chn = clientName_chn;
	}

	public java.lang.String getFlowCreator_chn() {
		return flowCreator_chn;
	}

	public void setFlowCreator_chn(java.lang.String flowCreator_chn) {
		this.flowCreator_chn = flowCreator_chn;
	}

	public java.lang.String getFlowStatues() {
		return flowStatues;
	}

	public void setFlowStatues(java.lang.String flowStatues) {
		this.flowStatues = flowStatues;
	}

	public java.lang.String getPreID() {
		return preID;
	}

	public void setPreID(java.lang.String preID) {
		this.preID = preID;
	}

	public java.sql.Timestamp getFlowCreateTime() {
		return flowCreateTime;
	}

	public void setFlowCreateTime(java.sql.Timestamp flowCreateTime) {
		this.flowCreateTime = flowCreateTime;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public Double getApplysum() {
		return applysum;
	}

	public void setApplysum(Double applysum) {
		this.applysum = applysum;
	}

	public String getUsergid() {
		return usergid;
	}

	public void setUsergid(String usergid) {
		this.usergid = usergid;
	}

	public String getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}

	public String getFlowTempaleMapName() {
		return flowTempaleMapName;
	}

	public void setFlowTempaleMapName(String flowTempaleMapName) {
		this.flowTempaleMapName = flowTempaleMapName;
	}

	public List<OsGworkflowComponents> getStepViewList() {
		return stepViewList;
	}

	public void setStepViewList(List<OsGworkflowComponents> stepViewList) {
		this.stepViewList = stepViewList;
	}
	
	
}
