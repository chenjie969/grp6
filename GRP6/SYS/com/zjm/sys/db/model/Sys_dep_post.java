package com.zjm.sys.db.model;

import java.io.Serializable;

/**
*  @description 部门和岗位关联表
*  @company http://www.igit.com.cn/
*  @author wuhn	
*  @date  2017年6月7日 下午7:17:34
*/
public class Sys_dep_post implements Serializable{
	private static final long serialVersionUID = 1L;
	private String post_ID; //岗位id
	private String depart_uid; // 部门id
	private String unit_uid; // 机构id
	private String user_uid; // 用户id  冗余字段，用于传值
	public String getPost_ID() {
		return post_ID;
	}
	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}
	public String getDepart_uid() {
		return depart_uid;
	}
	public void setDepart_uid(String depart_uid) {
		this.depart_uid = depart_uid;
	}
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
	
	
	
	
}
