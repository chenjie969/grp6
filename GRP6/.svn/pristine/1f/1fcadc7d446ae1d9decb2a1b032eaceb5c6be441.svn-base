package com.zjm.pro.meetResolution.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_meetingMapper;
import com.zjm.pro.db.map.Pro_meetingResolutionMapper;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingResolution;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.util.Tool;

@Service("meetingResolutionService")
@Transactional
public class MeetingResolutionServiceImpl implements MeetingResolutionService {

	@Resource
	private Pro_meetingResolutionMapper meetingResolutionMapper;
	@Resource
	private LogService logService;
	@Resource
	private Pro_meetingMapper pro_meetingMapper;
	
	/**
	 * 分页查询--根据applyID评审会决议表
	 */
	
	@Override
	public PageTable<Pro_meetingResolution> selectMeetingResolutionByApplyIDPageTable(PageTable<Pro_meetingResolution> pageTable) {
		List<Pro_meetingResolution> meetingResolutionList = meetingResolutionMapper.selectMeetingResolutionByApplyIDPageTable(pageTable);
		pageTable.setRows(meetingResolutionList);
		Long meetingResolutionTotal;
		try {
			meetingResolutionTotal = meetingResolutionMapper.selectMeetingResolutionByApplyIDPageTable_Count(pageTable);
			pageTable.setTotal(meetingResolutionTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	/**
	 * 添加评审决议内容
	 * 
	 */
	@Override
	public Boolean insertOneMeetingResolution(User user, Pro_meetingResolution meetResolution) {
		
		String meetingID = meetResolution.getMeeting_ID();
		Pro_meeting meeting = pro_meetingMapper.showOneEvaluItemsViewPage(meetingID);
		if(meeting!=null){
			meetResolution.setMeetingCode(meeting.getMeetingCode());
			meetResolution.setMeetingDate(meeting.getMeetingDateTime());
		}
		meetResolution.setUnit_uid(user.getUnit_uid());
		meetResolution.setUnit_uidName(user.getUnit_uidName());
		meetResolution.setUpdateUserName(user.getUser_name());
		
		if(meetingResolutionMapper.insertOneMeetingResolution(meetResolution)==1){
			try {
				logService.insertOneOperatorLogInfo(user, "评审会决议", "添加", "添加"+meetResolution.getResolutionCode());
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
		
	}
   /**
    * 查询决议内容
    * 
    */
	public Pro_meetingResolution selectOneResolutionByWhereSql(String wheresql) {
		Pro_meetingResolution meetResolution = meetingResolutionMapper.selectOneResolutionByWhereSql(wheresql);
		return meetResolution;
	}
   
	/**
	 * updateMeetingResolution
	 * 更新决议内容
	 * @param userSession
	 * @param meetingResolution
	 * @return
	 */  
	public Boolean updateMeetingResolution(User user, Pro_meetingResolution meetingResolution) {
		meetingResolution.setUpdateUserName(user.getUser_name());
		meetingResolution.setUnit_uid(user.getUnit_uid());
		meetingResolution.setUnit_uidName(user.getUnit_uidName());
		Integer returnInt = 0;
		try {
	       returnInt  = meetingResolutionMapper.updateMeetingResolution(meetingResolution);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "决议内容", "更改", "更改决议内容"+meetingResolution.getMeetingResolution_ID());
			return true;
		} else{
		return false;
		}
	}

	@Override
	public Boolean delMeetingResolutionBySql(User user, String wheresql) {
		if (meetingResolutionMapper.delMeetingResolutionBySql(wheresql) > 0){
			logService.insertOneOperatorLogInfo(user, "决议内容", "删除", "删除决议内容");
			return true;
		}
		return false;
	
	}
	

	/*@Override
	public Boolean isExistDicNodeNames(Gbpm_dicNode dicnode) {
		if(dicNodeMapper.isExistDicNodeNames(dicnode) == 0){
			return true;
		}else{
			return false;
		}
	}*/

}
