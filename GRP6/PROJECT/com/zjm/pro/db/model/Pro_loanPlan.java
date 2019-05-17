package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Pro_loanPlan implements Serializable{
	private static final long serialVersionUID = 1L;
	private	String	loanPlan_ID	;	//	放款计划ID	varchar(32)
	private	String	applyID	;	//	对应业务申请ID	varchar(32)
	private	String	applyDetailID	;	//	对应申请产品ID	varchar(32)
	private	String	busiTypeID	;	//	业务品种ID	varchar(32)
	private	String	busiTypeName	;	//	业务品种名称	varchar(50)
	private	String	bankTypeID	;	//	合作机构类型ID	varchar(32)
	private	String	bankTypeName	;	//	合作机构类型名称	varchar(20)
	private	String	bankID	;	//	合作机构ID	varchar(32)
	private	String	bankName	;	//	合作机构名称	varchar(50)
	private	String	subBankName	;	//	合作子机构（或个人）	varchar(100)
	private	Date	loanDate	;	//	计划放款日期	date
	private	Double	loanSum	;		//	计划放款金额	decimal(18,6)
	private	String	loanState	;	//	放款状态(中文：未放款/已放款)	varchar(20)
	private	String	unit_uid	;	//	担保机构编号unit_uid	varchar(32)
	private	String	unit_uidName	;	//	担保机构名称	varchar(50)
	private	String	updateUserName	;	//	最后修改人姓名	varchar(20)
	private	Date	updateDateTime	;	//	最后修改时间	datetime
	
	private String	accessType;		//冗余字段, 新增(add)或修改(update), 计算放款总金额时用
	private	String	busiClass;	//冗余字段, 业务大类, 担保/委贷有不同的放款复核页面
	
	private Integer  periodMonth;	//期限.月
	private Integer  periodDay;		//期限.天
	private String  periodMonthDay;	//申请期限.月天
	
	private Date billBeginDate;  //借据起始日期
	private Date billEndDate;  //借据到期日期
	private Float interestRate;  //年利率
	private	String	meetingDetail_ID	;	//评审会产品明细ID
	
	private	Integer	isDelayApply	;	//是否有延期或豁免事项申请
	private	String	delayApplyDesc	;	//延期或豁免事项申请详情
	private	String	receiveDesc	;	//保证措施落实情况
	private	String	remark	;	//备注
	private	String	approvalState	;	//放款审批状态（中文：待审批/审批中/审批通过/审批未通过）
	
	
	private List<Pro_projectfiles> projectfilesList; //冗余字段  附件
	private Pro_project project ; //冗余字段
	private String loadCode ; //放款单编号  冗余字段
	
		
	private List<Pro_planPay> planPayList;
	private List<Pro_costMust> costMustList;
	private List<Pro_costPre> costPreList;
	private List<Pro_costFact> costFactList;
	private List<Pro_costReturn> costReturnList;
	private List<Pro_project> projectList ;//冗余字段
	
	HashMap<String, Double> costPreSumMap;//小计map
	
	
	public String getApprovalState() {
		return approvalState;
	}
	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
	}
	public Integer getIsDelayApply() {
		return isDelayApply;
	}
	public void setIsDelayApply(Integer isDelayApply) {
		this.isDelayApply = isDelayApply;
	}
	public String getDelayApplyDesc() {
		return delayApplyDesc;
	}
	public void setDelayApplyDesc(String delayApplyDesc) {
		this.delayApplyDesc = delayApplyDesc;
	}
	public String getReceiveDesc() {
		return receiveDesc;
	}
	public void setReceiveDesc(String receiveDesc) {
		this.receiveDesc = receiveDesc;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLoadCode() {
		return loadCode;
	}
	public void setLoadCode(String loadCode) {
		this.loadCode = loadCode;
	}
	public Integer getPeriodMonth() {
		return periodMonth;

	}
	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}

	public Pro_project getProject() {
		return project;
	}
	public void setProject(Pro_project project) {
		this.project = project;
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
	public Date getBillBeginDate() {
		return billBeginDate;
	}
	public void setBillBeginDate(Date billBeginDate) {
		this.billBeginDate = billBeginDate;
	}
	public Date getBillEndDate() {
		return billEndDate;
	}
	public void setBillEndDate(Date billEndDate) {
		this.billEndDate = billEndDate;
	}
	public Float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}
	public String getMeetingDetail_ID() {
		return meetingDetail_ID;
	}
	public void setMeetingDetail_ID(String meetingDetail_ID) {
		this.meetingDetail_ID = meetingDetail_ID;
	}
	
	public String getLoanPlan_ID() {
		return loanPlan_ID;
	}
	public void setLoanPlan_ID(String loanPlan_ID) {
		this.loanPlan_ID = loanPlan_ID;
	}
	public String getApplyID() {
		return applyID;
	}
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}
	public String getApplyDetailID() {
		return applyDetailID;
	}
	public void setApplyDetailID(String applyDetailID) {
		this.applyDetailID = applyDetailID;
	}
	public String getBusiTypeID() {
		return busiTypeID;
	}
	public void setBusiTypeID(String busiTypeID) {
		this.busiTypeID = busiTypeID;
	}
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	public String getBankTypeID() {
		return bankTypeID;
	}
	public void setBankTypeID(String bankTypeID) {
		this.bankTypeID = bankTypeID;
	}
	public String getBankTypeName() {
		return bankTypeName;
	}
	public void setBankTypeName(String bankTypeName) {
		this.bankTypeName = bankTypeName;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getSubBankName() {
		return subBankName;
	}
	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public Double getLoanSum() {
		return loanSum;
	}
	public void setLoanSum(Double loanSum) {
		this.loanSum = loanSum;
	}
	public String getLoanState() {
		return loanState;
	}
	public void setLoanState(String loanState) {
		this.loanState = loanState;
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
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getBusiClass() {
		return busiClass;
	}
	public void setBusiClass(String busiClass) {
		this.busiClass = busiClass;
	}
	public List<Pro_planPay> getPlanPayList() {
		return planPayList;
	}
	public void setPlanPayList(List<Pro_planPay> planPayList) {
		this.planPayList = planPayList;
	}
	public List<Pro_projectfiles> getProjectfilesList() {
		return projectfilesList;
	}
	public void setProjectfilesList(List<Pro_projectfiles> projectfilesList) {
		this.projectfilesList = projectfilesList;
	}
	public List<Pro_costMust> getCostMustList() {
		return costMustList;
	}
	public void setCostMustList(List<Pro_costMust> costMustList) {
		this.costMustList = costMustList;
	}
	public List<Pro_costPre> getCostPreList() {
		return costPreList;
	}
	public void setCostPreList(List<Pro_costPre> costPreList) {
		this.costPreList = costPreList;
	}
	public List<Pro_costFact> getCostFactList() {
		return costFactList;
	}
	public void setCostFactList(List<Pro_costFact> costFactList) {
		this.costFactList = costFactList;
	}
	public List<Pro_costReturn> getCostReturnList() {
		return costReturnList;
	}
	public void setCostReturnList(List<Pro_costReturn> costReturnList) {
		this.costReturnList = costReturnList;
	}
	public HashMap<String, Double> getCostPreSumMap() {
		return costPreSumMap;
	}
	public void setCostPreSumMap(HashMap<String, Double> costPreSumMap) {
		this.costPreSumMap = costPreSumMap;
	}
	public List<Pro_project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Pro_project> projectList) {
		this.projectList = projectList;
	}
	
}
