package com.zjm.gworkFlow.db.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 作者 mashuo add 20170919
 */
public class PendingWorkFlow {
	private String unit_uid;// 机构id
	private Long flowID; // 流程id
	private Integer stepID;//步骤id
	private Integer actionID;//动作id
	private String projectID; // 项目id 业务实体id
	private String flowType;//流程分类   业务实体类型
	private String entityName;//业务实体名称
	
	private String businessId;//业务ID
	private String businessType;//业务类型
	
	private String createFlowUserName; // 发起人名称
	private String createFlowUserUid; // 发起人uid
	private String waitFlowUserName; // 办理人名称
	private String waitFlowUserUid; // 办理人uid
	
	private String createFlowDepartName; // 发起人部门名称
	private String createFlowDepartUid; // 发起人部门uid
	private String waitFlowDepartName; // 办理人部门名称
	private String waitFlowDepartUid; // 办理人部门uid
	
	private String flowTemplateName;// 流程名称
	private String user_uid;//当前用户id
	private String stepName;//步骤名称
	private String flowStatusName;///流程状态
	
	private Long historyID;//历史步骤表自增id
	
	private Integer limitDate;//限办时间
	private String limitDateUnit;//限办时间单位
	private String limitDateMessage;//限办时间提示
	private Timestamp start_date;//任务开始时间
	private Timestamp finish_date;//任务完成时间
	private Timestamp create_date;//流程创建时间
	
	
	
	
	
	
	private String[] roleNames;//下一步角色
	private String[] rolrUserUids;//下一步选中的人员
	//==================get/set======================================

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}


	public String getCreateFlowUserName() {
		return createFlowUserName;
	}

	public void setCreateFlowUserName(String createFlowUserName) {
		this.createFlowUserName = createFlowUserName;
	}

	public String getFlowTemplateName() {
		return flowTemplateName;
	}

	public void setFlowTemplateName(String flowTemplateName) {
		this.flowTemplateName = flowTemplateName;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getCreateFlowUserUid() {
		return createFlowUserUid;
	}

	public void setCreateFlowUserUid(String createFlowUserUid) {
		this.createFlowUserUid = createFlowUserUid;
	}

	public String getWaitFlowUserName() {
		return waitFlowUserName;
	}

	public void setWaitFlowUserName(String waitFlowUserName) {
		this.waitFlowUserName = waitFlowUserName;
	}

	public String getWaitFlowUserUid() {
		return waitFlowUserUid;
	}

	public void setWaitFlowUserUid(String waitFlowUserUid) {
		this.waitFlowUserUid = waitFlowUserUid;
	}

	public String getCreateFlowDepartName() {
		return createFlowDepartName;
	}

	public void setCreateFlowDepartName(String createFlowDepartName) {
		this.createFlowDepartName = createFlowDepartName;
	}

	public String getCreateFlowDepartUid() {
		return createFlowDepartUid;
	}

	public void setCreateFlowDepartUid(String createFlowDepartUid) {
		this.createFlowDepartUid = createFlowDepartUid;
	}

	public String getWaitFlowDepartName() {
		return waitFlowDepartName;
	}

	public void setWaitFlowDepartName(String waitFlowDepartName) {
		this.waitFlowDepartName = waitFlowDepartName;
	}

	public String getWaitFlowDepartUid() {
		return waitFlowDepartUid;
	}

	public void setWaitFlowDepartUid(String waitFlowDepartUid) {
		this.waitFlowDepartUid = waitFlowDepartUid;
	}

	public String getFlowStatusName() {
		return flowStatusName;
	}

	public void setFlowStatusName(String flowStatusName) {
		this.flowStatusName = flowStatusName;
	}

	public Long getHistoryID() {
		return historyID;
	}

	public void setHistoryID(Long historyID) {
		this.historyID = historyID;
	}

	public Integer getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Integer limitDate) {
		this.limitDate = limitDate;
	}

	public String getLimitDateUnit() {
		return limitDateUnit;
	}

	public void setLimitDateUnit(String limitDateUnit) {
		this.limitDateUnit = limitDateUnit;
	}

	public String getLimitDateMessage() {
		return limitDateMessage;
	}

	public void setLimitDateMessage(String limitDateMessage) {
		this.limitDateMessage = limitDateMessage;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Timestamp finish_date) {
		this.finish_date = finish_date;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Long getFlowID() {
		return flowID;
	}

	public void setFlowID(Long flowID) {
		this.flowID = flowID;
	}


	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	public Integer getActionID() {
		return actionID;
	}

	public void setActionID(Integer actionID) {
		this.actionID = actionID;
	}

	public String[] getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String[] roleNames) {
		this.roleNames = roleNames;
	}

	public String[] getRolrUserUids() {
		return rolrUserUids;
	}

	public void setRolrUserUids(String[] rolrUserUids) {
		this.rolrUserUids = rolrUserUids;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}




}
