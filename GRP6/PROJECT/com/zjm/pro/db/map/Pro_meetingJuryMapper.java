package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_meetingJury;

public interface Pro_meetingJuryMapper {

	public List<Pro_meetingJury> selectMeetingJuryPageTables(PageTable<Pro_meetingJury> pageTable);
	
	public Long selectMeetingJuryPageTables_count(PageTable<Pro_meetingJury> pageTable);
	
	public List<Pro_meetingJury> selectMeetingJuryListByWhereSql(String wheresql);
	
	public Pro_meetingJury selectOneMeetingJury(Pro_meetingJury meetingJury);
	
	public Integer insertOneMeetingJury(Pro_meetingJury meetingJury);
	
	public Integer updateOneMeetingJury(Pro_meetingJury meetingJury);
	
	public Integer deleteOneMeetingJury(Pro_meetingJury meetingJury);
	
}
