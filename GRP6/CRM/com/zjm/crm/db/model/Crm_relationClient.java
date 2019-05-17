package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;

public class Crm_relationClient implements Serializable{
	
	/**
	 * 关联企业
	 */
	private static final long serialVersionUID = 1L;
	
	private String relation_id;//关联ID
	private String client_ID;//客户ID
	private String relationClientID;//关联客户ID
	private String relationDesc;//关联关系描述
	private String updateUserName;//更新人
	private Date updateDateTime;//更新时间
	private String  unit_uid;//担保机构ID
	
	private String clientName;//客户名称  client表
	
	
	public String getRelation_id() {
		return relation_id;
	}
	public void setRelation_id(String relation_id) {
		this.relation_id = relation_id;
	}
	public String getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(String client_ID) {
		this.client_ID = client_ID;
	}
	public String getRelationClientID() {
		return relationClientID;
	}
	public void setRelationClientID(String relationClientID) {
		this.relationClientID = relationClientID;
	}
	public String getRelationDesc() {
		return relationDesc;
	}
	public void setRelationDesc(String relationDesc) {
		this.relationDesc = relationDesc;
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
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
}
