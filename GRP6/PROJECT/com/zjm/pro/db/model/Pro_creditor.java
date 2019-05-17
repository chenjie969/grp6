package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 债权转让表pro_apply
 */
public class Pro_creditor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String	creditorId;//	债权ID	varchar(32)
	
	private String	applyId;//	申请业务ID	varchar(32)
	
	private String projectId;//项目ID	Variable characters (32)
	
	private String creditApplyId;  //转让后业务申请id
	
	private String creditProjectId;  //转让后项目id
	
	private  String fundSource;//资金来源：省内／省外
	
	private String 	fundType     ;//资金方类型（中文：银行/非银行/个人）
	
	private String 	fundTypeId     ;//资金方类型（中文：银行/非银行/个人）ID
	
	private String 	fundName	;//资金方name
	
	private String 	fundId;  //资金方id
	
	private	String	subFundName	;//	资金方子机构名称 
	
	private Double creditorSum;//转让金额
	
	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getSubFundName() {
		return subFundName;
	}

	public void setSubFundName(String subFundName) {
		this.subFundName = subFundName;
	}

	private Date	createDate;//创建日期
	
	private Date	creditorDate;//上报日期
	
	private String	projectName;//项目名称（冗余字段）
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
	public String getFundSource() {
		return fundSource;
	}

	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getCreditorId() {
		return creditorId;
	}

	public void setCreditorId(String creditorId) {
		this.creditorId = creditorId;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

//	public String getOldClientId() {
//		return oldClientId;
//	}
//
//	public void setOldClientId(String oldClientId) {
//		this.oldClientId = oldClientId;
//	}
//
//	public String getOldClientName() {
//		return oldClientName;
//	}
//
//	public void setOldClientName(String oldClientName) {
//		this.oldClientName = oldClientName;
//	}
//
//	public String getNewClientId() {
//		return newClientId;
//	}
//
//	public void setNewClientId(String newClientId) {
//		this.newClientId = newClientId;
//	}
//
//	public String getNewClientName() {
//		return newClientName;
//	}
//
//	public void setNewClientName(String newClientName) {
//		this.newClientName = newClientName;
//	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreditorDate() {
		return creditorDate;
	}

	public void setCreditorDate(Date creditorDate) {
		this.creditorDate = creditorDate;
	}

	public Double getCreditorSum() {
		return creditorSum;
	}

	public void setCreditorSum(Double creditorSum) {
		this.creditorSum = creditorSum;
	}

	public String getFundTypeId() {
		return fundTypeId;
	}

	public void setFundTypeId(String fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	public String getCreditApplyId() {
		return creditApplyId;
	}

	public void setCreditApplyId(String creditApplyId) {
		this.creditApplyId = creditApplyId;
	}

	public String getCreditProjectId() {
		return creditProjectId;
	}

	public void setCreditProjectId(String creditProjectId) {
		this.creditProjectId = creditProjectId;
	}
	
	

}
