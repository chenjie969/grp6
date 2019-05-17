package com.zjm.crm.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 客户资料类型树表crm_materialTree
 * @author Administrator
 *
 */
public class Crm_materialTree implements Serializable {
	private static final long serialVersionUID = 1L;
	private String materialTree_ID	;//客户资料类型树ID	varchar(32)
	private String materialModel_ID	;//	客户资料模板ID	varchar(32)
	private String pmaterialTree_ID	;//	父客户资料类型树ID	varchar(200)
	private String materialTreeName	;//	//	客户资料类型名称	text
	private String materialTreeFullCode	;//完整编号	bigint
	private String order_id	;//	顺序	varchar(32)
	private String unit_uid	;//	担保机构ID	varchar(50)
	private String unit_uidName	;//		担保机构名称	varchar(20)
	private String updateUserName	;//最后修改人姓名	datetime
	private Date updateDateTime	;//	最后修改时间

	
	private Integer materialTreeLevel;//树层级(冗余字段)
	
	List<Crm_materialDetail> materialDetailList;//资料清单list
	
	List<Crm_materialTree> materialTreeList;//资料类型list
	
	public String getMaterialTree_ID() {
		return materialTree_ID;
	}
	public void setMaterialTree_ID(String materialTree_ID) {
		this.materialTree_ID = materialTree_ID;
	}
	public String getMaterialModel_ID() {
		return materialModel_ID;
	}
	public void setMaterialModel_ID(String materialModel_ID) {
		this.materialModel_ID = materialModel_ID;
	}
	public String getPmaterialTree_ID() {
		return pmaterialTree_ID;
	}
	public void setPmaterialTree_ID(String pmaterialTree_ID) {
		this.pmaterialTree_ID = pmaterialTree_ID;
	}
	public String getMaterialTreeName() {
		return materialTreeName;
	}
	public void setMaterialTreeName(String materialTreeName) {
		this.materialTreeName = materialTreeName;
	}
	public String getMaterialTreeFullCode() {
		return materialTreeFullCode;
	}
	public void setMaterialTreeFullCode(String materialTreeFullCode) {
		this.materialTreeFullCode = materialTreeFullCode;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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
	public Integer getMaterialTreeLevel() {
		return materialTreeLevel;
	}
	public void setMaterialTreeLevel(Integer materialTreeLevel) {
		this.materialTreeLevel = materialTreeLevel;
	}
	public List<Crm_materialDetail> getMaterialDetailList() {
		return materialDetailList;
	}
	public void setMaterialDetailList(List<Crm_materialDetail> materialDetailList) {
		this.materialDetailList = materialDetailList;
	}
	public List<Crm_materialTree> getMaterialTreeList() {
		return materialTreeList;
	}
	public void setMaterialTreeList(List<Crm_materialTree> materialTreeList) {
		this.materialTreeList = materialTreeList;
	}
	
	

	
}
