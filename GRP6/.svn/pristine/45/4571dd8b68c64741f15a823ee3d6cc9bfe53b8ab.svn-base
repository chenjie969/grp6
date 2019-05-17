package com.zjm.pro.riskMeetingRec.serivce;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_riskMeetingRec;
import com.zjm.pro.db.model.Pro_riskScheme;


public interface RiskMeetingRecService {
	
	 /**
	  * 查询待安排会议列表
	  * @param pageTable
	  * @return
	  */
	 public PageTable<Pro_riskScheme> selectAwaitingMeetingPageTables(PageTable<Pro_riskScheme> pageTable);
	 
	 /**
	  * 查询一条待安排会议
	  * @param riskScheme
	  * @return
	  */
	 public Pro_riskScheme selectOneAwaitingMeeting(String whereSql);
	/**
	 * 查询已安排会议列表
	 * @param pageTable
	 * @return
	 */
    public PageTable<Pro_riskMeetingRec> selectAwaitedMeetingPageTables(PageTable<Pro_riskMeetingRec> pageTable);
	/**
	 * 查询一条已安排会议
	 * @param riskMeetingRec
	 * @return
	 */
	public Pro_riskMeetingRec selectOneAwaitedMeeting(String whereSql);
    /**
     * 增加一个安排会议
     * @param user
     * @param riskMeetingRec
     * @return
     */
	public Boolean insertOneArrangeMeeting(User user, Pro_riskMeetingRec riskMeetingRec);
	
	
	/**
	 * 更改安排上会状态
	 * @param user
	 * @param riskScheme
	 * @return
	 */
	public Boolean updateMeetingStatus(User user, Pro_riskScheme riskScheme);
	
	
	
	/**
	 * 查询化解方案(工作进度)信息List
	 * @param wheresql
	 * @return
	 */
	public List<Pro_riskScheme> selectRiskSchemeList(String wheresql);
	
	/**
	 * 查询化解方案(工作进度)信息List
	 * @param wheresql
	 * @return
	 */
	public List<Pro_riskScheme> selectRiskSchemeListByRiskScheme_ID(String wheresql);
}
