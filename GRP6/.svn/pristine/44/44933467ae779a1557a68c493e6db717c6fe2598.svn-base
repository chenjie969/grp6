package com.zjm.pro.meetingJury.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_meetingJury;

public interface MeetingJuryService {
	
	public PageTable<Pro_meetingJury> selectMeetingJuryPageTables(PageTable<Pro_meetingJury> pageTable);
	
	public Pro_meetingJury selectOneMeetingJury(Pro_meetingJury meetingJury);

	public Boolean addMeetingJuries(User user, Pro_meetingJury meetingJury);
	
	public Boolean editMeetingJury(User user, Pro_meetingJury meetingJury);
	
	public Boolean delMeetingJury(User user, Pro_meetingJury meetingJury);
	
	public List<Pro_meetingJury> selectMeetingJuryListByWheresql(String wheresql);
}
