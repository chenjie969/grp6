package com.zjm.oa.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lancepro on 7/14/17.
 */
public class Oa_meeting implements Serializable {
    private String meeting_ID;
    //    会议名
    private String meetingName;
    //    会议室ID
    private String meetingRoomID;
    //    会议室名
    private String meetingRoomName;
    //    是否周期性会议
    private Boolean isCyclicity;
    //    会议开始日期时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date meetingBeginDateTime;
    //    会议结束日期时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date meetingEndDateTime;
    //    会议开始日期
    private Date meetingBeginDate;
    //    会议结束日期
    private Date meetingEndDate;
    //    会议开始时间
    private Date meetingBeginTime;
    //    会议结束时间
    private Date meetingEndTime;
    //    选定字段
    private String duplicateManName;
    //    内部与会人员
    private String membersIDList;
    private String membersNameList;
    //    主持人
    private String compereID;
    private String compereName;
    //    外部与会人员
    private String outMembers;
    //    会议主题
    private String subject;
    //    备注
    private String remark;
    private String createUserID;
    private String createUserName;
    private Date createDateTime;
    //0:to be approved;1:approved;2:canceled;3:rejected;-1:removed;
    private String status;
    private String returnDesc;
    private String unit_uid;
    private String unit_uidName;
    private String updateUserName;
    private Date updateDateTime;
    private String currentStatus;

    public String getMeeting_ID() {
        return meeting_ID;
    }

    public void setMeeting_ID(String meeting_ID) {
        this.meeting_ID = meeting_ID;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
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

    public Boolean getCyclicity() {
        return isCyclicity;
    }

    public void setCyclicity(Boolean cyclicity) {
        isCyclicity = cyclicity;
    }

    public Date getMeetingBeginDateTime() {
        return meetingBeginDateTime;
    }

    public void setMeetingBeginDateTime(Date meetingBeginDateTime) {
        this.meetingBeginDateTime = meetingBeginDateTime;
    }

    public Date getMeetingEndDateTime() {
        return meetingEndDateTime;
    }

    public void setMeetingEndDateTime(Date meetingEndDateTime) {
        this.meetingEndDateTime = meetingEndDateTime;
    }

    public Date getMeetingBeginDate() {
        return meetingBeginDate;
    }

    public void setMeetingBeginDate(Date meetingBeginDate) {
        this.meetingBeginDate = meetingBeginDate;
    }

    public Date getMeetingEndDate() {
        return meetingEndDate;
    }

    public void setMeetingEndDate(Date meetingEndDate) {
        this.meetingEndDate = meetingEndDate;
    }

    public Date getMeetingBeginTime() {
        return meetingBeginTime;
    }

    public void setMeetingBeginTime(Date meetingBeginTime) {
        this.meetingBeginTime = meetingBeginTime;
    }

    public Date getMeetingEndTime() {
        return meetingEndTime;
    }

    public void setMeetingEndTime(Date meetingEndTime) {
        this.meetingEndTime = meetingEndTime;
    }

    public String getDuplicateManName() {
        return duplicateManName;
    }

    public void setDuplicateManName(String duplicateManName) {
        this.duplicateManName = duplicateManName;
    }

    public String getMembersIDList() {
        return membersIDList;
    }

    public void setMembersIDList(String membersIDList) {
        this.membersIDList = membersIDList;
    }

    public String getMembersNameList() {
        return membersNameList;
    }

    public void setMembersNameList(String membersNameList) {
        this.membersNameList = membersNameList;
    }

    public String getCompereID() {
        return compereID;
    }

    public void setCompereID(String compereID) {
        this.compereID = compereID;
    }

    public String getCompereName() {
        return compereName;
    }

    public void setCompereName(String compereName) {
        this.compereName = compereName;
    }

    public String getOutMembers() {
        return outMembers;
    }

    public void setOutMembers(String outMembers) {
        this.outMembers = outMembers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
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

    public String getCurrentStatus() {
        if (StringUtils.isEmpty(this.currentStatus)) {
            Date current = new Date();
            if ("1".equals(this.status)) {
                if (this.meetingEndDateTime.compareTo(current) < 0) {
                    setCurrentStatus("over");
                } else if (this.meetingBeginDateTime.compareTo(current) > 0) {
                    setCurrentStatus("waiting");
                } else {
                    setCurrentStatus("running");
                }
            } else if ("0".equals(this.status) && this.meetingBeginDateTime.compareTo(current) <= 0) {
                setCurrentStatus("disabled");
            }
        }
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }


}
