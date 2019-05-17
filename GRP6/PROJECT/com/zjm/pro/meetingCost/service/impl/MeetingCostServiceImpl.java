package com.zjm.pro.meetingCost.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_meetingCostMapper;
import com.zjm.pro.db.model.Pro_meetingCost;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.meetingCost.service.MeetingCostService;
import com.zjm.util.Tool;

@Service("meetingCostService")
@Transactional
public class MeetingCostServiceImpl implements MeetingCostService {

	@Resource
	private Pro_meetingCostMapper pro_meetingCostMapper;
	@Resource
	private LogService logService;
	@Resource
	private MeetingResolutionService meetingResolutionService;
	
	@Override
	public List<Pro_meetingCost> selectMeetingCostList(String wheresql) {
		try {
			List<Pro_meetingCost> meetingCostList = pro_meetingCostMapper.selectMeetingCostList(wheresql);
			return meetingCostList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pro_meetingCost selectOneMeetingCost(Pro_meetingCost meetingCost) {
		try {
			meetingCost = pro_meetingCostMapper.selectOneMeetingCost(meetingCost);
			return meetingCost;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean insertOneMeetingCost(User user, Pro_meetingCost meetingCost) {
		try {
			Integer i = pro_meetingCostMapper.insertOneMeetingCost(meetingCost);
			if(i == 1){
				logService.insertOneOperatorLogInfo(user, "评审会决议批准收费标准", "添加", "收费标准ID="+meetingCost.getCostStandardID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateOneMeetingCostRemark(User user, Pro_meetingCost meetingCost) {
		try {
			Integer i = pro_meetingCostMapper.updateOneMeetingCostRemark(meetingCost);
			if(i == 1){
				logService.insertOneOperatorLogInfo(user, "评审会决议收费标准", "修改", "修改备注,批准收费标准ID="+meetingCost.getMeetingCost_ID());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteOneMeetingCost(User user, String meetingCost_ID) {
		try {
			Integer i = pro_meetingCostMapper.deleteOneMeetingCost(meetingCost_ID);
			if(i == 1){
				logService.insertOneOperatorLogInfo(user, "评审会决议收费标准", "删除", "删除批准收费标准ID="+meetingCost_ID);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean insertMeetingCostList(User user, Pro_meetingCost meetingCost) {
		try {
			meetingCost.setUpdateUserName(user.getUser_name());
			String[] costStandardList = meetingCost.getCostStandardIDList().split(",");
			for (String costStandard : costStandardList) {
				if(costStandard!=null && !"".equals(costStandard)){
					meetingCost.setMeetingCost_ID(Tool.createUUID32());
					meetingCost.setCostStandardID(costStandard);
					Integer i = pro_meetingCostMapper.insertOneMeetingCost(meetingCost);
					if(1==i){
						logService.insertOneOperatorLogInfo(user, "评审会决议批准收费标准", "添加", "收费标准ID="+meetingCost.getCostStandardID());
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
