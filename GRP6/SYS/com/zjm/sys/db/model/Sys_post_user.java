package com.zjm.sys.db.model;

import java.io.Serializable;

/**
 * 岗位与用户对应关系
 * @author zky  add 20170504
 */
public class Sys_post_user implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private String post_ID;//岗位ID

    private String user_uid;//用户user_uid

    private String unit_uid;//担保机构编号unit_uid

	public String getPost_ID() {
		return post_ID;
	}

	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}

	

    
}