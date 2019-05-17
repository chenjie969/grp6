package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;	

public class Pro_costPre implements Serializable{
	private static final long serialVersionUID = 1L;
	private 	String	costPre_ID	;//	流水号	varchar(32)
	private 	String	apply_ID	;//	申请业务ID	varchar(32)
	private 	String	applyDetail_ID	;//	申请产品ID	varchar(32)
	private 	String	costTypeID	;//	费用类型ID	varchar(32)
	private 	String	costTypeName	;//	费用名称	varchar(50)
	private 	Double	costRate	;//	费率	float
	private 	String	costUnit	;//	费率单位	varchar(10)
	private 	Double	preCostSum	;//	预收金额	decimal(18,6)
	private 	Date	preCostDate	;//	预收日期	date
	private 	String	remark	;//	备注	varchar(100)
	private 	String	operationDepartID	;//	经办部门	varchar(32)
	private 	String	operationDepartName	;//	经办部门名称	varchar(20)
	private 	String	operationUserID	;//	经办人	varchar(32)
	private 	String	operationUserName	;//	经办人名称	varchar(20)
	private 	String	unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private 	String	updateUserName	;//	最后修改人姓名	varchar(20)
	private 	Date	updateDateTime	;//	最后修改时间	datetime
	private 	String   costPreState;//状态
	
	private String loanPlan_ID;//计划放款表id
	private String costMust_ID;//应收费用表id
	private String meetingDetail_ID;// 评审会明细ID
	
	public String getMeetingDetail_ID() {
		return meetingDetail_ID;
	}
	public void setMeetingDetail_ID(String meetingDetail_ID) {
		this.meetingDetail_ID = meetingDetail_ID;
	}
	public String getCostPre_ID() {
		return costPre_ID;
	}
	public void setCostPre_ID(String costPre_ID) {
		this.costPre_ID = costPre_ID;
	}
	public String getApply_ID() {
		return apply_ID;
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
	public Double getPreCostSum() {
		return preCostSum;
	}
	public void setPreCostSum(Double preCostSum) {
		this.preCostSum = preCostSum;
	}
	public Date getPreCostDate() {
		return preCostDate;
	}
	public void setPreCostDate(Date preCostDate) {
		this.preCostDate = preCostDate;
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
	public String getCostPreState() {
		return costPreState;
	}
	public void setCostPreState(String costPreState) {
		this.costPreState = costPreState;
	}
	public String getLoanPlan_ID() {
		return loanPlan_ID;
	}
	public void setLoanPlan_ID(String loanPlan_ID) {
		this.loanPlan_ID = loanPlan_ID;
	}
	public String getCostMust_ID() {
		return costMust_ID;
	}
	public void setCostMust_ID(String costMust_ID) {
		this.costMust_ID = costMust_ID;
	}
	
}
