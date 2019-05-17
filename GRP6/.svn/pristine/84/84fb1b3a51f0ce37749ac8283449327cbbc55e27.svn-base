package com.zjm.pro.meetingJury.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.map.Pro_meetingJuryMapper;
import com.zjm.pro.db.model.Pro_meetingJury;
import com.zjm.pro.meetingJury.service.MeetingJuryService;
import com.zjm.util.Tool;

@Transactional
@Service("meetingJuryService")
public class MeetingJuryServiceImpl implements MeetingJuryService {

	@Resource
	private Pro_meetingJuryMapper pro_meetingJuryMapper;
	
	@Resource
	private LogService logService;
	
	@Override
	public PageTable<Pro_meetingJury> selectMeetingJuryPageTables(PageTable<Pro_meetingJury> pageTable) {
		try {
			 List<Pro_meetingJury> juryList = pro_meetingJuryMapper.selectMeetingJuryPageTables(pageTable);
			 pageTable.setRows(juryList);
			 Long juryCount = pro_meetingJuryMapper.selectMeetingJuryPageTables_count(pageTable);
			 pageTable.setTotal(juryCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageTable;
	}

	@Override
	public Pro_meetingJury selectOneMeetingJury(Pro_meetingJury meetingJury) {
		try {
			meetingJury = pro_meetingJuryMapper.selectOneMeetingJury(meetingJury);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetingJury;
	}
	
	@Override
	public Boolean addMeetingJuries(User user, Pro_meetingJury meetingJury) {
		Boolean flag = true;
		try {
			String juryUserUids = meetingJury.getJuryUserUids();
			juryUserUids = removeExistedJury(user,juryUserUids);		//新增评委时自动排除评委库中已有的评委,页面不提示信息
			if(juryUserUids != null && !juryUserUids.equals("")){
				String[] arrJuryUserUids = juryUserUids.split(",");
				String[] arrJuryUserNames = meetingJury.getJuryUserNames().split(",");
				Pro_meetingJury jury = new Pro_meetingJury();
				for (int i=0; i<arrJuryUserUids.length; i++) {
					if(arrJuryUserUids[i].equals("")){
						continue;
					}
					jury.setJuryStatus("01"); 	//新增评委默认可用状态
					jury.setUserUid(arrJuryUserUids[i]);
					jury.setUserName(arrJuryUserNames[i]);
					jury.setMeetingJury_ID(Tool.createUUID32());
					jury.setUnit_uid(user.getUnit_uid());
					jury.setUpdateUserName(user.getUser_name());
					if(pro_meetingJuryMapper.insertOneMeetingJury(jury)==1){
						logService.insertOneOperatorLogInfo(user, "评委库管理", "添加", "添加评审会评委"+jury.getUserName());
					}else{
						flag = false;
						break;
					}
				}
			}
			meetingJury.getJuryUserNames();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 排除评委库中已有的评委
	 */
	private String removeExistedJury(User user, String juryUserUids){
		List<Pro_meetingJury> existedJuryList = selectMeetingJuryListByWheresql(" and unit_uid='"+user.getUnit_uid()+"'");
		for (Pro_meetingJury jury : existedJuryList) {
			if(juryUserUids.indexOf(jury.getUserUid()) != -1){
				juryUserUids = juryUserUids.replace(jury.getUserUid(), "");
			}
		}
		return juryUserUids;
	}
	
	@Override
	public Boolean editMeetingJury(User user, Pro_meetingJury meetingJury) {
		try {
			meetingJury.setUpdateUserName(user.getUser_name());
			if(pro_meetingJuryMapper.updateOneMeetingJury(meetingJury)==1){
				logService.insertOneOperatorLogInfo(user, "评委库管理", "修改", "修改评审会评委"+meetingJury.getUserName());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delMeetingJury(User user, Pro_meetingJury meetingJury) {
		try {
			if(pro_meetingJuryMapper.deleteOneMeetingJury(meetingJury)==1){
				logService.insertOneOperatorLogInfo(user, "评委库管理", "删除", "删除评审会评委"+meetingJury.getUserName());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Pro_meetingJury> selectMeetingJuryListByWheresql(String wheresql) {
		try {
			return pro_meetingJuryMapper.selectMeetingJuryListByWhereSql(wheresql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
