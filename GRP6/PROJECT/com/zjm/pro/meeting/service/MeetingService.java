package com.zjm.pro.meeting.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_meeting;

public interface MeetingService {
	
	public Pro_meeting selectOneMeetingByWhereSql(String whereSql);
    
	/**
	 * 修改
	 * @param userSession
	 * @param meeting
	 * @return
	 */
	public Boolean updateMeetingUserName(User userSession, Pro_meeting meeting);
	
	/**
	 * 新增一条评审会信息
	 * @author xuyz
	 */
	public Boolean insertOneMeeting(User user, Pro_meeting meeting);
	
	/**
	 * 分页查询已安排的评审会列表(包括已上会和未上会)
	 * @author xuyz
	 */
	public PageTable<Pro_meeting> selectProMeetingPageTables(PageTable<Pro_meeting> pageTable); 
	
	/**
	 * 查看一条评审会信息
	 * @author xuyz
	 */
	public Pro_meeting selectOneProjectMeeting(String wheresql); 
	
	/**
	 * 修改一条评审会信息
	 * @author xuyz
	 */
	public Boolean updateOneMeeting(User user, Pro_meeting meeting);
	
	/**
	 * 修改评审会状态
	 * @author xuyz
	 */
	public Boolean updateMeetingStatus(Pro_meeting meeting);
	
}
