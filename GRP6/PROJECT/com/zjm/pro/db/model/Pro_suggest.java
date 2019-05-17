package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 项目意见表pro_suggest
 */
public class Pro_suggest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String	suggest_ID	;//	项目意见ID	varchar(32)
	private String	flowID	;//	流程实例ID	bigint
	private String	stepID	;//	步骤ID	bigint
	private String	stepName	;//	步骤名称	varchar(100)
	private String	historyStepID	;//	历史步骤ID	bigint
	private String	entityType	;//	业务类型（区分申请、打包）	char(2)
	private String	entityID	;//	业务ID	varchar(32)//apply_id
	private String	productInstanceID	;//	产品实例ID	varchar(32)
	private String	nodeID	;//	产品实例节点ID	varchar(32)//runNode_ID
	private String  nodeNames;//环节名称
	private String	taskID	;//	产品实例任务ID	varchar(32)//runTask_ID
	private String	taskName	;//	产品实例任务名称	varchar(100)
	private String	suggestContent	;//	意见内容	text
	private String	conclusionID	;//	意见结论ID	varchar(32)
	private String	conclusionName	;//	意见结论名称	varchar(20)
	private String	suggestUserID	;//	填写意见人ID	varchar(32)
	private String	suggestUserName	;//	填写意见人名称	varchar(20)
	private Date 	suggestDateTime	;//	填写意见时间	datetime
	private Double	agreetSum	;//	同意金额	decimal(18,6)
	private Integer	periodMonth	;//	同意期限.月	smallint
	private Integer	periodDay	;//	同意期限.天	smallint
	private String	periodMonthDay	;//	申请期限.月天	varchar(20)
	private float	guarantyRate	;//	担保费率	float
	private float	reviewRate	;//	评审费率	float
	private float	bankRate	;//	利率	float
	private float	bzScale	;//	保证金占比	float
	private Double	bzSum	;//	保证金	decimal(18,6)
	private String	unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String	updateUserName	;//	最后修改人姓名	varchar(20)
	private Date	updateDateTime	;//	最后修改时间	datetime
	
	private String  type;//页面类型：事项办理时候使用；
	private String  suggestType; 
	List<Pro_projectfiles> filesList;//附件列表
	
	List<Pro_suggest> suggestList;//意见汇总list
	
	
	
	public String getSuggest_ID() {
		return suggest_ID;
	}
	public void setSuggest_ID(String suggest_ID) {
		this.suggest_ID = suggest_ID;
	}
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}
	public String getStepID() {
		return stepID;
	}
	public void setStepID(String stepID) {
		this.stepID = stepID;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getHistoryStepID() {
		return historyStepID;
	}
	public void setHistoryStepID(String historyStepID) {
		this.historyStepID = historyStepID;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	public String getProductInstanceID() {
		return productInstanceID;
	}
	public void setProductInstanceID(String productInstanceID) {
		this.productInstanceID = productInstanceID;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getSuggestContent() {
		return suggestContent;
	}
	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}
	public String getConclusionID() {
		return conclusionID;
	}
	public void setConclusionID(String conclusionID) {
		this.conclusionID = conclusionID;
	}
	public String getConclusionName() {
		return conclusionName;
	}
	public void setConclusionName(String conclusionName) {
		this.conclusionName = conclusionName;
	}
	public String getSuggestUserID() {
		return suggestUserID;
	}
	public void setSuggestUserID(String suggestUserID) {
		this.suggestUserID = suggestUserID;
	}
	public String getSuggestUserName() {
		return suggestUserName;
	}
	public void setSuggestUserName(String suggestUserName) {
		this.suggestUserName = suggestUserName;
	}
	public Date getSuggestDateTime() {
		return suggestDateTime;
	}
	public void setSuggestDateTime(Date suggestDateTime) {
		this.suggestDateTime = suggestDateTime;
	}
	public Double getAgreetSum() {
		return agreetSum;
	}
	public void setAgreetSum(Double agreetSum) {
		this.agreetSum = agreetSum;
	}
	public Integer getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}
	public Integer getPeriodDay() {
		return periodDay;
	}
	public void setPeriodDay(Integer periodDay) {
		this.periodDay = periodDay;
	}
	public String getPeriodMonthDay() {
		return periodMonthDay;
	}
	public void setPeriodMonthDay(String periodMonthDay) {
		this.periodMonthDay = periodMonthDay;
	}
	public float getGuarantyRate() {
		return guarantyRate;
	}
	public void setGuarantyRate(float guarantyRate) {
		this.guarantyRate = guarantyRate;
	}
	public float getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(float reviewRate) {
		this.reviewRate = reviewRate;
	}
	public float getBankRate() {
		return bankRate;
	}
	public void setBankRate(float bankRate) {
		this.bankRate = bankRate;
	}
	public float getBzScale() {
		return bzScale;
	}
	public void setBzScale(float bzScale) {
		this.bzScale = bzScale;
	}
	public Double getBzSum() {
		return bzSum;
	}
	public void setBzSum(Double bzSum) {
		this.bzSum = bzSum;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Pro_projectfiles> getFilesList() {
		return filesList;
	}
	public void setFilesList(List<Pro_projectfiles> filesList) {
		this.filesList = filesList;
	}
	public List<Pro_suggest> getSuggestList() {
		return suggestList;
	}
	public void setSuggestList(List<Pro_suggest> suggestList) {
		this.suggestList = suggestList;
	}
	public String getNodeNames() {
		return nodeNames;
	}
	public void setNodeNames(String nodeNames) {
		this.nodeNames = nodeNames;
	}
	public String getSuggestType() {
		return suggestType;
	}
	public void setSuggestType(String suggestType) {
		this.suggestType = suggestType;
	}
	
	
	

}
