package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_meetingResolution;

//评审会决议表
public interface Pro_meetingResolutionMapper {
	/**
	 * 分页查询--根据applyID评审会决议表
	 */
	public List<Pro_meetingResolution> selectMeetingResolutionByApplyIDPageTable(PageTable<Pro_meetingResolution> pageTable);
	/**
	 * 分页查询--根据applyID评审会决议表  数量
	 */
	public Long selectMeetingResolutionByApplyIDPageTable_Count(PageTable<Pro_meetingResolution> pageTable);
	/**
	 * 
	 * 添加一个决议内容
	 * @param meetResolution
	 * @return
	 */
	public Integer insertOneMeetingResolution(Pro_meetingResolution meetResolution);
	/**
	 * 根据输入的条件查询单个决议内容
	 * @param string apply_ID
	 * @return
	 */
	public Pro_meetingResolution selectOneResolutionByWhereSql(String whereSql);
	
	/**
	 * updateMeetingResolution
	 * 更新决议内容
	 * @param userSession
	 * @param meetingResolution
	 * @return
	 */  
	public Integer updateMeetingResolution(Pro_meetingResolution meetingResolution);
	
	/**
	 *根据条件删除评审会决议 
	 * @param wheresql
	 * @return
	 */
	public Integer delMeetingResolutionBySql(String wheresql);
}
