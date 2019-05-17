package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Crm_materialModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String  materialModel_ID	;//	客户资料模板ID	varchar(32)
	private String  materialModelName	;//	客户资料模板名称	varchar(100)
	private String  busiTypeIDList	;//	适用业务品种ID集合	text
	private String  busiTypeNameList	;//	适用业务品种名称集合	text
	private String  clientTypeID	;//	适用客户类型ID(字典)	varchar(32)
	private String  clientTypeName	;//	适用客户类型名称	varchar(20)
	private Double  versionNumber	;//	版本	<Undefined>
	private Boolean  status	;//	模板状态(1：启用/0：禁用)	bool
	private String  remark	;//	备注	text
	private String  unit_uid	;//	担保机构ID	varchar(32)
	private String  unit_uidName	;//	担保机构名称	varchar(50)
	private String  updateUserName	;//	最后修改人姓名	varchar(20)
	private Date  updateDateTime	;//	最后修改时间	datetime
	
	
	
	public String getMaterialModel_ID() {
		return materialModel_ID;
	}
	public void setMaterialModel_ID(String materialModel_ID) {
		this.materialModel_ID = materialModel_ID;
	}
	public String getMaterialModelName() {
		return materialModelName;
	}
	public void setMaterialModelName(String materialModelName) {
		this.materialModelName = materialModelName;
	}
	public String getBusiTypeIDList() {
		return busiTypeIDList;
	}
	public void setBusiTypeIDList(String busiTypeIDList) {
		this.busiTypeIDList = busiTypeIDList;
	}
	public String getBusiTypeNameList() {
		return busiTypeNameList;
	}
	public void setBusiTypeNameList(String busiTypeNameList) {
		this.busiTypeNameList = busiTypeNameList;
	}
	public String getClientTypeID() {
		return clientTypeID;
	}
	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
	}
	public String getClientTypeName() {
		return clientTypeName;
	}
	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}
	
	
	
	public Double getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(Double versionNumber) {
		this.versionNumber = versionNumber;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
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
