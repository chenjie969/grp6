package com.zjm.sys.db.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 项目组
 * @author mashuo add 20170512
 *
 */
public class Sys_usergroup implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userGroup_uuid;//项目组id
	private String unit_uid;//机构id
	private String userGroupName;//项目组名称
	private Integer order_id;//排序
	private Date createdatetime;//创建时间
	private String create_user;//创建人名称
	private Date updatedatetime;//最后修改时间
	private String update_user;//最后修改人名称
	
	private String user_uids;//用户id集合
	private String user_names;//用户名称集合
	
	//=============get/set===============
	public String getUserGroup_uuid() {
		return userGroup_uuid;
	}
	public void setUserGroup_uuid(String userGroup_uuid) {
		this.userGroup_uuid = userGroup_uuid;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getUserGroupName() {
		return userGroupName;
	}
	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
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
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getUser_uids() {
		return user_uids;
	}
	public void setUser_uids(String user_uids) {
		this.user_uids = user_uids;
	}
	public String getUser_names() {
		return user_names;
	}
	public void setUser_names(String user_names) {
		this.user_names = user_names;
	}
	
	
}
