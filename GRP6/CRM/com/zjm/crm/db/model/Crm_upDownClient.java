package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业业务经营 之 上下游客户表
 */
public class Crm_upDownClient implements Serializable {

	private String upDownClient_ID;	//流水号
	private String client_ID;		//客户ID
	private String contractPeriod;	//合同期限
	private String upDownFlag;		//上下游标识   01上游供应商02下游销售商
	private String customerName;		//客户名称
	private String productName;		//产品
	private String currentSum;		//金额
	private String remark;			//备注
	private String unit_uid;			//担保机构ID
	private String unit_uidName;		//担保机构名称
	private String updateUserName;	//最后修改人姓名
	private Date updateDateTime;		//最后修改时间
	
	public String getUpDownClient_ID() {
		return upDownClient_ID;
	}
	public void setUpDownClient_ID(String upDownClient_ID) {
		this.upDownClient_ID = upDownClient_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getUpDownFlag() {
		return upDownFlag;
	}
	public void setUpDownFlag(String upDownFlag) {
		this.upDownFlag = upDownFlag;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCurrentSum() {
		return currentSum;
	}
	public void setCurrentSum(String currentSum) {
		this.currentSum = currentSum;
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
	
}
