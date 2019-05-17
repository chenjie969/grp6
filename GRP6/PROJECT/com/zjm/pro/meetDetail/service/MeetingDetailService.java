package com.zjm.pro.meetDetail.service;

import java.util.List;

import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_meetingDetail;

public interface MeetingDetailService {

   /**
    * 
    * @param user
    * @param meetingDetail
    * @return
    */
	public Boolean insertOneMeetingDetail(User user, Pro_meetingDetail meetingDetail);
	/**
	 * 
	 * @param user
	 * @param meetingDetail_ID
	 * @return
	 */
	public Boolean deleteOnemeetingDetail(User user,String meetingDetail_ID);
	/**
	 * 
	 * @param wheresql
	 * @return
	 */
	public Pro_meetingDetail selectOneMeetingDetailByWhereSql(String wheresql);
	
	/**
	 * 
	 * @param wheresql
	 * @return
	 */
	public List<Pro_meetingDetail> selectMeetingDetailListByWhereSql(String wheresql);
    /**
     * 
     * @param user
     * @param meetingDetail
     * @return
     */
	public Boolean updateOneMeetingDetail(User user, Pro_meetingDetail meetingDetail);
	/**
	 * 
	 * @Title: insertMeetingDetail   
	 * @Description: 新增申请信息时插入数据
	 * @param: @param user
	 * @param: @param applyDetail
	 * @param: @param meetingResolution_ID      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean insertMeetingDetail(User user, Pro_applyDetail applyDetail, String meetingResolution_ID);
	
	
}
