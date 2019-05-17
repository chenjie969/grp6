package com.zjm.pro.db.map;



import java.util.List;

import com.zjm.common.db.model.PageTable;
import com.zjm.pro.db.model.Pro_dynamic;
import com.zjm.sys.db.model.Sys_roles;



public interface Pro_dynamicMapper {
	/**
	 *	新增一条项目动态
	 */
	public Integer  insertOneProDynamic(Pro_dynamic prodynamic);	
	/**
	 * 查询所有项目动态
	 */
	public List<Pro_dynamic> selectProDynamicList(String whereSql);
	/**
	 * 删除项目动态
	 * 
	 */
	public Integer deleteProDynamicByDynamicID(String applyID);
	/**
	 * 根据项目动态ID查询项目动态
	 * @param dynamic_ID
	 * @return
	 */
	public Pro_dynamic selectOneProDynamic(String dynamic_ID);
	/**
	 * 查询所有项目动态总条数
	 */
	public Integer selectProDynamicCount(String applyID);
	/**
	 * 更新所有项目动态
	 */
	public Integer updateProDynamicList(String whereSql);
	
	/**
	 * 首页获取项目动态列表
	 * @param whereSql
	 * @return
	 */
	public List<Pro_dynamic> selectIndexProDynamicList(String whereSql);
	
	
	
	public List<Pro_dynamic> selectProDynamicTables(PageTable pageTable);
	/**
	 *  返回分页列表记录数
	 * @param pageTable
	 * @return
	 */
	public Long selectProDynamicTables_Count(PageTable pageTable);
}
