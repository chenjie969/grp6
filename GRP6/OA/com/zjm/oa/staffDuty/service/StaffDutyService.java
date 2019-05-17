package com.zjm.oa.staffDuty.service;

import java.util.List;

import com.zjm.oa.db.model.Hr_staffDuty;


public interface StaffDutyService {
	/**
	 * 查询用户列表    分页列表
	 */
	
	List<Hr_staffDuty> selectDutyListByCase_ID(String staffCase_ID);
	
	//根据ID查询
	
		public Hr_staffDuty selectOneByDutyId(String dutyID);
		//增加
		
		public Boolean insertOneDutyInfo(Hr_staffDuty hrstaffDuty);
	
		/**
		 * 更新	
		 */
		public Boolean updateOneDutyInfo(Hr_staffDuty hrstaffDuty);

}
