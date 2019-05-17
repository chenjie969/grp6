package com.zjm.sys.db.model;

import java.io.Serializable;

/**
 * 部门用户关联信息   
 * @author duanhuawei  add 20170426
 */
public class Sys_dep_user implements Serializable{
	private static final long serialVersionUID = 1L;
    private String user_uid;//用户ID

    private String depart_uid;//部门ID

    private String unit_uid;//机构ID

    private Integer is_otherdep;//是否是其他部门
    
    private String depart_uid_old;//老部门号，更新时暂存原来的部门号。
    
	public String getDepart_uid_old() {
		return depart_uid_old;
	}

	public void setDepart_uid_old(String depart_uid_old) {
		this.depart_uid_old = depart_uid_old;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
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

	public Integer getIs_otherdep() {
		return is_otherdep=0;
	}

	public void setIs_otherdep(Integer is_otherdep) {
		this.is_otherdep = is_otherdep;
	}

	

    
}