package com.zjm.pro.checkPlan.service;

import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.common.db.model.User;
import com.zjm.pro.db.model.Pro_apply;
import com.zjm.pro.db.model.Pro_applyDetail;
import com.zjm.pro.db.model.Pro_checkPlan;
import com.zjm.pro.db.model.Pro_project;

public interface CheckPlanService {
	/**
	 *	新增一条计划检查
	 */
	public Boolean  insertOneCheckPlan(User user,Pro_checkPlan proCheckPlan);	
	/**
	 *	根据计划检查周期新增计划检查
	 */
	public void  insertCheckPlans(Pro_project project, Integer checkDate);	
	
	
	/**
	 * 查询检查计划列表
	 */
	public List<Pro_checkPlan> selectProCheckPlanPageTables(String applyID);
	/**
	 * 查询检查计划列表
	 */
	public List<Pro_checkPlan> selectProCheckPlanPageList(String applyID);
	/**
	 * 删除计划表
	 * @param applyID
	 * @return
	 */
	public Boolean deleteCheckPlansByApplyID(String applyID);
	//保后检查计划表pro_checkPlan
	public Integer updateOneCheckPlan(Pro_checkPlan checkPlan);
}
