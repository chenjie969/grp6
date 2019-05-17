package com.zjm.sys.db.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 担保机构
 * @author duanhuawei add 20170425
 *
 */
public class Sys_units implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private String unit_uid;// 担保机构编号

    private String punit_uid;//上级机构编号

    private String unit_uidName;//机构名称

    private String unit_uidFullCode;//机构完整代码

    private Integer order_id;//节点排序顺序

    private Date createdatetime;//创建时间

    private String create_user;//创建人

    private Date upatedatetime;//最后更新时间

    private String update_user;//最后更新人

    private Integer isEable;//是否可禁用

    private Integer isDefault;//系统自带还是用户自定义

    private String unificationID;//统一编码
    
    private String pUnitsName;  // 上级机构名称，显示用
    
    private String user_id;//用户登录账号
    
    private String userpassword;//用户密码

	public String getUnit_uid() {
		return unit_uid;
	}

	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}

	public String getPunit_uid() {
		return punit_uid;
	}

	public void setPunit_uid(String punit_uid) {
		this.punit_uid = punit_uid;
	}

	public String getUnit_uidName() {
		return unit_uidName;
	}

	public void setUnit_uidName(String unit_uidName) {
		this.unit_uidName = unit_uidName;
	}

	public String getUnit_uidFullCode() {
		return unit_uidFullCode;
	}

	public void setUnit_uidFullCode(String unit_uidFullCode) {
		this.unit_uidFullCode = unit_uidFullCode;
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

	public Date getUpatedatetime() {
		return upatedatetime;
	}

	public void setUpatedatetime(Date upatedatetime) {
		this.upatedatetime = upatedatetime;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public Integer getIsEable() {
		return isEable;
	}

	public void setIsEable(Integer isEable) {
		this.isEable = isEable;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getUnificationID() {
		return unificationID;
	}

	public void setUnificationID(String unificationID) {
		this.unificationID = unificationID;
	}

	public String getpUnitsName() {
		return pUnitsName;
	}

	public void setpUnitsName(String pUnitsName) {
		this.pUnitsName = pUnitsName;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	

}