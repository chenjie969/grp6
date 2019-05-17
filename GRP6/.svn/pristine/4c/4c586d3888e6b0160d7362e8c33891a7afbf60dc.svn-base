package com.zjm.pro.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 评审会决议表pro_meetingResolution
 */
public class Pro_meetingResolution implements Serializable{
	private static final long serialVersionUID = 1L;
	private String meetingResolution_ID	;//	评审会决议ID	varchar(32)
	private String apply_ID	;//	业务申请ID	varchar(32)
	private String meeting_ID	;//	评审会ID	varchar(32)
	private String meetingCode	;//	评审会编号	varchar(50)
	private String resolutionType	;//	决议类型ID(字典)	varchar(32)
	private String resolutionTypeName	;//	决议类型名称	varchar(20)
	private Date meetingDate	;//	上会日期	date
	private String userIDList;  //表决评委ID集合
	private String userNameList;//表决评委名称集合
	private String otherUserNameList;// 其他列席人员
	private String resolutionCode	;//	决议编号	varchar(50)
	private Integer shouldJury	;//	参会人数	smallint
	private Integer senseJury	;//	实到人数	smallint
	private Integer passJury	;//	通过人数	smallint
	private String signed	;//	评审决议	text
	private String optDesc;     //保证措施 text
	private String processControl	;//	过程控制	text
	private String loanConditions	;//	放款条件	text
	private String otherMatters	;//	其他事项	text
	private String controlTypeID	;//	保后监控周期ID（字典）	varchar(32)
	private String controlTypeName	;//	保后监控周期名称	varchar(20)
	private String monitoredAsking	;//	在保监控要求	text
	private String resolutionResultID	;//	决议结果ID(字典)	varchar(32)
	private String resolutionResultName	;//	决议结果名称	varchar(20)
	private String unit_uid	;//	担保机构编号unit_uid	varchar(32)
	private String unit_uidName	;//	担保机构名称	varchar(50)
	private String updateUserName	;//	最后修改人姓名	varchar(20)
	private Date updateDateTime	;//	最后修改时间	datetime
	
	
	private Integer controlTypeNumber	;//	保后监控周期ID（字典）对应的数字	varchar(32)
	
	private List<Pro_meetingDetail> meetingDetailList ;

	public String getMeetingResolution_ID() {
		return meetingResolution_ID;
	}
	public void setMeetingResolution_ID(String meetingResolution_ID) {
		this.meetingResolution_ID = meetingResolution_ID;
	}
	public String getMeetingCode() {
		return meetingCode;
	}
	public void setMeetingCode(String meetingCode) {
		this.meetingCode = meetingCode;
	}
	public String getResolutionType() {
		return resolutionType;
	}
	public void setResolutionType(String resolutionType) {
		this.resolutionType = resolutionType;
	}
	public String getResolutionTypeName() {
		return resolutionTypeName;
	}
	public void setResolutionTypeName(String resolutionTypeName) {
		this.resolutionTypeName = resolutionTypeName;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getResolutionCode() {
		return resolutionCode;
	}
	public void setResolutionCode(String resolutionCode) {
		this.resolutionCode = resolutionCode;
	}
	public Integer getShouldJury() {
		return shouldJury;
	}
	public void setShouldJury(Integer shouldJury) {
		this.shouldJury = shouldJury;
	}
	public Integer getSenseJury() {
		return senseJury;
	}
	public void setSenseJury(Integer senseJury) {
		this.senseJury = senseJury;
	}
	public Integer getPassJury() {
		return passJury;
	}
	public void setPassJury(Integer passJury) {
		this.passJury = passJury;
	}
	public String getSigned() {
		return signed;
	}
	public void setSigned(String signed) {
		this.signed = signed;
	}
	public String getProcessControl() {
		return processControl;
	}
	public void setProcessControl(String processControl) {
		this.processControl = processControl;
	}
	public String getLoanConditions() {
		return loanConditions;
	}
	public void setLoanConditions(String loanConditions) {
		this.loanConditions = loanConditions;
	}
	public String getOtherMatters() {
		return otherMatters;
	}
	public void setOtherMatters(String otherMatters) {
		this.otherMatters = otherMatters;
	}
	public String getControlTypeID() {
		return controlTypeID;
	}
	public void setControlTypeID(String controlTypeID) {
		this.controlTypeID = controlTypeID;
	}
	public String getControlTypeName() {
		return controlTypeName;
	}
	public void setControlTypeName(String controlTypeName) {
		this.controlTypeName = controlTypeName;
	}
	public String getMonitoredAsking() {
		return monitoredAsking;
	}
	public void setMonitoredAsking(String monitoredAsking) {
		this.monitoredAsking = monitoredAsking;
	}
	public String getResolutionResultID() {
		return resolutionResultID;
	}
	public void setResolutionResultID(String resolutionResultID) {
		this.resolutionResultID = resolutionResultID;
	}
	public String getResolutionResultName() {
		return resolutionResultName;
	}
	public void setResolutionResultName(String resolutionResultName) {
		this.resolutionResultName = resolutionResultName;
	}
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
	public Integer getControlTypeNumber() {
		return controlTypeNumber;
	}
	public void setControlTypeNumber(Integer controlTypeNumber) {
		this.controlTypeNumber = controlTypeNumber;
	}
	public String getOptDesc() {
		return optDesc;
	}
	public void setOptDesc(String optDesc) {
		this.optDesc = optDesc;
	}
	public String getApply_ID() {
		return apply_ID;
	}
	public void setApply_ID(String apply_ID) {
		this.apply_ID = apply_ID;
	}
	public String getMeeting_ID() {
		return meeting_ID;
	}
	public void setMeeting_ID(String meeting_ID) {
		this.meeting_ID = meeting_ID;
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
	public List<Pro_meetingDetail> getMeetingDetailList() {
		return meetingDetailList;
	}
	public void setMeetingDetailList(List<Pro_meetingDetail> meetingDetailList) {
		this.meetingDetailList = meetingDetailList;
	}
	

}
