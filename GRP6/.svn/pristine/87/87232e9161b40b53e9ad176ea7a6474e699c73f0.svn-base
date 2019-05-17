package com.zjm.pro.meetDetail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_meetingDetailMapper;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_meetingDetail;
import com.zjm.pro.meetDetail.service.MeetingDetailService;
import com.zjm.util.Tool;

@Service("meetingDetailService")
@Transactional
public class MeetingDetailServiceImpl implements MeetingDetailService {
	@Resource
	private Pro_meetingDetailMapper meetingDetailMapper;
	@Resource
	private LogService logService;

	@Override
	public Boolean insertOneMeetingDetail(User user, Pro_meetingDetail meetingDetail) {
		/**
		 * 拼接申请期限字符串
		 */
		String periodMonthDay = "";
		if(meetingDetail.getPeriodMonth()!=null&&meetingDetail.getPeriodMonth() != 0){	
			periodMonthDay +=meetingDetail.getPeriodMonth()+"个月";
			
		}
		if(meetingDetail.getPeriodDay()!=null&&meetingDetail.getPeriodDay() != 0){		
			periodMonthDay +=meetingDetail.getPeriodDay()+"天";					
		}				
		meetingDetail.setPeriodMonthDay(periodMonthDay);
		
		meetingDetail.setUnit_uid(user.getUnit_uid());
		meetingDetail.setUnit_uidName(user.getUnit_uidName());
		meetingDetail.setUpdateUserName(user.getUser_name());
		if(meetingDetailMapper.insertOneMeetingDetail(meetingDetail)==1){
			try {
				logService.insertOneOperatorLogInfo(user, "评审会产品明细", "添加", "添加一条评审会产品明细"+meetingDetail.getMeetingDetail_ID());
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	@Override
	public Boolean deleteOnemeetingDetail(User user, String meetingDetail_ID) {
		if( meetingDetailMapper.deleteOnemeetingDetail(meetingDetail_ID)==1){
			
			logService.insertOneOperatorLogInfo(user, "评审会产品明细", "删除", "删除一条评审会产品明细"+meetingDetail_ID);
			return true;
		 }else {
			return false;
		  }
	}
	

	@Override
	public Pro_meetingDetail selectOneMeetingDetailByWhereSql(String wheresql) {
		Pro_meetingDetail meetingDetail = meetingDetailMapper.selectOneMeetingDetailByWhereSql(wheresql);
		return meetingDetail;
	}

	@Override
	public Boolean updateOneMeetingDetail(User user, Pro_meetingDetail meetingDetail) {	
		/**
		 * 拼接申请期限字符串
		 */
		String periodMonthDay = "";
		if(meetingDetail.getPeriodMonth()!=null&&meetingDetail.getPeriodMonth() != 0){	
			periodMonthDay +=meetingDetail.getPeriodMonth()+"个月";
			
		}
		if(meetingDetail.getPeriodDay()!=null&&meetingDetail.getPeriodDay() != 0){		
			periodMonthDay +=meetingDetail.getPeriodDay()+"天";					
		}				
		meetingDetail.setPeriodMonthDay(periodMonthDay);
		meetingDetail.setUpdateUserName(user.getUser_name());
		meetingDetail.setUnit_uid(user.getUnit_uid());
		meetingDetail.setUnit_uidName(user.getUnit_uidName());
		Integer returnInt = 0;
		try {
	       returnInt  = meetingDetailMapper.updateOneMeetingDetail(meetingDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnInt>0){
			logService.insertOneOperatorLogInfo(user, "评审会产品明细", "更新", "更新一条评审会产品明细内容"+meetingDetail.getMeetingDetail_ID());
			return true;
		} else{
		return false;
		}
	}
  /**
   * 
   * 查询多条明细
   * 
   */
	@Override
	public List<Pro_meetingDetail> selectMeetingDetailListByWhereSql(String wheresql) {
		List<Pro_meetingDetail> meetingDetailList = meetingDetailMapper.selectMeetingDetailListByWhereSql(wheresql);
		return meetingDetailList;
	}
     /**
      * 
      */
	public Boolean insertMeetingDetail(User user, Pro_applyDetail applyDetail, String meetingResolution_ID) {
		Boolean b  = false;
		Pro_meetingDetail meetingDetail = new Pro_meetingDetail();
		meetingDetail.setMeetingDetail_ID(Tool.createUUID32());
		meetingDetail.setMeetingResolution_ID(meetingResolution_ID);
		meetingDetail.setApply_ID(applyDetail.getApply_ID());
		meetingDetail.setApplyDetail_ID(applyDetail.getApplyDetail_ID());
		meetingDetail.setAgreeSum(applyDetail.getApplySum());
		meetingDetail.setBankID(applyDetail.getBankID());
		meetingDetail.setBankName(applyDetail.getBankName());
		meetingDetail.setBankTypeID(applyDetail.getBankTypeID());
		meetingDetail.setBantTypeName(applyDetail.getBankTypeName());
		meetingDetail.setBusiTypeID(applyDetail.getBusiTypeID());
		meetingDetail.setBusiTypeName(applyDetail.getBusiTypeName());
		meetingDetail.setSubBankName(applyDetail.getSubBankName());
		meetingDetail.setPeriodMonth(applyDetail.getPeriodMonth());
		meetingDetail.setPeriodDay(applyDetail.getPeriodDay());
		meetingDetail.setPeriodMonthDay(applyDetail.getPeriodMonthDay());
		meetingDetail.setUnit_uid(user.getUnit_uid());
		meetingDetail.setUnit_uidName(user.getUnit_uidName());
	    Integer insertOneMeetingDetail = meetingDetailMapper.insertOneMeetingDetail(meetingDetail);
		if(insertOneMeetingDetail >0){
			 logService.insertOneOperatorLogInfo(user,"申请登记", "新增", " 评审会产品明细表信息ID="+meetingDetail.getMeetingDetail_ID());	
		}
		return b;
	}

}
