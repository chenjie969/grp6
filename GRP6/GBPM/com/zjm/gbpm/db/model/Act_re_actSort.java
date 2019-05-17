package com.zjm.gbpm.db.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * 流程分类
 * @author mashuo add 20170714
 *
 */
public class Act_re_actSort implements Serializable {
	
	private String actSortID;//流程分类ID
	private String pactSortID;//流程分类pID
	private String unit_uid;//机构id
	private String actSortName;//流程分类名称
	private String actSortFullCode;//流程分类完整编码
	private Integer order_id;//排序
	private String remark;//备注
	private Date createdatetime;//创建时间
	private String create_user;//创建人
	private Date updatedatetime;//最后修改时间
	private String update_user;//最后修改人
	private Integer isOpen;//是否打开节点
	
	//==================get/set========================
	
	public String getActSortID() {
		return actSortID;
	}
	public void setActSortID(String actSortID) {
		this.actSortID = actSortID;
	}
	public String getPactSortID() {
		return pactSortID;
	}
	public void setPactSortID(String pactSortID) {
		this.pactSortID = pactSortID;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getActSortName() {
		return actSortName;
	}
	public void setActSortName(String actSortName) {
		this.actSortName = actSortName;
	}
	public String getActSortFullCode() {
		return actSortFullCode;
	}
	public void setActSortFullCode(String actSortFullCode) {
		this.actSortFullCode = actSortFullCode;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public Integer getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

}
