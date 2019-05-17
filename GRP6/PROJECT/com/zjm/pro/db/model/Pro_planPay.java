package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

public class Pro_planPay implements Serializable{
	private static final long serialVersionUID = 1L;
	private String planPay_ID;		//流水号	varchar(32)
	private String apply_ID;		//对应申请业务ID	varchar(32)
	private String applyDetail_ID;	//对应申请产品ID	varchar(32)
	private String loanPlan_ID;		//对应还款计划ID	varchar(32)
	private String project_ID;		//对应项目ID	varchar(32)
	private Date planPayDate;		//计划还款日期	date
	private Integer planPayMonth;	//放款后第几个月还款
	private Double planPaySum;		//计划还款金额	decimal(18,6)
	private String payStatus;		//还款状态（中文：未还款/部分还款/已还清）	varchar(32)
	private String unit_uid;		//担保机构编号unit_uid	varchar(32)
	private String updateUserName;	//最后修改人姓名	varchar(32)
	private Date updateDateTime;	//最后修改时间	datetime
	
	private String	accessType;		//冗余字段, 新增或修改还款计划时, 判断来源路径是新增(insert)还是修改(update)
	private Integer	startMonth;		//冗余字段, 自动生成还款计划时用, 从放款后第几个月开始还款
	private Integer	monthNum;		//冗余字段, 自动生成还款计划时用, 每隔几个月还一次款
	
	private String	payCount;       //冗余字段,判断是一次还款，还是多次还款
	private Double	notPlanPaySum;       //冗余字段,未做计划还款金额
	
	
	public String getPayCount() {
		return payCount;
	}
	public void setPayCount(String payCount) {
		this.payCount = payCount;
	}
	public String getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}
	public String getPlanPay_ID() {
		return planPay_ID;
	}
	public void setPlanPay_ID(String planPay_ID) {
		this.planPay_ID = planPay_ID;
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
	public Date getPlanPayDate() {
		return planPayDate;
	}
	public void setPlanPayDate(Date planPayDate) {
		this.planPayDate = planPayDate;
	}
	public Double getPlanPaySum() {
		return planPaySum;
	}
	public void setPlanPaySum(Double planPaySum) {
		this.planPaySum = planPaySum;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
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
	public String getLoanPlan_ID() {
		return loanPlan_ID;
	}
	public void setLoanPlan_ID(String loanPlan_ID) {
		this.loanPlan_ID = loanPlan_ID;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public Integer getPlanPayMonth() {
		return planPayMonth;
	}
	public void setPlanPayMonth(Integer planPayMonth) {
		this.planPayMonth = planPayMonth;
	}
	public Integer getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}
	public Integer getMonthNum() {
		return monthNum;
	}
	public void setMonthNum(Integer monthNum) {
		this.monthNum = monthNum;
	}
	public Double getNotPlanPaySum() {
		return notPlanPaySum;
	}
	public void setNotPlanPaySum(Double notPlanPaySum) {
		this.notPlanPaySum = notPlanPaySum;
	}
	
}
