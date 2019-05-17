package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 应收费用明细表 pro_costMust
 */
public class Pro_costMust implements Serializable{
	private static final long serialVersionUID = 1L;
	private String costMust_ID	;//	流水号	varchar(32)
	private String apply_ID	;//	申请业务ID	varchar(32)
	private String applyDetail_ID	;//	申请产品ID	varchar(32)
	private String costTypeID	;//	费用类型ID（字典）	varchar(32)
	private String costName	;//	费用名称	varchar(50)
	private Double costRate	;//	费率	float
	private String costUnit	;//	费率单位	varchar(10)
	//-- 新增--
	private Double interestSum;//利息
	private Double capitalMustCostSum;//本金应收费用
	private Double interestMustCostSum;//利息应收费用
	//-- 新增--
	private Double mustCostSum	;//	总应收费用	decimal(18,6)
	private String remark	;//	备注	varchar(100)
	private String costMustState	;//	状态	varchar(100) 未收到/已收到
	private String operationDepartID	;//	经办部门ID	varchar(32)
	private String operationDepartName	;//	经办部门名称	varchar(20)
	private String operationUserID	;//	经办人ID	varchar(32)
	private String operationUserName	;//	经办人名称	varchar(20)
	private String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String updateUserName	;//	最后修改人姓名	varchar(20)
	private Date updateDateTime	;//	最后修改时间	datetime
	private String loanPlan_ID;//计划放款表id
	private Date mustCostDate;//新增  最迟应收日期
	
	private String meetingDetail_ID;// 评审会明细ID
	
	
	
	public String getCostMust_ID() {
		return costMust_ID;
	}
	public void setCostMust_ID(String costMust_ID) {
		this.costMust_ID = costMust_ID;
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
	public Double getMustCostSum() {
		return mustCostSum;
	}
	public void setMustCostSum(Double mustCostSum) {
		this.mustCostSum = mustCostSum;
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
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
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
	public String getCostMustState() {
		return costMustState;
	}
	public void setCostMustState(String costMustState) {
		this.costMustState = costMustState;
	}
	public String getMeetingDetail_ID() {
		return meetingDetail_ID;
	}
	public void setMeetingDetail_ID(String meetingDetail_ID) {
		this.meetingDetail_ID = meetingDetail_ID;
	}
	public Double getInterestSum() {
		return interestSum;
	}
	public void setInterestSum(Double interestSum) {
		this.interestSum = interestSum;
	}
	public Double getCapitalMustCostSum() {
		return capitalMustCostSum;
	}
	public void setCapitalMustCostSum(Double capitalMustCostSum) {
		this.capitalMustCostSum = capitalMustCostSum;
	}
	public Double getInterestMustCostSum() {
		return interestMustCostSum;
	}
	public void setInterestMustCostSum(Double interestMustCostSum) {
		this.interestMustCostSum = interestMustCostSum;
	}
	public Date getMustCostDate() {
		return mustCostDate;
	}
	public void setMustCostDate(Date mustCostDate) {
		this.mustCostDate = mustCostDate;
	}
	
}
