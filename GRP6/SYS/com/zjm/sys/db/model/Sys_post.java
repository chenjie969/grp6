package com.zjm.sys.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位
 * @author zky add 20170504
 *
 */
public class Sys_post implements Serializable{
	private static final long serialVersionUID = 1L;
	private String	post_ID; //岗位ID
	private String	parentPostID;//父岗位ID
	private String  unit_uid;//担保机构编号
	private String	postFullCode;//节点完整代码
	private String	postCode;///岗位代码
	private String	postName;//岗位名称
	private String	postDescription;//岗位描述
	private Boolean	isDelete;//逻辑删除标识
	private String	order_id;//排列位置
	private String	createUserName;//创建人名称
	private Date	createDateTime;//创建时间
	private String updateUserName;//最后修改人名称	
	private Date	updateDateTime;//最后修改时间
	private String  post_User;// 岗位和人员信息 --> 用于显示
	
	private String	parentPostName;//父岗位名称，显示用
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public String getPost_ID() {
		return post_ID;
	}
	public void setPost_ID(String post_ID) {
		this.post_ID = post_ID;
	}
	public String getParentPostID() {
		return parentPostID;
	}
	public void setParentPostID(String parentPostID) {
		this.parentPostID = parentPostID;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getParentPostName() {
		return parentPostName;
	}
	public void setParentPostName(String parentPostName) {
		this.parentPostName = parentPostName;
	}
	public String getPostFullCode() {
		return postFullCode;
	}
	public void setPostFullCode(String postFullCode) {
		this.postFullCode = postFullCode;
	}
	public String getPost_User() {
		return post_User;
	}
	public void setPost_User(String post_User) {
		this.post_User = post_User;
	}
	
	
	
	
	
	
	
	
	
}