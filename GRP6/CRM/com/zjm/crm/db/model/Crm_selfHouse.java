package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Crm_selfHouse implements Serializable{
	
	/**
	 * 自有住房表
	 */
	private static final long serialVersionUID = 1L;
	
	private String selfHosuse_ID;//流水号
	private String client_ID;//客户ID
	private String address;//坐落
	private Float area;//建筑面积.平方
	private String ownership;//权属类型
	private String thirdName;//第三人姓名
	private String personNum;//身份证号码
	private String relation;//与借款人关系
	private String remark;//备注
	private String updateUserName;//最后修改人姓名
	private Date updateDateTime;//最后修改时间
	private String   unit_uid;//担保机构ID
	
	
	

	public String getSelfHosuse_ID() {
		return selfHosuse_ID;
	}
	public void setSelfHosuse_ID(String selfHosuse_ID) {
		this.selfHosuse_ID = selfHosuse_ID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getArea() {
		return area;
	}
	public void setArea(Float area) {
		this.area = area;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public String getThirdName() {
		return thirdName;
	}
	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
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
