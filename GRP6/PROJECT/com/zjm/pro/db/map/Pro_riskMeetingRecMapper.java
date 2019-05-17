package com.zjm.pro.db.map;

import java.util.List;
import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_riskMeetingRec;

/**
 * 会议记录表映射
 * @author Administrator
 *
 */
public interface Pro_riskMeetingRecMapper {
    /**
     * 新增一条安排会议
     * @param riskMeetingRec
     * @return
     */
	public Integer insertOneArrangeMeeting(Pro_riskMeetingRec riskMeetingRec);
	/**
	 *
	 * 分页查询安排会议列表
	 */
	public List<Pro_riskMeetingRec> selectAwaitedMeetingPageTables(PageTable<Pro_riskMeetingRec> pageTable);
	
	/**
	 *
	 * 查询安排会议列表总数
	 */
	public Long selectAwaitedMeetedPageTables_count(PageTable<Pro_riskMeetingRec> pageTable);
	
	/**
	 * 
	 * 查询一条安排会议信息
	 */
	public Pro_riskMeetingRec selectOneAwaitedMeeting(String wheresql);
	
	/**
	 * 修改审批状态 
	 *//*
	public Integer updateMeetingStatus(Pro_riskMeetingRec riskMeetingRec);*/
	
}
