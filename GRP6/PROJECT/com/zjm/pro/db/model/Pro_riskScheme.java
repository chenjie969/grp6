package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 化解方案（工作进度）表
 */
public class Pro_riskScheme implements Serializable {

	  private static final long serialVersionUID = 1L;
	  private String riskScheme_ID;        //varchar(32) not null, 化解方案与工作进度ID
	  private String relationMain_ID;        //varchar(32)主体客户ID
	  private String relationMainName;        //varchar(32)主体客户名称
	  private String reviewType;			//varchart 审批类型：中文:方案、工作进度、打击逃废债工作进度
	  private String product_ID;           //varchar(32) 审批流程ID
	  private String productName;         // varchar(20), 审批流程名称
	  private String nodeID;		 //varChar(32) 当前环节ID
	  private String nodeNames;		 //varChar(100) 当前环节名称
	  private String productInstance_ID;  // varchar(32), 流程实例ID
	  private String title;               //varchar(200),标题
	  private String workProgress;        // text, 工作进展
	  private String needCoordination;    // text, 需协调事项
	  private String nextPlan;            // text,下一步计划
	  private String lawsuitInfo;         // text,涉诉情况
	  private String lawsuitProgress;      //text,涉案进展
	  private String remark;               //text,备注
	  private String createUserID;        // varchar(32),创建人ID
	  private String createUserName;       //varchar(20),创建人名称
	  private Date createDate;           //date,创建日期
	  private String status;              // varchar(20),审批状态
	  private Integer  isMeeting;         //是否已安排会议
	  private Date  stopDate;         //否决时间
	  private String  stopDesc;         //否决原因
	  private Date  finishDate;         //审批完成时间
	  private String unit_uid;             //varchar(32),担保机构编号unit_uid
	  private String updateUserName;       //varchar(20),最后修改人姓名
	  private String updateDateTime;       //datetime,最后修改时间
	  
	  //冗余字段，待安排会议列表用
	  private String meetingTypeName;        //会议类型名称
	  private String meetingTypeID;           //会议类型ID
	  //冗余字段，风险处置首页最新工作进度用
	  private String projectTypeID;   	//项目类型ID（字典）----融投特有
	  private String projectTypeName;  	//项目类型名称----融投特有
	  private String fullAreaName;		//所属区域名称
	  private Integer riskSchemeNum;	//冗余字段  统计数量
	  
	  
	  private List<Pro_projectfiles> filesList; // 方案相关附件
	  
	  private List<Pro_projectfiles> attachFileList; //附件   -->重点项目审批
	  private List<Pro_projectfiles> schemeFileList; //方案附件  -->重点项目审批
	  
	public List<Pro_projectfiles> getAttachFileList() {
		return attachFileList;
	}
	public void setAttachFileList(List<Pro_projectfiles> attachFileList) {
		this.attachFileList = attachFileList;
	}
	public List<Pro_projectfiles> getSchemeFileList() {
		return schemeFileList;
	}
	public void setSchemeFileList(List<Pro_projectfiles> schemeFileList) {
		this.schemeFileList = schemeFileList;
	}
	public String getRiskScheme_ID() {
		return riskScheme_ID;
	}
	public void setRiskScheme_ID(String riskScheme_ID) {
		this.riskScheme_ID = riskScheme_ID;
	}
	public String getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductInstance_ID() {
		return productInstance_ID;
	}
	public void setProductInstance_ID(String productInstance_ID) {
		this.productInstance_ID = productInstance_ID;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkProgress() {
		return workProgress;
	}
	public void setWorkProgress(String workProgress) {
		this.workProgress = workProgress;
	}
	public String getNeedCoordination() {
		return needCoordination;
	}
	public void setNeedCoordination(String needCoordination) {
		this.needCoordination = needCoordination;
	}
	public String getNodeNames() {
		return nodeNames;
	}
	public void setNodeNames(String nodeNames) {
		this.nodeNames = nodeNames;
	}
	public String getNextPlan() {
		return nextPlan;
	}
	public void setNextPlan(String nextPlan) {
		this.nextPlan = nextPlan;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	public String getStopDesc() {
		return stopDesc;
	}
	public void setStopDesc(String stopDesc) {
		this.stopDesc = stopDesc;
	}
	public Integer getRiskSchemeNum() {
		return riskSchemeNum;
	}
	public void setRiskSchemeNum(Integer riskSchemeNum) {
		this.riskSchemeNum = riskSchemeNum;
	}
	public String getLawsuitInfo() {
		return lawsuitInfo;
	}
	public void setLawsuitInfo(String lawsuitInfo) {
		this.lawsuitInfo = lawsuitInfo;
	}
	public String getLawsuitProgress() {
		return lawsuitProgress;
	}
	public void setLawsuitProgress(String lawsuitProgress) {
		this.lawsuitProgress = lawsuitProgress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public Integer getIsMeeting() {
		return isMeeting;
	}
	public void setIsMeeting(Integer isMeeting) {
		this.isMeeting = isMeeting;
	}
	public String getMeetingTypeName() {
		return meetingTypeName;
	}
	public void setMeetingTypeName(String meetingTypeName) {
		this.meetingTypeName = meetingTypeName;
	}
	public String getMeetingTypeID() {
		return meetingTypeID;
	}
	public void setMeetingTypeID(String meetingTypeID) {
		this.meetingTypeID = meetingTypeID;
	}
	public List<Pro_projectfiles> getFilesList() {
		return filesList;
	}
	public void setFilesList(List<Pro_projectfiles> filesList) {
		this.filesList = filesList;
	}
	public String getRelationMain_ID() {
		return relationMain_ID;
	}
	public void setRelationMain_ID(String relationMain_ID) {
		this.relationMain_ID = relationMain_ID;
	}
	public String getRelationMainName() {
		return relationMainName;
	}
	public void setRelationMainName(String relationMainName) {
		this.relationMainName = relationMainName;
	}
	public String getProjectTypeID() {
		return projectTypeID;
	}
	public void setProjectTypeID(String projectTypeID) {
		this.projectTypeID = projectTypeID;
	}
	public String getProjectTypeName() {
		return projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	public String getFullAreaName() {
		return fullAreaName;
	}
	public void setFullAreaName(String fullAreaName) {
		this.fullAreaName = fullAreaName;
	}
	
}
