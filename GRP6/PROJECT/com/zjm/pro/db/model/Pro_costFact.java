package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 实收费用明细表Pro_costFact
 */
public class Pro_costFact implements Serializable{
	private static final long serialVersionUID = 1L;
	private	String	costFact_ID	;	//	流水号	varchar(32)
	private	String	apply_ID	;//	申请业务ID	varchar(32)
	private	String applyDetail_ID	;//	申请产品ID	varchar(32)
	private	String costTypeID	;//	费用类型ID	varchar(32)
	private	String costTypeName	;//	费用名称	varchar(50)
	private	Double costRate	;//	费率	float
	private	String costUnit	;//	费率单位	varchar(10)
	private	Double factCostSum	;//	实收金额	decimal(18,6)
	private	Date factCostDate	;//	实收日期	date
	private	String remark	;//	备注	varchar(100)
	private	String operationDepartID	;//	经办部门	varchar(32)
	private	String operationDepartName	;//	经办部门名称	varchar(20)
	private	String operationUserID	;//	经办人	varchar(32)
	private	String operationUserName	;//	经办人名称	varchar(20)
	private	String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private	String updateUserName	;//	最后修改人姓名	varchar(20)
	private	Date updateDateTime	;//	最后修改时间	datetime

	private String loanPlan_ID;//计划放款表id
	private String costPre_ID;//预收费用表id
	private String costFactState;//状态（未确认/已确认）
	private 	Date	planFactCostDate	;//	计划实收日期	date
	
	private String planFactTableData;	//冗余字段，实收确认时，计划拆分表格中的所有数据
	
	/*private Sys_costStandard costStandard;	//冗余字段, 系统定义收费标准
	private String	busiTypeName;	//冗余字段, 业务品种
	private String	bankName;		//冗余字段, 合作机构
	private Double	agreeSum;		//冗余字段, 担保金额(同意金额)
	private String	costPre_ID;		//冗余字段, 记录是哪个预收转成实收的*/	
//	private	String	costType	;	//	费用类型	varchar(32)
//	private	String	costName	;	//	费用名称	varchar(50)
	
	private String meetingDetail_ID;// 评审会明细ID
	
	public String getMeetingDetail_ID() {
		return meetingDetail_ID;
	}
	public void setMeetingDetail_ID(String meetingDetail_ID) {
		this.meetingDetail_ID = meetingDetail_ID;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public String getCostFact_ID() {
		return costFact_ID;
	}
	public void setCostFact_ID(String costFact_ID) {
		this.costFact_ID = costFact_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getApplyDetail_ID() {
		return applyDetail_ID;
	}
	public void setApplyDetail_ID(String applyDetail_ID) {
		this.applyDetail_ID = applyDetail_ID;
	}
	public Double getFactCostSum() {
		return factCostSum;
	}
	public void setFactCostSum(Double factCostSum) {
		this.factCostSum = factCostSum;
	}
	public Date getFactCostDate() {
		return factCostDate;
	}
	public void setFactCostDate(Date factCostDate) {
		this.factCostDate = factCostDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOperationDepartID() {
		return operationDepartID;
	}
	public void setOperationDepartID(String operationDepartID) {
		this.operationDepartID = operationDepartID;
	}
	public String getOperationDepartName() {
		return operationDepartName;
	}
	public void setOperationDepartName(String operationDepartName) {
		this.operationDepartName = operationDepartName;
	}
	public String getOperationUserID() {
		return operationUserID;
	}
	public void setOperationUserID(String operationUserID) {
		this.operationUserID = operationUserID;
	}
	public String getOperationUserName() {
		return operationUserName;
	}
	public void setOperationUserName(String operationUserName) {
		this.operationUserName = operationUserName;
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
	
	public String getCostTypeID() {
		return costTypeID;
	}
	public void setCostTypeID(String costTypeID) {
		this.costTypeID = costTypeID;
	}
	public String getCostTypeName() {
		return costTypeName;
	}
	public void setCostTypeName(String costTypeName) {
		this.costTypeName = costTypeName;
	}
	public Double getCostRate() {
		return costRate;
	}
	public void setCostRate(Double costRate) {
		this.costRate = costRate;
	}
	public String getCostUnit() {
		return costUnit;
	}
	public void setCostUnit(String costUnit) {
		this.costUnit = costUnit;
	}
	public String getLoanPlan_ID() {
		return loanPlan_ID;
	}
	public void setLoanPlan_ID(String loanPlan_ID) {
		this.loanPlan_ID = loanPlan_ID;
	}
	public String getCostPre_ID() {
		return costPre_ID;
	}
	public void setCostPre_ID(String costPre_ID) {
		this.costPre_ID = costPre_ID;
	}
	public String getCostFactState() {
		return costFactState;
	}
	public void setCostFactState(String costFactState) {
		this.costFactState = costFactState;
	}
	public Date getPlanFactCostDate() {
		return planFactCostDate;
	}
	public void setPlanFactCostDate(Date planFactCostDate) {
		this.planFactCostDate = planFactCostDate;
	}
	public String getPlanFactTableData() {
		return planFactTableData;
	}
	public void setPlanFactTableData(String planFactTableData) {
		this.planFactTableData = planFactTableData;
	}
	 
}
