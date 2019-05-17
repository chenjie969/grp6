package com.zjm.pro.CheckPlans.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjm.common.sysDicData.service.SysDicDataService;
import com.zjm.pro.apply.service.ProjectApplyService;
import com.zjm.pro.checkPlan.service.CheckPlanService;
import com.zjm.pro.checkReport.service.CheckReportService;
import com.zjm.pro.db.map.Pro_checkPlanMapper;
import com.zjm.pro.db.model.Pro_checkPlan;
import com.zjm.common.db.model.User;
import com.zjm.common.log.service.LogService;
import com.zjm.pro.db.model.Pro_project;
import com.zjm.pro.meetResolution.service.MeetingResolutionService;
import com.zjm.pro.project.service.ProjectService;

@Service("checkPlanService")
@Transactional
public class CheckPlanServiceImpl implements CheckPlanService {

	@Resource
	private CheckPlanService checkPlanService;
	@Resource
	private Pro_checkPlanMapper pro_checkPlanMapper;
	@Resource
	private ProjectApplyService projectApplyService;
	@Resource
	private CheckReportService checkReportService;
	@Resource
	private ProjectService projectService;
	@Resource
	private SysDicDataService sysDicDataService;
	@Resource
	private MeetingResolutionService meetingResolutionService;
	@Resource
	private LogService logService;
	/**
	 * 新增一条计划检查
	 */
	@Override
	public Boolean insertOneCheckPlan(User user,Pro_checkPlan proCheckPlan) {
		if (pro_checkPlanMapper.insertOneCheckPlan(proCheckPlan) == 1) {
			logService.insertOneOperatorLogInfo(user, "保后检查计划", "新增", "新增一条计划检查, ID="+proCheckPlan.getCheckPlan_ID());
			return true;
		}
		return false;
	}

	/**
	 * 根据检查周期新增计划检查
	 */
	@Override
	public void insertCheckPlans(Pro_project project, Integer checkDate) {
//		String whereSql = " and apply_ID = \'" + project.getApply_ID() + "\'";
//		project = projectService.selectOneProjectInfoByWheresql(whereSql);
//		// 算出两个日期相差的月份（d1交大日期，d2较小日期）
//		Date d1 = project.getDelayEndDate();
//		Date d2 = project.getDelayBeginDate();
//		Calendar c1 = Calendar.getInstance();
//		Calendar c2 = Calendar.getInstance();
//		c1.setTime(d1);
//		c2.setTime(d2);
//		if (c1.getTimeInMillis() > c2.getTimeInMillis()) {
//			int year1 = c1.get(Calendar.YEAR);
//			int year2 = c2.get(Calendar.YEAR);
//			int month1 = c1.get(Calendar.MONTH);
//			int month2 = c2.get(Calendar.MONTH);
//			int day1 = c1.get(Calendar.DAY_OF_MONTH);
//			int day2 = c2.get(Calendar.DAY_OF_MONTH);
//			// 获取年的差值 假设 d1 = 2015-8-16 d2 = 2011-9-30
//			int yearInterval = year1 - year2;
//			// 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
//			if (month1 < month2 || month1 == month2 && day1 < day2)
//				yearInterval--;
//			// 获取月数差值
//			int monthInterval = (month1 + 12) - month2;
//			if (day1 < day2)
//				monthInterval--;
//			monthInterval %= 12;
//			// 相差的月数
//			monthInterval = yearInterval * 12 + monthInterval;		
//			 int b=monthInterval%checkDate; 
//			 for(int i=0;i<b;i++){
//				 Pro_checkPlan  proCheckPlan=new Pro_checkPlan();
//				 proCheckPlan.setCheckPlan_ID(Tool.createUUID32());
//				 proCheckPlan.setApplyID(project.getApply_ID());
//				 proCheckPlan.setCreate_user(SystemSession.getUserSession().getUser_name());
//				 Date date1=new Date();
//				 proCheckPlan.setPlanCheckDate(date1);
//				 proCheckPlan.setCreate_user(SystemSession.getUserSession().getUser_name());
//				 proCheckPlan.setUnit_uid(SystemSession.getUserSession().getUnit_uid());				 
//			 pro_checkPlanMapper.insertOneCheckPlan(proCheckPlan);
//			 }		 
//		}
	}

	/**
	 * 查询检查计划列表
	 */
	@Override
	public List<Pro_checkPlan> selectProCheckPlanPageTables(String wheresql) {
		return pro_checkPlanMapper.selectProCheckPlanPageTables(wheresql);
	}
	/**
	 * 查询检查计划列表
	 */
	@Override
	public List<Pro_checkPlan> selectProCheckPlanPageList(String wheresql) {
		return pro_checkPlanMapper.selectProCheckPlanPageList(wheresql);
	}

	/**
	 * 删除计划表
	 */
	@Override
	public Boolean deleteCheckPlansByApplyID(String applyID) {
		if (pro_checkPlanMapper.deleteCheckPlansByApplyID(applyID) == 1) {
			return true;
		}
		return false;
	}
	//保后检查计划表pro_checkPlan
	@Override
	public Integer updateOneCheckPlan(Pro_checkPlan checkPlan) {
		try {
			return pro_checkPlanMapper.updateOneCheckPlan(checkPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
