package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 打包表 pro_project
 */
public class Pro_package implements Serializable{
	 private static final long serialVersionUID = 1L;
	 private String  package_ID;//打包ID	
	 private String	packageName;//打包名称
	 private String	packageDesc;//打包描述
	 private String	packageStatus;//打包阶段
	 private Integer  isUnPackage=0;//是否已拆包
	 private String	createManID;//创建人ID
	 private String	createManName;//创建人
	 private Date	createDateTime;//创建时间
	 private String unit_uid;//担保机构编号
	 private String	unit_uidName;//担保机构名称
	 
	 private String applyIDS;//打包子项目ID集合
	 //下面是上会申请用到
	 private Integer  isArrangeMeeting=0;//是否已经被安排上会
	 
	public Integer getIsArrangeMeeting() {
		return isArrangeMeeting;
	}
	public void setIsArrangeMeeting(Integer isArrangeMeeting) {
		this.isArrangeMeeting = isArrangeMeeting;
	}
	public String getPackage_ID() {
		return package_ID;
	}
	public void setPackage_ID(String package_ID) {
		this.package_ID = package_ID;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDesc() {
		return packageDesc;
	}
	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}
	public String getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}
	public Integer getIsUnPackage() {
		return isUnPackage;
	}
	public void setIsUnPackage(Integer isUnPackage) {
		this.isUnPackage = isUnPackage;
	}
	public String getCreateManID() {
		return createManID;
	}
	public void setCreateManID(String createManID) {
		this.createManID = createManID;
	}
	public String getCreateManName() {
		return createManName;
	}
	public void setCreateManName(String createManName) {
		this.createManName = createManName;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
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
	public String getApplyIDS() {
		return applyIDS;
	}
	public void setApplyIDS(String applyIDS) {
		this.applyIDS = applyIDS;
	}
	
}
