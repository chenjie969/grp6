package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 对外担保情况表  Crm_guarantyRec
 */
public class Crm_guarantyRec implements Serializable {

	private String guarantyRec_ID;	//流水号
	private String client_ID;	//客户ID
	private String guarantyUnit;	//对外担保单位
	private Double guarantySum;	//担保金额（万元）
	private String period;	//担保期限
	private Date beginDate;	//开始日期
	private Date endDate;	//结束日期
	private String eachOther;	//互保企业
	private String remark;	//备注
	private String unit_uid;	//担保机构ID
	private String unit_uidName;	//担保机构名称
	private String updateUserName;	//最后修改人姓名
	private Date updateDateTime;	//最后修改时间
	public String getGuarantyRec_ID() {
		return guarantyRec_ID;
	}
	public void setGuarantyRec_ID(String guarantyRec_ID) {
		this.guarantyRec_ID = guarantyRec_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getGuarantyUnit() {
		return guarantyUnit;
	}
	public void setGuarantyUnit(String guarantyUnit) {
		this.guarantyUnit = guarantyUnit;
	}
	public Double getGuarantySum() {
		return guarantySum;
	}
	public void setGuarantySum(Double guarantySum) {
		this.guarantySum = guarantySum;
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
	public String getEachOther() {
		return eachOther;
	}
	public void setEachOther(String eachOther) {
		this.eachOther = eachOther;
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
