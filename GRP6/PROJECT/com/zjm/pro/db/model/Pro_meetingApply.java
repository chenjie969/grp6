package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 评审会与申请对应表pro_meetingApply
 */
public class Pro_meetingApply implements Serializable{
	private static final long serialVersionUID = 1L;
	private String	meetingApply_ID;//	流水号	varchar(32)
	private String	meeting_ID;//	评审会ID
	private String	entityType;//业务类型(01申请02打包) char(2)
	private String	entityID;//业务ID
	private String	userIDList;//	表决评委ID
	private String	userNameList;//	表决评委名称
	private Integer	meetingSort;//	上会顺序
	private String	updateUserName;//最后修改人姓名
	private Date	updateDateTime;// 最后修改时间
	
	private Pro_apply proApply;	//冗余字段, 评审会中的项目详情
	private Pro_jurySuggest jurySuggest;//冗余字段, 上会项目对应的某个评委的表决结果
	private String	voteResult;	//冗余字段, 上会项目的评委表决结果
	
	public String getMeetingApply_ID() {
		return meetingApply_ID;
	}
	public void setMeetingApply_ID(String meetingApply_ID) {
		this.meetingApply_ID = meetingApply_ID;
	}
	public String getMeeting_ID() {
		return meeting_ID;
	}
	public void setMeeting_ID(String meeting_ID) {
		this.meeting_ID = meeting_ID;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		this.entityID = entityID;
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
	public Integer getMeetingSort() {
		return meetingSort;
	}
	public void setMeetingSort(Integer meetingSort) {
		this.meetingSort = meetingSort;
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
	public Pro_apply getProApply() {
		return proApply;
	}
	public void setProApply(Pro_apply proApply) {
		this.proApply = proApply;
	}
	public Pro_jurySuggest getJurySuggest() {
		return jurySuggest;
	}
	public void setJurySuggest(Pro_jurySuggest jurySuggest) {
		this.jurySuggest = jurySuggest;
	}
	public String getVoteResult() {
		return voteResult;
	}
	public void setVoteResult(String voteResult) {
		this.voteResult = voteResult;
	}
	
}
