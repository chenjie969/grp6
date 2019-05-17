package com.zjm.pro.db.map;

import java.util.List;

import com.zjm.pro.db.model.Pro_meetingDetail;


public interface Pro_meetingDetailMapper {
	/**
	 * 增加一条评审会产品记录
	 * @param meetingDetail
	 * @return
	 */
	public Integer insertOneMeetingDetail(Pro_meetingDetail meetingDetail);
	/**
	 * 删除一条评审会产品记录
	 * @param apply_ID
	 * @return
	 */
	public Integer deleteOnemeetingDetail(String meetingDetail_ID);
	/**
	 * 更新一条评审会产品记录
	 * @param meetingDetail
	 * @return
	 */

	public Integer updateOneMeetingDetail(Pro_meetingDetail meetingDetail);
	
	/**
	 * 查看一条评审会产品记录
	 * @param apply_ID
	 * @return
	 */
	public Pro_meetingDetail selectOneMeetingDetailByWhereSql(String meetingDetail_ID);
	/**
	 * 
	 * 
	 * 查询多条评审会记录
	 * @param wheresql
	 * @return
	 */
	
	public List<Pro_meetingDetail> selectMeetingDetailListByWhereSql(String wheresql);
	
	/**
	 * 删除项目数据时删除评审会信息
	 * @param applyId
	 */
	public Integer deleteMeetingDetailByApply_ID(String apply_ID);
	
}
