package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业详情→企业财务状况→主要负债情况→开票银行
 */
public class Crm_billRec implements Serializable {

	private String billRec_ID;	//流水号
	private String client_ID;	//客户ID
	private String billBank;	//开票银行
	private Double billSum;	//票面金额（万元）
	private String period;	//票据期限
	private Date beginDate;	//开始日期
	private Date endDate;	//结束日期
	private Double creditSum;	//敞口金额
	private String remark;	//备注
	private String unit_uid;	//担保机构ID
	private String unit_uidName;	//担保机构名称
	private String updateUserName;	//最后修改人姓名
	private Date updateDateTime;	//最后修改时间
	public String getBillRec_ID() {
		return billRec_ID;
	}
	public void setBillRec_ID(String billRec_ID) {
		this.billRec_ID = billRec_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getBillBank() {
		return billBank;
	}
	public void setBillBank(String billBank) {
		this.billBank = billBank;
	}
	public Double getBillSum() {
		return billSum;
	}
	public void setBillSum(Double billSum) {
		this.billSum = billSum;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getCreditSum() {
		return creditSum;
	}
	public void setCreditSum(Double creditSum) {
		this.creditSum = creditSum;
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
