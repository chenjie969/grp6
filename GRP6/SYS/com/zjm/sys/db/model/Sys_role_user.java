package com.zjm.sys.db.model;

import java.io.Serializable;

/**
 * 角色与用户关系表
 * @author mashuo add 20170524
 *
 */
public class Sys_role_user implements Serializable{
	private static final long serialVersionUID = 1L;
	private String role_uid;//角色id
	private String unit_uid;//机构id
	private String user_uid;//用户id
	
	//=============get/set===============
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getUser_uid() {
		return user_uid;
	}
	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}
	public String getRole_uid() {
		return role_uid;
	}
	public void setRole_uid(String role_uid) {
		this.role_uid = role_uid;
	}
	
}
