package com.zjm.sys.db.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * 用户信息   
 * @author mashuo  1144689809@qq.com  add 20170330
 */
public class Sys_users implements Serializable{
	private static final long serialVersionUID = 1L;
	private String unit_uid;
	private String unit_uidName;
	private String user_uid;//用户id
	private String user_id;
	private String user_bh;
	private String user_name;
	private String user_type;
	private Integer isactive;
	private Date createdatetime;
	private String create_user;
	private Date updatedatetime;
	private String update_user;
	private String userpassword;
	private Integer order_id;
	private Integer isAdmin;
	private Integer isEable;
	//duanhuawei  add 20170427  添加用户时传数据使用
	private String depart_uid;
	private String depart_name;
	//duanhuawei add 20170427  添加用户时传数据使用
	private Integer is_otherdep;//is_otherdep

	private String post_ID; //添加用户时传数据使用
	private String postName; //添加用户时传数据使用
	private String departUid;//在更改用户部门时创建,页面中不可出现depart_uid
	private String departOldId;//在更新用户部门时创建，暂存原来的depart_uid
	
	public String getDepartOldId() {
		return departOldId;
	}
	public void setDepartOldId(String departOldId) {
		this.departOldId = departOldId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_bh() {
		return user_bh;
	}
	public void setUser_bh(String user_bh) {
		this.user_bh = user_bh;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
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
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public Integer getIs_otherdep() {
		return is_otherdep;
	}
	public void setIs_otherdep(Integer is_otherdep) {
		this.is_otherdep = is_otherdep;
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
	public String getDepart_uid() {
		return depart_uid;
	}
	public void setDepart_uid(String depart_uid) {
		this.depart_uid = depart_uid;
	}
	public Integer getIsEable() {
		return isEable;
	}
	public void setIsEable(Integer isEable) {
		this.isEable = isEable;
	}
	public String getUnit_uidName() {
		return unit_uidName;
	}
	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}

	public String getPost_ID() {
		return post_ID;
	}
	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getDepartUid() {
		return departUid;
	}
	public void setDepartUid(String departUid) {
		this.departUid = departUid;
	}

	
	
}
