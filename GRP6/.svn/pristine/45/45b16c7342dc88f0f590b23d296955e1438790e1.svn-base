package com.zjm.pro.meetingJurySuggest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_jurySuggestMapper;
import com.zjm.pro.db.map.Pro_projectfilesMapper;
import com.zjm.pro.db.model.Pro_countOfVotes;
import com.zjm.pro.db.model.Pro_jurySuggest;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_projectfiles;
import com.zjm.pro.meetingJurySuggest.service.JurySuggestService;
import com.zjm.util.Tool;

@Transactional
@Service("jurySuggestService")
public class JurySuggestServiceImpl implements JurySuggestService {

	@Resource
	private Pro_jurySuggestMapper pro_jurySuggestMapper;
	@Resource
	private LogService logService;
	@Resource
	private Pro_projectfilesMapper projectfilesMapper;
	
	/**
	 * 查询当前评委未完成表决的评审会列表
	 */
	@Override
	public PageTable<Pro_meeting> selectNotVoteMeetingPageTables(PageTable<Pro_meeting> pageTable){
		try {
			List<Pro_meeting> notVoteMeetingList = pro_jurySuggestMapper.selectNotVoteMeetingList(pageTable);
			pageTable.setRows(notVoteMeetingList);
			Long notVoteMeetingList_count = pro_jurySuggestMapper.selectNotVoteMeetingList_count(pageTable);
			pageTable.setTotal(notVoteMeetingList_count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	/**
	 * 查询当前评委已完成表决的评审会列表
	 */
	@Override
	public PageTable<Pro_meeting> selectHasVotedMeetingPageTables(PageTable<Pro_meeting> pageTable){
		try {
			List<Pro_meeting> hasVotedMeetingList = pro_jurySuggestMapper.selectHasVotedMeetingList(pageTable);
			pageTable.setRows(hasVotedMeetingList);
			Long hasVotedMeetingList_count = pro_jurySuggestMapper.selectHasVotedMeetingList_count(pageTable);
			pageTable.setTotal(hasVotedMeetingList_count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}
	
	/**
	 * 新增一条评委表决意见
	 */
	@Override
	public Pro_jurySuggest insertOneJurySuggest(User user, Pro_jurySuggest jurySuggest) {
		jurySuggest.setJurySuggest_ID(Tool.createUUID32());
		jurySuggest.setUserID(user.getUser_uid());
		jurySuggest.setUserName(user.getUser_name());
		jurySuggest.setUnit_uid(user.getUnit_uid());
		jurySuggest.setUnit_uidName(user.getUnit_uidName());
		jurySuggest.setUpdateUserName(user.getUser_name());
		jurySuggest.setSuggestStatus(false);
		try {
			if(1==pro_jurySuggestMapper.insertOneJurySuggest(jurySuggest)){
				logService.insertOneOperatorLogInfo(user, "评委表决", "新增", "新增评委表决, jurySuggest_ID="+jurySuggest.getJurySuggest_ID());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jurySuggest;
	}

	/**
	 * 修改一条评委表决意见
	 */
	@Override
	public Boolean updateOneJurySuggest(User user, Pro_jurySuggest jurySuggest) {
		try {
			jurySuggest.setUpdateUserName(user.getUser_name());
			if(1==pro_jurySuggestMapper.updateOneJurySuggest(jurySuggest)){
				logService.insertOneOperatorLogInfo(user, "评委表决", "修改", "修改评委表决, jurySuggest_ID="+jurySuggest.getJurySuggest_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询一条评委表决意见
	 */
	@Override
	public Pro_jurySuggest selectOneJurySuggestByWheresql(String wheresql) {
		try {
			Pro_jurySuggest jurySuggest = pro_jurySuggestMapper.selectOneJurySuggestByWheresql(wheresql);
			return jurySuggest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 提交评委意见(更新提交状态和表决时间)
	 */
	@Override
	public Boolean submitJurySuggest(String wheresql){
		try {
			pro_jurySuggestMapper.submitJurySuggest(wheresql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询多条评委意见
	 */
	@Override
	public List<Pro_jurySuggest> selectJurySuggestListByWheresql(String wheresql) {
		try {
			List<Pro_jurySuggest> jurySuggestList = pro_jurySuggestMapper.selectJurySuggestListByWheresql(wheresql);
			return jurySuggestList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  评委表决结果统计
	 */
	@Override
	public List<Pro_countOfVotes> countOfJuryVotes(String wheresql) {
		try {
			List<Pro_countOfVotes> list = pro_jurySuggestMapper.countOfJuryVotes(wheresql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查询附件
	@Override
	public List<Pro_projectfiles> getAttachments(String entityID) {
		List<Pro_projectfiles> listFiles = null;
		 try {
			 listFiles = projectfilesMapper.selectProFilesListByEntityID(entityID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFiles;
	}
}
