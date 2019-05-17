package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_meetingApply;
/**
 * 评审会与申请对应表pro_meetingApply 映射mapper
 * @author zky
 * @time 2017-6-30;
 */
public interface Pro_meetingApplyMapper {
	public Integer insertOneMeetingApplyApply(Pro_meetingApply meetingApply);

	public void deleteOneEvaluItems(Pro_meetingApply pro_meetingApply);

	public List<Pro_meetingApply> selectOneMeetingApplyById(String meetingID);

	public List<Pro_meetingApply> selectAllMeetingApplyInfo();

	public Integer delMeetingApplyBymeeting_ID(String meetingID);

	public List<Pro_meetingApply> selectMeetingIDByApplyID(String entityID);
	/**
	 * 根据输入的条件查询单个pro_meetingApply信息
	 * @param whereSql
	 * @return
	 */
	Pro_meetingApply selectOneMeetingApplyByWhereSql(String whereSql);
	
	
	/* *********************xuyz****start************************************************/
	/**
	 * 新增一条评审会与申请对应信息 
	 * @author xuyz
	 */
	public Integer insertOneMeetingApply(Pro_meetingApply meetingApply);
	
	/**
	 * 根据meeting_ID删除评审会与申请对应信息 
	 */
	public Integer deleteMeetingApplyByMeetingID(String meeting_ID);
	/* *********************xuyz****end************************************************/
}
