package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_meeting;
/**
 * 业务申请信息表 映射mapper
 * @author wzk
 * 
 */
public interface Pro_meetingMapper {
	//查询所有的会议室
	public List<Pro_meeting> selectAllMeetingRooms(PageTable<Pro_meeting> pageTable);
	//插入一条上会申请
	public Integer insertOneMeetingApply(Pro_meeting meeting);
	//通过会议室名或得评审信息
	public List<Pro_meeting> listByDuration(PageTable<Pro_meeting> pageTable);
	/**
	 * 分页查询评审会列表
	 */
	public List<Pro_meeting> selectMyProMeetingPageTable(PageTable<Pro_meeting> pageTable);

	public Long selectMyProMeetingPageTable_Count(PageTable<Pro_meeting> pageTable);

	public Long deleteOneEvaluItems(Pro_meeting meeting);

	public Pro_meeting showOneEvaluItemsViewPage(String meeting_ID);

	public Integer isExistMeetingCode(Pro_meeting meeting);
	
	public List<Pro_meeting> selectMeetingInfoByMeetingStatus(PageTable<Pro_meeting> pageTable);
	public Integer updateMeetingStatusById(String meeting_ID);
	public Integer updateRejectReasonAndMeetingStatusById(Pro_meeting meeting);
	public Integer updateRevokeMeetingStatusById(Pro_meeting meeting);
	public List<Pro_meeting> selectMeetingIdById(String meetingRoomID);
	public Integer delMeetingBymeeting_ID(String meeting_ID);
	public Integer delMeetingByMeetingRoomID(String meetingRoomID);
	
	
	
	/**
	 * 根据输入的条件查询相应的条件查询
	 * @param whereSql
	 * @return
	 */
	public Pro_meeting selectOneMeetingByWhereSql(String whereSql);
	/**
	 * 修改单个meeting信息
	 * @param meeting
	 * @return
	 */
	public Integer updateOneMeeting(Pro_meeting meeting);
	
	/* *********************************xuyz新增*****START*********************************************** */
	/**
	 * 新增一条评审会信息 
	 */
	public Integer insertOneMeeting(Pro_meeting pro_meeting);
	
	/**
	 * 分页查询已安排的评审会列表(包括已上会和未上会)
	 */
	public List<Pro_meeting> selectProMeetingPageTables(PageTable<Pro_meeting> pageTable);
	
	/**
	 * 查询已安排的评审会总数(包括已上会和未上会)
	 */
	public Long selectProMeetingPageTables_count(PageTable<Pro_meeting> pageTable);
	
	/**
	 * 查询一条评审会信息
	 */
	public Pro_meeting selectOneProjectMeeting(String wheresql);
	
	/**
	 * 修改评审会状态 
	 */
	public Integer updateMeetingStatus(Pro_meeting meeting);
	
	/* *********************************xuyz新增*****END************************************************* */

}
