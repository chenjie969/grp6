package com.zjm.pro.meetingJurySuggest.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_countOfVotes;
import com.zjm.pro.db.model.Pro_jurySuggest;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_projectfiles;

public interface JurySuggestService {
	
	/**
	 * 查询当前评委未完成表决的评审会列表
	 */
	public PageTable<Pro_meeting> selectNotVoteMeetingPageTables(PageTable<Pro_meeting> pageTable);

	/**
	 * 查询当前评委已完成表决的评审会列表
	 */
	public PageTable<Pro_meeting> selectHasVotedMeetingPageTables(PageTable<Pro_meeting> pageTables);
	
	/**
	 * 新增一条评委表决意见
	 */
	public Pro_jurySuggest insertOneJurySuggest(User user, Pro_jurySuggest jurySuggest);
	
	/**
	 * 修改一条评委表决意见
	 */
	public Boolean updateOneJurySuggest(User user, Pro_jurySuggest jurySuggest);
	
	/**
	 * 查询一条评委表决意见
	 */
	public Pro_jurySuggest selectOneJurySuggestByWheresql(String wheresql);
	
	/**
	 * 查询多条评委意见
	 */
	public List<Pro_jurySuggest> selectJurySuggestListByWheresql(String wheresql);
	
	/**
	 * 提交评委意见(更新提交状态和表决时间)
	 */
	public Boolean submitJurySuggest(String wheresql);
	
	/**
	 *  评委表决结果统计
	 */
	public List<Pro_countOfVotes> countOfJuryVotes(String wheresql);
	
	//查询附件
	public List<Pro_projectfiles> getAttachments(String entityID);
	
}
