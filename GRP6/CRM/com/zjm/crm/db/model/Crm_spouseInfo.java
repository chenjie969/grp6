package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Crm_spouseInfo implements Serializable{
	
	/**
	 * 配偶信息表
	 */
	private static final long serialVersionUID = 1L;
	private String spouseInfo_ID;//流水号
	private String   client_ID;//客户ID
	private String   spouseName;//配偶姓名
	private String   personNum ;//身份证号
	private String   unitName;//单位名称
	private String   unitAddress;//单位地址
	private String   unitPost;//单位邮编
	private String   unitPhone;//单位电话
	private Float  monthIncome;//税后月收入.元
	private String   contact;//联系方式
	private String   remark;//备注
	private String   updateUserName;//最后修改人姓名
	private Date   updateDateTime;//最后修改时间
	private String   unit_uid;//担保机构ID
	
	
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getUnitPost() {
		return unitPost;
	}
	public void setUnitPost(String unitPost) {
		this.unitPost = unitPost;
	}
	public String getUnitPhone() {
		return unitPhone;
	}
	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}
	public Float getMonthIncome() {
		return monthIncome;
	}
	public void setMonthIncome(Float monthIncome) {
		this.monthIncome = monthIncome;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getSpouseInfo_ID() {
		return spouseInfo_ID;
	}
	public void setSpouseInfo_ID(String spouseInfo_ID) {
		this.spouseInfo_ID = spouseInfo_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	
	
}
