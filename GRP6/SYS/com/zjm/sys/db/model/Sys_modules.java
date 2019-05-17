package com.zjm.sys.db.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 菜单      
 * @author mashuo  1144689809@qq.com  add 20170330
 */
public class Sys_modules implements Serializable{
	private static final long serialVersionUID = 1L;
	private String unit_uid;//机构id
	private String mod_uid;//模块id
	private String pmod_id;//模块父id
	private String mod_name;//模块名称
	private String url;//模块url
	private String title;
	private String iframe;
	private String icon;//模块图标
	private String iconopen;
	private Boolean isopen;//是否打开
	private Integer order_id;//排序
	private Date createdatetime;
	private String create_user;
	private Date updatedatetime;
	private String update_user;
	private Integer mod_type;//模块类型
	private Integer isReload;//是否自动刷新
	
	
	private List<Sys_modules> modulesList;
	
	
	
	
	
	
	public String getMod_name() {
		return mod_name;
	}
	public void setMod_name(String mod_name) {
		this.mod_name = mod_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIframe() {
		return iframe;
	}
	public void setIframe(String iframe) {
		this.iframe = iframe;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconopen() {
		return iconopen;
	}
	public void setIconopen(String iconopen) {
		this.iconopen = iconopen;
	}
	public Boolean getIsopen() {
		return isopen;
	}
	public void setIsopen(Boolean isopen) {
		this.isopen = isopen;
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
	public List<Sys_modules> getModulesList() {
		return modulesList;
	}
	public void setModulesList(List<Sys_modules> modulesList) {
		this.modulesList = modulesList;
	}
	
	public Integer getMod_type() {
		return mod_type;
	}
	public void setMod_type(Integer mod_type) {
		this.mod_type = mod_type;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
	}
	public String getMod_uid() {
		return mod_uid;
	}
	public void setMod_uid(String mod_uid) {
		this.mod_uid = mod_uid;
	}
	public String getPmod_id() {
		return pmod_id;
	}
	public void setPmod_id(String pmod_id) {
		this.pmod_id = pmod_id;
	}
	public Integer getIsReload() {
		return isReload;
	}
	public void setIsReload(Integer isReload) {
		this.isReload = isReload;
	}
	
	
	

}
