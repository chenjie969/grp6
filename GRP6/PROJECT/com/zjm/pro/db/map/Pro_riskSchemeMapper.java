package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_riskScheme;

/**
 * 
 * 化解方案（工作进度）表映射
 * @author Administrator
 *
 */
public interface Pro_riskSchemeMapper {
     
	/**
	 *
	 * 分页查询待安排会议列表
	 */
	public List<Pro_riskScheme> selectAwaitingMeetingPageTables(PageTable<Pro_riskScheme> pageTable);
	
	/**
	 *
	 * 查询待安排会议列表总数
	 */
	public Long selectAwaitingMeetingPageTables_count(PageTable<Pro_riskScheme> pageTable);
	
	/**
	 * 
	 * 查询一条待安排会议信息
	 */
	public Pro_riskScheme selectOneAwaitingMeeting(String wheresql);
	
	/**
	 *修改安排上会的状态 
	 * @param riskScheme
	 * @return
	 */
	public Integer updateMeetingStatus(Pro_riskScheme riskScheme);
	
	/**
	 * 查询化解方案(工作进度)信息List
	 * @param wheresql
	 * @return
	 */
	public List<Pro_riskScheme> selectRiskSchemeList(String wheresql);
	/**
	 * 
	 * @param wheresql
	 * @return
	 */
	public List<Pro_riskScheme> selectRiskSchemeListByRiskScheme_ID(String wheresql);
	
	/*--------------------------------------------------------------------------------------------------------------*/
	
	/**
	 * 新增化解方案
	 * @param riskScheme
	 * @return
	 */
	public Integer insertOneRiskSchemeInfo(Pro_riskScheme riskScheme);

	public List<Pro_riskScheme> selectRiskSchemePageTables(PageTable<Pro_riskScheme> pageTable);

	public Long selectRiskSchemePageTables_Count(PageTable<Pro_riskScheme> pageTable);

	public Pro_riskScheme selectOneRiskShemeInfo(String whereSql);

	public Integer updateOneRiskSchemeInfo(Pro_riskScheme riskScheme);
	
	/**
	 * 查询最新工作进度-更多列表
	 * @param pageTable
	 * @author xuyz
	 */
	 public List<Pro_riskScheme> selectMoreRiskSchemeTable(PageTable<Pro_riskScheme> pageTable);

	public List<Pro_riskScheme> selectRiskSchemeStageList();

	public Integer finishRiskScheme(Pro_riskScheme riskScheme);
	 
	 /**
	 * 查询最新工作进度-更多列表
	 * @param pageTable
	 * @author xuyz
	 */
	 public List<Pro_riskScheme> selectSchemeNoticeList(PageTable<Pro_riskScheme> pageTable);
	 
	 /**
	 * 查询最新工作进度-更多列表
	 * @param pageTable
	 * @author xuyz
	 */
	 public Long selectSchemeNoticeList_count(PageTable<Pro_riskScheme> pageTable);

	/**
	 * 删除 重点项目审批
	 * @param riskScheme_ID
	 * @return
	 */
	public Integer deleteByRiskSchemeId(String riskScheme_ID);
	
	
	/**
	 * 根据关系名查询相关案件
	 * @param relamMainName
	 * @return
	 */
	public List<Pro_riskScheme> selectSchemeByRelaMain(String relamMainName);
	 
}
