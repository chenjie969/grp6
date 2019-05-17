package com.zjm.gbpm.db.model;

import java.io.Serializable;

/**
 * 手机APP首页数据
 * @author xuyz
 *
 */
public class AppDesktopVO implements Serializable {
	
	/*基本信息*/
	private String title;	//标题
	private String icon;	//图标名称
	private String desc;	//简要信息
	private Integer totalNum;	//总数
	
	/*消息相关*/
	/*private String messageTypePID;	//消息大类ID	*/	
	
	public AppDesktopVO() {
		super();
	}

	public AppDesktopVO(String title, String icon, String desc, Integer totalNum /*, String messageTypePID*/) {
		super();
		this.title = title;
		this.icon = icon;
		this.desc = desc;
		this.totalNum = totalNum;
		/*this.messageTypePID = messageTypePID;*/
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	/*public String getMessageTypePID() {
		return messageTypePID;
	}

	public void setMessageTypePID(String messageTypePID) {
		this.messageTypePID = messageTypePID;
	}*/
	
}