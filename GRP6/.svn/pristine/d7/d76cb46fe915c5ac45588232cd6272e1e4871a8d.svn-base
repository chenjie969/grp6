package com.zjm.pro.onManagement.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_meeting;
import com.zjm.pro.db.model.Pro_meetingApply;

/**
 * @author Administrator
 *
 */
public interface ProMeetingService {
	//查询所有的会议室
	public List<Pro_meeting> selectAllMeetingRooms(PageTable<Pro_meeting> pageTable);

	public Object insertOneMeetingApply(Pro_meeting meeting);
	//通过会议室名或得评审信息
	public List<Pro_meeting> listByDuration(PageTable<Pro_meeting>  pageTable);
	public Integer insertOneMeetingApplyApply(Pro_meetingApply meetingApply);
	public PageTable<Pro_meeting> selectMyProMeetingPageTable(PageTable<Pro_meeting> pageTable);
	public Long deleteOneEvaluItems(Pro_meeting meeting);

	public Pro_meeting showOneEvaluItemsViewPage(Pro_meeting meeting);

	public Boolean isExistMeetingCode(Pro_meeting meeting);


	public List<Pro_meeting> selectMeetingApprovalList(String approvalStatus,String keyword);

	public Pro_meeting selectOneApprovalInfoById(String meeting_ID);

	public Integer approveMeeting(Pro_meeting meeting);

	public Integer rejectApproval(Pro_meeting meeting);

	public List<Pro_meeting> selectApplyRecordList(String approvalStatus, String keyword);

	public Integer revokeApplyRecord(Pro_meeting meeting);
	//根据会议室ID删除
	public Integer delApplyRecordByMeetingRoomID(String meetingRoomID);

	public List<Pro_meeting> selectMeetingIdById(String meetingRoomID);
}
