package com.zjm.pro.meetingApply.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_meetingApplyMapper;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.meetingApply.service.MeetingApplyService;
import com.zjm.pro.project.service.ProjectService;

@Service("meetingApplyService")
@Transactional
public class MeetingApplyServiceImpl implements MeetingApplyService {
    
	@Resource
	private ProjectService  projectService;
	@Resource
	private Pro_meetingApplyMapper pro_meetingApplyMapper;
	
	@Resource
	private LogService logService;

	@Override
	public Pro_meetingApply selectOneMeetingApplyByWhereSql(String whereSql) {
		Pro_meetingApply meetingApply =	pro_meetingApplyMapper.selectOneMeetingApplyByWhereSql(whereSql);
		return meetingApply;
	}

	/**
	 * 新增一条评审会与申请对应信息 
	 * @author xuyz
	 */
	@Override
	public Boolean insertOneMeetingApply(Pro_meetingApply meetingApply) {
		try {
			if(pro_meetingApplyMapper.insertOneMeetingApply(meetingApply)==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据meeting_ID删除评审会与申请对应信息 
	 * @author xuyz
	 */
	@Override
	public Integer deleteMeetingApplyByMeetingID(String meeting_ID){
		try {
			return pro_meetingApplyMapper.deleteMeetingApplyByMeetingID(meeting_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
