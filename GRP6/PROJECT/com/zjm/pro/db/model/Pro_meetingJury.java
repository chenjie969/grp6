package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

public class Pro_meetingJury implements Serializable{

	private static final long serialVersionUID = 1L;
	private String 	meetingJury_ID;
	private String 	userUid;
	private String 	userName;
	private String	juryStatus;		//01启用02禁用
	private String 	unit_uid;
	private String 	updateUserName;
	private Date 	updateDateTime;
	
	private String	juryUserUids;		//冗余字段, 从页面接收多个评委ID
	private String	juryUserNames;	//冗余字段, 从页面接收多个评委名字
	
	public String getMeetingJury_ID() {
		return meetingJury_ID;
	}
	public void setMeetingJury_ID(String meetingJury_ID) {
		this.meetingJury_ID = meetingJury_ID;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJuryStatus() {
		return juryStatus;
	}
	public void setJuryStatus(String juryStatus) {
		this.juryStatus = juryStatus;
	}
	public String getUnit_uid() {
		return unit_uid;
	}
	public void setUnit_uid(String unit_uid) {
		this.unit_uid = unit_uid;
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
	public String getJuryUserUids() {
		return juryUserUids;
	}
	public void setJuryUserUids(String juryUserUids) {
		this.juryUserUids = juryUserUids;
	}
	public String getJuryUserNames() {
		return juryUserNames;
	}
	public void setJuryUserNames(String juryUserNames) {
		this.juryUserNames = juryUserNames;
	}
	
}
