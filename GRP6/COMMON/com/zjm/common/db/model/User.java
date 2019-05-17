package com.zjm.common.db.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * 用户
 * @author mashuo add 20170522
 */
public class User implements Serializable {
	private String unit_uid;//机构id
	private String unit_uidName;//机构名称
	private String user_uid;//用户id
	private String user_id;//用户账号
	private String userpassword;//用户密码
	private String user_bh;//用户编号
	private String user_name;//用户名称
	private String user_type;//用户类型
	private Integer isEable;//是否禁用
	private Integer isactive;//是否允许登录
	private Integer isAdmin;//是否管理员
	private Integer order_id;//排序
	private Date createdatetime;//创建时间
	private String create_user;//创建人
	private Date updatedatetime;//最后修改时间
	private String update_user;//最后修改人
	private String depart_uid;//部门id
	private String depart_name;//部门名称
	private Integer is_otherdep;//是否是其他所属部门
	private String post_id; // 岗位ID
	private String postName; // 岗位名称
	
	private String ipaddress;//登录ip
	
	private String role_uids;
	
	
	//==================get/set==========================
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
	public String getUser_uid() {
		return user_uid;
	}
	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
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
	public Integer getIsEable() {
		return isEable;
	}
	public void setIsEable(Integer isEable) {
		this.isEable = isEable;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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
	public String getDepart_uid() {
		return depart_uid;
	}
	public void setDepart_uid(String depart_uid) {
		this.depart_uid = depart_uid;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public Integer getIs_otherdep() {
		return is_otherdep;
	}
	public void setIs_otherdep(Integer is_otherdep) {
		this.is_otherdep = is_otherdep;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getRole_uids() {
		return role_uids;
	}
	public void setRole_uids(String role_uids) {
		this.role_uids = role_uids;
	}

}
