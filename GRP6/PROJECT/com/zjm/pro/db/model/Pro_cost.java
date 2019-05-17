package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 费用  冗余实体类     取数据用的
 */
public class Pro_cost implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String costTypeName	;//	费用类型
	private String loanAgreeSum	;//	对应放款
	
	private Double mustCostSum	;//	应收金额
	private Double factCostSum	;//	实收金额
	private Double preCostSum	;//	预收金额
	private Double returnCostSum;//	退费金额
	public String getCostTypeName() {
		return costTypeName;
	}
	public void setCostTypeName(String costTypeName) {
		this.costTypeName = costTypeName;
	}
	public String getLoanAgreeSum() {
		return loanAgreeSum;
	}
	public void setLoanAgreeSum(String loanAgreeSum) {
		this.loanAgreeSum = loanAgreeSum;
	}
	public Double getMustCostSum() {
		return mustCostSum;
	}
	public void setMustCostSum(Double mustCostSum) {
		this.mustCostSum = mustCostSum;
	}
	public Double getFactCostSum() {
		return factCostSum;
	}
	public void setFactCostSum(Double factCostSum) {
		this.factCostSum = factCostSum;
	}
	public Double getPreCostSum() {
		return preCostSum;
	}
	public void setPreCostSum(Double preCostSum) {
		this.preCostSum = preCostSum;
	}
	public Double getReturnCostSum() {
		return returnCostSum;
	}
	public void setReturnCostSum(Double returnCostSum) {
		this.returnCostSum = returnCostSum;
	}
	
}
