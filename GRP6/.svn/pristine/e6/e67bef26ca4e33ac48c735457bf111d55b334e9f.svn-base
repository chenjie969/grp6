package com.zjm.pro.meetingSummary.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_meetingSummaryMapper;
import com.zjm.pro.db.model.Pro_meetingSummary;
import com.zjm.pro.meetingSummary.service.MeetingSummaryService;
import com.zjm.util.Tool;

@Service("meetingSummeryService")
@Transactional
public class MeetingSummaryServiceImpl implements MeetingSummaryService {
	@Resource
	private MeetingSummaryService meetingSummeryService;
	@Resource
	private Pro_meetingSummaryMapper meetingSummaryMapper;
	@Resource
	private LogService logService;
	
   /**
    * 
    * 新增一个总办会纪要
    */
	@Override
	public Boolean insertOneMeetSummary(User userSession, Pro_meetingSummary meetingSummary) {
		meetingSummary.setMeetingSummary_ID(Tool.createUUID32());
		meetingSummary.setUnit_uid(userSession.getUnit_uid());
		meetingSummary.setUpdateUserName(userSession.getUser_name());
		
		try {
			if(meetingSummaryMapper.insertOneMeetSummary(meetingSummary)==1){
				logService.insertOneOperatorLogInfo(userSession,"新增总办会纪要", "新增", "新增总办会纪要"+meetingSummary.getMeetingSummary_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    /**
     * 
     * 更新总办会纪要
     * 
     */
	@Override
	public Boolean updateOneMeetSummary(User userSession, Pro_meetingSummary meetingSummary) {
		meetingSummary.setUnit_uid(userSession.getUnit_uid());
		meetingSummary.setUpdateUserName(userSession.getUser_name());
		//处理上会时间字段
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			String meetingDateTimeStr = meetingSummary.getMeetingDateTimeStr();
			Date meetingDateTime = sdf.parse(meetingDateTimeStr);
			meetingSummary.setMeetingDateTime(meetingDateTime);
			
		if(meetingSummaryMapper.updateOneMeetSummary(meetingSummary)==1){
			logService.insertOneOperatorLogInfo(userSession,"修改总办会纪要", "修改", "修改总办会纪要" +meetingSummary.getMeetingSummary_ID());
			return true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
     /**
      * 
      * 查询总办会纪要
      */
	@Override
	public Pro_meetingSummary selectOneMeetSummary(String whereSql) {

		Pro_meetingSummary meetingSummary = meetingSummaryMapper.selectOneMeetSummary(whereSql);
		
		return meetingSummary;
	}
}
