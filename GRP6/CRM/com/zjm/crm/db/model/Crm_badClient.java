package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 黑名单表
 */
public class Crm_badClient implements Serializable {

	private String	badClient_ID;	//流水号
	private String	client_ID;		//客户ID
	private String 	operationDepartFullCode;	//经办部门完整代码
	private String 	operationDepartName;		//经办部门名称
	private String	operatorID;		//经办人ID
	private String	operatorName;	//经办人姓名
	private Date 	operatorDate;	//经办时间
	private String 	operationDescription;	//拉入黑名单原因
	private String 	cancelDepartFullCode;	//取消黑名单经办部门完整代码
	private String 	cancelDepartName;		//取消黑名单经办部门名称
	private String	cancelOperatorID;		//取消黑名单经办人ID
	private String	cancelOperatorName;		//取消黑名单经办人姓名
	private Date 	cancelDate;		//取消黑名单经办时间
	private String 	cancelDescription;		//取消黑名单原因
	private String 	updateUserName;	//最后修改人姓名
	private Date	updateDateTime;	//最后修改时间
	private String  unit_uid;//担保机构ID
	private String	unit_uidName;//机构名称
	private Client 	client;
	
	
	public String getBadClient_ID() {
		return badClient_ID;
	}
	public void setBadClient_ID(String badClient_ID) {
		this.badClient_ID = badClient_ID;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public String getCancelOperatorID() {
		return cancelOperatorID;
	}
	public void setCancelOperatorID(String cancelOperatorID) {
		this.cancelOperatorID = cancelOperatorID;
	}
	public String getOperationDepartFullCode() {
		return operationDepartFullCode;
	}
	public void setOperationDepartFullCode(String operationDepartFullCode) {
		this.operationDepartFullCode = operationDepartFullCode;
	}
	public String getOperationDepartName() {
		return operationDepartName;
	}
	public void setOperationDepartName(String operationDepartName) {
		this.operationDepartName = operationDepartName;
	}
	public Date getOperatorDate() {
		return operatorDate;
	}
	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}
	public String getOperationDescription() {
		return operationDescription;
	}
	public void setOperationDescription(String operationDescription) {
		this.operationDescription = operationDescription;
	}
	public String getCancelDepartFullCode() {
		return cancelDepartFullCode;
	}
	public void setCancelDepartFullCode(String cancelDepartFullCode) {
		this.cancelDepartFullCode = cancelDepartFullCode;
	}
	public String getCancelDepartName() {
		return cancelDepartName;
	}
	public void setCancelDepartName(String cancelDepartName) {
		this.cancelDepartName = cancelDepartName;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelDescription() {
		return cancelDescription;
	}
	public void setCancelDescription(String cancelDescription) {
		this.cancelDescription = cancelDescription;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getCancelOperatorName() {
		return cancelOperatorName;
	}
	public void setCancelOperatorName(String cancelOperatorName) {
		this.cancelOperatorName = cancelOperatorName;
	}
	public String getUnit_uidName() {
		return unit_uidName;
	}
	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}
	
}
