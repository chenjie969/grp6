package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 评审会信息表pro_meeting
 */
public class Pro_meeting implements Serializable{
	private static final long serialVersionUID = 1L;
	private String	meeting_ID;//	评审会ID	varchar(32)
	private String	meetingCode;//	评审会编号varchar(50)
	private String	meetingTypeID;//	评审会类型ID
	private String	meetingTypeName;//	评审会类型名称
	private Date	meetingDateTime;//	上会时间
	private String	meetingRoomID;//会议室ID
	private String	meetingRoomName;//会议室名称
	private String	userIDList;//参会评委ID集合
	private String	userNameList;//参会评委姓名集合
	private String	otherUserNameList;//其他列席人员集合
	private String	meetingStatus;//会议状态    char(2) 01未上会 02 已上会
	private String	unit_uid;
	private String	updateUserName;//最后修改人姓名
	private Date	updateDateTime;// 最后修改时间
	
	private String	meetingDateTimeStr;	//上会时间冗余字段,页面用datetimepicker取出的时间值带有时分秒, 后台不能用Date接收 
	
	private List<Map<String,String>> mapList;	//冗余字段, 接收页面传来的评审会对应申请信息
	private Integer	applyNum;	//冗余字段, 查询该次评审会中有几个项目申请
	private List<Pro_meetingApply> meetingApplyList;	//冗余字段, 查询该次评审会中的项目信息

	public String getMeeting_ID() {
		return meeting_ID;
	}

	public void setMeeting_ID(String meeting_ID) {
		this.meeting_ID = meeting_ID;
	}

	public String getMeetingCode() {
		return meetingCode;
	}

	public void setMeetingCode(String meetingCode) {
		this.meetingCode = meetingCode;
	}

	public String getMeetingTypeID() {
		return meetingTypeID;
	}

	public void setMeetingTypeID(String meetingTypeID) {
		this.meetingTypeID = meetingTypeID;
	}

	public String getMeetingTypeName() {
		return meetingTypeName;
	}

	public void setMeetingTypeName(String meetingTypeName) {
		this.meetingTypeName = meetingTypeName;
	}

	public Date getMeetingDateTime() {
		return meetingDateTime;
	}

	public void setMeetingDateTime(Date meetingDateTime) {
		this.meetingDateTime = meetingDateTime;
	}

	public String getMeetingRoomID() {
		return meetingRoomID;
	}

	public void setMeetingRoomID(String meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public String getUserIDList() {
		return userIDList;
	}

	public void setUserIDList(String userIDList) {
		this.userIDList = userIDList;
	}

	public String getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(String userNameList) {
		this.userNameList = userNameList;
	}

	public String getOtherUserNameList() {
		return otherUserNameList;
	}

	public void setOtherUserNameList(String otherUserNameList) {
		this.otherUserNameList = otherUserNameList;
	}

	public String getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
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

	public List<Map<String, String>> getMapList() {
		return mapList;
	}

	public void setMapList(List<Map<String, String>> mapList) {
		this.mapList = mapList;
	}

	public Integer getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}

	public List<Pro_meetingApply> getMeetingApplyList() {
		return meetingApplyList;
	}

	public void setMeetingApplyList(List<Pro_meetingApply> meetingApplyList) {
		this.meetingApplyList = meetingApplyList;
	}

	public String getMeetingDateTimeStr() {
		return meetingDateTimeStr;
	}

	public void setMeetingDateTimeStr(String meetingDateTimeStr) {
		this.meetingDateTimeStr = meetingDateTimeStr;
	}

}
