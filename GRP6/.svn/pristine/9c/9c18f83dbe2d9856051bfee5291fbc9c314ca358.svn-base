package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

import com.zjm.sys.db.model.Sys_costStandard;

/**
 * 缓收费用明细表pro_costDelay
 * @author Administrator
 *
 */
public class Pro_costDelay implements Serializable{
	private static final long serialVersionUID = 1L;
	private 	String	costDelay_ID	;//	流水号	varchar(32)
	private 	String	apply_ID	;//	申请ID	varchar(32)
	private 	String	applyDetail_ID	;//	申请业务明细ID	varchar(32)
	private 	String	costTypeID	;//	费用类型ID	varchar(32)
	private 	String	costName	;//	费用名称	varchar(50)
	private     Double costRate	;//	费率	float
	private 	String	costUnit	;//	费率单位	varchar(10)
	private      Double delayCostSum	;//	缓收金额	decimal(18,6)
	private 	String	remark	;//	备注	varchar(100)
	private 	String	operationDepartID	;//	经办部门	varchar(32)
	private 	String	operationDepartName	;//	经办部门名称	varchar(20)
	private 	String	operationUserID	;//	经办人	varchar(32)
	private 	String	operationUserName	;//	经办人名称	varchar(20)
	private 	String		unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private 	String updateUserName	;//	最后修改人姓名	varchar(20)
	private     Date updateDateTime	;//	最后修改时间	datetime

	
	private 	Sys_costStandard costStandard;	//冗余字段, 系统定义收费标准
	private 	String	busiTypeName;	//冗余字段, 业务品种
	private 	String	bankName;		//冗余字段, 合作机构
	private 	Double	agreeSum;		//冗余字段, 担保金额(同意金额)
	private 	String 	costMust_ID;	//冗余字段, 应收转缓收所对应的应收费用ID
	
	
	public String getCostDelay_ID() {
		return costDelay_ID;
	}
	public void setCostDelay_ID(String costDelay_ID) {
		this.costDelay_ID = costDelay_ID;
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
	public Double getDelayCostSum() {
		return delayCostSum;
	}
	public void setDelayCostSum(Double delayCostSum) {
		this.delayCostSum = delayCostSum;
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
	public Sys_costStandard getCostStandard() {
		return costStandard;
	}
	public void setCostStandard(Sys_costStandard costStandard) {
		this.costStandard = costStandard;
	}
	public String getBusiTypeName() {
		return busiTypeName;
	}
	public void setBusiTypeName(String busiTypeName) {
		this.busiTypeName = busiTypeName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Double getAgreeSum() {
		return agreeSum;
	}
	public void setAgreeSum(Double agreeSum) {
		this.agreeSum = agreeSum;
	}
	public String getCostMust_ID() {
		return costMust_ID;
	}
	public void setCostMust_ID(String costMust_ID) {
		this.costMust_ID = costMust_ID;
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
	
}
