package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_countOfVotes;
import com.zjm.pro.db.model.Pro_jurySuggest;
import com.zjm.pro.db.model.Pro_meeting;

public interface Pro_jurySuggestMapper {

	/**
	 * 查询当前评委未完成表决的评审会列表
	 */
	public List<Pro_meeting> selectNotVoteMeetingList(PageTable<Pro_meeting> pageTable);
	
	/**
	 * 查询当前评委未完成表决的评审会列表_求总数
	 */
	public Long selectNotVoteMeetingList_count(PageTable<Pro_meeting> pageTable);

	/**
	 * 查询当前评委已完成表决的评审会列表
	 */
	public List<Pro_meeting> selectHasVotedMeetingList(PageTable<Pro_meeting> pageTables);
	
	/**
	 * 查询当前评委已完成表决的评审会列表_求总数
	 */
	public Long selectHasVotedMeetingList_count(PageTable<Pro_meeting> pageTables);
	
	/**
	 * 新增一条评委表决意见
	 */
	public Integer insertOneJurySuggest(Pro_jurySuggest jurySuggest);
	
	/**
	 * 修改一条评委表决意见
	 */
	public Integer updateOneJurySuggest(Pro_jurySuggest jurySuggest);
	
	/**
	 * 查看一条评委表决意见
	 */
	public Pro_jurySuggest selectOneJurySuggestByWheresql(String wheresql);
	
	/**
	 * 提交评委意见(更新提交状态和表决时间)
	 */
	public Integer submitJurySuggest(String wheresql);
	
	/**
	 * 查询多条评委意见
	 */
	public List<Pro_jurySuggest> selectJurySuggestListByWheresql(String wheresql);
	
	/**
	 *  评委表决结果统计
	 */
	public List<Pro_countOfVotes> countOfJuryVotes(String wheresql);
	
}
