package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业业务经营 之 水电气费缴纳情况表
 */
public class Crm_costInfo implements Serializable {

	private String costInfo_ID;	//流水号
	private String client_ID;	//客户ID
	private String yearMonth;	//年月
	private Integer intYear;	//年份
	private Integer intMonth;	//月份
	private Double electricCost;	//电费
	private Double waterCost;	//水费
	private Double otherCost;	//其他费用
	private Double costSum;	//小计
	private String remark;	//备注
	private String unit_uid;	//担保机构ID
	private String unit_uidName;	//担保机构名称
	private String updateUserName;	//最后修改人姓名
	private Date updateDateTime;	//最后修改时间
	
	public String getCostInfo_ID() {
		return costInfo_ID;
	}
	public void setCostInfo_ID(String costInfo_ID) {
		this.costInfo_ID = costInfo_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public Integer getIntYear() {
		return intYear;
	}
	public void setIntYear(Integer intYear) {
		this.intYear = intYear;
	}
	public Integer getIntMonth() {
		return intMonth;
	}
	public void setIntMonth(Integer intMonth) {
		this.intMonth = intMonth;
	}
	public Double getElectricCost() {
		return electricCost;
	}
	public void setElectricCost(Double electricCost) {
		this.electricCost = electricCost;
	}
	public Double getWaterCost() {
		return waterCost;
	}
	public void setWaterCost(Double waterCost) {
		this.waterCost = waterCost;
	}
	public Double getOtherCost() {
		return otherCost;
	}
	public void setOtherCost(Double otherCost) {
		this.otherCost = otherCost;
	}
	public Double getCostSum() {
		return costSum;
	}
	public void setCostSum(Double costSum) {
		this.costSum = costSum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	
}
