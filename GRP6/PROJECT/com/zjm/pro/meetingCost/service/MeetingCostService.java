package com.zjm.pro.meetingCost.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_meetingCost;

public interface MeetingCostService {

	public List<Pro_meetingCost> selectMeetingCostList(String wheresql);
	
	public Pro_meetingCost selectOneMeetingCost(Pro_meetingCost meetingCost);
	
	public Boolean insertOneMeetingCost(User user, Pro_meetingCost meetingCost);
	
	public Boolean insertMeetingCostList(User user, Pro_meetingCost meetingCost);
	
	public Boolean updateOneMeetingCostRemark(User user, Pro_meetingCost meetingCost);
	
	public Boolean deleteOneMeetingCost(User user, String meetingCost_ID);
}
