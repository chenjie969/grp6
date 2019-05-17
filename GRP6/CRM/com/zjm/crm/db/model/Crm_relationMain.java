package com.zjm.crm.db.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 关联主体表 
 */
public class Crm_relationMain implements Serializable {

	private static final long serialVersionUID = 1L;
	private String relationMain_ID;	//流水号
	private String relationMainName;	//关联主体名称
	private String clientID;			//主体客户ID
	private String clientName;			//主体客户名称
	private String clientGUID;			//主体客户唯一标识
	private String relationTypeID;		//关系类型ID	
	private String relationTypeName;	//关系类型名称
	private String remark;				//备注
	private String updateUserName;		//最后修改人姓名
	private Date updateDateTime;		//最后修改时间
	private String unit_uid;			//修改人机构ID
	private String	unit_uidName;//机构名称
	
	private List<Crm_client_relationMain> cmlist; 	//冗余字段，封装同一relationMain_ID的Crm_client_relationMain对象
	private String[] relationMainIDs;					//冗余字段，接收批量删除时的主体id
	private String[] relationMainNames;					//冗余字段，接收批量删除时的主体名称
	private String clientIDs;			//冗余字段，用于接收某一主体下所有关联企业的id
	private String clientNames;			//冗余字段，用于接收某一主体下所有关联企业的name
	
	private Double guarantySum;       //2015年1月末担保余额-----融投特有
	private Double guarantyEntrustSum;   //2015年1月末担保集团委贷余额-----融投特有
	private Double entrustSum;    //2015年1月末融投系委贷余额-----融投特有
	private String projectTypeID;   //项目类型ID（字典）----融投特有
	private String projectTypeName;  //项目类型名称----融投特有
	private Double creditorSum;   //保外债权人融资金额
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getRelationTypeID() {
		return relationTypeID;
	}
	public void setRelationTypeID(String relationTypeID) {
		this.relationTypeID = relationTypeID;
	}
	public String getRelationTypeName() {
		return relationTypeName;
	}
	public void setRelationTypeName(String relationTypeName) {
		this.relationTypeName = relationTypeName;
	}
	public String getRelationMainName() {
		return relationMainName;
	}
	public void setRelationMainName(String relationMainName) {
		this.relationMainName = relationMainName;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Crm_client_relationMain> getCmlist() {
		return cmlist;
	}
	public void setCmlist(List<Crm_client_relationMain> cmlist) {
		this.cmlist = cmlist;
	}
	public String[] getRelationMainIDs() {
		return relationMainIDs;
	}
	public void setRelationMainIDs(String[] relationMainIDs) {
		this.relationMainIDs = relationMainIDs;
	}
	public String getClientIDs() {
		return clientIDs;
	}
	public void setClientIDs(String clientIDs) {
		this.clientIDs = clientIDs;
	}
	public String getClientNames() {
		return clientNames;
	}
	public void setClientNames(String clientNames) {
		this.clientNames = clientNames;
	}
	public String getRelationMain_ID() {
		return relationMain_ID;
	}
	public void setRelationMain_ID(String relationMain_ID) {
		this.relationMain_ID = relationMain_ID;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
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
	public String getClientGUID() {
		return clientGUID;
	}
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	public Double getGuarantySum() {
		return guarantySum;
	}
	public void setGuarantySum(Double guarantySum) {
		this.guarantySum = guarantySum;
	}
	public Double getGuarantyEntrustSum() {
		return guarantyEntrustSum;
	}
	public void setGuarantyEntrustSum(Double guarantyEntrustSum) {
		this.guarantyEntrustSum = guarantyEntrustSum;
	}
	public Double getEntrustSum() {
		return entrustSum;
	}
	public void setEntrustSum(Double entrustSum) {
		this.entrustSum = entrustSum;
	}
	public String getProjectTypeID() {
		return projectTypeID;
	}
	public void setProjectTypeID(String projectTypeID) {
		this.projectTypeID = projectTypeID;
	}
	public String getProjectTypeName() {
		return projectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
	public Double getCreditorSum() {
		return creditorSum;
	}
	public void setCreditorSum(Double creditorSum) {
		this.creditorSum = creditorSum;
	}
	public String[] getRelationMainNames() {
		return relationMainNames;
	}
	public void setRelationMainNames(String[] relationMainNames) {
		this.relationMainNames = relationMainNames;
	}
	
	
}
