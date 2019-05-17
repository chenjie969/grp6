package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 利息计算表（按月，按季）
 * 
 * @author jchen
 *
 */
public class Pro_calculationFactPay implements Serializable {
	private static final long serialVersionUID = 1L;
	private String calculation_ID;// 
	private String apply_ID;// 业务申请id
	private String project_ID;// 项目id
	private Double interest;// 本次产生的利息
	private Double fxinterest;// 本次当月产生的罚息
	private Double flinterest;// 本次产生的复利
	private Double surplusInterest;//  本次还款后剩余的利息
	private Double surplusFxinterest;// 本次还款后剩余的罚息
	private Double surplusFlinterest;// 本次还款后剩余的复利
	private Double surplusSum;// 本次还款后剩余的还款利息(还的利息比产生的利息多)
	private Date interestDate;// 利息产生时间
	
	public Double getSurplusInterest() {
		return surplusInterest;
	}

	public void setSurplusInterest(Double surplusInterest) {
		this.surplusInterest = surplusInterest;
	}

	public Double getSurplusFxinterest() {
		return surplusFxinterest;
	}

	public void setSurplusFxinterest(Double surplusFxinterest) {
		this.surplusFxinterest = surplusFxinterest;
	}

	public Double getSurplusFlinterest() {
		return surplusFlinterest;
	}

	public void setSurplusFlinterest(Double surplusFlinterest) {
		this.surplusFlinterest = surplusFlinterest;
	}

	public Double getSurplusSum() {
		return surplusSum;
	}

	public void setSurplusSum(Double surplusSum) {
		this.surplusSum = surplusSum;
	}

	public String getCalculation_ID() {
		return calculation_ID;
	}

	public void setCalculation_ID(String calculation_ID) {
		this.calculation_ID = calculation_ID;
	}

	public String getApply_ID() {
		return apply_ID;
	}

	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}

	public String getProject_ID() {
		return project_ID;
	}

	public void setProject_ID(String project_ID) {
		this.project_ID = project_ID;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getFxinterest() {
		return fxinterest;
	}

	public void setFxinterest(Double fxinterest) {
		this.fxinterest = fxinterest;
	}

	public Double getFlinterest() {
		return flinterest;
	}

	public void setFlinterest(Double flinterest) {
		this.flinterest = flinterest;
	}

	public Date getInterestDate() {
		return interestDate;
	}

	public void setInterestDate(Date interestDate) {
		this.interestDate = interestDate;
	}

}
