package com.zjm.pro.db.map;



import java.util.List;

import com.zjm.pro.db.model.Pro_checkPlan;



public interface Pro_checkPlanMapper {
	/**
	 *	新增一条计划检查
	 */
	public Integer  insertOneCheckPlan(Pro_checkPlan proCheckPlan);	
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
	public Integer deleteCheckPlansByApplyID(String applyID);
	
	//根据条件删除保后检查计划表pro_checkPlan
	public Integer deleteCheckPlansByWhereSql(String string);
	//保后检查计划表pro_checkPlan
	public Integer updateOneCheckPlan(Pro_checkPlan checkPlan);
	
}
