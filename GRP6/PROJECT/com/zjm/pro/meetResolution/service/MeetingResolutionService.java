package com.zjm.pro.meetResolution.service;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_meetingResolution;

public interface MeetingResolutionService {

	/**
	 * 分页查询节点列表
	 */
	public PageTable<Pro_meetingResolution> selectMeetingResolutionByApplyIDPageTable(PageTable<Pro_meetingResolution> pageTable);
    /**
     * 添加一个决议内容
     * @param user
     * @param meetResolution
     * @return
     */
	public Boolean insertOneMeetingResolution(User user, Pro_meetingResolution meetResolution);
    
	/**
	 * 根据输入的条件查询单个决议内容
	 * @param string wheresql
	 * @return
	 */
	public Pro_meetingResolution selectOneResolutionByWhereSql(String wheresql);
    
	/**
	 * updateMeetingResolution
	 * 更新决议内容
	 * @param userSession
	 * @param meetingResolution
	 * @return
	 */
	public Boolean updateMeetingResolution(User user, Pro_meetingResolution meetingResolution);
	
	/**
	 * 根据条件删除评审会决议
	 * @param user
	 * @param wheresql
	 * @return
	 */
	public Boolean delMeetingResolutionBySql(User user, String wheresql);
	
	
}
