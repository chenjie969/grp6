package com.zjm.pro.meeting.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.db.map.Pro_meetingMapper;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;
import com.zjm.pro.meeting.service.MeetingService;
import com.zjm.pro.meetingApply.service.MeetingApplyService;
import com.zjm.util.Tool;

@Service("projectMeetingService")
@Transactional
public class ProMeetingServiceImpl implements MeetingService {
    
	@Resource
	private Pro_meetingMapper pro_meetingMapper;
	@Resource
	private MeetingApplyService meetingApplyService;
	@Resource
	private ProjectApplyService  projectApplyService;
	
	@Resource
	private LogService logService;

	public Pro_meeting selectOneMeetingByWhereSql(String whereSql) {
		Pro_meeting Pro_meeting =  pro_meetingMapper.selectOneMeetingByWhereSql(whereSql);
		return Pro_meeting;
	}
   
	public Boolean updateMeetingUserName(User userSession, Pro_meeting meeting) {
		Boolean b= false;
		Integer returnInt = pro_meetingMapper.updateOneMeeting(meeting);
		if(returnInt>0){
			b=true;
		}
		return b;
	}

	/**
	 * @author xuyz
	 * 新增一条评审会信息(pro_meeting表)
	 * 同时新增对应的多条申请信息(pro_meetingApply表)
	 * 同时修改这些申请的上会状态为"未上会"(pro_apply表)
	 */
	@Override
	public Boolean insertOneMeeting(User user, Pro_meeting meeting) {
		try {
			//新增一条评审会信息
			meeting.setMeetingStatus("01");
			meeting.setMeeting_ID(Tool.createUUID32());
			meeting.setUpdateUserName(user.getUser_name());
			meeting.setUnit_uid(user.getUnit_uid());
			//处理上会时间字段
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date meetingDateTime = sdf.parse(meeting.getMeetingDateTimeStr());
			meeting.setMeetingDateTime(meetingDateTime);
			Integer result1 = pro_meetingMapper.insertOneMeeting(meeting);
			
			//新增对应的多条申请信息, 并修改这多条申请的上会状态为"未上会"
			Boolean boolean1 = insertMeetingApplyAndUpdateProApply(user,meeting);
		
			if(boolean1 && result1==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 新增评审会对应申请信息, 并修改这多条申请的上会状态为"未上会"
	 */
	private Boolean insertMeetingApplyAndUpdateProApply(User user, Pro_meeting meeting){
		//新增对应的多条申请信息
		List<Map<String,String>> meetingApplyList = meeting.getMapList();
		Pro_meetingApply meetingApply = new Pro_meetingApply();
		meetingApply.setMeeting_ID(meeting.getMeeting_ID());
		String applyIDs = "";
		for (Map<String, String> map : meetingApplyList) {
			meetingApply.setMeetingApply_ID(Tool.createUUID32());
			meetingApply.setEntityID(map.get("applyID"));
			meetingApply.setEntityType("01");
			meetingApply.setMeetingSort(Integer.parseInt(map.get("order")));
			meetingApply.setUserIDList(map.get("idList"));
			meetingApply.setUserNameList(map.get("nameList"));
			meetingApply.setUpdateUserName(user.getUser_name());
			if(!meetingApplyService.insertOneMeetingApply(meetingApply)){
				return false;
			}
			applyIDs += map.get("applyID")+",";
		}
		
		// 修改这多条申请的上会状态为"未上会"
		Pro_apply proApply = new Pro_apply();
		proApply.setMeetingApplyIDs(applyIDs);
		Boolean boolean1 = projectApplyService.setMeetingStatusArranging(proApply, "未上会");
		
		return boolean1;
	}
	
	/**
	 * 分页查询已安排的评审会列表(包括已上会和未上会)
	 * @author xuyz
	 */
	@Override
	public PageTable<Pro_meeting> selectProMeetingPageTables(PageTable<Pro_meeting> pageTable) {
		try {
			List<Pro_meeting> proMeetingList = pro_meetingMapper.selectProMeetingPageTables(pageTable);
			pageTable.setRows(proMeetingList);
			Long proMeeting_count = pro_meetingMapper.selectProMeetingPageTables_count(pageTable);
			pageTable.setTotal(proMeeting_count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	/**
	 * 查询一条评审会信息
	 * @author xuyz
	 */
	@Override
	public Pro_meeting selectOneProjectMeeting(String wheresql) {
		try {
			Pro_meeting pro_meeting = pro_meetingMapper.selectOneProjectMeeting(wheresql);
			return pro_meeting;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改一条评审会信息
	 * @author xuyz
	 */
	@Override
	public Boolean updateOneMeeting(User user, Pro_meeting meeting) {
		try {
			// 查询原评审会下所有的项目, 并将这些项目的上会状态修改回"待安排"
			Pro_meeting oldMeeting = pro_meetingMapper.selectOneProjectMeeting(" and pm.meeting_ID = '"+meeting.getMeeting_ID()+"'");
			List<Pro_meetingApply> oldMeetingApplyList = new ArrayList<>();
			oldMeetingApplyList = oldMeeting.getMeetingApplyList();
			Pro_apply proApply = new Pro_apply();
			String meetingApplyIDs = "";
			for (Pro_meetingApply pro_meetingApply : oldMeetingApplyList) {
				meetingApplyIDs += pro_meetingApply.getEntityID()+",";
			}
			proApply.setMeetingApplyIDs(meetingApplyIDs);
			Boolean result1 = projectApplyService.setMeetingStatusArranging(proApply,"待安排");
			
			// 删除原评审会下的所有项目
			Integer result2 = meetingApplyService.deleteMeetingApplyByMeetingID(meeting.getMeeting_ID());
			
			//新增对应的多条申请信息, 并修改这多条申请的上会状态为"未上会"
			Boolean result3 = insertMeetingApplyAndUpdateProApply(user,meeting);
			
			// 更新评审会本身信息
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date meetingDateTime = sdf.parse(meeting.getMeetingDateTimeStr());
			meeting.setMeetingDateTime(meetingDateTime);
			Integer result4 = pro_meetingMapper.updateOneMeeting(meeting);
			
			if(result1 && result2==oldMeetingApplyList.size() && result3 && result4==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改评审会状态
	 * @author xuyz
	 */
	@Override
	public Boolean updateMeetingStatus(Pro_meeting meeting){
		try {
			if(1==pro_meetingMapper.updateMeetingStatus(meeting)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
