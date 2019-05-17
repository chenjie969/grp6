package com.zjm.pro.meetingApply.service;

import com.zjm.pro.db.model.Pro_meetingApply;

public interface MeetingApplyService {
	
	/**
	 * 查询一条评审会与申请对应信息 
	 */
	public Pro_meetingApply selectOneMeetingApplyByWhereSql(String whereSql);
	
	/**
	 * 新增一条评审会与申请对应信息 
	 * @author xuyz
	 */
	public Boolean insertOneMeetingApply(Pro_meetingApply meetingApply);
	
	/**
	 * 根据meeting_ID删除评审会与申请对应信息 
	 * @author xuyz
	 */
	public Integer deleteMeetingApplyByMeetingID(String meeting_ID);
	
}
