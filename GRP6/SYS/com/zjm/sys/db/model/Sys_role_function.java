package com.zjm.sys.db.model;

import java.io.Serializable;

/**
 * 角色与功能关系表
 * @author mashuo add 20170525
 *
 */
public class Sys_role_function implements Serializable{
	private static final long serialVersionUID = 1L;
	private String role_uid;//角色id
	private String unit_uid;//机构id
	private String fun_id;//功能id
	
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
	public String getFun_id() {
		return fun_id;
	}
	public void setFun_id(String fun_id) {
		this.fun_id = fun_id;
	}
	
}
