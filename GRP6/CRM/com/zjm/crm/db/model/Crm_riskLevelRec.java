package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

/*
 * 风险等级变更记录表
 */
public class Crm_riskLevelRec implements Serializable {
  
	 private String  riskLevelRec_ID ;//流水号
	 private String client_ID;//客户ID
	 private String riskLevelID;//风险等级ID
	 private String riskLevelName;//风险等级名称
	 private String riskLevelIDDesc ;//风险等级描述
	 private Date changeDateTime;//变更时间
	 private String changeUserID;//变更人ID
	 private String changeUserName ;//变更人名称
	 private String  unit_uid;//担保机构ID
	 private String  unit_uidName;	//担保机构名称
	 private String   updateUserName;//最后修改人姓名
	 private Date  updateDateTime;//最后修改时间
	 //冗余字段
	 private String divisionID;   //分类处置划分ID
	 private String divisionName;   //分类处置划分名称
	public String getRiskLevelRec_ID() {
		return riskLevelRec_ID;
	}
	public void setRiskLevelRec_ID(String riskLevelRec_ID) {
		this.riskLevelRec_ID = riskLevelRec_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getRiskLevelName() {
		return riskLevelName;
	}
	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
	}
	public String getRiskLevelIDDesc() {
		return riskLevelIDDesc;
	}
	public void setRiskLevelIDDesc(String riskLevelIDDesc) {
		this.riskLevelIDDesc = riskLevelIDDesc;
	}
	public Date getChangeDateTime() {
		return changeDateTime;
	}
	public void setChangeDateTime(Date changeDateTime) {
		this.changeDateTime = changeDateTime;
	}
	public String getChangeUserID() {
		return changeUserID;
	}
	public void setChangeUserID(String changeUserID) {
		this.changeUserID = changeUserID;
	}
	public String getChangeUserName() {
		return changeUserName;
	}
	public void setChangeUserName(String changeUserName) {
		this.changeUserName = changeUserName;
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
	public String getRiskLevelID() {
		return riskLevelID;
	}
	public void setRiskLevelID(String riskLevelID) {
		this.riskLevelID = riskLevelID;
	}
	public String getDivisionID() {
		return divisionID;
	}
	public void setDivisionID(String divisionID) {
		this.divisionID = divisionID;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	
}
