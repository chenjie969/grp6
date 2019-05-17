package com.zjm.pro.riskScheme.serivce;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_riskScheme;


public interface RiskSchemeService {
	
	 /**
	  * 查询待安排会议列表
	  * @param pageTable
	  * @return
	  */
	 public PageTable<Pro_riskScheme> selectRiskSchemePageTables(PageTable<Pro_riskScheme> pageTable);

	 /**
	  * 新增化解方案
	  * @param user
	  * @param riskScheme
	  * @return
	  */
	public Boolean insertOneRiskSchemeInfo(User user, Pro_riskScheme riskScheme);

	public Pro_riskScheme selectOneRiskShemeInfo(String whereSql);

	public Boolean updateOneRiskSchemeInfo(User user, Pro_riskScheme riskScheme);
	
	/**
	 * 查询最新工作进度-更多列表
	 * @param pageTable
	 * @author xuyz
	 */
	 public PageTable<Pro_riskScheme> selectMoreRiskSchemeTable(PageTable<Pro_riskScheme> pageTable);
	public List<Pro_riskScheme> selectRiskSchemeStageList();

	public Boolean finishRiskScheme(User userSession, Pro_riskScheme riskScheme);

	 
	 /**
	  * 查询首页工作进度提醒_统计数量
	  */
	 public Long selectSchemeNoticeList_count(User user, String type);
	 
	 /**
	  * 查询首页工作进度提醒
	  */
	 public PageTable<Pro_riskScheme> selectSchemeNoticeList(PageTable<Pro_riskScheme> pageTable);
	 
	 /**
	  * 根据关系名查询相关案件
	  * @param relamMainName
	  * @return
	  */
	 public List<Pro_riskScheme> selectSchemeByRelaMain(String relamMainName);
	 
}
