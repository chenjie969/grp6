package com.zjm.sys.db.model;

import java.io.Serializable;

/**
 * 角色与岗位关系表
 * @author mashuo add 20170525
 *
 */
public class Sys_role_post implements Serializable{
	private static final long serialVersionUID = 1L;
	private String role_uid;//角色id
	private String unit_uid;//机构id
	private String post_ID;//岗位id
	
	//=============get/set===============
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getRole_uid() {
		return role_uid;
	}
	public void setRole_uid(String role_uid) {
		this.role_uid = role_uid;
	}
	public String getPost_ID() {
		return post_ID;
	}
	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}
	
}
